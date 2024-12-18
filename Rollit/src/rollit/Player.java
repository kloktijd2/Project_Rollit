package rollit;

public class Player {
    private final Color color;
    private int score;
    private final String name;
    private final Board board;

    public Player(String name, Color color, Board board) {
        this.name = name;
        this.color = color;
        //        standaardscore op 0 zetten hier? "this.score = 0;" - Y
        this.board = board;
    }

    public Color getColor() {
        return color;
    }

    public int getScore() {
        UpdateScore();
        return score;
    }

    public String getName() {
        return name;
    }

    //    Voor de score omhoog te laten
//    public void addScore(int points) {
//    this.score += points;
//    } - Y
    // nee want score moet gwn geupdated worden met UpdateScore na elke move, ni 1 per 1

    public void UpdateScore() {
        this.score = board.getAmount(color);
    }


    public void Play(Coordinate coordinate) {
        Move move = new Move(coordinate, color, board);
        if (move.checkLegal()) {
            board.setPiece(move);
            if (move.getFirstN() != null) {
                Coordinate N = move.getFirstN();
                int it = coordinate.getY() - N.getY();
                for (int i = 0; i < it; i++) {
                    board.getPiece(coordinate.addCoordinateInt(0,-i)).ChangeColor(color);

                }
            }

            if (move.getFirstNE() != null) {
                Coordinate NE = move.getFirstNE();
                int it = NE.getX() - coordinate.getX();
                for (int i = 0; i < it; i++) {
                    board.getPiece(coordinate.addCoordinateInt(i,-i)).ChangeColor(color);

                }
            }

            if (move.getFirstE() != null) {
                Coordinate E = move.getFirstE();
                int it = E.getX() - coordinate.getX();
                for (int i = 0; i < it; i++) {
                    board.getPiece(coordinate.addCoordinateInt(i,0)).ChangeColor(color);

                }
            }

            if (move.getFirstSE() != null) {
                Coordinate SE = move.getFirstSE();
                int it = SE.getX() - coordinate.getX();
                for (int i = 0; i < it; i++) {
                    board.getPiece(coordinate.addCoordinateInt(i,i)).ChangeColor(color);

                }
            }

            if (move.getFirstS() != null) {
                Coordinate S = move.getFirstS();
                int it = S.getY()-  coordinate.getY();
                for (int i = 0; i < it; i++) {
                    board.getPiece(coordinate.addCoordinateInt(0,i)).ChangeColor(color);

                }
            }

            if (move.getFirstSW() != null) {
                Coordinate SW = move.getFirstSW();
                int it =   coordinate.getX() - SW.getX();
                for (int i = 0; i < it; i++) {
                    board.getPiece(coordinate.addCoordinateInt(-i,i)).ChangeColor(color);

                }
            }

            if (move.getFirstW() != null) {
                Coordinate W = move.getFirstW();
                int it =   coordinate.getX() - W.getX();
                for (int i = 0; i < it; i++) {
                    board.getPiece(coordinate.addCoordinateInt(-i,0)).ChangeColor(color);

                }
            }

            if (move.getFirstNW() != null) {
                Coordinate NW = move.getFirstNW();
                int it =   coordinate.getX() - NW.getX();
                for (int i = 0; i < it; i++) {
                    board.getPiece(coordinate.addCoordinateInt(-i,-i)).ChangeColor(color);

                }
            }

            UpdateScore();

        }
    }
}
