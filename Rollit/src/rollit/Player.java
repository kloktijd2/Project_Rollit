package rollit;

public class Player {
    private Color color;
    private int score;
    private final String name;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
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

}
