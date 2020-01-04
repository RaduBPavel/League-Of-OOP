package main;

import game.GameBoard;
import observer.GrandMagician;
import players.BasePlayer;
import java.util.List;

public final class Main {
    private Main() { }

    public static void main(final String[] args) {
        // Read the data from the current file and stores it
        ProjectInputLoader projectInputLoader = new ProjectInputLoader(args[0]);
        ProjectInput projectInput = projectInputLoader.load();

        // Instantiate the game board and the grand magician and plays the game
        GrandMagician grandMagician = GrandMagician.getInstance();
        grandMagician.setFileName(args[1]);

        GameBoard gameBoard = GameBoard.getInstance();
        gameBoard.setData(projectInput.getGameMap(),
                projectInput.getPlayersData(), projectInput.getPlayersMoves(),
                projectInput.getNoRows(), projectInput.getNoCols(),
                projectInput.getAngelsData(), grandMagician);
        gameBoard.play();

        // Writes the data to the output file
        List<BasePlayer> players = gameBoard.getListOfPlayers();
        grandMagician.writeResults(players);
    }
}
