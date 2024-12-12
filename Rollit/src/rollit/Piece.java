package rollit;

public class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void ChangeColor(Color color) {
        this.color = color;
    }
}
