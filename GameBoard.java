package TicTacToe;

public class GameBoard {
	/* ??????? ????, ????????? ?? ??????? ???????? */
	protected char[] [] board = {
		{' ','|', ' ', '|', ' '},
		{'-','+','-','+','-'},
		{' ','|', ' ', '|', ' '},
		{'-','+','-','+','-'},
		{' ','|', ' ', '|', ' '}
	};
	
	/* ??????? ???? ??? ??????? */
	/*
	 * ?????? ?????????? ???????? -1
	 * ? ???????? ???? ????? ??????????? 0 ??? 1
	 */
	int[] [] GameTable = {
			{-1, -1, -1},
			{-1, -1, -1},		
			{-1, -1, -1}
	};
	
	/* ?????, ?????????????? ???? */
	public void DrawBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < 5; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
	}
}

