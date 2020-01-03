package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class Dracula extends BaseAngel {
    public Dracula(int currRow, int currCol) {
        super(currRow, currCol);
    }

    @Override
    public void visits(Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.setBaseModifier(pyro.getBaseModifier() - Constants.DRACULA_PYRO_MODIFIER);
            pyro.takeDamage(Constants.DRACULA_PYRO_HP);
        }
    }

    @Override
    public void visits(Knight knight) {
        if (knight.isAlive()) {
            knight.setBaseModifier(knight.getBaseModifier() - Constants.DRACULA_KNIGHT_MODIFIER);
            knight.takeDamage(Constants.DRACULA_KNIGHT_HP);
        }
    }

    @Override
    public void visits(Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.setBaseModifier(rogue.getBaseModifier() - Constants.DRACULA_ROGUE_MODIFIER);
            rogue.takeDamage(Constants.DRACULA_ROGUE_HP);
        }
    }

    @Override
    public void visits(Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.setBaseModifier(wizard.getBaseModifier() - Constants.DRACULA_WIZARD_MODIFIER);
            wizard.takeDamage(Constants.DRACULA_WIZARD_HP);
        }
    }

    @Override
    public String toString() {
        return "Dracula{" +
                "currRow=" + currRow +
                ", currCol=" + currCol +
                '}';
    }
}
