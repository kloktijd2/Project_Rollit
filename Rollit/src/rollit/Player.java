package rollit;

public class Player {
    private Color color;
    private int score;
    private final String name;
    private final int playerNumber;
    private final Board board;

    public Player(String name, Color color, int playerNumber, Board board) {
        this.name = name;
        this.color = color;
        this.playerNumber = playerNumber;
//        standaardscore op 0 zetten hier? "this.score = 0;" - Y
        this.board = board;
    }

    public Color getColor() {
        return color;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setScore(int score) {
        this.score = score;
    }

//   Dit toegevoegd als setter, "name = name" omdat het final is dus geen this - Y
    public void setName(String name) {
        name = name;
    }

//    Getter om playernummer te krijgen - Y
    public int getPlayerNumber() {
        return playerNumber;
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
            board.SetPiece(move);
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
