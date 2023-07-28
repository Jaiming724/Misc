package algs.graph;//Modified version of Algorithms 4th edition by Robert Sedgewick

import java.util.LinkedList;
import java.util.Scanner;

public class UndirectedGraph {
    private final int verticeCount; // number of vertices
    private int edgeCount; // number of edges
    private LinkedList<Integer>[] adj; // adjacency lists

    public UndirectedGraph(int verticesCount) {
        this.verticeCount = verticesCount;
        this.edgeCount = 0;
        adj = new LinkedList[verticesCount];
        for (int v = 0; v < verticesCount; v++)
            adj[v] = new LinkedList<>();
    }

    public UndirectedGraph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            //System.out.println(v+"-"+w);
            addEdge(v, w);
        }
    }

    public int V() {
        return verticeCount;
    }

    public int E() {
        return edgeCount;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edgeCount++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        String s = verticeCount + " vertices, " + edgeCount + " edges\n";
        for (int v = 0; v < verticeCount; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) s += w + " ";
            s += "\n";
        }
        return s;
    }
}