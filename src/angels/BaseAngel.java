package angels;

public abstract class BaseAngel {
    protected int currRow;
    protected int currCol;

    public BaseAngel(final int currRow, final int currCol) {
        this.currRow = currRow;
        this.currCol = currCol;
    }

    public BaseAngel() {
        this.currCol = -1;
        this.currRow = -1;
    }
}
