package rollit;

public class Player {
    private Color color;
    private int score;
    private final String name;
    private final int playerNumber;

    public Player(String name, Color color, int playerNumber) {
        this.name = name;
        this.color = color;
        this.playerNumber = playerNumber;
//        standaardscore op 0 zetten hier? "this.score = 0;" - Y
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

//    Voor de score omhoog te laten gaan?
//    public void addScore(int points) {
//    this.score += points;
//    } - Y

}
