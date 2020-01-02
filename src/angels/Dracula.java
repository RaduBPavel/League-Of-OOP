package angels;

public final class Dracula extends BaseAngel {
    public Dracula(int currRow, int currCol) {
        super(currRow, currCol);
    }

    @Override
    public String toString() {
        return "Dracula{" +
                "currRow=" + currRow +
                ", currCol=" + currCol +
                '}';
    }
}
