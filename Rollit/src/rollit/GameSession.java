package rollit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameSession {
    private final Board board;
    private Player[] players;
    private List<Move> moveList;
    private int amountOfPlayers;
    private int turnNumber;

    public int getAmountOfPlayers() {
        return amountOfPlayers;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public GameSession(Board board) {
        this.board = board;
        amountOfPlayers = 0;
        moveList = new ArrayList<>();
        turnNumber = 0;
        this.players = new Player[4];
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
        amountOfPlayers++;
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
        Player CurrentPlayer = getCurrent();
        CurrentPlayer.Play(coordinate);
        moveList.add(new Move(coordinate, CurrentPlayer.getColor(), board));
        turnNumber++;
    }

    public Player getCurrent() {
        return players[turnNumber % (amountOfPlayers )];
    }


    public void undo() {
        board.clear();
        board.init();
        turnNumber = 0;
        moveList.remove(moveList.getLast());
        for (Move move : moveList) {
            //kijkt voor de zekerheid of de move in de movelijst zijn kleur overeenkomt met de beurtorder zijn kleur (normaal zou da ni fout kunnen lopen)
            if (move.getColor() == getCurrent().getColor()) {
                Play(move.getCoordinate());
            } else {
                throw new IllegalArgumentException("coordinate playorder mismatch (dees zou ni mogen gebeuren ma voor de zekerheid)");
            }


        }
    }

}
