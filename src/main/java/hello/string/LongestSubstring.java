import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    /**
     * 暴力法：查找最长无重复字符子串的长度
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
        int result = lengthOfLongestSubstring(input);
        System.out.println("最长无重复子串的长度为: " + result); // 输出 3 ("abc")
    }
}
