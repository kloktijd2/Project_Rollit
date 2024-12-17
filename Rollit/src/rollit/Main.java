package rollit;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        GameSession gameSession = new GameSession();
        gameSession.setBoard(board);

//        Color.RED want weet niet hoe je random kleur gaat geven of laten kiezen
        Player player1 = new Player("Speler 1", Color.RED);
        Player player2 = new Player("Speler 2", Color.BLUE);

        gameSession.addPlayer(player1);
        gameSession.addPlayer(player2);

        System.out.println(player1.getName() + " speelt met kleur: " + player1.getColor());
        System.out.println(player2.getName() + " speelt met kleur: " + player2.getColor());

        Move move = new Move(1, 2, player1.getColor());
        if (board.addPiece(move)) {
            System.out.println("Zet geplaatst door " + player1.getName());
        } else {
            System.out.println("Zet ongeldig!");
        }

        Menu menu = new Menu();
        menu.showHighScore();
        
        HighScoreRanking ranking = new HighScoreRanking();
        ranking.displayScores();
    }
}
