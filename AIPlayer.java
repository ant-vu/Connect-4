import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    @Override
    public void makeMove(Board board) {
        int winMove = -1;
        for (int col = 0; col < board.getColumns(); col++) {
            if (board.validMove(col)) {
                board.playMove(symbol, col);
                if (board.containsWin()) {
                    winMove = col;
                }
                board.undoMove(col);
            }
        }
        if (winMove != -1) {
            board.playMove(symbol, winMove);
        }
        else if (board.containsWinOpponent(symbol) != -1) {
            board.playMove(symbol, board.containsWinOpponent(symbol));
        }
        else {
            Random random = new Random();
            int col = random.nextInt(7);
            while (!board.validMove(col)) {
                col = random.nextInt(7);
            }
            board.playMove(symbol, col);
        }
    }

}
