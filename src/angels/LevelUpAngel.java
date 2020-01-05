package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class LevelUpAngel extends BaseAngel {
    public LevelUpAngel(final int currRow, final int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(true);
        this.setAngelName("LevelUpAngel");
    }

    @Override
    public boolean visits(final Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.setBaseModifier(pyro.getBaseModifier()
                    + Constants.LEVEL_UP_ANGEL_PYRO_MODIFIER);
            int xpNeeded = pyro.getLevel() * Constants.PER_LEVEL_XP
                    + Constants.BASE_LEVEL_XP - pyro.getXpPoints();
            pyro.addXP(xpNeeded);
            pyro.levelUp();
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Knight knight) {
        if (knight.isAlive()) {
            knight.setBaseModifier(knight.getBaseModifier()
                    + Constants.LEVEL_UP_ANGEL_KNIGHT_MODIFIER);
            int xpNeeded = knight.getLevel() * Constants.PER_LEVEL_XP
                    + Constants.BASE_LEVEL_XP - knight.getXpPoints();
            knight.addXP(xpNeeded);
            knight.levelUp();
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.setBaseModifier(rogue.getBaseModifier()
                    + Constants.LEVEL_UP_ANGEL_ROGUE_MODIFIER);
            int xpNeeded = rogue.getLevel() * Constants.PER_LEVEL_XP
                    + Constants.BASE_LEVEL_XP - rogue.getXpPoints();
            rogue.addXP(xpNeeded);
            rogue.levelUp();
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.setBaseModifier(wizard.getBaseModifier()
                    + Constants.LEVEL_UP_ANGEL_WIZARD_MODIFIER);
            int xpNeeded = wizard.getLevel() * Constants.PER_LEVEL_XP
                    + Constants.BASE_LEVEL_XP - wizard.getXpPoints();
            wizard.addXP(xpNeeded);
            wizard.levelUp();
            return true;
        }
        return false;
    }
}
