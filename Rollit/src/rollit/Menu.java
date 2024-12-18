package rollit;

public class Menu {
    private GameSession session;
    private HighscoreRanking highScores;

    public HighscoreRanking getHighScores() {
        return highScores;
    }

    public Menu() {
        highScores = new HighscoreRanking();
    }

    public GameSession getSession() {
        return session;
    }

    public void start2player(int boardWidth, int boardHeight, String naam1, String naam2) {
        session = new GameSession(new Board(boardWidth, boardHeight));
        session.getBoard().init();
        session.addPlayer(naam1);
        session.addPlayer(naam2);
    }

    public void start3player(int boardWidth, int boardHeight, String naam1, String naam2, String naam3) {
        session = new GameSession(new Board(boardWidth, boardHeight));
        session.getBoard().init();
        session.addPlayer(naam1);
        session.addPlayer(naam2);
        session.addPlayer(naam3);
    }

    public void start4player(int boardWidth, int boardHeight, String naam1, String naam2, String naam3, String naam4) {
        session = new GameSession(new Board(boardWidth, boardHeight));
        session.getBoard().init();
        session.addPlayer(naam1);
        session.addPlayer(naam2);
        session.addPlayer(naam3);
        session.addPlayer(naam4);
    }

    public String showHighScores() {
        return highScores.toString();
    }

}
