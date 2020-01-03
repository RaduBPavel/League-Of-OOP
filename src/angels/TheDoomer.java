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
        pyro.takeDamage(pyro.getCurrHP());
    }

    @Override
    public void visits(Knight knight) {
        knight.takeDamage(knight.getCurrHP());
    }

    @Override
    public void visits(Rogue rogue) {
        rogue.takeDamage(rogue.getCurrHP());
    }

    @Override
    public void visits(Wizard wizard) {
        wizard.takeDamage(wizard.getCurrHP());
    }
}
