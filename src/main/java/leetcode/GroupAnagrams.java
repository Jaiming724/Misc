package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> group = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        stringList.addAll(Arrays.asList(strs));

        if (strs.length < 2) {
            group.add(stringList);
            return group;
        }
        while (true) {
            if (stringList.size() < 2) {
                if (!stringList.isEmpty()) {
                    group.add(stringList);
                }
                break;
            }
            List<String> anagrams = new ArrayList<>();
            String first = stringList.get(0);
            anagrams.add(first);
            for (int i = 1; i < stringList.size(); i++) {
                if (isAnagrams(stringList.get(i), first)) {
                    anagrams.add(stringList.get(i));
                }
            }

            group.add(anagrams);
            for (String i : anagrams) {
                stringList.remove(i);
            }
        }
        return group;
    }

    public static boolean isAnagrams(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char[] a1 = a.toCharArray();
        char[] a2 = b.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

}
