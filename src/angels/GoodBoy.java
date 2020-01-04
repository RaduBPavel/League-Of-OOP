package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class GoodBoy extends BaseAngel {
    public GoodBoy(int currRow, int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(true);
        this.setAngelName("GoodBoy");
    }

    @Override
    public void visits(Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.setBaseModifier(pyro.getBaseModifier() + Constants.GOOD_BOY_PYRO_MODIFIER);
            pyro.setCurrHP(pyro.getCurrHP() + Constants.GOOD_BOY_PYRO_HP);
        }
    }

    @Override
    public void visits(Knight knight) {
        if (knight.isAlive()) {
            knight.setBaseModifier(knight.getBaseModifier() + Constants.GOOD_BOY_KNIGHT_MODIFIER);
            knight.setCurrHP(knight.getCurrHP() + Constants.GOOD_BOY_KNIGHT_HP);
        }
    }

    @Override
    public void visits(Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.setBaseModifier(rogue.getBaseModifier() + Constants.GOOD_BOY_ROGUE_MODIFIER);
            rogue.setCurrHP(rogue.getCurrHP() + Constants.GOOD_BOY_ROGUE_HP);
        }
    }

    @Override
    public void visits(Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.setBaseModifier(wizard.getBaseModifier() + Constants.GOOD_BOY_WIZARD_MODIFIER);
            wizard.setCurrHP(wizard.getCurrHP() + Constants.GOOD_BOY_WIZARD_HP);
        }
    }
}
