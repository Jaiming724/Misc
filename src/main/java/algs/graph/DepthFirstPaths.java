package algs.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DepthFirstPaths {
    private boolean[] marked; // Has dfs() been called for this vertex?
    private int[] edgeTo; // last vertex on known path to this vertex private final
    int start; // source

    public DepthFirstPaths(UndirectedGraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.start = s;
        dfs(G, s);
        for (int i = 0; i < edgeTo.length; i++) {
            System.out.println(i+" : "+edgeTo[i]);
        }
    }

    private void dfs(UndirectedGraph G, int v) {
        if (marked[v]) {
            return;
        }
        marked[v] = true;
        for (int w : G.adj(v)) {
            edgeTo[w] = v;
            dfs(G, w);
        }


    }

    public boolean hasPathTo(int v) {

        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Queue<Integer> path = new LinkedList<>();
        for (int x = v; x != start; x = edgeTo[x])
            path.add(x);
        path.add(start);
        return path;
    }
}