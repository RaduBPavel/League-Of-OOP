package angels;

public final class Spawner extends BaseAngel {
    public Spawner(int currRow, int currCol) {
        super(currRow, currCol);
    }

    @Override
    public String toString() {
        return "Spawner{" +
                "currRow=" + currRow +
                ", currCol=" + currCol +
                '}';
    }
}
