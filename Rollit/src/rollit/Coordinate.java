package rollit;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    //verandert niks aan de coordinaat maakt het gwn makkelijker om andere coordinaten te maken gebasseerd op vorige coordinaten
    
    public Coordinate addCoordinateInt(int x, int y) {
        return new Coordinate(this.x +x, this.y + y);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",x,y);
    }
}
