package leetCode.medium;

public class MazeSolver {

    // Time complexity: O(n * m)
    // Space complexity: O(n * m)
    public static int[][] solveMaze(int[][] maze) {
        int row = maze.length;
        int col = maze[0].length;

        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                // Start DFS from the top-left corner
                if (!dfs(maze, i, j)) {
                    // If no path exists, return the original maze
                    return maze;
                }
            }
        }

        return maze;
    }

    // Recursive DFS to find a path from (x, y) to the bottom-right corner
    private static boolean dfs(int[][] maze, int x, int y) {

        // Base case: if we've reached the bottom-right corner
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            maze[x][y] = 9;  // Mark the end cell as part of the path
            return true;
        }

        // Check if out of bounds, or if it's a wall, or already visited
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] != 1) {
            return false;
        }

        // Mark the current cell as part of the path
        maze[x][y] = 9;

        // Explore all four directions: down, right, up, and left, in that order
        if (dfs(maze, x + 1, y) ||  // Move Down
                dfs(maze, x, y + 1) ||  // Move Right
                dfs(maze, x - 1, y) ||  // Move Up
                dfs(maze, x, y - 1)) {  // Move Left
            return true;
        }

        // Backtrack: Unmark this cell if no path is found
        maze[x][y] = 1;

        return false;  // No path found
    }


    // Driver method to test the maze solution
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        int[][] solution = solveMaze(maze);

        // Print the result
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}

