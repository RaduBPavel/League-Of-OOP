package angels;

public final class LifeGiver extends BaseAngel {
    public LifeGiver(int currRow, int currCol) {
        super(currRow, currCol);
    }

    @Override
    public String toString() {
        return "LifeGiver{" +
                "currRow=" + currRow +
                ", currCol=" + currCol +
                '}';
    }
}
