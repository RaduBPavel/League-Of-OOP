package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class Spawner extends BaseAngel {
    public Spawner(int currRow, int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(true);
        this.setAngelName("Spawner");
    }

    @Override
    public void visits(Pyromancer pyro) {
        if (!pyro.isAlive()) {
            pyro.revive();
            pyro.setCurrHP(Constants.SPAWNER_PYRO_REVIVE_HP);
        }
    }

    @Override
    public void visits(Knight knight) {
        if (!knight.isAlive()) {
            knight.revive();
            knight.setCurrHP(Constants.SPAWNER_KNIGHT_REVIVE_HP);
        }
    }

    @Override
    public void visits(Rogue rogue) {
        if (!rogue.isAlive()) {
            rogue.revive();
            rogue.setCurrHP(Constants.SPAWNER_ROGUE_REVIVE_HP);
        }
    }

    @Override
    public void visits(Wizard wizard) {
        if (!wizard.isAlive()) {
            wizard.revive();
            wizard.setCurrHP(Constants.SPAWNER_WIZARD_REVIVE_HP);
        }
    }
}
