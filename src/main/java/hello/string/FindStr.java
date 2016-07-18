package hello.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by scnyig on 7/11/2016.
 */
public class FindStr {

    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        int i, j;
        for (i = 0; i < source.length() - target.length() + 1; i++) {
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                } //if
            } //for j
            if (j == target.length()) {
                return i;
            }
        } //for i

        // did not find the target
        return -1;
    }

    public static boolean anagram(String s, String t) {
        // write your code here
        if (s==null || t==null || s.length()!=t.length()) return false;
            int[] ss = new int[256];
            int[] tt = new int[256];
            for (int i=0; i<s.length(); i++) {
                ss[s.charAt(i)]++;
                tt[t.charAt(i)]++;
            }
            for (int j=0; j<256; j++) {
                if (ss[j] != tt[j])
                    return false;
            }
        return true;
    }

    public static void main(String[] args) {
        String a = "abcabcbb";
        String b = "acbd";
//        boolean flag = anagram2(a,b);
        int maxL = lengthOfLongestSubstring(a);
        System.out.println(maxL);
    }

    public static boolean anagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[(int) s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[(int) t.charAt(i)]--;
            if (count[(int) t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param s A string
     * @return the length of last word
     */
    public static int lengthOfLastWord(String s) {
        if (s == null | s.isEmpty()) return 0;

        // trim right space
        int begin = 0, end = s.length();
        while (end > 0 && s.charAt(end - 1) == ' ') {
            end--;
        }
        // find the last space
        for (int i = 0; i < end; i++) {
            if (s.charAt(i) == ' ') {
                begin = i + 1;
            }
        }

        return end - begin;
    }

    /*
    * return the longest substring without repeating characters
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxsofar = 0;
        int from = 0;

        Map<Character, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (idxMap.containsKey(c)) {
                if (idxMap.size() > maxsofar) {
                    maxsofar = idxMap.size();
                }
                int to = idxMap.get(c);
                removeRange(idxMap, s, from, to);
                from = to + 1;
            }
            idxMap.put(c, i);

        }

        if (idxMap.size() > maxsofar) {
            maxsofar = idxMap.size();
        }

        return maxsofar;
    }

    private static void removeRange(Map<Character, Integer> idxMap, String s, int from, int to) {
        for (int i = from; i <=to; i++) {
            idxMap.remove(s.charAt(i));
        }
    }
}
