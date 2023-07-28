package algs.graph;

import java.util.LinkedList;
import java.util.Scanner;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private LinkedList<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++) adj[v] = new LinkedList<Edge>();
    }

    public EdgeWeightedGraph(Scanner scanner) {
        this(scanner.nextInt());
        int count = scanner.nextInt();
        System.out.println("Count "+count);
        for (int i = 0; i < count; i++) {

            int v = scanner.nextInt();
            int w = scanner.nextInt();
            float weight = scanner.nextFloat();
            //System.out.println(v+" "+w+" "+weight);
            addEdge(v, w, (double) weight);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w, double weight) {
        adj[v].add(new Edge(v, w, weight));
        adj[w].add(new Edge(w, v, weight));
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }


}