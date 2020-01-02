package main;

import java.util.List;

// Class used for storing and passing data
public final class ProjectInput {
    private final List<String> gameMap;
    private final List<List<String>> playersData;
    private final List<String> playersMoves;
    private final List<List<String>> angelsData;
    private final int noRows;
    private final int noCols;

    public ProjectInput() {
        noRows = -1;
        noCols = -1;
        gameMap = null;
        playersData = null;
        playersMoves = null;
        angelsData = null;
    }

    ProjectInput(final List<String> gameMap, final List<List<String>> playersData,
                 final List<String> playersMoves, final int noRows, final int noCols,
                 final List<List<String>> angelsData) {
        this.gameMap = gameMap;
        this.playersMoves = playersMoves;
        this.playersData = playersData;
        this.noRows = noRows;
        this.noCols = noCols;
        this.angelsData = angelsData;
    }

    List<String> getGameMap() {
        return gameMap;
    }

    List<List<String>> getPlayersData() {
        return playersData;
    }

    List<String> getPlayersMoves() {
        return playersMoves;
    }

    int getNoRows() {
        return noRows;
    }

    int getNoCols() {
        return noCols;
    }

    List<List<String>> getAngelsData() {
        return angelsData;
    }

    public boolean isValidInput() {
        boolean membersInstantiated = gameMap != null && playersData != null
                && playersMoves != null && angelsData != null;
        boolean membersNotEmpty = gameMap.size() > 0 && playersData.size() > 0
                && playersMoves.size() > 0 && noRows > 0 && noCols > 0 &&
                angelsData.size() != 0;

        return membersInstantiated && membersNotEmpty;
    }
}
