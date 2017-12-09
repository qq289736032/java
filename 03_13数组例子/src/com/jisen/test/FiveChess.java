package com.jisen.test;

public class FiveChess{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int row = 19, colum = 16;
		String chessBoard[][] = new String[row][colum];

		// {"â”?,"â”?,"â”?},
		// {"â”?,"â•?,"â”?},
		// {"â”?,"â”?,"â”?}
		chessBoard[0][0] = "â”";
		chessBoard[0][colum - 1] = "â”";
		chessBoard[row - 1][0] = "â”";
		chessBoard[row - 1][colum - 1] = "â”";
		int i = 0, j = 0;
		for (i = 1; i < row - 1; i++) {
			chessBoard[i][0] = "â”";
			chessBoard[i][colum - 1] = "â”";
			for (j = 1; j < colum - 1; j++) {
				chessBoard[0][j] = "â”";
				chessBoard[row - 1][j] = "â”";
				chessBoard[i][j] = "â•";
			}
		}
		chessBoard[5][5] = "â—";
		chessBoard[2][2] = "â—";
		for (i = 0; i < chessBoard.length; i++) {
			for (j = 0; j < chessBoard[i].length; j++) {
				System.out.print(chessBoard[i][j]);
			}
			System.out.println();
		}

	}

}
