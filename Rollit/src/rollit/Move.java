package rollit;

public class Move {
    private final int x;
    private final int y;
    private final Color color;
    private final Board board;

    public int getX() {
        return x;
    }

    //    Setter - Y
    public void setX(int x) {
    }

    public int getY() {
        return y;
    }

    //    Setter - Y
    public void setY(int y) {
    }

    public Color getColor() {
        return color;
    }

    //    Setter - Y
    public void setColor(Color color) {
    }

    public Move(int x, int y, Color color, Board board) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.board = board;


    }

    //    Probeersel voor boolean, width en height zou ik lokaal moeten implementeren op deze manier
//    Voor te checken of de zet binnen de grenzen zit van het bord
//    Moet bedenken wat die anders returned als het gaat of een bal in de weg zit etc. - Y
    // i guess het is makkelijker om gwn te zeggen dat elke zet een board nodig heeft -K
    public boolean checkLegal(int x, int y) {
        if (x < 0 || x >= board.getWidth() || y < 0 || y >= board.getHeight()) {
            return false;
            //kijkt of er al een piece is op die plek
        } else if (board.getPiece(x, y) != null) {
            return false;

            //kijkt of het piece naast een piece ligt
        } else if (
                        (board.getPiece(x+1, y) == null) ||
                        (board.getPiece(x-1, y) == null) ||
                        (board.getPiece(x, y+1) == null) ||
                        (board.getPiece(x, y-1) == null) ||
                        (board.getPiece(x+1,y+1) == null) ||
                        (board.getPiece(x+1,y-1) == null) ||
                        (board.getPiece(x-1,y+1) == null) ||
                        (board.getPiece(x-1,y-1) == null)
        ) {
            return false;

        }
        else {
            //hier moet nog een check off ge een bal kunt capturen en ge dat doet -k
            return true;
        }

    }
}
