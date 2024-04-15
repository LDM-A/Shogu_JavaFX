package MVPGlobal.Model;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private int scorePlayer1;
    private int scorePlayer2;
    private int amountOfMoves;

    public Game(Board board, Player player1, Player player2, int amountOfMoves) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
        this.amountOfMoves = amountOfMoves;
    }

    public String getBoardState() {
        // Return the current state of the board
        return "Placeholder for board state";
    }

    public String getPlayerInfo(int playerNumber) {
        // Return information about the specified player
        if (playerNumber == 1) {
            return player1.toString(); // Implement toString() method in Player class to provide player info
        } else if (playerNumber == 2) {
            return player2.toString(); // Implement toString() method in Player class to provide player info
        } else {
            return "Invalid player number";
        }
    }

    public int getHighScore(int playerNumber) {
        // Return the high score of the specified player
        if (playerNumber == 1) {
            return scorePlayer1;
        } else if (playerNumber == 2) {
            return scorePlayer2;
        } else {
            return -1; // Negative score indicates an error
        }
    }

    public void resetGame() {
        // Reset the game to the initial state
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        amountOfMoves = 0;
    }
}
