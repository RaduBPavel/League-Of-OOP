package main;

import game.GameBoard;
import players.BasePlayer;
import java.util.List;

public final class Main {
    private Main() { }

    public static void main(final String[] args) {
        // Read the data from the current file and stores it
        ProjectInputLoader projectInputLoader = new ProjectInputLoader(args[0]);
        ProjectInput projectInput = projectInputLoader.load();

        // Instantiate the game board and plays the game
        GameBoard gameBoard = new GameBoard(projectInput.getGameMap(),
                projectInput.getPlayersData(), projectInput.getPlayersMoves(),
                projectInput.getNoRows(), projectInput.getNoCols());
        gameBoard.play();

        // Writes the data to the output file
        List<BasePlayer> players = gameBoard.getListOfPlayers();
        ProjectOutput projectOutput = new ProjectOutput(args[1], players);
        projectOutput.write();
    }
}
