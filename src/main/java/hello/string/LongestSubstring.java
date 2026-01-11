package hello.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {
    /**
     * 暴力法：查找最长无重复字符子串的长度
     * 列出这个方法是为理解sliding window 算法
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;

        // 1. 遍历所有可能的起始点 i
        for (int i = 0; i < n; i++) {
            // 2. 遍历所有可能的终点 j
            for (int j = i + 1; j <= n; j++) {
                // 3. 检查子串 s[i...j) 是否包含重复字符
                if (allUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;
    }

    /**
     * 辅助方法：检查字符串指定范围内的字符是否全部唯一
     */
    private static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                return false; // 发现重复字符
            }
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        int result = lengthOfLongestSubstringSliding(input);
        System.out.println("最长无重复子串的长度为: " + result); // 输出 3 ("abc")
    }

    /**
     * Sliding Window 算法
     * 
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringSliding(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int end = s.length();
        int res = 0;
        while (right < end) {
            Character c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                Character d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }

            res = Math.max(res, right - left);
        }
        return res;
    }
}
