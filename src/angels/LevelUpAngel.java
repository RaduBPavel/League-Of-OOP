package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class LevelUpAngel extends BaseAngel {
    public LevelUpAngel(int currRow, int currCol) {
        super(currRow, currCol);
    }

    @Override
    public void visits(Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.setBaseModifier(pyro.getBaseModifier() + Constants.LEVEL_UP_ANGEL_PYRO_MODIFIER);
            int xpNeeded = (pyro.getLevel() + 1) * Constants.PER_LEVEL_XP +
                    Constants.BASE_LEVEL_XP - pyro.getXpPoints();
            pyro.addXP(xpNeeded);
            pyro.levelUp();
        }
    }

    @Override
    public void visits(Knight knight) {
        if (knight.isAlive()) {
            knight.setBaseModifier(knight.getBaseModifier() + Constants.LEVEL_UP_ANGEL_KNIGHT_MODIFIER);
            int xpNeeded = (knight.getLevel() + 1) * Constants.PER_LEVEL_XP +
                    Constants.BASE_LEVEL_XP - knight.getXpPoints();
            knight.addXP(xpNeeded);
            knight.levelUp();
        }
    }

    @Override
    public void visits(Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.setBaseModifier(rogue.getBaseModifier() + Constants.LEVEL_UP_ANGEL_ROGUE_MODIFIER);
            int xpNeeded = (rogue.getLevel() + 1) * Constants.PER_LEVEL_XP +
                    Constants.BASE_LEVEL_XP - rogue.getXpPoints();
            rogue.addXP(xpNeeded);
            rogue.levelUp();
        }
    }

    @Override
    public void visits(Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.setBaseModifier(wizard.getBaseModifier() + Constants.LEVEL_UP_ANGEL_WIZARD_MODIFIER);
            int xpNeeded = (wizard.getLevel() + 1) * Constants.PER_LEVEL_XP +
                    Constants.BASE_LEVEL_XP - wizard.getXpPoints();
            wizard.addXP(xpNeeded);
            wizard.levelUp();
        }
    }
}
