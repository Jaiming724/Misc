package algs.graph;

import java.util.*;

//O(E*log(E))
public class LazyPrimMST {
    private boolean[] visited;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;
    private EdgeWeightedGraph g;


    //Add all edges of a vertex if ending vertex has not been visited
    private void visit(int current) {
        visited[current] = true;

        for (Edge i : g.adj(current)) {
            //Sedgewick Algorithms had an another way to get start and end edge, this will not work with it
            //This is the simplest way
            int v = i.starting();
            int w = i.end();
            if (!visited[w]) {
                pq.add(i);
            }
        }
    }


    public LazyPrimMST(EdgeWeightedGraph G, int starting) {
        this.g = G;
        pq = new PriorityQueue<>();
        visited = new boolean[G.V()];
        mst = new LinkedList<>();
        visit(starting);
        //or check if mst size is equal to # of vertex-1
        while (pq.size() > 0) {
            Edge minEdge = pq.poll();
            int v = minEdge.starting();
            int w = minEdge.end();
            //if we already connected two vertex, ignore or else we will get a cycle
            if (visited[v] && visited[w]) {
                continue;
            }
            mst.add(minEdge);

            if (!visited[w]) {
                visit(w);
            }
        }
    }

    public Iterable<Edge> getMST() {
        return mst;
    }
}
