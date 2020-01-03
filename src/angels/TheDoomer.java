package angels;

import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class TheDoomer extends BaseAngel {
    public TheDoomer(int currRow, int currCol) {
        super(currRow, currCol);
    }

    @Override
    public void visits(Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.takeDamage(pyro.getCurrHP());
        }
    }

    @Override
    public void visits(Knight knight) {
        if (knight.isAlive()) {
            knight.takeDamage(knight.getCurrHP());
        }
    }

    @Override
    public void visits(Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.takeDamage(rogue.getCurrHP());
        }
    }

    @Override
    public void visits(Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.takeDamage(wizard.getCurrHP());
        }
    }
}
