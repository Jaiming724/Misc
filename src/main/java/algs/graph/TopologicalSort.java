package algs.graph;

import java.util.*;

public class TopologicalSort {
    private int[] in_degree;
    private Queue<Integer> queue = new LinkedList<>();
    private List<Integer> result = new ArrayList<>();

    public TopologicalSort(DirectedGraph g) {
        //calculate in degree of every vertex
        in_degree = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            for (int w : g.adj(i)) {
                in_degree[w] += 1;
            }
        }
        for (int i = 0; i < g.V(); i++) {
            System.out.println(i+" : "+in_degree[i]);
            if(in_degree[i]==0){
                queue.add(i);
            }
        }

         while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            //for every vertex connected to current, degree their degree by 1
            for (int w : g.adj(current)) {
                in_degree[w] -= 1;
                if (in_degree[w] <= 0) {
                    queue.add(w);
                }
            }
        }
        result.forEach(System.out::println);

    }
}
