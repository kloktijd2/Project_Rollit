package rollit;

public class Move {
    private final int x;
    private final int y;
    private final Color color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public Move(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;


    }
}
