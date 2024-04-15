package MVPGlobal.Model;

public class Move {
    public boolean isValid(Board board, StoneColour playerColour, int startX, int startY, int endX, int endY) {
        // Check if the move is within the bounds of the board
        if (startX < 0 || startY < 0 || endX < 0 || endY < 0 ||
                startX >= board.getSize() || startY >= board.getSize() ||
                endX >= board.getSize() || endY >= board.getSize()) {
            return false;
        }

        // Check if the start square contains a stone of the player's color
        Square startSquare = board.getSquare(startX, startY);
        Stone startStone = startSquare.getStone();
        if (startStone == null || startStone.getColour() != playerColour) {
            return false;
        }

        // Add more validation rules according to the specific rules of Shobu

        return true;
    }

    public boolean isPassive() {
        // In Shobu, a move is passive if it doesn't involve removing stones from the board
        return false; // Assuming all moves in Shobu are active
    }
}
