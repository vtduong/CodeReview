package gameOfLife;

import java.util.Scanner;

public class GameOfLife {
	private static int row;
	private static int col;
	private static int[][] arr;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		row = scanner.nextInt();
		System.out.println("row: " + row);
		col = scanner.nextInt();
		System.out.println("col: " + col);
		scanner.nextLine();
		arr = new int[row][col];
		for(int i = 0; i < row; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < col; j++) {
				if (line.charAt(j) == '@') {
					arr[i][j] = 1;
				} else {
					arr[i][j] = 0;
				}
			}
		}
		
		int gen = scanner.nextInt();
		System.out.println("Num of gens: " + gen);
		for (int k = 1; k <= gen; k++) {
			System.out.println("Generation: " + k);
			for (int i = 0; i < row; i ++) {
				for(int j = 0; j < col; j++) {
					int num = checkSurrounding( i, j);
					if(arr[i][j] == 1) {
						if( num == 0 || num == 1 || num >= 4)
							arr[i][j] = 2; //marked to be deleted
					}
					if (arr[i][j] == 0 && num == 3) {
							arr[i][j] = 3;//marked to be created	
					}
				
				}
			}
			
			for(int i = 0; i< row; i++) {
				for(int j = 0; j< col; j++) {
					if(arr[i][j] == 2) {
						arr[i][j] = 0;//delete organism
					}
					if(arr[i][j] == 3) {
						arr[i][j] = 1;//one is born
					}
				}
			}
		}
		
		int result = 0;
		for( int i = 0; i < row; i ++) {
			for(int j = 0; j < col; j++) {
				if (arr[i][j] == 1)
						result++;
			}
		}
		
		System.out.println("Output: " + result);

	}

	private static int checkSurrounding( int i, int j) {
		int num = 0;
		for (int dx = -1; dx <= 1; dx++) {
			for(int dy = -1; dy <= 1; dy++) {
				if(!(dx == 0 && dy == 0))
					num += checkCell(i + dx, j +dy);
			}
		}
		return num;
	}

	private static int checkCell(int i, int j) {
		if(i < 0 || j < 0 || i > row-1 || j > col-1)
			return 0;
		else {
			if(arr[i][j] == 1 || arr[i][j] == 2)
				return 1;
		}
		return 0;
	}

}
