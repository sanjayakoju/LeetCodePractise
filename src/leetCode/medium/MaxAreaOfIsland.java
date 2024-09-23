package leetCode.medium;

/**
 * 695. Max Area of Island
 * Medium
 * Topics
 * Companies
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */
public class MaxAreaOfIsland {

    boolean [][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        visited = new boolean[r][c];
        int maxArea = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(i, j, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int r, int c, int[][] grid) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
                || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;

        return (1 + dfs(r + 1, c, grid) +
                dfs(r - 1, c, grid) +
                dfs(r, c + 1, grid) +
                dfs(r, c - 1, grid));
    }
}
