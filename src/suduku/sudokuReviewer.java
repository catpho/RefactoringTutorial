package suduku;


public class sudokuReviewer {

    public static void main(String[] args) {
    	int[][] sudokutemp = sudokuSetup.createDefaultTemp();
    	System.out.println("Here is the starting Sudoku:");
    	for (int[] row : sudokutemp) {
		    for (int num : row) {
		        System.out.print(num + " ");
		    }
		    System.out.println();
		}
    	
    	int[][] sudokuSol = sudokuSetup.Solutionset();
    	
    	int[][] sudokuwrong = sudokuSetup.wrongSet();
    	
    	System.out.println("");
    	System.out.println("");
    	System.out.println("Here is proposed solution to Sudoku:");
    	for (int[] row : sudokuwrong) {
		    for (int num : row) {
		        System.out.print(num + " ");
		    }
		    System.out.println();
		}
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
    	for (int[] row : sudokuwrong) {
		    for (int num : row) {
		        System.out.print(num + " ");
		    }
		    System.out.println();
		}
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
}
