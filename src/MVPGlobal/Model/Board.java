package MVPGlobal.Model;

import MVPGlobal.Model.Square;
import MVPGlobal.Model.Stone;

public class Board {
    private final int SIZE = 8; // Assuming an 8x8 square board
    private Square[][] squares;
    public Board(Stone stones){
        squares = new Square[SIZE][SIZE];
    }

    public Square getSquare(int x, int y) {
    return squares[x][y];
    }
}
