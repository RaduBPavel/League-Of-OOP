package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

// Spawner, revives dead players
public final class Spawner extends BaseAngel {
    public Spawner(final int currRow, final int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(true);
        this.setAngelName("Spawner");
    }

    @Override
    public boolean visits(final Pyromancer pyro) {
        if (!pyro.isAlive()) {
            pyro.revive();
            pyro.setCurrHP(Constants.SPAWNER_PYRO_REVIVE_HP);
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Knight knight) {
        if (!knight.isAlive()) {
            knight.revive();
            knight.setCurrHP(Constants.SPAWNER_KNIGHT_REVIVE_HP);
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Rogue rogue) {
        if (!rogue.isAlive()) {
            rogue.revive();
            rogue.setCurrHP(Constants.SPAWNER_ROGUE_REVIVE_HP);
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Wizard wizard) {
        if (!wizard.isAlive()) {
            wizard.revive();
            wizard.setCurrHP(Constants.SPAWNER_WIZARD_REVIVE_HP);
            return true;
        }
        return false;
    }
}
