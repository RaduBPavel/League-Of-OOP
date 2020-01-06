package players;

import angels.BaseAngel;
import common.Constants;
import strategy.KnightDamageStrategy;
import strategy.KnightHealthStrategy;

public final class Knight extends BasePlayer {
    Knight(final int currRow, final int currCol) {
        super(currRow, currCol);
        this.setMaxHP(Constants.KNIGHT_STARTING_HP);
        this.setCurrHP(Constants.KNIGHT_STARTING_HP);
        this.setPlayerType("K");
        this.setPlayerName("Knight");
        this.setDamageStrategy(new KnightDamageStrategy());
        this.setHealthStrategy(new KnightHealthStrategy());
    }

    @Override
    public void levelUp() {
        int levelsGained = (getXpPoints()
                - (Constants.BASE_LEVEL_XP + Constants.PER_LEVEL_XP * getLevel()))
                / Constants.PER_LEVEL_XP + 1;
        setMaxHP(getMaxHP() + Constants.KNIGHT_LEVEL_HP * levelsGained);
        setCurrHP(getMaxHP());
        setLevel(getLevel() + levelsGained);
        revive();
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

        float modifierFirst = pyromancer.getBaseModifier()
                + Constants.PYRO_VS_KNIGHT_FIREBLAST_MODIFIER;
        float modifierSecond = pyromancer.getBaseModifier()
                + Constants.PYRO_VS_KNIGHT_IGNITE_MODIFIER;
        float modifierDoT = pyromancer.getBaseModifier()
                + Constants.PYRO_VS_KNIGHT_IGNITE_MODIFIER;

        // Apply damage
        this.takeDamage(Math.round(Math.round(baseFirst) * modifierFirst)
                + Math.round(Math.round(baseSecond) * modifierSecond));
        this.applyDoT(Math.round(Math.round(baseDoT) * modifierDoT),
                Constants.IGNITE_OVERTIME_ROUNDS);
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
        float modifierFirst = Constants.KNIGHT_VS_KNIGHT_EXECUTE_MODIFIER;
        float modifierSecond = knight.getBaseModifier()
                +  Constants.KNIGHT_VS_KNIGHT_SLAM_MODIFIER;

        // Apply damage
        this.takeDamage(Math.round(Math.round(baseFirst) * modifierFirst)
                + Math.round(Math.round(baseSecond) * modifierSecond));
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

        float modifierFirst = rogue.getBaseModifier()
                + Constants.ROGUE_VS_KNIGHT_BACKSTAB_MODIFIER;
        float modifierSecond = rogue.getBaseModifier()
                + Constants.ROGUE_VS_KNIGHT_PARALYSIS_MODIFIER;

        // Apply damage
        int rogueDoT = Math.round(Math.round(baseSecond) * modifierSecond);
        this.takeDamage(Math.round(Math.round(baseFirst) * modifierFirst)
                + rogueDoT);
        this.applyDoT(rogueDoT, overtimeRounds);
        this.applyStun(overtimeRounds);
    }

    @Override
    public void isAttackedBy(final Wizard wizard, final String typeOfLand) {
        // Base damages
        float baseFirst = wizard.firstAbility(typeOfLand);
        float baseSecond = wizard.secondAbility(typeOfLand);

        // Modifiers
        float modifierFirst = wizard.getBaseModifier()
                + Constants.WIZARD_VS_KNIGHT_DRAIN_MODIFIER;
        float modifierSecond = wizard.getBaseModifier()
                + Constants.WIZARD_VS_KNIGHT_DEFLECT_MODIFIER;

        baseFirst *= modifierFirst;
        baseSecond *= modifierSecond;

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

    // Used for Double Dispatch in conjunction with the angels
    @Override
    public boolean isVisitedBy(final BaseAngel angel) {
        return angel.visits(this);
    }

    // Dynamically choosing the strategy
    @Override
    public void applyStrategy() {
        if (Math.round(Constants.KNIGHT_MIN_PERCENT * this.getMaxHP()) < this.getCurrHP()
                && Math.round(Constants.KNIGHT_MAX_PERCENT * this.getMaxHP()) > this.getCurrHP()) {
            this.getDamageStrategy().applyDamageStrategy(this);
        } else if (Math.round(Constants.KNIGHT_MIN_PERCENT * this.getMaxHP()) > this.getCurrHP()) {
            this.getHealthStrategy().applyHealthStrategy(this);
        }
    }
}
