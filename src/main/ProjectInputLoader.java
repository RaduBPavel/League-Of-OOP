package main;

import fileio.implementations.FileReader;
import java.util.ArrayList;
import java.util.List;

// Class used for reading the input data
public final class ProjectInputLoader {
    private static final int NUM_ARGUMENTS = 3;
    private final String mInputPath;

    public ProjectInputLoader(final String inputPath) {
        this.mInputPath = inputPath;
    }

    public ProjectInput load() {
        List<String> gameMap = new ArrayList<>();
        List<List<String>> playersData = new ArrayList<>();
        List<String> playersMoves = new ArrayList<>();
        int noRows = 0;
        int noCols = 0;
        int noPlayers = 0;
        int noMoves = 0;

        // Reads the input from the .in file
        try {
            FileReader fs = new FileReader(mInputPath);

            noRows = fs.nextInt();
            noCols = fs.nextInt();
            for (int i = 0; i < noRows; ++i) {
                gameMap.add(fs.nextWord());
            }

            noPlayers = fs.nextInt();
            for (int i = 0; i < noPlayers; ++i) {
                List<String> tempList = new ArrayList<>();
                for (int j = 0; j < NUM_ARGUMENTS; ++j) {
                    tempList.add(fs.nextWord());
                }
                playersData.add(tempList);
            }

            noMoves = fs.nextInt();
            for (int i = 0; i < noMoves; ++i) {
                playersMoves.add(fs.nextWord());
            }

            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new ProjectInput(gameMap, playersData, playersMoves, noRows, noCols);
    }
}
