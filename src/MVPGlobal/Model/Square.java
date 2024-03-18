package MVPGlobal.Model;

public class Square {
    // Squares that make up the board
    private Stone stone;

    // Constructor
    public Square() {
        this.stone = null;
    }

    public Square(Stone stone) {
        this.stone = stone;
    }
    public Stone getPiece() {
        return stone;
    }

    public void setPiece(Stone stone) {
        this.stone = stone;
    }

    public boolean isEmpty() {
        return stone == null;
    }
}
