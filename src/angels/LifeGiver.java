package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class LifeGiver extends BaseAngel {
    public LifeGiver(int currRow, int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(true);
        this.setAngelName("LifeGiver");
    }

    @Override
    public void visits(Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.setCurrHP(pyro.getCurrHP() + Constants.LIFE_GIVER_ANGEL_PYRO_HP);
        }
    }

    @Override
    public void visits(Knight knight) {
        if (knight.isAlive()) {
            knight.setCurrHP(knight.getCurrHP() + Constants.LIFE_GIVER_ANGEL_PYRO_HP);
        }
    }

    @Override
    public void visits(Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.setCurrHP(rogue.getCurrHP() + Constants.LIFE_GIVER_ANGEL_PYRO_HP);
        }
    }

    @Override
    public void visits(Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.setCurrHP(wizard.getCurrHP() + Constants.LIFE_GIVER_ANGEL_PYRO_HP);
        }
    }
}
