//https://youtu.be/s8p8ukTyA2I
import java.util.*;

class Solution {
    public static int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Character key : map.keySet()) {
            priorityQueue.add(map.get(key));
        }
        int time = 0;
        Queue<Pair> queue = new LinkedList<>();
        while (queue.size() > 0 || priorityQueue.size() > 0) {
            time += 1;

            if (priorityQueue.size() > 0) {
                int num = priorityQueue.poll();
                if (num - 1 > 0) {
                    queue.add(new Pair(num - 1, time + n));
                }
            }
            if (queue.size() > 0 && queue.peek().time == time) {
                Pair temp = queue.poll();
                priorityQueue.add(temp.count);
            }
        }
        return time;
    }
}
class Pair {
    public Integer count;
    public Integer time;

    public Pair(Integer count, Integer time) {
        this.count = count;
        this.time = time;
    }
}