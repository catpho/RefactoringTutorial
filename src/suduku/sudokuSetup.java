package suduku;

public class sudokuSetup {

	static int[][] createDefaultTemp() {
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

}
