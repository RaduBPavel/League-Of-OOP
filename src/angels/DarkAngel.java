package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class DarkAngel extends BaseAngel {
    public DarkAngel(int currRow, int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(false);
        this.setAngelName("DarkAngel");
    }

    @Override
    public void visits(Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.takeDamage(Constants.DARK_ANGEL_PYRO_HP);
        }
    }

    @Override
    public void visits(Knight knight) {
        if (knight.isAlive()) {
        knight.takeDamage(Constants.DARK_ANGEL_KNIGHT_HP);
        }
    }

    @Override
    public void visits(Rogue rogue) {
        if (rogue.isAlive()) {
        rogue.takeDamage(Constants.DARK_ANGEL_ROGUE_HP);
        }
    }

    @Override
    public void visits(Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.takeDamage(Constants.DARK_ANGEL_WIZARD_HP);
        }
    }
}
