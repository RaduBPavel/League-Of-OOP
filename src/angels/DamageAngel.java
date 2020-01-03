package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class DamageAngel extends BaseAngel {
    public DamageAngel(int currRow, int currCol) {
        super(currRow, currCol);
    }

    @Override
    public void visits(Pyromancer pyro) {
        pyro.setBaseModifier(pyro.getBaseModifier() + Constants.DAMAGE_ANGEL_PYRO_MODIFIER);
    }

    @Override
    public void visits(Knight knight) {
        knight.setBaseModifier(knight.getBaseModifier() + Constants.DAMAGE_ANGEL_KNIGHT_MODIFIER);
    }

    @Override
    public void visits(Rogue rogue) {
        rogue.setBaseModifier(rogue.getBaseModifier() + Constants.DAMAGE_ANGEL_ROGUE_MODIFIER);
    }

    @Override
    public void visits(Wizard wizard) {
        wizard.setBaseModifier(wizard.getBaseModifier() + Constants.DAMAGE_ANGEL_WIZARD_MODIFIER);
    }
}
