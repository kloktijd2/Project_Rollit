package rollit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameSession {
    private final Board board;
    private Player[] players;
    private List<Move> moveList;
    int amountOfPlayers;
    int turnNumber;

    public GameSession(Board board) {
        this.board = board;
        amountOfPlayers = 0;
        moveList = new ArrayList<>();
        turnNumber = 0;
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

        players[amountOfPlayers] = new Player(name, color, amountOfPlayers, board);
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

    public void Play(Coordinate coordinate) {
        Player CurrentPlayer = players[turnNumber % (amountOfPlayers + 1)];
        CurrentPlayer.Play(coordinate);
        moveList.add(new Move(coordinate, CurrentPlayer.getColor(), board));
    }

    public void undo() {
        board.clear();
        turnNumber = 0;
        moveList.remove(moveList.getLast());
        for (Move move : moveList) {
            //kijkt voor de zekerheid of de move in de movelijst zijn kleur overeenkomt met de beurtorder zijn kleur (normaal zou da ni fout kunnen lopen)
            if (move.getColor() == players[turnNumber % (amountOfPlayers + 1)].getColor()) {
                Play(move.getCoordinate());
            } else {
                throw new IllegalArgumentException("coordinate playorder mismatch (dees zou ni mogen gebeuren ma voor de zekerheid)");
            }


        }
    }

}
