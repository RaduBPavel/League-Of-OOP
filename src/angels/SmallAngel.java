package angels;

public final class SmallAngel extends BaseAngel {
    public SmallAngel(int currRow, int currCol) {
        super(currRow, currCol);
    }

    @Override
    public String toString() {
        return "SmallAngel{" +
                "currRow=" + currRow +
                ", currCol=" + currCol +
                '}';
    }
}
