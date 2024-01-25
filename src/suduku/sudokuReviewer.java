package suduku;


public class sudokuReviewer {

    public static void main(String[] args) {
    	int[][] sudokutemp = createDefaultTemp();
    	System.out.println("Here is the starting Sudoku:");
    	printSudoku(sudokutemp);
    	
    	int[][] sudokuSol = {
            {8, 7, 5, 9, 2, 1, 3, 4, 6},
            {3, 6, 1, 7, 5, 4, 8, 9, 2},
            {2, 4, 9, 8, 6, 3, 7, 1, 5},
            {5, 8, 4, 6, 9, 7, 1, 2, 3},
            {7, 1, 3, 2, 4, 8, 6, 5, 9},
            {9, 2, 6, 1, 3, 5, 4, 8, 7},
            {6, 9, 7, 4, 1, 2, 5, 3, 8},
            {1, 5, 8, 3, 7, 9, 2, 6, 4},
            {4, 3, 2, 5, 8, 6, 9, 7, 1}
        };
    	
    	int[][] sudokuwrong = {
                {8, 7, 2, 1, 2, 2, 8, 4, 6},
                {3, 6, 7, 2, 9, 8, 8, 9, 5},
                {2, 8, 1, 8, 5, 4, 7, 1, 5},
                {1, 8, 4, 2, 9, 7, 4, 2, 3},
                {7, 1, 5, 7, 4, 9, 6, 5, 9},
                {1, 2, 7, 1, 3, 6, 4, 8, 4},
                {6, 9, 7, 8, 4, 2, 5, 1, 8},
                {4, 5, 8, 3, 7, 9, 2, 6, 4},
                {4, 3, 1, 2, 8, 4, 9, 7, 4}
            };
    	
    	System.out.println("");
    	System.out.println("");
    	System.out.println("Here is proposed solution to Sudoku:");
    	printSudoku(sudokuwrong);
    	System.out.println("");
    	System.out.println("");
    	
    	/*
    	if (validPositions(sudokuSol)) {
            System.out.println("This is a valid Sudoku solution!");
        } else {
            System.out.println("This is an invalid Sudoku solution!");
        }
    	*/
    	if (validPositions(sudokuwrong)) {
            System.out.println("This is a valid Sudoku solution!");
        } else {
            System.out.println("This is an invalid Sudoku solution!");
        }
    	System.out.println("Here's the proof!All wrong entries highlighted as '-1's!");
        //printSudoku(sudokuSol);
    	compareAndReplace(sudokuSol,sudokuwrong);
    	printSudoku(sudokuwrong);
    }

	private static int[][] createDefaultTemp() {
		int[][] sudokutemp = {
                {0, 7, 0, 0, 2, 0, 0, 4, 6},
                {0, 6, 0, 0, 0, 0, 8, 9, 0},
                {2, 0, 0, 8, 0, 0, 7, 1, 5},
                {0, 8, 4, 0, 9, 7, 0, 0, 0},
                {7, 1, 0, 0, 0, 0, 0, 5, 9},
                {0, 0, 0, 1, 3, 0, 4, 8, 0},
                {6, 9, 7, 0, 0, 2, 0, 0, 8},
                {0, 5, 8, 3, 7, 9, 2, 6, 4},
                {4, 3, 0, 0, 8, 0, 0, 7, 0}
            };
		return sudokutemp;
	}

    public static boolean validPositions(int[][] board) {
        // Check rows and columns
        for (int i = 0; i < 9; i++) {
        	if (!validRow(board, i) || !validColumn(board, i)) {
                return false;
        }
        }

        // Check 3x3 subgrids
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!validSubgrid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
    

    private static boolean validRow(int[][] board, int row) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < 9; i++) {
            int num = board[row][i];
            if (num != 0) {
                if (seen[num - 1]) {
                    // Duplicate found, mark positions as -1
                    board[row][i] = -1;
                    return false;
                }
                seen[num - 1] = true;
            }
        }
        return true;
    }

    private static boolean validColumn(int[][] board, int col) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < 9; i++) {
            int num = board[i][col];
            if (num != 0) {
                if (seen[num - 1]) {
                    // Duplicate found, mark positions as -1
                    board[i][col] = -1;
                    return false;
                }
                seen[num - 1] = true;
            }
        }
        return true;
    }

    private static boolean validSubgrid(int[][] board, int startRow, int startCol) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = board[startRow + i][startCol + j];
                if (num != 0) {
                    if (seen[num - 1]) {
                        // Duplicate found, mark positions as -1
                        board[startRow + i][startCol + j] = -1;
                        return false;
                    }
                    seen[num - 1] = true;
                }
            }
        }
        return true;
    }
    
    private static void compareAndReplace(int[][] solution1, int[][] solution2) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (solution1[i][j] != solution2[i][j]) {
                    solution2[i][j] = -1;
                }
            }
        }
    }

    private static void printSudoku(int[][] sudoku) {
        for (int[] row : sudoku) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
