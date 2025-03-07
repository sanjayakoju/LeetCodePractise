package leetCode.hard;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is shown below:
 * <p>
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution
 */
public class SudokuSolver {

    public static boolean solveSudoku(char[][] board) {
        return solver(board, 0, 0);
    }

    public static boolean solver(char[][] board, int row, int col) {

//        if (row == board.length) {
//            return true;
//        }
//
//        int nRow = 0;
//        int nCol = 0;
//
//        if (col != board.length - 1) {
//            nRow = row;
//            nCol = col + 1;
//        } else {
//            nRow = row + 1;
//            nCol = col;
//        }
//
//        if (board[row][col] != '.') {
//            return solver(board, nRow, nCol);
//        } else {
//            for (char i = '1'; i <= '9'; i++) {
//                if (isSafe(board, row, col, i)) {
//                    board[row][col] = i;
//                    if (solver(board, nRow, nCol)) {
//                        return true;
//                    } else {
//                        board[row][col] = '.';
//                    }
//                }
//            }
//        }
//
//        return false;


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isSafe(board, i, j, k)) {
                            board[i][j] = k;
                            if (solver(board, 0, 0)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;


    }

    public static boolean isSafe(char[][] board, int row, int col, char k) {
        for (int i = 0; i < 9; i++) {

            // Check row
            if (board[row][i] == k) {
                return false;
            }

            // Check col
            if (board[i][col] == k) {
                return false;
            }

//             Check 3 * 3 matrix
//            if (board[3 * (row / 3) + i % 3] [3 * (col / 3) + i % 3] == k) {
//                return false;
//            }
        }

        //grid
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;

        for (int i = sr; i<sr+3;i++) {
            for (int j = sc; j <sc+3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        System.out.println(solveSudoku(board));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

}
