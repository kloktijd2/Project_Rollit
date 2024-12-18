package rollit;

public class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    //change color for after a move
    public void ChangeColor(Color color) {
        this.color = color;
        System.out.println("color changed");
    }
}
