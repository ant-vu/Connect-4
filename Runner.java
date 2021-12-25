public class Runner {

    public static void main(String[] args) {
        Board board = new Board();
        ConnectFour game = new ConnectFour(board);
        game.setPlayer1(new AIPlayer('A', board, "Anthony"));
        game.setPlayer2(new AIPlayer('V', board, "Vincent"));
        game.playGame();
    }

}
