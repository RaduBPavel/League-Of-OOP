package observer;

import angels.BaseAngel;
import players.BasePlayer;

import fileio.implementations.FileWriter;
import java.util.List;

// Grand Magician, implemented with the help of the Singleton Pattern
public final class GrandMagician {
    private static GrandMagician instance = null;
    private FileWriter fileWriter;

    private GrandMagician() { }
    public static GrandMagician getInstance() {
        if (instance == null) {
            instance = new GrandMagician();
        }

        return instance;
    }

    public void setFileName(final String fileName) {
        try {
            this.fileWriter = new FileWriter(fileName);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // Round update message
    public void updateRound(final int roundNumber) {
        try {
            if (roundNumber != 1) {
                fileWriter.writeNewLine();
            }

            fileWriter.writeWord("~~ Round " + roundNumber + " ~~");
            fileWriter.writeNewLine();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // Player kill update message
    public void updatePlayerKill(final BasePlayer killedPlayer, final int indexKilled,
                                 final BasePlayer killerPlayer, final int indexKiller) {
        try {
            fileWriter.writeWord("Player " + killedPlayer.getPlayerName()
                    + " " + indexKilled + " was killed by " + killerPlayer.getPlayerName()
                    + " " + indexKiller + "\n");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // Player level up update message
    public void updateLevel(final BasePlayer player, final int index, final int prevLevel) {
        try {
           for (int i = prevLevel + 1; i <= player.getLevel(); ++i) {
               fileWriter.writeWord(player.getPlayerName() + " " + index
                       + " reached level " + i + "\n");
           }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // Angel Spawn update message
    public void updateAngelSpawn(final BaseAngel angel) {
        try {
            fileWriter.writeWord("Angel " + angel.getAngelName() + " was spawned at "
                    + angel.getCurrRow() + " " + angel.getCurrCol() + "\n");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // Angel effect update message
    public void updateAngelAction(final BaseAngel angel, final BasePlayer player, final int index,
                                  final String action) {
        try {
            fileWriter.writeWord(angel.getAngelName());
            if (angel.isHelper()) {
                fileWriter.writeWord(" helped ");
            } else {
                fileWriter.writeWord(" hit ");
            }
            fileWriter.writeWord(player.getPlayerName() + " " + index + "\n");

            if (action.equals("revived")) {
                fileWriter.writeWord("Player " + player.getPlayerName() + " " + index
                        + " was brought to life by an angel\n");
            } else if (action.equals("killed")) {
                fileWriter.writeWord("Player " + player.getPlayerName() + " " + index
                        + " was killed by an angel\n");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // Final results update message
    public void writeResults(final List<BasePlayer> players) {
        try {
            fileWriter.writeNewLine();
            fileWriter.writeWord("~~ Results ~~\n");
            for (BasePlayer player : players) {
                if (!player.isAlive()) {
                    fileWriter.writeWord(player.getPlayerType() + " dead ");
                    fileWriter.writeNewLine();
                } else {
                    fileWriter.writeWord((player.toString()));
                    fileWriter.writeNewLine();
                }
            }
            fileWriter.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
