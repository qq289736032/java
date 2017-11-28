package com.jisen.test;

public class 五子棋 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int row = 19, colum = 16;
		String chessBoard[][] = new String[row][colum];

		// {"┏","┳","┓"},
		// {"┣","╋","┫"},
		// {"┗","┻","┛"}
		chessBoard[0][0] = "┏";
		chessBoard[0][colum - 1] = "┓";
		chessBoard[row - 1][0] = "┗";
		chessBoard[row - 1][colum - 1] = "┛";
		int i = 0, j = 0;
		for (i = 1; i < row - 1; i++) {
			chessBoard[i][0] = "┣";
			chessBoard[i][colum - 1] = "┫";
			for (j = 1; j < colum - 1; j++) {
				chessBoard[0][j] = "┳";
				chessBoard[row - 1][j] = "┻";
				chessBoard[i][j] = "╋";
			}
		}
		chessBoard[5][5] = "○";
		chessBoard[2][2] = "●";
		for (i = 0; i < chessBoard.length; i++) {
			for (j = 0; j < chessBoard[i].length; j++) {
				System.out.print(chessBoard[i][j]);
			}
			System.out.println();
		}

	}

}
