/**
 * EXERCISE 8.16 Design a TwoPlayerGame subclass called RockPaperScissors. The rules of this game
 * are that each player, at the same time, picks either a rock, a paper, or a scissors. For each
 * round, the rock beats the scissors, the scissors beats the paper, and the paper beats the rock.
 * Ties are allowed. The game is won in a best out of three fashion when one of the players wins two
 * rounds.
 * 
 * OBS: The user interaction could be better done, but it's not my focus here.
 */

package chapter08;

public class RockPaperScisors extends TwoPlayerGame implements CLUIPlayableGame {
    public static final int INVALID = -1;
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISORS = 3;

    private int bestOfNGames;
    private int player1Wins;
    private int player2Wins;

    public RockPaperScisors() {
        this.bestOfNGames = 3;
        this.player1Wins = 0;
        this.player2Wins = 0;
    }

    public RockPaperScisors(int bestOfNGames) {
        this.player1Wins = 0;
        this.player2Wins = 0;

        // It has to be a positive odd number
        if (bestOfNGames > 0 && bestOfNGames % 2 == 1) {
            this.bestOfNGames = bestOfNGames;
        } else {
            this.bestOfNGames = 3;
        }
    }

    public boolean gameOver() {
        return this.player1Wins >= this.bestOfNGames / 2.0
                || this.player2Wins >= this.bestOfNGames / 2.0;
    }

    private int getGameWinner(int player1Movement, int player2Movement) {
        if (player1Movement == player2Movement) {
            return 0; // draw
        }
        if (player1Movement == INVALID) {
            return 2; // only player 1 made an invalid move
        }
        if (player2Movement == INVALID) {
            return 1; // only player 2 made an invalid move
        }
        if (player1Movement == ROCK) {
            if (player2Movement == SCISORS) {
                return 1; // player 1 wins
            }
            return 2; // player 2 played paper and wins
        }
        if (player1Movement == PAPER) {
            if (player2Movement == SCISORS) {
                return 2;
            }
            return 1; // player 2 played rock
        }
        if (player1Movement == SCISORS) {
            if (player2Movement == ROCK) {
                return 2;
            }
            return 1; // player 2 played paper
        }
        return 0; // default return
    }

    public String getWinner() {
        if (this.gameOver()) {
            return "The winner is: "
                    + (this.player1Wins > this.player2Wins ? "Player 1." : "Player 2.");
        }
        return "There's no winner yet!";
    }

    private int getPlayerMovement(int movement) {
        if (movement != ROCK && movement != SCISORS && movement != PAPER) {
            return INVALID;
        }
        return movement;
    }

    public String getGamePrompt() {
        return "\nYou can select: ROCK (" + ROCK + "); PAPER (" + PAPER + "); SCISORS (" + SCISORS
                + ").";
    }

    public String reportGameState() {
        if (!gameOver())
            return ("\nPlayer 1 wins: " + this.player1Wins + "; Player 2 wins: "
                    + this.player2Wins);
        else
            return ("\nGame over! Winner is Player " + getWinner() + " with "
                    + Math.max(this.player1Wins, this.player2Wins) + " wins.\n");
    }

    public void play(UserInterface ui) {

        ui.report(this.getRules());

        while (!this.gameOver()) {
            ui.report(this.reportGameState());

            // Player 1 moves
            ui.prompt("Player 1 turn!");
            ui.prompt(this.getGamePrompt());
            int player1Movement = this.getPlayerMovement(Integer.parseInt(ui.getUserInput()));

            // Player 2 moves
            ui.prompt("Player 2 turn!");
            ui.prompt(this.getGamePrompt());
            int player2Movement = this.getPlayerMovement(Integer.parseInt(ui.getUserInput()));

            int gameWinner = this.getGameWinner(player1Movement, player2Movement);

            if (gameWinner == 1) {
                this.player1Wins++;
            } else if (gameWinner == 2) {
                this.player2Wins++;
            }
        }
        ui.report(reportGameState());
    }

    public static void main(String args[]) {
        KeyboardReader kb = new KeyboardReader();
        CLUIPlayableGame game = new RockPaperScisors();

        game.play(kb);
    }
}
