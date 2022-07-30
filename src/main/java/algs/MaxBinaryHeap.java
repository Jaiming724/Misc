package algs;

public class MaxBinaryHeap<E extends Comparable<E>> {
    private int size = 1;
    private E[] pq;

    public MaxBinaryHeap(int s) {
        pq = (E[]) new Comparable[s + 1];
    }

    public void insert(E ele) {
        pq[size] = ele;
        swim(size);
        size++;
    }

    public E deleteMax() {
        E max = pq[1];
        debug();

        exch(1, --size);
        sink(1);
        pq[size] = null;
        return max;
    }

    private void swim(int n) {
        if (n == 1) {
            return;
        }
        int parent = getParent(n);
        while (parent > 0 && less(parent, n)) {
            exch(n, parent);
            n = parent;
            parent = getParent(parent);
        }
    }


    private void sink(int n) {
        int child = getLeftChild(n);
        while (child < size) {
            if (child + 1 < size && less(child, child + 1)) {
                child++;
            }
            if (!less(n, child))
                break;
            exch(n, child);

            n = child;
            child = getLeftChild(n);
        }
    }

    private void exch(int a, int b) {
        E temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private int getParent(int n) {
        return n / 2;
    }

    private int getLeftChild(int n) {
        return 2 * n;
    }

    private int getRightChild(int n) {
        return 2 * n + 1;
    }

    public void debug() {
        for (int i = 0; i < pq.length; i++) {
            System.out.print(pq[i] + " ");
        }
        System.out.println();
    }
}
