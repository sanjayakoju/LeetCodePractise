package leetCode.medium;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    private char [][] g;

    public int numIslands(char[][] grid) {
        this.g  = grid;
        int rows = grid.length;
        if (rows == 0) return 0;
        int count = 0;
        int cols = grid[0].length;

        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if(g[i][j] == '1') {
                    dfs(i,j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j) {
        // Boundary case for matrix
        if(i < 0 || i>= g.length || j < 0 || j>=g[0].length || g[i][j] == '0') return;

        // marks as visited
        g[i][j] = '0';

        // Make recursive call in all 4 adjacent directions
        dfs(i-1,j); // UP
        dfs(i+1,j); // DOWN
        dfs(i,j-1); // LEFT
        dfs(i,j+1); // RIGHT
    }

    public static void main(String[] args) {
        char grid[][] = {
                {'1','0','1','0','1'},
                {'0','1','0','1','0'},
                {'1','0','1','0','1'},
                {'0','1','0','1','0'}
        };

//        char grid[][] = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        };

        NumberOfIslands ob = new NumberOfIslands();
        System.out.println(ob.numIslands(grid));
    }
}
