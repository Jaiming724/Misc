package algs;

public class HeapSort {
    public static void sort(Comparable[] nums) {
        int k = getParent(nums.length);
        for (int i = k; i >= 0; i--) {
            sink(i, nums, nums.length);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            exch(0, i, nums);
            sink(0, nums, i);
        }

    }

    private static void sink(int n, Comparable[] pq, int limit) {
        int child = getLeftChild(n);
        while (child < limit) {
            if (child + 1 < limit && less(child, child + 1, pq)) {
                child++;
            }
            if (!less(n, child, pq))
                break;
            exch(n, child, pq);

            n = child;
            child = getLeftChild(n);
        }
    }

    private static void exch(int a, int b, Comparable[] pq) {
        Comparable temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }

    private static boolean less(int i, int j, Comparable[] pq) {

        return pq[i].compareTo(pq[j]) < 0;
    }

    private static int getParent(int n) {
        return (n - 1) / 2;
    }

    private static int getLeftChild(int n) {
        return (2 * n) + 1;
    }

    private static int getRightChild(int n) {
        return (2 * n) + 2;
    }


}
