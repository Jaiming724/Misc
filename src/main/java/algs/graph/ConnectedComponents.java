package algs.graph;

public class ConnectedComponents {
    private boolean[] visited;
    private int[] id;

    private void dfs(UndirectedGraph g, int current, int count) {
        if (visited[current])
            return;
        visited[current] = true;
        id[current] = count;
        for (int i : g.adj(current)) {
            dfs(g, i, count);
        }
    }

    public ConnectedComponents(UndirectedGraph g) {
        visited = new boolean[g.V()];
        id = new int[g.V()];
        int count = 1;
        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                dfs(g, i, count);
                count += 1;
            }
        }
    }
}
