package MVPGlobal.Model;

public class Board {
    private final int SIZE = 8; // Assuming an 8x8 square board
    private Square[][] squares;

    public Board() {
        squares = new Square[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize each square on the board
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                squares[i][j] = new Square();
            }
        }
    }

    public Square getSquare(int x, int y) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
            return squares[x][y];
        } else {
            return null; // Return null if coordinates are out of bounds
        }
    }

    public int getSize() {
        return SIZE;
    }
}
