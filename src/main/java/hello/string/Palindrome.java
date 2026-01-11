package hello.string;

/**
 * Created by scnyig on 8/25/2016.
 * 
 */
public class Palindrome {
    /**
     * 求解最长回文子串（Longest Palindromic Substring）主要有三种方式：
     * 中心扩展法（最推荐，空间(O(1))）、动态规划（适合理解原理）和 Manacher 算法（最优 (O(n))）
     * 
     * @param args
     */
    public static void main(String[] args) {
        String ss = "A man, a plan, a canal: Panama";
        String s = "abcdzdc";
        String sss = s.substring(0, s.length());
        boolean isPal = isPalindrome(ss);
        String result = longestPalindrome(s);
        System.out.println(result);
    }

    /**
     * 最长回文子串的暴力解法（Brute Force）
     * 
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String result = new String();
        if (s == null || s.isEmpty())
            return result;

        int longest = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindromeSub(sub) && sub.length() > longest) {
                    longest = sub.length();
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right);
    }

    /**
     * 回文检查只需要检查到一半即可,以下方法可以改进
     * 
     * @param ss
     * @return
     */
    public static boolean isPalindromeSub(String ss) {
        if (ss == null || ss.isEmpty())
            return false;

        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i) != ss.charAt(ss.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 验证回文串 (Valid Palindrome) 的标准算法。双指针 (Two Pointers) 且 跳过非字母数字字符
     * 
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if ("".equals(s) || s.length() == 0) {
            return true;
        }

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 中心扩展法 (Center Expansion)
     * 
     * @param x
     * @return
     */
    public static String centerExpansion(String s) {
        if (s == null || s.length() == 0)
            return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expansion(s, i, i);
            int len2 = expansion(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public static int expansion(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    /**
     * 回文数（Palindrome Number）算法的经典实现
     * 
     * @param x
     * @return
     */
    public boolean isPalindromNumber(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            int temp = x;
            int y = 0;
            while (x != 0) {
                y = y * 10 + x % 10;
                x = x / 10;
            }

            return temp == y ? true : false;
        }
    }
}
