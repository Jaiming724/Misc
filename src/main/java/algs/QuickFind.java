package algs;

import java.util.Arrays;

public class QuickFind {
    private int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public QuickFind(int[] id) {
        this.id = id;
    }

    public void union(int n1, int n2) {
        for (int i = 0; i < id.length; i++) {
            if (id[i] == n1) {
                id[i] = id[n2];
            }
        }
    }

    public boolean connected(int n1, int n2) {
        return id[n1] == id[n2];
    }

    @Override
    public String toString() {
        return "QuickFind{" +
                "id=" + Arrays.toString(id) +
                '}';
    }
}
