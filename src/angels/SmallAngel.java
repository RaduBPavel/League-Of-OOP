package angels;

import common.Constants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

// Small Angel, heals players and increases their damage
public final class SmallAngel extends BaseAngel {
    public SmallAngel(final int currRow, final int currCol) {
        super(currRow, currCol);
        this.setHelperStatus(true);
        this.setAngelName("SmallAngel");
    }

    @Override
    public boolean visits(final Pyromancer pyro) {
        if (pyro.isAlive()) {
            pyro.setBaseModifier(pyro.getBaseModifier()
                    + Constants.SMALL_ANGEL_PYRO_MODIFIER);
            pyro.setCurrHP(pyro.getCurrHP() + Constants.SMALL_ANGEL_PYRO_HP);

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
            knight.setBaseModifier(knight.getBaseModifier()
                    + Constants.SMALL_ANGEL_KNIGHT_MODIFIER);
            knight.setCurrHP(knight.getCurrHP() + Constants.SMALL_ANGEL_KNIGHT_HP);

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
            rogue.setBaseModifier(rogue.getBaseModifier()
                    + Constants.SMALL_ANGEL_ROGUE_MODIFIER);
            rogue.setCurrHP(rogue.getCurrHP() + Constants.SMALL_ANGEL_ROGUE_HP);

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
            wizard.setBaseModifier(wizard.getBaseModifier()
                    + Constants.SMALL_ANGEL_WIZARD_MODIFIER);
            wizard.setCurrHP(wizard.getCurrHP() + Constants.SMALL_ANGEL_WIZARD_HP);

            // Checks if the maximum HP limit has been passed
            if (wizard.getCurrHP() > wizard.getMaxHP()) {
                wizard.setCurrHP(wizard.getMaxHP());
            }
            return true;
        }
        return false;
    }
}
