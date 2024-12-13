package rollit;

public class Board {
    private Piece[][] board;
    private final int width;
    private final int height;

    public Board(int width, int height) {
        board = new Piece[width][height];
        this.width =width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public int getAmountFilled(){
        int amount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] != null) {
                    amount++;
                }
            }

        }
        return amount;
    }

    // renamed getFull to IsFull omda da een bool is
    public boolean IsFull() {
        return (getAmountFilled() == width*height);
    }
    
    public int getAmount(Color color) {
        int amount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //checkt eerst of coordinaat i, j ingevuld is en dan pas of de kleur hetzelfde is
                //(niet in een if omdat ik bang ben dat da anders crasht)
                if (board[i][j] != null) {
                    if (board[i][j].getColor() == color) {
                        amount++;
                    }
                }
                
            }
            
        }
        return amount;
    }

    void clear() {
        board = new Piece[width][height];
    }

//    Trying om de SetPiece erin te krijgen, geen idee wat ik best nog erbij steek voor compleet
//    Probably iets van bekijken of de zet kan ma no idea of ik het erbij moet steken - Y
    public void SetPiece(Move move){
        int x = move.getX();
        int y = move.getY();
        Color color = move.getColor();
    }
}
