package TicTacToe;

public class GameStart {
	public static void main(String[] args) {
		System.out.println("����� ����: \n");
		GameBoard gm = new GameBoard();
		gm.DrawBoard();
		Game game = new Game(gm);
		game.StartGame();
	}
}
