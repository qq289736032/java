package com.jisen;


import java.util.Arrays;
import java.util.Scanner;

public class 五子棋优化 {

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public static void showChessBoard(int row,int colum){
		
		String chessBoard[][] = new String[row][colum];

		// {"┏","┳","┓"},
		// {"┣","╋","┫"},
		// {"┗","┻","┛"}
		chessBoard[0][0] = "┏━";
		chessBoard[0][colum - 1] = "┓";
		chessBoard[row - 1][0] = "┗━";
		chessBoard[row - 1][colum - 1] = "┛";
		int i = 0, j = 0;
		for (i = 1; i < row - 1; i++) {
			chessBoard[i][0] = "┣━";
			chessBoard[i][colum - 1] = "┫";
			for (j = 1; j < colum - 1; j++) {
				chessBoard[0][j] = "┳━";
				chessBoard[row - 1][j] = "┻━";
				chessBoard[i][j] = "╋━";
			}
		}
		//chessBoard[5][5] = "○";
		//chessBoard[2][2] = "●";
		String[] shu=new String[colum];
		Arrays.fill(shu, "┃");
		for (i = 0; i < chessBoard.length; i++) {
			for (j = 0; j < chessBoard[i].length; j++) {
				System.out.print(chessBoard[i][j]);
			}
			if(i==chessBoard.length-1)
				break;
			System.out.println();
			for (j = 0; j < chessBoard[i].length; j++) {
				System.out.print(shu[j]+"  ");
				
			}
			System.out.println();
			
		}
	}
	
	public static void main(String[] args) {
		System.out.print("请输入棋盘的行数和列数：");
		Scanner scan=new Scanner(System.in);
		int row=scan.nextInt();
		int colum=scan.nextInt();
		showChessBoard(row,colum);
		System.out.println("请输入");

	}

}
