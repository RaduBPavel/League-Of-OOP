package players;

import angels.BaseAngel;
import common.Constants;
import strategy.RogueDamageStrategy;
import strategy.RogueHealthStrategy;

public final class Rogue extends BasePlayer {
    private int numOfBackstabs;

    Rogue(final int currRow, final int currCol) {
        super(currRow, currCol);
        this.setMaxHP(Constants.ROGUE_STARTING_HP);
        this.setCurrHP(Constants.ROGUE_STARTING_HP);
        this.setPlayerType("R");
        this.numOfBackstabs = 0;
        this.setDamageStrategy(new RogueDamageStrategy());
        this.setHealthStrategy(new RogueHealthStrategy());
    }

    @Override
    public void levelUp() {
        int levelsGained = (getXpPoints()
                - (Constants.BASE_LEVEL_XP + Constants.PER_LEVEL_XP * getLevel()))
                / Constants.PER_LEVEL_XP + 1;
        setMaxHP(getMaxHP() + Constants.ROGUE_LEVEL_HP * levelsGained);
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

        float modifierFirst = pyromancer.getBaseModifier() + Constants.PYRO_VS_ROGUE_FIREBLAST_MODIFIER;
        float modifierSecond = pyromancer.getBaseModifier() + Constants.PYRO_VS_ROGUE_IGNITE_MODIFIER;
        float modifierDoT = pyromancer.getBaseModifier() + Constants.PYRO_VS_ROGUE_IGNITE_MODIFIER;

        // Apply damage
        this.takeDamage(Math.round(baseFirst * modifierFirst)
                + Math.round(baseSecond * modifierSecond));
        this.applyDoT(Math.round(baseDoT * modifierDoT), Constants.IGNITE_OVERTIME_ROUNDS);
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
        float modifierFirst = knight.getBaseModifier() + Constants.KNIGHT_VS_ROGUE_EXECUTE_MODIFIER;
        float modifierSecond = knight.getBaseModifier() + Constants.KNIGHT_VS_ROGUE_SLAM_MODIFIER;

        // Apply damage
        this.takeDamage(Math.round(baseFirst * modifierFirst)
                + Math.round(baseSecond * modifierSecond));
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

        float modifierFirst = rogue.getBaseModifier() + Constants.ROGUE_VS_ROGUE_BACKSTAB_MODIFIER;
        float modifierSecond = rogue.getBaseModifier() + Constants.ROGUE_VS_ROGUE_PARALYSIS_MODIFIER;

        // Apply damage
        this.takeDamage(Math.round(baseFirst * modifierFirst)
                + Math.round(baseSecond * modifierSecond));
        this.applyDoT(Math.round(baseSecond * modifierSecond), overtimeRounds);
        this.applyStun(overtimeRounds);
    }

    @Override
    public void isAttackedBy(final Wizard wizard, final String typeOfLand) {
        // Base damages
        float baseFirst = wizard.firstAbility(typeOfLand);
        float baseSecond = wizard.secondAbility(typeOfLand);

        // Modifiers
        float modifierFirst = wizard.getBaseModifier() + Constants.WIZARD_VS_ROGUE_DRAIN_MODIFIER;
        float modifierSecond = wizard.getBaseModifier() + Constants.WIZARD_VS_ROGUE_DEFLECT_MODIFIER;

        baseFirst *= modifierFirst;
        baseSecond *= modifierSecond;

        float baseDrain = Math.min(Constants.DRAIN_HP_MODIFIER * this.getMaxHP(),
                this.getCurrHP());
        int baseDeflect = Math.round(this.firstAbility(typeOfLand))
                + Math.round(this.secondAbility(typeOfLand));
        reduceNumOfBackstabs();

        // Apply damage
        this.takeDamage(Math.round(baseFirst * baseDrain)
                + Math.round(baseSecond * baseDeflect));
    }

    @Override
    // Backstab
    public float firstAbility(final String typeOfLand) {
        numOfBackstabs++;
        float baseDamage = Constants.BACKSTAB_BASE_DAMAGE
                + getLevel() * Constants.BACKSTAB_LEVEL_DAMAGE;
        if (typeOfLand.equals("W")) {
            if (numOfBackstabs % Constants.BACKSTAB_BONUS_COUNTER == 1) {
                baseDamage *= Constants.BACKSTAB_DAMAGE_MODIFIER;
            }
            baseDamage += baseDamage * Constants.ROGUE_WOODS_MODIFIER;
        }

        return baseDamage;
    }

    @Override
    // Paralysis
    public float secondAbility(final String typeOfLand) {
        float baseDamage = Constants.PARALYSIS_BASE_DAMAGE
                + getLevel() * Constants.PARALYSIS_LEVEL_DAMAGE;
        if (typeOfLand.equals("W")) {
            baseDamage += baseDamage * Constants.ROGUE_WOODS_MODIFIER;
        }

        return baseDamage;
    }

    public void reduceNumOfBackstabs() {
        numOfBackstabs--;
    }

    @Override
    public void isVisitedBy(final BaseAngel angel) {
        angel.visits(this);
    }

    @Override
    public void applyStrategy() {
        if (Constants.ROGUE_MIN_PERCENT * this.getMaxHP() < this.getCurrHP()
                && Constants.ROGUE_MAX_PERCENT * this.getMaxHP() > this.getCurrHP()) {
            this.getDamageStrategy().applyDamageStrategy(this);
        } else if (Constants.ROGUE_MIN_PERCENT * this.getMaxHP() > this.getCurrHP()) {
            this.getHealthStrategy().applyHealthStrategy(this);
        }
    }
}
