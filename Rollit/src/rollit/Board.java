package rollit;

public class Board {
    private Piece[][] board;
    private final int width;
    private final int height;

    public Board(int width, int height) {
        board = new Piece[width][height];
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Piece getPiece(Coordinate coordinate) {
        // extra code zodat mijn checklegal functie geen errors krijgt als die out of bounds pieces probeert te lezen
        if ((coordinate.getX() >= 0) && (coordinate.getX() < width) && (coordinate.getY() >= 0) && (coordinate.getY() < height)) {
            return board[coordinate.getX()][coordinate.getY()];
        } else {
            return null;
        }
    }

    public int getAmountFilled() {
        int amount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] != null) {
                    amount++;
                }
            }

        }
        return amount;
    }

    // renamed getFull to IsFull omda da een bool is
    public boolean IsFull() {
        return (getAmountFilled() == width * height);
    }

    public int getAmount(Color color) {
        int amount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //checkt eerst of coordinaat i, j ingevuld is en dan pas of de kleur hetzelfde is
                //(niet in een if omdat ik bang ben dat da anders crasht)
                if (board[i][j] != null) {
                    if (board[i][j].getColor() == color) {
                        amount++;
                    }
                }

            }

        }
        return amount;
    }

    void clear() {
        board = new Piece[width][height];
    }

//    Trying om de SetPiece erin te krijgen, geen idee wat ik best nog erbij steek voor compleet
//    Probably iets van bekijken of de zet kan ma no idea of ik het erbij moet steken - Y

    // kheb nog ni gekozen of ik de logica om de andere pieces te veranderen ook hier in wil of ergens anders
    //also dit doet nog niks lol
    //update kga het in Player.play() doen
    public void setPiece(Move move) {
        Coordinate coordinate = move.getCoordinate();
        int x = coordinate.getX();
        int y = coordinate.getY();
        Color color = move.getColor();
        board[x][y] = new Piece(color);
    }


    public String toString(Player current) {
        StringBuilder string = new StringBuilder();
        string.append("   ");
        for (int i = 0; i < width; i++) {
            string.append(String.format("%d",i)).append(" ");
        }
        string.append("\n  ");
        string.append("--".repeat(Math.max(0, width)));
        string.append("\n");
        for (int i = 0; i < height; i++) {
            string.append(String.format("%2d",i)).append("|");
            for (int j = 0; j < width; j++) {
                if (board[j][i] == null) {
                    Move check = new Move(new Coordinate(j,i), current.getColor(), this );
                    if (check.checkLegal()) {
                        string.append("\u001B[36m");

                    }
                    string.append("0 ").append("\u001B[0m");
                } else {

                    string.append(board[j][i].getColor().getChar()).append(" ");
                }
            }
            string.append("\n");

        }
        return string.toString();
    }

    public void init() {
        Move temp1 = new Move(new Coordinate((width/2)-1,(height/2)-1), Color.RED, this);
        setPiece(temp1);
        Move temp2 = new Move(new Coordinate((width/2),(height/2)-1), Color.YELLOW, this);
        setPiece(temp2);
        Move temp3 = new Move(new Coordinate((width/2),(height/2)), Color.GREEN, this);
        setPiece(temp3);
        Move temp4 = new Move(new Coordinate((width/2)-1,(height/2)), Color.BLUE, this);
        setPiece(temp4);
    }
}
