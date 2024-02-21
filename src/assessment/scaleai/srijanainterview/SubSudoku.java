package assessment.scaleai.srijanainterview;


    public class SubSudoku {

        public static boolean isSubSudoku(int[][] matrix) {
            int n = matrix.length;

            // Check rows
            for (int[] row : matrix) {
                if (!isValidSet(row, n)) {
                    return false;
                }
            }

            // Check columns
            for (int col = 0; col < n; col++) {
                int[] column = new int[n];
                for (int row = 0; row < n; row++) {
                    column[row] = matrix[row][col];
                }
                if (!isValidSet(column, n)) {
                    return false;
                }
            }

            return true;
        }

        private static boolean isValidSet(int[] array, int n) {
            int[] count = new int[n + 1];

            for (int num : array) {
                if (num < 1 || num > n || count[num] > 0) {
                    return false;
                }
                count[num]++;
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

            System.out.println(isSubSudoku(grid1)); // Output: true
            System.out.println(isSubSudoku(grid2)); // Output: false

            System.out.println(isSubSudokus(grid1)); // Output: true
            System.out.println(isSubSudokus(grid2)); // Output: false

        }


// Optimized
        public static boolean isSubSudokus(int[][] matrix) {
            int n = matrix.length;

            // Check rows
            for (int row = 0; row < n; row++) {
                if (!isValids(matrix, row, 0, n)) {
                    return false;
                }
            }

            // Check columns
            for (int col = 0; col < n; col++) {
                if (!isValids(matrix, 0, col, n)) {
                    return false;
                }
            }

            return true;
        }

        private static boolean isValids(int[][] matrix, int row, int col, int n) {
            boolean[] seen = new boolean[n + 1];

            for (int i = 0; i < n; i++) {
                int num;

                // Check row
                if (col == 0) {
                    num = matrix[row][i];
                } else { // Check column
                    num = matrix[i][col];
                }

                if (num < 1 || num > n || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }

            return true;
        }

    }



