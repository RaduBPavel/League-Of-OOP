package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class DamageAngel extends BaseAngel {
    public DamageAngel(int currRow, int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(true);
        this.setAngelName("DamageAngel");
    }

    @Override
    public void visits(Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.setBaseModifier(pyro.getBaseModifier() + Constants.DAMAGE_ANGEL_PYRO_MODIFIER);
        }
    }

    @Override
    public void visits(Knight knight) {
        if (knight.isAlive()) {
            knight.setBaseModifier(knight.getBaseModifier() + Constants.DAMAGE_ANGEL_KNIGHT_MODIFIER);
        }
    }

    @Override
    public void visits(Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.setBaseModifier(rogue.getBaseModifier() + Constants.DAMAGE_ANGEL_ROGUE_MODIFIER);
        }
    }

    @Override
    public void visits(Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.setBaseModifier(wizard.getBaseModifier() + Constants.DAMAGE_ANGEL_WIZARD_MODIFIER);
        }
    }
}
