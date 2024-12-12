package rollit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameSession {
    private final Board board;
    private Player[] players;
    private List<Move> moveList;
    int amountOfPlayers;

    public GameSession(Board board) {
        this.board = board;
        amountOfPlayers =0;
        moveList = new ArrayList<>() {
        };
    }

    public void addPlayer(String name) {
        Color color;

        switch (amountOfPlayers) {
            case 0 -> color = Color.RED;
            case 1 -> color = Color.GREEN;
            case 2 -> color = Color.YELLOW;
            case 3 -> color = Color.BLUE;
            default -> color = Color.EMPTY;
        }

        players[amountOfPlayers] = new Player(name, color, amountOfPlayers);
    }
    
    void AddMove(Move move) {
        moveList.add(move);
    }
    
    public Player getPlayer(int playerID) {
        return players[playerID];
    }


    public Board getBoard() {
        return board;
    }
}
