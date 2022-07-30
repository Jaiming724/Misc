package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LengthOfLongestSubstring {


    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Queue<Character> queue = new LinkedList<>();
        int max = -1;

        for (int i = 0; i < s.length(); i++) {
            while (queue.contains(s.charAt(i))) {
                queue.remove();
            }
            queue.add(s.charAt(i));

            if (queue.size() > max) {
                max = queue.size();
            }
        }
        return max;

    }
}
