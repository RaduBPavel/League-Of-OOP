package angels;

import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class TheDoomer extends BaseAngel {
    public TheDoomer(final int currRow, final int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(false);
        this.setAngelName("TheDoomer");
    }

    @Override
    public boolean visits(final Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.takeDamage(pyro.getCurrHP());
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Knight knight) {
        if (knight.isAlive()) {
            knight.takeDamage(knight.getCurrHP());
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.takeDamage(rogue.getCurrHP());
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.takeDamage(wizard.getCurrHP());
            return true;
        }
        return false;
    }
}
