package rollit;

public class Move {
    private final Coordinate coordinate;
    private final Color color;
    private final Board board;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    //    Setter - Y
    public void setCoordinate(int coordinate) {
    }


    public Color getColor() {
        return color;
    }

    //    Setter - Y
    public void setColor(Color color) {
    }

    public Move(Coordinate coordinate, Color color, Board board) {
        this.coordinate = coordinate;
        this.color = color;
        this.board = board;
    }

    //    Probeersel voor boolean, width en height zou ik lokaal moeten implementeren op deze manier
//    Voor te checken of de zet binnen de grenzen zit van het bord
//    Moet bedenken wat die anders returned als het gaat of een bal in de weg zit etc. - Y
    // i guess het is makkelijker om gwn te zeggen dat elke zet een board nodig heeft
    // also check legal heeft geen coordinate nodig da pakt die gwn uit de move-K
    public boolean checkLegal() {
        if (coordinate.getX() < 0 || coordinate.getX() >= board.getWidth() || coordinate.getY() < 0 || coordinate.getY() >= board.getHeight()) {
            return false;
            //kijkt of er al een piece is op die plek
        } else if (board.getPiece(coordinate) != null) {
            return false;

            //kijkt of het piece naast een piece ligt
        } else if ( // klein nadeel aan mijn nieuwe klasse coordinaat, nu moet ik hier altijd coordinaten maken gebaseerd op vorige coordinaten
                (board.getPiece(coordinate.addCoordinateInt(1, 0)) == null) &&
                        (board.getPiece(coordinate.addCoordinateInt(-1, 0)) == null) &&
                        (board.getPiece(coordinate.addCoordinateInt(0, 1)) == null) &&
                        (board.getPiece(coordinate.addCoordinateInt(0, -1)) == null) &&
                        (board.getPiece(coordinate.addCoordinateInt(1, 1)) == null) &&
                        (board.getPiece(coordinate.addCoordinateInt(1, -1)) == null) &&
                        (board.getPiece(coordinate.addCoordinateInt(-1, 1)) == null) &&
                        (board.getPiece(coordinate.addCoordinateInt(-1, -1)) == null)
        ) {
            return false;

        } else if (
                (getFirstN() == null) &&
                        (getFirstNE() == null) &&
                        (getFirstE() == null) &&
                        (getFirstSE() == null) &&
                        (getFirstS() == null) &&
                        (getFirstSW() == null) &&
                        (getFirstW() == null) &&
                        (getFirstNW() == null)
        ) {
            if (board.getAmount(color) == 0) {
                return true;
            }
            else {
                return false;
            }

        } else {
            return true;
        }

    }

    //Alle getFirst zijn om de eerste coordinaat met dezelfde kleur in die richting te vinden
    public Coordinate getFirstN() {
        boolean looping = true;
        int iterator = 1;
        Coordinate check;
        Coordinate coord = null;
        while (looping) {
            check = coordinate.addCoordinateInt(0, -iterator);
            if (board.getPiece(check) == null) {
                looping = false;
            } else if (board.getPiece(check).getColor() == color) {
                looping = false;
                coord = check;
            } else {
                iterator++;
            }
        }
        return coord;
    }

    public Coordinate getFirstNE() {
        boolean looping = true;
        int iterator = 1;
        Coordinate check;
        Coordinate coord = null;
        while (looping) {
            check = coordinate.addCoordinateInt(iterator, -iterator);
            if (board.getPiece(check) == null) {
                looping = false;
            } else if (board.getPiece(check).getColor() == color) {
                looping = false;
                coord = check;
            } else {
                iterator++;
            }
        }
        return coord;
    }

    public Coordinate getFirstE() {
        boolean looping = true;
        int iterator = 1;
        Coordinate check;
        Coordinate coord = null;
        while (looping) {
            check = coordinate.addCoordinateInt(iterator, 0);
            if (board.getPiece(check) == null) {
                looping = false;
            } else if (board.getPiece(check).getColor() == color) {
                looping = false;
                coord = check;
            } else {
                iterator++;
            }
        }
        return coord;
    }

    public Coordinate getFirstSE() {
        boolean looping = true;
        int iterator = 1;
        Coordinate check;
        Coordinate coord = null;
        while (looping) {
            check = coordinate.addCoordinateInt(iterator, iterator);
            if (board.getPiece(check) == null) {
                looping = false;
            } else if (board.getPiece(check).getColor() == color) {
                looping = false;
                coord = check;
            } else {
                iterator++;
            }
        }
        return coord;
    }

    public Coordinate getFirstS() {
        boolean looping = true;
        int iterator = 1;
        Coordinate check;
        Coordinate coord = null;
        while (looping) {
            check = coordinate.addCoordinateInt(0, iterator);
            if (board.getPiece(check) == null) {
                looping = false;
            } else if (board.getPiece(check).getColor() == color) {
                looping = false;
                coord = check;
            } else {
                iterator++;
            }
        }
        return coord;
    }

    public Coordinate getFirstSW() {
        boolean looping = true;
        int iterator = 1;
        Coordinate check;
        Coordinate coord = null;
        while (looping) {
            check = coordinate.addCoordinateInt(-iterator, iterator);
            if (board.getPiece(check) == null) {
                looping = false;
            } else if (board.getPiece(check).getColor() == color) {
                looping = false;
                coord = check;
            } else {
                iterator++;
            }
        }
        return coord;
    }

    public Coordinate getFirstW() {
        boolean looping = true;
        int iterator = 1;
        Coordinate check;
        Coordinate coord = null;
        while (looping) {
            check = coordinate.addCoordinateInt(-iterator, 0);
            if (board.getPiece(check) == null) {
                looping = false;
            } else if (board.getPiece(check).getColor() == color) {
                looping = false;
                coord = check;
            } else {
                iterator++;
            }
        }
        return coord;
    }

    public Coordinate getFirstNW() {
        boolean looping = true;
        int iterator = 1;
        Coordinate check;
        Coordinate coord = null;
        while (looping) {
            check = coordinate.addCoordinateInt(-iterator, -iterator);
            if (board.getPiece(check) == null) {
                looping = false;
            } else if (board.getPiece(check).getColor() == color) {
                looping = false;
                coord = check;
            } else {
                iterator++;
            }
        }
        return coord;
    }
}
