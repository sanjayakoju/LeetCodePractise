package leetCode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 * Solved
 * Medium
 * Topics
 * Companies
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
 * [0,4]: [0,4] -> Pacific Ocean
 *        [0,4] -> Atlantic Ocean
 * [1,3]: [1,3] -> [0,3] -> Pacific Ocean
 *        [1,3] -> [1,4] -> Atlantic Ocean
 * [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
 *        [1,4] -> Atlantic Ocean
 * [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
 *        [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
 * [3,0]: [3,0] -> Pacific Ocean
 *        [3,0] -> [4,0] -> Atlantic Ocean
 * [3,1]: [3,1] -> [3,0] -> Pacific Ocean
 *        [3,1] -> [4,1] -> Atlantic Ocean
 * [4,0]: [4,0] -> Pacific Ocean
 *        [4,0] -> Atlantic Ocean
 * Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
 * Example 2:
 *
 * Input: heights = [[1]]
 * Output: [[0,0]]
 * Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.
 *
 *
 * Constraints:
 *
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 105
 */
public class PacificAtlanticWaterFlow {

    // Time Complexity: O(M * N)
    // Space Complexity: O(M * N)
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int i=0;i<cols;i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, rows -1, i, Integer.MIN_VALUE, atlantic);
        }

        for(int i=0;i<rows;i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, cols-1, Integer.MIN_VALUE, atlantic);
        }

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int [][] heights, int r, int c, int prev, boolean [][] ocean) {
        if(r < 0 || c < 0 || r >= heights.length || c >= heights[0].length)
            return;

        if(heights[r][c] < prev || ocean[r][c])
            return;

        ocean[r][c] = true;

        dfs(heights, r - 1, c, heights[r][c], ocean);
        dfs(heights, r + 1, c, heights[r][c], ocean);
        dfs(heights, r, c + 1, heights[r][c], ocean);
        dfs(heights, r, c - 1, heights[r][c], ocean);
    }
}
