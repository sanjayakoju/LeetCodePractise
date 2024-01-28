package leetCode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 994. Rotting Oranges
 *
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 */
public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i,j}); // add all rotten oranges indices pair in queue
                }
                if (grid[i][j] == 1) {
                    freshCount++; // count fresh oranges
                }
            }
        }

        int[][] direction = {{1,0} , {0,1}, {-1,0}, {0,-1}}; // defined 4 direction 2d-array
        int time = 0;

        while (!q.isEmpty() && freshCount > 0) {
            time++;
            int size = q.size();
            while (size-- > 0) {
                int[] xy = q.poll(); // poll rotten oranges from queue
                for (int[] d: direction) {
                    int x = xy[0] + d[0];
                    int y = xy[1] + d[1];
                    // continue if x or y out of grid or grid don't have fresh orange
                    if(x < 0 || y < 0 || x>=grid.length || y>=grid[0].length || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    q.add(new int[]{x,y}); // add indices pair of fresh orange in queue
                    grid[x][y] = 2; //mark fresh orange to rotten - kind of marking visited
                    freshCount--; // decrease freshCount
                }
            }
        }
        return freshCount == 0 ? time : -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{2,1,1} , {1,1,0}, {0,1,1}};
        System.out.println(orangesRotting(arr));
    }
}
