package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class LifeGiver extends BaseAngel {
    public LifeGiver(final int currRow, final int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(true);
        this.setAngelName("LifeGiver");
    }

    @Override
    public boolean visits(final Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.setCurrHP(pyro.getCurrHP() + Constants.LIFE_GIVER_ANGEL_PYRO_HP);

            // Checks if the maximum HP limit has been passed
            if (pyro.getCurrHP() > pyro.getMaxHP()) {
                pyro.setCurrHP(pyro.getMaxHP());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Knight knight) {
        if (knight.isAlive()) {
            knight.setCurrHP(knight.getCurrHP() + Constants.LIFE_GIVER_ANGEL_KNIGHT_HP);

            // Checks if the maximum HP limit has been passed
            if (knight.getCurrHP() > knight.getMaxHP()) {
                knight.setCurrHP(knight.getMaxHP());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.setCurrHP(rogue.getCurrHP() + Constants.LIFE_GIVER_ANGEL_ROGUE_HP);

            // Checks if the maximum HP limit has been passed
            if (rogue.getCurrHP() > rogue.getMaxHP()) {
                rogue.setCurrHP(rogue.getMaxHP());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.setCurrHP(wizard.getCurrHP() + Constants.LIFE_GIVER_ANGEL_WIZARD_HP);

            // Checks if the maximum HP limit has been passed
            if (wizard.getCurrHP() > wizard.getMaxHP()) {
                wizard.setCurrHP(wizard.getMaxHP());
            }
            return true;
        }
        return false;
    }
}
