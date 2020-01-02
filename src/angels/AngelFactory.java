package angels;

import java.util.List;

public final class AngelFactory {
    public enum AngelType {
        DamageAngel, DarkAngel, Dracula, GoodBoy, LevelUpAngel, LifeGiver,
            SmallAngel, Spawner, TheDoomer, XPAngel
    }

    public AngelFactory() { }

    public BaseAngel getAngel(final String[] angelData) {
        int currRow = Integer.parseInt(angelData[1]);
        int currCol = Integer.parseInt(angelData[2]);

        switch (angelData[0]) {
            case "DamageAngel":
                return new DamageAngel(currRow, currCol);
            case "DarkAngel":
                return new DarkAngel(currRow, currCol);
            case "Dracula":
                return new Dracula(currRow, currCol);
            case "GoodBoy":
                return new GoodBoy(currRow, currCol);
            case "LevelUpAngel":
                return new LevelUpAngel(currRow, currCol);
            case "LifeGiver":
                return new LifeGiver(currRow, currCol);
            case "SmallAngel":
                return new SmallAngel(currRow, currCol);
            case "Spawner":
                return new Spawner(currRow, currCol);
            case "TheDoomer":
                return new TheDoomer(currRow, currCol);
            case "XPAngel":
                return new XPAngel(currRow, currCol);
        }

        return null;
    }
}
