package assessment.collabera.aws;

import java.util.Scanner;

/**
 * Groups of Ones
 * An airline has multiple hubs and typically the hub serves some cities around it. You are given a matrix that represents all the cities and the ones which the airline flies to, is marked with a "1" while the one that it does not fly to, is marked with a "0". A hub network can be identified by all the connected ones regardless of whether they are adjacent row-wise, column-wise or diagonally. Can you find the number of hub networks that exist in the matrix? Input
 * The first line of the test case contains two integers N and M.
 * The next line contains NM inputs of the matrix, separated by space.
 * Output
 * An integer denoting the total no. of hub networks. If there is "1" that is isolated, consider that to be a network that is in-process of being built out and count it as a hub as well.  Constraints
 * 1 <= N, M <= 50
 * Example #1
 * Input
 * 3 4
 * 100001010101
 * Output
 * 2
 * A =
 * 1
 * 0
 * 0
 * 1
 * 1
 * 0
 * 0
 * 0
 * 01
 * 11
 * This is a [3x4] matrix:
 * (0,0),(1,1) and (2,1) form one network.
 * Ones at (1,3) and (2,3) form second network.
 * Ones at
 * Example #2
 * Input
 * 3 3
 * 100 000010 -- public static void main(String]
 * args) {
 * int n, m;
 * Scanner in = new Scanner(System. in);
 * n = in.nextIntO;
 * m = in nextIntO;
 * int 0]D
 * array = new int[n] [m];
 * for
 * (int i=0;i<n;i++){
 * for (int j=0; j<m; j++){
 * array［iJ［j］=in.nextInt（）；
 *
 * System.out.print(hubs(array));
 *
 * public static int. hubs(int@ array){
 * // Write your code here
 * V/ Return the number of hubs return -- solve the function
 */
public class Test {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] array = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    array[i][j] = in.nextInt();
                }
            }

            System.out.println(hubs(array));
        }

        public static int hubs(int[][] array) {
            int n = array.length;
            int m = array[0].length;
            int count = 0;

            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (array[i][j] == 1 && !visited[i][j]) {
                        dfs(array, visited, i, j);
                        count++;
                    }
                }
            }

            return count;
        }

        private static void dfs(int[][] array, boolean[][] visited, int row, int col) {
            int n = array.length;
            int m = array[0].length;

            if (row < 0 || col < 0 || row >= n || col >= m || array[row][col] == 0 || visited[row][col]) {
                return;
            }

            visited[row][col] = true;

            // Explore in all 8 possible directions (up, down, left, right, and diagonals)
            dfs(array, visited, row - 1, col);
            dfs(array, visited, row + 1, col);
            dfs(array, visited, row, col - 1);
            dfs(array, visited, row, col + 1);
            dfs(array, visited, row - 1, col - 1);
            dfs(array, visited, row - 1, col + 1);
            dfs(array, visited, row + 1, col - 1);
            dfs(array, visited, row + 1, col + 1);
        }
    }

