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
    public abstract boolean visits(Pyromancer pyro);
    public abstract boolean visits(Knight knight);
    public abstract boolean visits(Rogue rogue);
    public abstract boolean visits(Wizard wizard);

    /***
     * @return
     */
    public int getCurrRow() {
        return currRow;
    }

    /***
     * @return
     */
    public int getCurrCol() {
        return currCol;
    }

    /***
     *
     * @return
     */
    public boolean isHelper() {
        return helperStatus;
    }

    /***
     * @param helperStatus
     */
    public void setHelperStatus(final boolean helperStatus) {
        this.helperStatus = helperStatus;
    }

    /***
     * @return
     */
    public String getAngelName() {
        return angelName;
    }

    /***
     * @param angelName
     */
    public void setAngelName(final String angelName) {
        this.angelName = angelName;
    }
}
