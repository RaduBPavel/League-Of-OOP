package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class DarkAngel extends BaseAngel {
    public DarkAngel(final int currRow, final int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(false);
        this.setAngelName("DarkAngel");
    }

    @Override
    public boolean visits(final Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.takeDamage(Constants.DARK_ANGEL_PYRO_HP);
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Knight knight) {
        if (knight.isAlive()) {
            knight.takeDamage(Constants.DARK_ANGEL_KNIGHT_HP);
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.takeDamage(Constants.DARK_ANGEL_ROGUE_HP);
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.takeDamage(Constants.DARK_ANGEL_WIZARD_HP);
            return true;
        }
        return false;
    }
}
