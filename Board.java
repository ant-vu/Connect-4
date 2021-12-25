public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private final char[][] board = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
	
	/* 
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 */
	
	public Board() {
		for (int row = 0; row < NUM_OF_ROW; row++) {
			for (int col = 0; col < NUM_OF_COLUMNS; col++) {
				board[row][col] = ' ';
			}
		}
	}
	
	public void printBoard() {
		for (int row = 0; row < NUM_OF_ROW; row++) {
			System.out.print("|");
			for (int col = 0; col < NUM_OF_COLUMNS; col++) {
				System.out.print(board[row][col]);
				System.out.print("|");
			}
			System.out.println();
		}
	}
	
	public boolean containsWin() {
		for (int row = 0; row < NUM_OF_ROW; row++) {
			for (int col = 0; col < NUM_OF_COLUMNS - 3; col++) {
				if (board[row][col] != ' ' &&
						board[row][col + 1] != ' ' &&
						board[row][col + 2] != ' ' &&
						board[row][col + 3] != ' ' &&
						board[row][col] == board[row][col + 1] &&
						board[row][col] == board[row][col + 2] &&
						board[row][col] == board[row][col + 3]) {
					return true;
				}
			}
		}
		for (int row = 0; row < NUM_OF_ROW - 3; row++) {
			for (int col = 0; col < NUM_OF_COLUMNS; col++) {
				if (board[row][col] != ' ' &&
						board[row + 1][col] != ' ' &&
						board[row + 2][col] != ' ' &&
						board[row + 3][col] != ' ' &&
						board[row][col] == board[row + 1][col] &&
						board[row][col] == board[row + 2][col] &&
						board[row][col] == board[row + 3][col]) {
					return true;
				}
			}
		}
		for (int row = 3; row < NUM_OF_ROW; row++) {
			for (int col = 0; col < NUM_OF_COLUMNS - 3; col++) {
				if (board[row][col] != ' ' &&
						board[row - 1][col + 1] != ' ' &&
						board[row - 2][col + 2] != ' ' &&
						board[row - 3][col + 3] != ' ' &&
						board[row][col] == board[row - 1][col + 1] &&
						board[row][col] == board[row - 2][col + 2] &&
						board[row][col] == board[row - 3][col + 3]) {
					return true;
				}
			}
		}
		for (int row = 0; row < NUM_OF_ROW - 3; row++) {
			for (int col = 0; col < NUM_OF_COLUMNS - 3; col++) {
				if (board[row][col] != ' ' &&
						board[row + 1][col + 1] != ' ' &&
						board[row + 2][col + 2] != ' ' &&
						board[row + 3][col + 3] != ' ' &&
						board[row][col] == board[row + 1][col + 1] &&
						board[row][col] == board[row + 2][col + 2] &&
						board[row][col] == board[row + 3][col + 3]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isTie() {
		for (int col = 0; col < NUM_OF_COLUMNS; col++) {
			if (board[0][col] == ' ') {
				return false;
			}
		}
		return true;
	}
	
	public void reset() {
		for (int row = 0; row < NUM_OF_ROW; row++) {
			for (int col = 0; col < NUM_OF_COLUMNS; col++) {
				board[row][col] = ' ';
			}
		}
	}

	public double getColumns() {
		return NUM_OF_COLUMNS;
	}

	public void playMove(char sym, int col) {
		for (int row = NUM_OF_ROW - 1; row >= 0; row--) {
			if (board[row][col] == ' ') {
				board[row][col] = sym;
				break;
			}
		}
	}

	public boolean validMove(int col) {
		for (int row = NUM_OF_ROW - 1; row >= 0; row--) {
			if (board[row][col] == ' ') {
				return true;
			}
		}
		return false;
	}

	public void undoMove(int col) {
		for (int row = 0; row < NUM_OF_ROW; row++) {
			if (board[row][col] != ' ') {
				board[row][col] = ' ';
				break;
			}
		}
	}

	public int containsWinOpponent(char sym) {
		char opponentSymbol = ' ';
		int opponentColumn = -1;
		for (int row = 0; row < NUM_OF_ROW; row++) {
			for (int col = 0; col < NUM_OF_COLUMNS; col++) {
				if (board[row][col] != sym && board[row][col] != ' ') {
					opponentSymbol = board[row][col];
				}
			}
		}
		for (int col = 0; col < NUM_OF_COLUMNS; col++) {
			if (validMove(col)) {
				playMove(opponentSymbol, col);
				if (containsWin()) {
					opponentColumn = col;
				}
				undoMove(col);
			}
		}
		return opponentColumn;
	}
	
}
