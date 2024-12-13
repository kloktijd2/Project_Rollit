package rollit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighscoreRanking {
//    Lists voor de verschillende aantal spelers met scores - Y
    private List<Player> twoPlayerScores;
    private List<Player> threePlayerScores;
    private List<Player> fourPlayerScores;

//    Constructor - Y
    public HighscoreRanking() {
        this.twoPlayerScores = new ArrayList<>();
        this.threePlayerScores = new ArrayList<>();
        this.fourPlayerScores = new ArrayList<>();
    }

//     Scores toevoegen aan lijsten met aantal spelers - Y
    public void addScore(Player player, int numPlayers) {
        switch (numPlayers) {
            case 2 -> addScoreToList(player, twoPlayerScores);
            case 3 -> addScoreToList(player, threePlayerScores);
            case 4 -> addScoreToList(player, fourPlayerScores);
            default -> throw new IllegalArgumentException("Invalid number of players: " + numPlayers);
        }
    }

//     Score toevoegen en sorteren - Y
    private void addScoreToList(Player player, List<Player> scoreList) {
        scoreList.add(player);
//         Hoogste eerst - Y
        scoreList.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));
//         Laatste 5 Scores - Y
        if (scoreList.size() > 5) {
            scoreList.remove(scoreList.size() - 1);
        }
    }

//   Scores ophalen voor bepaald aantal spelers - Y
    public List<Player> getTopScores(int numPlayers) {
        return switch (numPlayers) {
            case 2 -> Collections.unmodifiableList(twoPlayerScores);
            case 3 -> Collections.unmodifiableList(threePlayerScores);
            case 4 -> Collections.unmodifiableList(fourPlayerScores);
            default -> throw new IllegalArgumentException("Invalid number of players: " + numPlayers);
        };
    }
}
