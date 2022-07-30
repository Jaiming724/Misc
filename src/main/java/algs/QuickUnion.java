package algs;

import java.util.Arrays;

public class QuickUnion {
    private int[] id;

    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        id[getRoot(p)] = id[getRoot(q)];
    }

    public boolean connected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    private int getRoot(int i) {
        int root = i;
        int value = id[i];
        while (root != value) {
            root = value;
            value = id[root];
        }
        return root;
    }


    @Override
    public String toString() {
        return "QuickUnion{" +
                "id=" + Arrays.toString(id) +
                '}';
    }
}
