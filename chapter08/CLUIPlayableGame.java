// Class given by the book

package chapter08;

public interface CLUIPlayableGame extends IGame {

    /**
     * play() implements the play loop for a game that interfaces to a UserInterface. It is meant to
     * be implented by games that support a command-line interface.
     */
    public abstract void play(UserInterface ui);
}
