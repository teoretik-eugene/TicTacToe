package TicTacToe;

import java.util.Scanner;

public class Game {
	public boolean endOfgame = false;
	protected GameBoard gm;			
	
	Game(GameBoard gm){ this.gm = gm; }		// �������� ������ �����
	
	/* �������� ���� */
	protected boolean CheckTable(int a) {			// � - �������� �������� ��� ������
		// �������� �� �����������
		for(int i = 0; i < 3; i++) {
			if(gm.GameTable[i][0] == a && gm.GameTable[i][1] == a && gm.GameTable[i][2] == a)
				return true;
		}
		// �������� �� ���������
		for(int i = 0; i < 3; i++) {
			if(gm.GameTable[0][i] == a && gm.GameTable[1][i] == a && gm.GameTable[2][i] == a)
				return true;
		}
		if((gm.GameTable[0][0] == a && gm.GameTable[1][1] == a && gm.GameTable[2][2] == a) || (gm.GameTable[2][0] == a && gm.GameTable[1][1] == a && gm.GameTable[0][2] == a))
			return true;
		return false;
	}
	
	protected boolean draw() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(gm.GameTable[i][j] == -1)
					return false;
			}
		}
		return true;
	}

	/* ����� ���� */
	protected void StartGame() {
		int turn = 1; 			// ���������� ���: ������� ��� �����
		Scanner in = new Scanner(System.in);		// ��������� Scanner 
		
		System.out.println("������� ���������� � �������� [1;3]");
		while(!endOfgame) {
			System.out.println();
			int x, y;
			/* ��� "��������" */
			if(turn == 1) {
				System.out.println("��� ��������: ");		// ��������������� �� �������� ���������� �����
				System.out.print("������: ");
				if(!(in.hasNextInt())) {
					System.out.println("����� �� �����, �������������� ���������");
					break;
				}
				x = in.nextInt();
				System.out.print("�������: ");
				if(!(in.hasNextInt())) {
					System.out.println("����� �� �����, �������������� ���������");
					break;
				}
				y = in.nextInt();
				System.out.println("");			// ������� ������
				if(gm.GameTable[x-1][y-1] != -1) {
					System.out.println("������");		// �������� �� ��������� ������ 
					continue;
				}
				gm.GameTable[--x][--y] = 1;		// ���������� ��������� ����
				gm.board[x*2][y*2] = 'X';		// ���������� ����������� ����
				turn--;		// ������� ��������� � "������"
				gm.DrawBoard();
				/* �������� �� ����������� */
				if(CheckTable(1)) {
					System.out.println("\n\n\"�������\" �������!");
					endOfgame = true;
				}
				if(draw()) {
					System.out.println("\n\n�����");
					break;
				}
			}
			/* ��� "������" */
			else {				// ��� ���������� � ���������
				System.out.println("��� ������: ");
				System.out.print("������: ");
				if(!(in.hasNextInt())) {
					System.out.println("����� �� �����, �������������� ���������");
					break;
				}
				x = in.nextInt();
				System.out.print("�������: ");
				if(!(in.hasNextInt())) {
					System.out.println("����� �� �����, �������������� ���������");
					break;
				}
				y = in.nextInt();
				System.out.println("");
				if(gm.GameTable[x-1][y-1] != -1) {
					System.out.println("������");
					continue;
				}
				gm.GameTable[--x][--y] = 0;
				gm.board[x*2][y*2] = 'O';				
				turn++;		// ������� ��������� � "��������"
				gm.DrawBoard();
				if(CheckTable(0)) {
					System.out.println("\n\n\"�����\" �������!");
					endOfgame = true;
				}
				if(draw()) {
					System.out.println("\n\n�����");
					break;
				}
			}
		}
		in.close();
	}
}
