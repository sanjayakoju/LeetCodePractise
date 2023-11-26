package datastucture.graph;

import java.util.LinkedList;

public class Graph {
    // No .of verices
    private int vertices;

    // Adjacency Lists
    private LinkedList<Integer> adjacency[];

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacency = new LinkedList[vertices];
        for (int i=0;i<vertices;++i) {
            adjacency[i] = new LinkedList<>();
        }
    }

    public LinkedList<Integer>[] addEdge(int v, int w) {
        adjacency[v].add(w);
        return adjacency;
    }
}
