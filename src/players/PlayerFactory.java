package players;

import java.util.List;

// Factory class for player generation
public final class PlayerFactory {
    public PlayerFactory() { }

    public BasePlayer getPlayer(final List<String> playerData) {
        int currRow = Integer.parseInt(playerData.get(1));
        int currCol = Integer.parseInt(playerData.get(2));

        if (playerData.get(0).equals("P")) {
            return new Pyromancer(currRow, currCol);
        }
        if (playerData.get(0).equals("K")) {
            return new Knight(currRow, currCol);
        }
        if (playerData.get(0).equals("W")) {
            return new Wizard(currRow, currCol);
        }
        if (playerData.get(0).equals("R")) {
            return new Rogue(currRow, currCol);
        }
        return null;
    }
}
