package players;

import common.Constants;

public final class Wizard extends BasePlayer {
    Wizard(final int currRow, final int currCol) {
        super(currRow, currCol);
        this.setMaxHP(Constants.WIZARD_STARTING_HP);
        this.setCurrHP(Constants.WIZARD_STARTING_HP);
        this.setPlayerType("W");
    }

    @Override
    public void levelUp() {
        int levelsGained = (getXpPoints()
                - (Constants.BASE_LEVEL_XP + Constants.PER_LEVEL_XP * getLevel()))
                / Constants.PER_LEVEL_XP + 1;
        setMaxHP(getMaxHP() + Constants.WIZARD_LEVEL_HP * levelsGained);
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

        float modifierFirst = baseFirst * Constants.PYRO_VS_WIZARD_FIREBLAST_MODIFIER;
        float modifierSecond = baseSecond * Constants.PYRO_VS_WIZARD_IGNITE_MODIFIER;
        float modifierDoT = baseDoT * Constants.PYRO_VS_WIZARD_IGNITE_MODIFIER;

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
        float modifierFirst = baseFirst * Constants.KNIGHT_VS_WIZARD_EXECUTE_MODIFIER;
        float modifierSecond = baseSecond * Constants.KNIGHT_VS_WIZARD_SLAM_MODIFIER;

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

        float modifierFirst = baseFirst * Constants.ROGUE_VS_WIZARD_BACKSTAB_MODIFIER;
        float modifierSecond = baseSecond * Constants.ROGUE_VS_WIZARD_PARALYSIS_MODIFIER;

        // Apply damage
        this.takeDamage(Math.round(baseFirst + modifierFirst)
                + Math.round(baseSecond + modifierSecond));
        this.applyDoT(Math.round(baseSecond + modifierSecond), overtimeRounds);
        this.applyStun(overtimeRounds);
    }

    @Override
    public void isAttackedBy(final Wizard wizard, final String typeOfLand) {
        // In the wizard vs wizard scenario, the wizards don't use deflect
        float baseFirst = wizard.firstAbility(typeOfLand);
        float modifierFirst = baseFirst * Constants.WIZARD_VS_WIZARD_DRAIN_MODIFIER;

        baseFirst += modifierFirst;
        float baseDrain = Math.min(Constants.DRAIN_HP_MODIFIER * this.getMaxHP(),
                this.getCurrHP());

        // Apply damage
        this.takeDamage(Math.round(baseFirst * baseDrain));
    }

    @Override
    // Drain
    public float firstAbility(final String typeOfLand) {
        float baseDamage = Constants.DRAIN_BASE_PERCENT
                + getLevel() * Constants.DRAIN_LEVEL_PERCENT;
        if (typeOfLand.equals("D")) {
            baseDamage += baseDamage * Constants.WIZARD_DESERT_MODIFIER;
        }

        return baseDamage;
    }

    @Override
    // Deflect
    public float secondAbility(final String typeOfLand) {
        float baseDamage = Constants.DEFLECT_BASE_PERCENT
                + getLevel() * Constants.DEFLECT_LEVEL_PERCENT;
        if (typeOfLand.equals("D")) {
            baseDamage += baseDamage * Constants.WIZARD_DESERT_MODIFIER;
        }

        return baseDamage;
    }
}