package TicTacToe;

import java.util.Scanner;

public class Game {
	public boolean endOfgame = false;
	protected GameBoard gm;			
	
	Game(GameBoard gm){ this.gm = gm; }		// Получаем объект доски
	
	/* Проверка поля */
	protected boolean CheckTable(int a) {			// а - значение крестика или нолика
		// Проверка по горизонтали
		for(int i = 0; i < 3; i++) {
			if(gm.GameTable[i][0] == a && gm.GameTable[i][1] == a && gm.GameTable[i][2] == a)
				return true;
		}
		// Проверка по вертикали
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

	/* Старт игры */
	protected void StartGame() {
		int turn = 1; 			// Показывает ход: крестик или нолик
		Scanner in = new Scanner(System.in);		// Открываем Scanner 
		
		System.out.println("Вводить координаты в пределах [1;3]");
		while(!endOfgame) {
			System.out.println();
			int x, y;
			/* Ход "Крестика" */
			if(turn == 1) {
				System.out.println("Ход крестика: ");		// Модернизировать на проверку введенного числа
				System.out.print("Строка: ");
				if(!(in.hasNextInt())) {
					System.out.println("Ввели не число, перезагружайте программу");
					break;
				}
				x = in.nextInt();
				System.out.print("Столбец: ");
				if(!(in.hasNextInt())) {
					System.out.println("Ввели не число, перезагружайте программу");
					break;
				}
				y = in.nextInt();
				System.out.println("");			// Сделать пробел
				if(gm.GameTable[x-1][y-1] != -1) {
					System.out.println("Занято");		// Проверка на занятость клетки 
					continue;
				}
				gm.GameTable[--x][--y] = 1;		// Заполнение цифрового поля
				gm.board[x*2][y*2] = 'X';		// Заполнение символьного поля
				turn--;		// Очередь переходит к "нолику"
				gm.DrawBoard();
				/* Проверка на пересечение */
				if(CheckTable(1)) {
					System.out.println("\n\n\"Крестик\" победил!");
					endOfgame = true;
				}
				if(draw()) {
					System.out.println("\n\nНичья");
					break;
				}
			}
			/* Ход "Нолика" */
			else {				// Все аналогично с крестиком
				System.out.println("Ход нолика: ");
				System.out.print("Строка: ");
				if(!(in.hasNextInt())) {
					System.out.println("Ввели не число, перезагружайте программу");
					break;
				}
				x = in.nextInt();
				System.out.print("Столбец: ");
				if(!(in.hasNextInt())) {
					System.out.println("Ввели не число, перезагружайте программу");
					break;
				}
				y = in.nextInt();
				System.out.println("");
				if(gm.GameTable[x-1][y-1] != -1) {
					System.out.println("Занято");
					continue;
				}
				gm.GameTable[--x][--y] = 0;
				gm.board[x*2][y*2] = 'O';				
				turn++;		// Очередь переходит к "крестику"
				gm.DrawBoard();
				if(CheckTable(0)) {
					System.out.println("\n\n\"Нолик\" победил!");
					endOfgame = true;
				}
				if(draw()) {
					System.out.println("\n\nНичья");
					break;
				}
			}
		}
		in.close();
	}
}
