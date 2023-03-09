package leetCode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 * <p>
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 */
public class Matrix01 {

    // BFS Approach
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int direction[][] = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        while (!queue.isEmpty()) {
            int cell[] = queue.poll();
            for (int d[] : direction) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                // Boundary case for matrix
                if (r < 0 || r >= m || c < 0 || c >= n || mat[r][c] != -1)
                    continue;
                queue.add(new int[]{r, c});
                mat[r][c] = mat[cell[0]][cell[1]] + 1;
            }
        }

        return mat;
    }

    // DFS Approach
    public static int[][] updateMatrix1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] resultMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] > 0) {
                    resultMatrix[i][j] = dfs(mat, i, j, new boolean[m][n]);
                }
            }
        }
        return resultMatrix;
    }

    public static int dfs(int[][] mat, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || visited[i][j])
            return 1000;
        if (mat[i][j] == 0)
            return 0;
        visited[i][j] = true;
        int val = 1 + Math.min(
                Math.min(dfs(mat, i + 1, j, visited),
                        dfs(mat, i - 1, j, visited)),
                Math.min(dfs(mat, i, j + 1, visited),
                        dfs(mat, i, j - 1, visited))
        );
        visited[i][j] = false;
        return val;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int mat[][] = updateMatrix(matrix);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}
