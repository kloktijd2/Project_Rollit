package rollit;

public class Move {
    private final int x;
    private final int y;
    private final Color color;

    public int getX() {
        return x;
    }

//    Setter - Y
    public void setX(int x) {}

    public int getY() {
        return y;
    }

//    Setter - Y
    public void setY(int y) {}

    public Color getColor() {
        return color;
    }

//    Setter - Y
    public void setColor(Color color) {}

    public Move(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;


    }

//    Probeersel voor boolean, width en height zou ik lokaal moeten implementeren op deze manier
//    Voor te checken of de zet binnen de grenzen zit van het bord
//    Moet bedenken wat die anders returned als het gaat of een bal in de weg zit etc. - Y
//    public boolean checkLegal(int x, int y) {
//        if (x < 0 || x >= width || y < 0 || y >= height){
//            return false;
//        }
//    }
}
