package game;

import angels.AngelFactory;
import observer.GrandMagician;
import players.BasePlayer;
import players.PlayerFactory;
import angels.BaseAngel;

import java.util.ArrayList;
import java.util.List;

public final class GameBoard {
    private String[][] gameMap;
    private List<BasePlayer> listOfPlayers;
    private List<String> playerMoves;
    private List<List<BaseAngel>> angelsData;
    private static GameBoard instance = null;
    private GrandMagician grandMagician = null;

    public static GameBoard getInstance() {
        if (instance == null) {
            instance = new GameBoard();
        }

        return instance;
    }

    private GameBoard() {}

    public void setData(final List<String> gameMap, final List<List<String>> playersData,
                        final List<String> playersMoves, final int noRows, final int noCols,
                        final List<List<String>> angelsData, final GrandMagician grandMagician) {
        this.gameMap = new String[noRows][noCols];
        this.listOfPlayers = new ArrayList<>();
        this.playerMoves = new ArrayList<>();
        this.angelsData = new ArrayList<>();
        this.grandMagician = grandMagician;

        // Construct the game space
        for (int i = 0; i < noRows; ++i) {
            for (int j = 0; j < noCols; ++j) {
                this.gameMap[i][j] = Character.toString(gameMap.get(i).charAt(j));
            }
        }

        // Instantiate the players
        PlayerFactory playerFactory = new PlayerFactory();
        for (List<String> playersDatum : playersData) {
            this.listOfPlayers.add(playerFactory.getPlayer(playersDatum));
        }

        // Store the moves of the players
        this.playerMoves.addAll(playersMoves);

        // Instantiate the angels
        AngelFactory angelFactory = new AngelFactory();
        for (List<String> angelList : angelsData) {
            List<BaseAngel> tempAngelList = new ArrayList<>();

            for (String angelInfo : angelList) {
                tempAngelList.add(angelFactory.getAngel(angelInfo.split(",")));
            }
            this.angelsData.add(tempAngelList);
        }
    }

    public void play() {
        int counter = -1;

        for (String playerMove : playerMoves) {
            List<Integer> prevLevelList = new ArrayList<>();
            prevLevelList.clear();

            // Acknowledge round number
            counter++;
            grandMagician.updateRound(counter + 1);

            // Apply the strategies and store initial levels
            for (BasePlayer player : listOfPlayers) {
                prevLevelList.add(player.getLevel());
                if (player.isAlive()) {
                    player.applyStrategy();
                }
            }

            // Move the players
            for (int j = 0; j < playerMove.length(); ++j) {
                if (!listOfPlayers.get(j).isAlive()) {
                    continue;
                }
                if (listOfPlayers.get(j).suffersFromStun()) {
                    listOfPlayers.get(j).applyStunEffects();
                    continue;
                }
                String currMove = Character.toString(playerMove.charAt(j));
                listOfPlayers.get(j).move(currMove);
            }

            // Check for DoT's
            for (BasePlayer player : listOfPlayers) {
                if (player.suffersFromDoT()) {
                    player.applyDoTEffects();
                }
            }

            // Initiate the fights
            for (int j = 0; j < listOfPlayers.size() - 1; ++j) {
                if (!listOfPlayers.get(j).isAlive()) {
                    continue;
                }

                // Looks for a player on the same position
                for (int k = j + 1; k < listOfPlayers.size(); ++k) {
                    if (!listOfPlayers.get(k).isAlive()) {
                        continue;
                    }

                    if (listOfPlayers.get(j).getRow() == listOfPlayers.get(k).getRow()
                            && listOfPlayers.get(j).getCol() == listOfPlayers.get(k).getCol()) {
                        fight(listOfPlayers.get(j), listOfPlayers.get(k));

                        // Update the magician with a kill message
                        if (!listOfPlayers.get(j).isAlive() && listOfPlayers.get(k).isAlive()) {
                            grandMagician.updatePlayerKill(listOfPlayers.get(j), j,
                                    listOfPlayers.get(k), k);

                        } else if (listOfPlayers.get(j).isAlive() && !listOfPlayers.get(k).isAlive()) {
                            grandMagician.updatePlayerKill(listOfPlayers.get(k), k,
                                    listOfPlayers.get(j), j);
                        }
                        break;
                    }
                }
            }

            // Checks if any players has leveled up
            int levelIndex = -1;
            for (BasePlayer player : listOfPlayers) {
                levelIndex++;
                if (player.levelStatus() && player.isAlive()) {
                    player.levelUp();
                    grandMagician.updateLevel(player, levelIndex, prevLevelList.get(levelIndex));
                }
            }

            // Apply the angel effects, if there are any
            List<BaseAngel> angelList = angelsData.get(counter);
            for (BaseAngel angel : angelList) {
                // Update the grand magician with the angel position
                grandMagician.updateAngelSpawn(angel);

                int index = -1;
                for (BasePlayer player : listOfPlayers) {
                    index++;
                    if (player.getCol() == angel.getCurrCol() && player.getRow() == angel.getCurrRow()) {
                        String action = "none";
                        boolean playerInitialStatus = player.isAlive();
                        player.isVisitedBy(angel);

                        // Checks if the player was killed or revived and update the magician
                        if (playerInitialStatus && playerInitialStatus != player.isAlive()) {
                            action = "killed";
                        } else if (!playerInitialStatus &&  playerInitialStatus != player.isAlive()) {
                            action = "revived";
                        }

                        grandMagician.updateAngelAction(angel, player, index, action);
                    }
                }
            }
        }
    }

    private void fight(final BasePlayer firstPlayer, final BasePlayer secondPlayer) {
        // Players attack each other, and if a player is rogue he always goes second
        if (firstPlayer.getPlayerType().equals("R")) {
            secondPlayer.attack(firstPlayer, gameMap[firstPlayer.getRow()][firstPlayer.getCol()]);
            firstPlayer.attack(secondPlayer, gameMap[firstPlayer.getRow()][firstPlayer.getCol()]);
        } else {
            firstPlayer.attack(secondPlayer, gameMap[firstPlayer.getRow()][firstPlayer.getCol()]);
            secondPlayer.attack(firstPlayer, gameMap[firstPlayer.getRow()][firstPlayer.getCol()]);
        }

        // Adds corresponding XP
        if (firstPlayer.isAlive() && !secondPlayer.isAlive()) {
            firstPlayer.addXP(secondPlayer);
        } else if (!firstPlayer.isAlive() && secondPlayer.isAlive()) {
            secondPlayer.addXP(firstPlayer);
        } else if (!firstPlayer.isAlive()) {
            int tempXP = secondPlayer.computeXP(firstPlayer);
            firstPlayer.addXP(secondPlayer);
            secondPlayer.addXP(tempXP);
        }
    }


    public List<BasePlayer> getListOfPlayers() {
        return listOfPlayers;
    }
}
