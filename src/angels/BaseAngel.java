package angels;

import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public abstract class BaseAngel {
    private int currRow;
    private int currCol;
    private boolean helperStatus;
    private String angelName;

    public BaseAngel(final int currRow, final int currCol) {
        this.currRow = currRow;
        this.currCol = currCol;
    }

    public BaseAngel() {
        this.currCol = -1;
        this.currRow = -1;
    }

    // Functions used for Double Dispatch
    public abstract void visits(Pyromancer pyro);
    public abstract void visits(Knight knight);
    public abstract void visits(Rogue rogue);
    public abstract void visits(Wizard wizard);

    public int getCurrRow() {
        return currRow;
    }

    public int getCurrCol() {
        return currCol;
    }

    public boolean isHelper() {
        return helperStatus;
    }

    public void setHelperStatus(boolean helperStatus) {
        this.helperStatus = helperStatus;
    }

    public String getAngelName() {
        return angelName;
    }

    public void setAngelName(String angelName) {
        this.angelName = angelName;
    }
}
