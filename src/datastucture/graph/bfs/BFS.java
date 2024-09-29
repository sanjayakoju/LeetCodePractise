package datastucture.graph.bfs;

import datastucture.graph.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Work on the base of Queue (FIFO)
 */
public class BFS {

    static int V = 4;
    static LinkedList<Integer>[] adj;

    public static void bfs(int source) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // parent node optional not required
        int parentNode[] = new int[adj.length];

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[source] = true;
        queue.add(source);
        parentNode[source] = -1;
        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            int p = queue.poll();
            System.out.print(p + " ");

            // Get all adjacent vertices of the dequeued
            // vertex source
            // If an adjacent has not been visited,
            // then mark it visited and enqueue it
            for (int i : adj[p]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    parentNode[i] = p;
                }
            }

            // Using Iterator
//            Iterator<Integer> i = adj[p].listIterator();
//            while (i.hasNext()) {
//                int n = i.next();
//                if (!visited[n]) {
//                    visited[n] = true;
//                    queue.add(n);
//                    parentNode[n] = p;
//                }
//            }
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
        bfs(2);
    }
}
