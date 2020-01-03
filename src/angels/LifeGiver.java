package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class LifeGiver extends BaseAngel {
    public LifeGiver(int currRow, int currCol) {
        super(currRow, currCol);
    }

    @Override
    public void visits(Pyromancer pyro) {
        pyro.setCurrHP(pyro.getCurrHP() + Constants.LIFE_GIVER_ANGEL_PYRO_HP);
    }

    @Override
    public void visits(Knight knight) {
        knight.setCurrHP(knight.getCurrHP() + Constants.LIFE_GIVER_ANGEL_PYRO_HP);
    }

    @Override
    public void visits(Rogue rogue) {
        rogue.setCurrHP(rogue.getCurrHP() + Constants.LIFE_GIVER_ANGEL_PYRO_HP);
    }

    @Override
    public void visits(Wizard wizard) {
        wizard.setCurrHP(wizard.getCurrHP() + Constants.LIFE_GIVER_ANGEL_PYRO_HP);
    }

    @Override
    public String toString() {
        return "LifeGiver{" +
                "currRow=" + currRow +
                ", currCol=" + currCol +
                '}';
    }
}
