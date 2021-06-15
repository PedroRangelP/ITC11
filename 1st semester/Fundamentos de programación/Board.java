public class Board {
	public static final int EMPTY_CELL = -1;
	public static final int HUMAN_CHIP = 0;
	public static final int COMPUTER_CHIP = 1;
    private int[][] board;

    public Board() {
        board = new int[3][3];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public String getBoardDisplay() {
        String texto = "\n";
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                texto += getChip(board[i][j]) + " | ";
            }
            texto = texto.substring(0, texto.length()-3) + "\n";
            if (i<2)
	            texto += "---------\n";
        }
        return texto;
    }

    public boolean turn(int player, int row, int column) {
        if (board[row][column] == EMPTY_CELL) {
            board[row][column] = player;
            return true;
        }
        return false;
    }

    private String getChip(int value) {
        String chip = " ";
        if (value == HUMAN_CHIP)
            chip = "X";
        else if (value == COMPUTER_CHIP)
            chip = "O";

        return chip;
    }

    public String getWinner() {
		int winner = determineWinner();
		if (winner == HUMAN_CHIP)
			return "You win!";
		else if (winner == COMPUTER_CHIP)
			return "Computer wins!";
		else
			return "It's a tie";
	}

    public int determineWinner() {
        int winner = EMPTY_CELL;
        //Verificar lineas horizontales
        for (int i=0; i<board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != EMPTY_CELL) {
                winner = board[i][0];
			}
        }

        //Verificar lineas verticales
        for (int i=0; i<board.length; i++) {
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != EMPTY_CELL) {
                winner = board[0][i];
			}
        }

        //Verificar diagonales
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != EMPTY_CELL) {
            winner = board[0][0];
		}
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != EMPTY_CELL) {
            winner = board[0][2];
		}

        //Verificar empate
        if (winner == EMPTY_CELL) {
			int casillasVacias = 0;
			for (int i=0; i<board.length; i++) {
				for (int j=0; j<board[i].length; j++) {
					if (board[i][j] == EMPTY_CELL)
						casillasVacias++;
				}
			}
			if (casillasVacias == 0)
				winner = 2;
		}

        return winner;
    }
}