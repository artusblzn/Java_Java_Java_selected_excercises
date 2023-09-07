// Class given by the book
// Just removed the computer players

package chapter08;


public abstract class TwoPlayerGame {
    public static final int PLAYER_ONE = 1; // Class constants
    public static final int PLAYER_TWO = 2;

    protected boolean onePlaysNext = true; // Player 1 plays next

    /**
     * setPlayer() sets which player makes the first move.
     * 
     * @param starter, an int representing PLAYER_ONE or PLAYER_TWOI
     */
    public void setPlayer(int starter) {
        if (starter == PLAYER_TWO)
            onePlaysNext = false;
        else
            onePlaysNext = true;
    } // setPlayer()

    /**
     * getPlayer() returns an int representing whose turn it it.
     * 
     * @return an int representing PLAYER_ONE or PLAYER_TWO.
     */
    public int getPlayer() {
        if (onePlaysNext)
            return PLAYER_ONE;
        else
            return PLAYER_TWO;
    } // getPlayer()

    /**
     * changePlayer() toggles between PLAYER_ONE or PLAYER_TWO.
     */
    public void changePlayer() {
        onePlaysNext = !onePlaysNext;
    } // changePlayer

    /**
     * getRules() returns a String describing the rules of the game.
     * 
     * @return a String giving the game's rules.
     */
    public String getRules() {
        return "The rules of this game are: ";
    }


    /**
     * gameOver() defines when the game is over. It is meant to be implemented in subclasses.
     */
    public abstract boolean gameOver(); // Abstract Methods

    /**
     * getWinner() defines who wins the game. It is meant to be implemented in subclasses.
     */
    public abstract String getWinner();
} // TwoPlayerGame
