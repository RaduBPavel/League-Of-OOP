package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class XPAngel extends BaseAngel {
    public XPAngel(final int currRow, final int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(true);
        this.setAngelName("XPAngel");
    }

    @Override
    public boolean visits(final Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.addXP(Constants.XP_ANGEL_PYRO_XP_MODIFIER);
            if (pyro.levelStatus()) {
                pyro.levelUp();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Knight knight) {
        if (knight.isAlive()) {
            knight.addXP(Constants.XP_ANGEL_KNIGHT_XP_MODIFIER);
            if (knight.levelStatus()) {
                knight.levelUp();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Rogue rogue) {
        if (rogue.isAlive()) {
            rogue.addXP(Constants.XP_ANGEL_ROGUE_XP_MODIFIER);
            if (rogue.levelStatus()) {
                rogue.levelUp();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean visits(final Wizard wizard) {
        if (wizard.isAlive()) {
            wizard.addXP(Constants.XP_ANGEL_WIZARD_XP_MODIFIER);
            if (wizard.levelStatus()) {
                wizard.levelUp();
            }
            return true;
        }
        return false;
    }
}
