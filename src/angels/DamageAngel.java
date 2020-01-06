package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

// Damage Angel, raises the player damage
public final class DamageAngel extends BaseAngel {
    public DamageAngel(final int currRow, final int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(true);
        this.setAngelName("DamageAngel");
    }

    @Override
    public boolean visits(final Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.setBaseModifier(pyro.getBaseModifier()
                    + Constants.DAMAGE_ANGEL_PYRO_MODIFIER);
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Knight knight) {
        if (knight.isAlive()) {
            knight.setBaseModifier(knight.getBaseModifier()
                    + Constants.DAMAGE_ANGEL_KNIGHT_MODIFIER);
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.setBaseModifier(rogue.getBaseModifier()
                    + Constants.DAMAGE_ANGEL_ROGUE_MODIFIER);
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.setBaseModifier(wizard.getBaseModifier()
                    + Constants.DAMAGE_ANGEL_WIZARD_MODIFIER);
            return true;
        }
        return false;
    }
}
