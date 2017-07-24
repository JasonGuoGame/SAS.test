package hello.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by scnyig on 7/11/2016.
 * abcd,bc
 */
public class FindStr {

    public static int strStr(String source, String target) {
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

    /*
    * Given s="abcd", t="dcab", return true.
     */
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
        String c = "aa ddddd cccccc ddddddddddddddddd";
//        boolean flag = anagram2(a,b);
        int index = strStr(a,b);
        int aa = lengthOfLastWord(c);
        int maxL = lengthOfLongestSubstring("avbcve");
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
    * 遍历字符串中的所有字符，将每个字符存入map，key为字符，value为位置。
    * 对于每个字符，在将其存入map之前，做如下事情：
    * 查看map中存不存在，如不存在，直接将其存入map，否则继续以下步骤
    * 如果map的size大于当前最长子串的长度，更新当前最长子串的长度
    * clear map中直到当前字符的所有字符
    * 将当前字符存入map
    * avbcve
    *
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

    public Character getFirstOnceChar(String str) {
        if(str == null || str.isEmpty()) {
            return '\0';
        }

        Map<Character, Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < str.length();i++) {
            if(map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), -2);
            } else {
                map.put(str.charAt(i), i);
            }
        }

        Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();

        Character result='\0';
        int index = Integer.MAX_VALUE;

        for (Map.Entry<Character,Integer> entry : entrySet) {
            if(entry.getValue() > 0 && entry.getValue() < index) {
                result = entry.getKey();
            }
        }

        return result;
    }
}
