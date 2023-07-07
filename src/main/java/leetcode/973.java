class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        Double d1 = (Math.pow(this.x,2) + Math.pow(this.y,2));
        Double d2 = (Math.pow(o.x,2) + Math.pow(o.y,2));
        return d1.compareTo(d2);
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        int[][] res = new int[k][2];
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>();
        for (int[] i : points) {
            priorityQueue.add(new Point(i[0], i[1]));
        }
        for (int i = 0; i < k; i++) {
            Point p = priorityQueue.poll();
            int[] temp = {p.x, p.y};
            res[i] = temp;
        }
        return res;
    }
}