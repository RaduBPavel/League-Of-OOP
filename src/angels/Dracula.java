package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class Dracula extends BaseAngel {
    public Dracula(final int currRow, final int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(false);
        this.setAngelName("Dracula");
    }

    @Override
    public boolean visits(final Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.setBaseModifier(pyro.getBaseModifier() - Constants.DRACULA_PYRO_MODIFIER);
            pyro.takeDamage(Constants.DRACULA_PYRO_HP);
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Knight knight) {
        if (knight.isAlive()) {
            knight.setBaseModifier(knight.getBaseModifier() - Constants.DRACULA_KNIGHT_MODIFIER);
            knight.takeDamage(Constants.DRACULA_KNIGHT_HP);
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.setBaseModifier(rogue.getBaseModifier() - Constants.DRACULA_ROGUE_MODIFIER);
            rogue.takeDamage(Constants.DRACULA_ROGUE_HP);
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.setBaseModifier(wizard.getBaseModifier() - Constants.DRACULA_WIZARD_MODIFIER);
            wizard.takeDamage(Constants.DRACULA_WIZARD_HP);
            return true;
        }
        return false;
    }
}
