package leetCode.easy;

import java.util.Arrays;

/**
 * 733. Flood Fill
 * Easy
 * 6.7K
 * 673
 * Companies
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 *
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 *
 * Return the modified image after performing the flood fill.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 * Example 2:
 *
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
 * Output: [[0,0,0],[0,0,0]]
 * Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 *
 *
 * Constraints:
 *
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], color < 216
 * 0 <= sr < m
 * 0 <= sc < n
 */
public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int source = image[sr][sc];
        if(color == source)
            return image;
        dfs(image, sr, sc, rows, cols, color, source);
        return image;
    }

    public static void dfs(int [][] image, int sr, int sc, int rows, int cols, int color, int source) {
        if(sr<0 || sc<0 || sr>=rows || sc>=cols)
            return;
        else if(image[sr][sc]!=source)
            return;
        image[sr][sc] = color;

        dfs(image,sr-1,sc,rows,cols,color,source);
        dfs(image,sr+1,sc,rows,cols,color,source);
        dfs(image,sr-1,sc-1,rows,cols,color,source);
        dfs(image,sr-1,sc+1,rows,cols,color,source);
    }
    public static void main(String[] args) {
        int arr[][] = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int rtnArr [] [] = floodFill(arr,1,1,2);
        System.out.println(Arrays.deepToString(rtnArr));
    }
}
