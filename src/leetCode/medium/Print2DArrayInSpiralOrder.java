package leetCode.medium;


/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class Print2DArrayInSpiralOrder {

    public static void printSpiralOrder(int mat[][]) {
        int m = mat.length;
        int n = mat[0].length;
        int t = 0, b = m - 1, l = 0, r = n - 1;
        int dir = 0;
        while (t <= b && l <= r) {
            if (dir == 0) {
                for (int i = l; i <= r; i++) {
                    System.out.print(mat[t][i]);
                }
                t++;
            } else if (dir == 1) {
                for (int i = t; i <= b; i++) {
                    System.out.print(mat[i][r]);
                }
                r--;
            } else if (dir == 2) {
                for (int i = r; i >= l; i--) {
                    System.out.print(mat[b][i]);
                }
                b--;
            } else if (dir == 3) {
                for (int i = b; i >= t; i--) {
                    System.out.print(mat[i][l]);
                }
                l++;
            }
            dir = (dir + 1) % 4;
        }
    }

    public static void main(String[] args) {
        int arr[][] = {
                {2, 4, 6, 8},
                {5, 9, 12, 16},
                {2, 11, 5, 9},
                {3, 2, 1, 8}
        };
        printSpiralOrder(arr);
    }
}
