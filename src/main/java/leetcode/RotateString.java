package leetcode;

import java.util.LinkedList;

public class RotateString {
    public static boolean rotateString(String s, String goal) {
        if (s.equals(goal)) {
            return true;
        }
        LinkedList<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }
        int iterations = 0;
        while (iterations < s.length()) {
            Character c = queue.remove(0);
            queue.add(c);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < queue.size(); i++) {
                stringBuilder.append(queue.get(i));
            }
            if(stringBuilder.toString().equals(goal)){
                return true;
            }
            iterations++;
        }
        return false;
    }

}
