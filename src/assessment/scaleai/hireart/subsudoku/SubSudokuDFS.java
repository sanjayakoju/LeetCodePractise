package assessment.scaleai.hireart.subsudoku;

public class SubSudokuDFS {

    public static boolean isSubSudoku(int[][] matrix) {
        int n = matrix.length;

        // Check rows and columns using DFS
        for (int i = 0; i < n; i++) {
            if (!isValid(matrix, i, 0, n) || !isValid(matrix, 0, i, n)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(int[][] matrix, int row, int col, int n) {
        boolean[] seen = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int num = (col == 0) ? matrix[row][i] : matrix[i][col];
            if (num < 1 || num > n || seen[num]) {
                return false;
            }
            seen[num] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {2, 3, 1},
                {1, 2, 3},
                {3, 1, 2}
        };

        int[][] grid2 = {
                {1, 2, 4},
                {2, 3, 1},
                {3, 1, 2}
        };

        int[][] grid3 = {
                {1, 2, 3},
                {3, 2, 1},
                {3, 1, 2}
        };

        int[][] grid4 = {
                {1, 3, 2},
                {3, 2, 1},
                {2, 1, 3}
        };

        System.out.println(isSubSudoku(grid1)); // Output: true
        System.out.println(isSubSudoku(grid2)); // Output: false
        System.out.println(isSubSudoku(grid3)); // Output: false
        System.out.println(isSubSudoku(grid4)); // Output: true
    }
}

