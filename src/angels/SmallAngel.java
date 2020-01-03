package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class SmallAngel extends BaseAngel {
    public SmallAngel(int currRow, int currCol) {
        super(currRow, currCol);
    }

    @Override
    public void visits(Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.setBaseModifier(pyro.getBaseModifier() + Constants.SMALL_ANGEL_PYRO_MODIFIER);
            pyro.setCurrHP(pyro.getCurrHP() + Constants.SMALL_ANGEL_PYRO_HP);
        }
    }

    @Override
    public void visits(Knight knight) {
        if (knight.isAlive()) {
            knight.setBaseModifier(knight.getBaseModifier() + Constants.SMALL_ANGEL_KNIGHT_MODIFIER);
            knight.setCurrHP(knight.getCurrHP() + Constants.SMALL_ANGEL_KNIGHT_HP);
        }
    }

    @Override
    public void visits(Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.setBaseModifier(rogue.getBaseModifier() + Constants.SMALL_ANGEL_ROGUE_MODIFIER);
            rogue.setCurrHP(rogue.getCurrHP() + Constants.SMALL_ANGEL_ROGUE_HP);
        }
    }

    @Override
    public void visits(Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.setBaseModifier(wizard.getBaseModifier() + Constants.SMALL_ANGEL_WIZARD_MODIFIER);
            wizard.setCurrHP(wizard.getCurrHP() + Constants.SMALL_ANGEL_WIZARD_HP);
        }
    }

    @Override
    public String toString() {
        return "SmallAngel{" +
                "currRow=" + currRow +
                ", currCol=" + currCol +
                '}';
    }
}
