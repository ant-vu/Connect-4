import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    @Override
    public void makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(name + ", please input your move: ");
        int col = scanner.nextInt();
        while (!board.validMove(col - 1)) {
            System.out.print(name + ", please input your move: ");
            col = scanner.nextInt();
        }
        board.playMove(symbol, col - 1);
    }

}
