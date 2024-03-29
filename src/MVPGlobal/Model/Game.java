package MVPGlobal.Model;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private int scorePlayer1;
    private int scorePlayer2;
    private int amountOfMoves;

    // this constructor will be used to initialize games from a save state => hence the scores being added in arguments
    public Game(Board board, Player player1, Player player2, int scorePlayer1, int scorePlayer2, int amountOfMoves) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.scorePlayer1 = scorePlayer1;
        this.scorePlayer2 = scorePlayer2;
        this.amountOfMoves = amountOfMoves;
    }

    // this constructor will be used to initialize new games
    public Game(Board board, Player player1, Player player2, int amountOfMoves) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
        this.amountOfMoves = amountOfMoves;
    }

    public String getBoard(){
        return String.format("Placeholder for later");
    }

    public String getPlayer(int numberPlayer){
        switch (numberPlayer){
            case 1: return String.format("info about player 1");
            case 2: return String.format("info about player 2");
            default: return String.format("Invalid");
        }
    }
    public int getHighScores(int numberPlayer){
        switch (numberPlayer){
            case 1: return scorePlayer1 ;
            case 2: return scorePlayer2;
            // negative score is returned when an error is made
            default: return -1;
        }
    }
    public Game resetGame(Game game){
        game.scorePlayer2 = 0;
        game.scorePlayer1 = 0;
        game.amountOfMoves = 0;

        return game;
    }
}
