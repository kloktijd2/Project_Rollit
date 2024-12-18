package rollit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighscoreRanking {
//    Lists voor de verschillende aantal spelers met scores - Y
    private final List<Player> twoPlayerScores;
    private final List<Player> threePlayerScores;
    private final List<Player> fourPlayerScores;

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
            scoreList.removeLast();
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

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Top scores 2 player games:\n");
        for (int i = 0; i < getTopScores(2).size(); i++) {
            string.append((i + 1)).append(". ").append(getTopScores(2).get(i).getName()).append(": ").append(getTopScores(2).get(i).getScore()).append("\n");
        }

        string.append("\nTop scores 3 player games: \n");
        for (int i = 0; i < getTopScores(3).size(); i++) {
            string.append((i + 1)).append(". ").append(getTopScores(3).get(i).getName()).append(": ").append(getTopScores(3).get(i).getScore());
        }

        string.append("\nTop scores 4 player games: \n");
        for (int i = 0; i < getTopScores(3).size(); i++) {
            string.append((i + 1)).append(". ").append(getTopScores(4).get(i).getName()).append(": ").append(getTopScores(4).get(i).getScore());
        }
        return string.toString();
    }
}
