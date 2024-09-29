package datastucture.graph.dfs;

import datastucture.graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Work on the base of Stack (LIFO)
 */
public class DFS {

    static int V = 4;
    static LinkedList<Integer>[] adj;

    private static void dfs(int source) {

        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // parent node optional not required
        int parentNode[] = new int[adj.length];

        // Create a Stack for DFS
        Stack<Integer> stack = new Stack<>();

        // Mark the current node as visited and enqueue it
        visited[source] = true;
        stack.push(source);
        parentNode[source] = -1;

        while (!stack.isEmpty()) {
            // Pop a vertex from stack and print it
            int p = stack.pop();
            System.out.print(p + " ");

            // Get all adjacent vertices of the dequeued
            // vertex source
            // If an adjacent has not been visited,
            // then mark it visited and pop it
            for (int i: adj[p]) {
                if (!visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                    parentNode[i] = p;
                }
            }
        }


    }


    public static void main(String[] args) {
        Graph g = new Graph(V);
        adj = g.addEdge(0, 1);
        adj = g.addEdge(0, 2);
        adj = g.addEdge(1, 2);
        adj = g.addEdge(2, 0);
        adj = g.addEdge(2, 3);
        adj = g.addEdge(3, 3);
        dfs(2);
    }
}
