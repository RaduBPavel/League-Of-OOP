Pavel Radu-Bogdan
324CA
Facultatea de Automatica si Calculatoare



                                                     README
                                            League of OOP - 2nd Phase


1. Objective
    The objective of this project was to work upon a fully functioning game, written in Java, in order to implement new
functionalities and features. More specifically, in its incipient stage, League of OOP was a 2D, turn-based game, which
featured 4 different types of players, pitted against each other in an arena to determine the winner. Each player has
specific abilities and interactions with the other players, and each player has a predetermined set of moves which it
follows.
    In the 2nd phase of the project, several new features are added. In order to make the game more challenging for the
players, two new major aspects were added: the presence of angels and strategies. Angels are either malevolent or
benevolent creatures, which help or hinder players, be it by increasing or reducing their damage, damaging or healing
them, giving them XP, or even killing and reviving them. Strategies are dynamically chosen by the players, based on
their remaining health, in order to increase their damage and reduce their health, or vice-versa.
    Finally, an admin was also added to the game, named the Grand Magician. The role of this admin is to monitor the
moves of the players and the angels, and document the fights and interaction that take place between them, in order to
give a better overview of the game when it is finished.

2. Implementation details
    By using the already existing Java code of the game, the only modifications to the game were in the form of adding
the angels to the game, along with their respective effects, implementing the strategies for each of the players and
implementing the functionalities of the Grand Magician, which acts as an observer.
    The interaction between the angels and players was modelled based on the Visitor Design Pattern. By using this
design pattern, I made sure that the correct class type was passed as an argument when executing the interactions
between the entities, more specifically, the instance type, instead of the reference type. Thus, each player has a
"isVisitedBy", function, which calls a "visit" function inside the respective angel type, where the interactions are
modelled.
    The main objective of the strategies was to model them in order to be chosen dynamically by the players, based on
preexisting conditions (their amount of remaining HP compared to their maximum HP). In order to do that and decouple
the strategy implementation from the implementation of the player, in order to achieve a certain degree of
encapsulation, I have used the Strategy Design Pattern. By using this pattern, each player can choose dynamically
between two preexisting strategies, each player with his own specific strategies. The players choose their strategy
using the "applyStrategy" method, which calls the respective strategy and then the interaction takes place.
    The Grand Magician was modelled using the Observer Design Pattern. In our case, the Observable object is the
game board, which is constantly shifting based on the interactions of the players. The game board thus sends an update
message to the Grand Magician each time a change is made, which the Grand Magician documents and then, in my case,
prints the specific message associated with that change.
