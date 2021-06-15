import java.util.Scanner;

/**
 * Tic tac toe game
 */
public class TicTacToe {
	/**
	 *
	 * The only valid values are:
	 * Board.EMPTY_CELL When the cell has no chips
	 * Board.COMPUTER_CHIP WHen the computer has already placed a chip in there
	 * Board.HUMAN_CHIP When the user has already placed a chip in there
	 */
	public static void automaticTurn(Board game) {
		int[][] board = game.getBoard();
		boolean turn = false;

		//WRITE YOUR CODE HERE

		//SAMPLE CODE. You can remove it if you want.
		//Looks for the first empty cell (left to right, top to bottom) and places a chip in there
		for (int i=0; i<3 && !turn; i++) {
			for (int j=0; j<3 && !turn; j++) {
				if (board[i][j] == Board.EMPTY_CELL) {
					board[i][j] = Board.COMPUTER_CHIP;
					turn = true;
				}
			}
		}
	}

    public static void main(String[] args) {
        Board board = new Board();
        Scanner scan = new Scanner(System.in);
        int row, column;

        do {
			//Ask the place of the chip
			boolean isValid = true;
			do {
				if (isValid == false)
					System.out.println("Invalid spot. Try again.");
				System.out.print("Row: ");
				row = Integer.parseInt(scan.nextLine());
				System.out.print("Column: ");
				column = Integer.parseInt(scan.nextLine());
				isValid = board.turn(Board.HUMAN_CHIP, row, column);
			} while (isValid == false);
			//Check if somebody won
			if (board.determineWinner() < 0) {
            	automaticTurn(board);
			}
			//Print the board
			System.out.println(board.getBoardDisplay());
        } while (board.determineWinner() < 0);
		//Print the name of the winner
        System.out.println(board.getWinner());
    }
}