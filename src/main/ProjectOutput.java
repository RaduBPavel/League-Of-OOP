package main;

import fileio.implementations.FileWriter;
import players.BasePlayer;

import java.util.List;

// Class used for writing data
class ProjectOutput {
    private final String filename;
    private List<BasePlayer> players;

    ProjectOutput(final String filename, final List<BasePlayer> players) {
        this.filename = filename;
        this.players = players;
    }

    final void write() {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            for (BasePlayer player : players) {
                if (!player.isAlive()) {
                    fileWriter.writeWord(player.getPlayerType() + " dead");
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
