package rollit;

public class Menu {
    GameSession session;

    public void start2player(int boardWidth, int boardHeight) {
        session = new GameSession(new Board(boardWidth, boardHeight));
        //LANGE NI AF
        // doe opt einde

    }
}
