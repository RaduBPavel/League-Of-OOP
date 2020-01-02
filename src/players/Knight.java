package players;

import common.Constants;

public final class Knight extends BasePlayer {
    Knight(final int currRow, final int currCol) {
        super(currRow, currCol);
        this.setMaxHP(Constants.KNIGHT_STARTING_HP);
        this.setCurrHP(Constants.KNIGHT_STARTING_HP);
        this.setPlayerType("K");
    }

    @Override
    public void levelUp() {
        int levelsGained = (getXpPoints()
                - (Constants.BASE_LEVEL_XP + Constants.PER_LEVEL_XP * getLevel()))
                / Constants.PER_LEVEL_XP + 1;
        setMaxHP(getMaxHP() + Constants.KNIGHT_LEVEL_HP * levelsGained);
        setCurrHP(getMaxHP());
        setLevel(getLevel() + levelsGained);
    }

    /***
     *  The following functions ensure through the double dispatch design pattern
     *  that the type used for the players is the instance type, and not the
     *  reference type, which allows me to use the corresponding abilities
     *  of each player.
     */

    @Override
    public void attack(final BasePlayer player, final String typeOfLand) {
        player.isAttackedBy(this, typeOfLand);
    }

    @Override
    public void isAttackedBy(final Pyromancer pyromancer, final String typeOfLand) {
        // Base damages
        float baseFirst = pyromancer.firstAbility(typeOfLand);
        float baseSecond = pyromancer.secondAbility(typeOfLand);
        float baseDoT = Constants.IGNITE_BASE_OVERTIME_DAMAGE
                + pyromancer.getLevel() * Constants.IGNITE_LEVEL_OVERTIME_DAMAGE;

        // Modifiers
        if (typeOfLand.equals("V")) {
            baseDoT += baseDoT * Constants.PYRO_VOLCANIC_MODIFIER;
        }

        float modifierFirst = baseFirst * Constants.PYRO_VS_KNIGHT_FIREBLAST_MODIFIER;
        float modifierSecond = baseSecond * Constants.PYRO_VS_KNIGHT_IGNITE_MODIFIER;
        float modifierDoT = baseDoT * Constants.PYRO_VS_KNIGHT_IGNITE_MODIFIER;

        // Apply damage
        this.takeDamage(Math.round(baseFirst + modifierFirst)
                + Math.round(baseSecond + modifierSecond));
        this.applyDoT(Math.round(baseDoT + modifierDoT), Constants.IGNITE_OVERTIME_ROUNDS);
    }

    @Override
    public void isAttackedBy(final Knight knight, final String typeOfLand) {
        // Check first for execute
        if (this.getCurrHP() < this.getMaxHP() * (Constants.EXECUTE_BASE_PERCENT
                + Constants.EXECUTE_LEVEL_PERCENT * knight.getLevel())) {
            this.takeDamage(this.getCurrHP());
            return;
        }

        // Base damages
        float baseFirst = knight.firstAbility(typeOfLand);
        float baseSecond = knight.secondAbility(typeOfLand);

        // Modifiers
        float modifierFirst = baseFirst * Constants.KNIGHT_VS_KNIGHT_EXECUTE_MODIFIER;
        float modifierSecond = baseSecond * Constants.KNIGHT_VS_KNIGHT_SLAM_MODIFIER;

        // Apply damage
        this.takeDamage(Math.round(baseFirst + modifierFirst)
                + Math.round(baseSecond + modifierSecond));
        this.applyStun(Constants.SLAM_OVERTIME_ROUNDS);
    }

    @Override
    public void isAttackedBy(final Rogue rogue, final String typeOfLand) {
        // Base damages
        float baseFirst = rogue.firstAbility(typeOfLand);
        float baseSecond = rogue.secondAbility(typeOfLand);
        int overtimeRounds = Constants.PARALYSIS_OVERTIME_ROUNDS;

        // Modifier
        if (typeOfLand.equals("W")) {
            overtimeRounds = Constants.PARALYSIS_EXTENDED_OVERTIME;
        }

        float modifierFirst = baseFirst * Constants.ROGUE_VS_KNIGHT_BACKSTAB_MODIFIER;
        float modifierSecond = baseSecond * Constants.ROGUE_VS_KNIGHT_PARALYSIS_MODIFIER;

        // Apply damage
        this.takeDamage(Math.round(baseFirst + modifierFirst)
                + Math.round(baseSecond + modifierSecond));
        this.applyDoT(Math.round(baseSecond + modifierSecond), overtimeRounds);
        this.applyStun(overtimeRounds);
    }

    @Override
    public void isAttackedBy(final Wizard wizard, final String typeOfLand) {
        // Base damages
        float baseFirst = wizard.firstAbility(typeOfLand);
        float baseSecond = wizard.secondAbility(typeOfLand);

        // Modifiers
        float modifierFirst = baseFirst * Constants.WIZARD_VS_KNIGHT_DRAIN_MODIFIER;
        float modifierSecond = baseSecond * Constants.WIZARD_VS_KNIGHT_DEFLECT_MODIFIER;

        baseFirst += modifierFirst;
        baseSecond += modifierSecond;

        float baseDrain = Math.min(Constants.DRAIN_HP_MODIFIER * this.getMaxHP(),
                this.getCurrHP());
        int baseDeflect = Math.round(this.firstAbility(typeOfLand))
                + Math.round(this.secondAbility(typeOfLand));

        // Apply damage
        this.takeDamage(Math.round(baseFirst * baseDrain)
                + Math.round(baseSecond * baseDeflect));
    }

    @Override
    // Execute
    public float firstAbility(final String typeOfLand) {
        float baseDamage = Constants.EXECUTE_BASE_DAMAGE
                + getLevel() * Constants.EXECUTE_LEVEL_DAMAGE;
        if (typeOfLand.equals("L")) {
            baseDamage += baseDamage * Constants.KNIGHT_LAND_MODIFIER;
        }

        return baseDamage;
    }

    @Override
    // Slam
    public float secondAbility(final String typeOfLand) {
        float baseDamage = Constants.SLAM_BASE_DAMAGE
                + getLevel() * Constants.SLAM_LEVEL_DAMAGE;
        if (typeOfLand.equals("L")) {
            baseDamage += baseDamage * Constants.KNIGHT_LAND_MODIFIER;
        }

        return baseDamage;
    }
}
