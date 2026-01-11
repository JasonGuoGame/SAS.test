package hello.wordsimilar;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.List;

/**
 * Created by scnyig on 6/2/2016.
 * http://blog.csdn.net/lhkaikai/article/details/25186255
 * levab(i, j) = max(i, j) 如果min(i, j) = 0; = min(levab(i - 1, j) + 1, levab(i,
 * j-1) + 1, levab(i - 1, j - 1) + 1) (ai != bj)
 */
public class LevenshteinDistance {
    public static void main(String[] args) {
        String a = "aaadddeee";
        String b = "efadfe";
        int length = computeLevenshteinDistance(a, b);
        System.out.println(length);
    }

    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int computeLevenshteinDistance(String lhs, String rhs) {
        if (lhs == null || rhs == null) {
            return rhs == null ? lhs.length() : rhs.length();
        }

        // distance[i][j] 代表 s1 的前 i 个字符和 s2 的前 j 个字符之间的编辑距离
        int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];

        // 初始化边界：从空字符串转换到长度为 i 的字符串需要 i 次插入
        for (int i = 0; i <= lhs.length(); i++)
            distance[i][0] = i;
        for (int j = 1; j <= rhs.length(); j++)
            distance[0][j] = j;

        for (int i = 1; i <= lhs.length(); i++)
            for (int j = 1; j <= rhs.length(); j++)
                if (lhs.charAt(i - 1) == rhs.charAt(j - 1)) {
                    // 字符相等，不需要操作
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    // 字符不等，取三种操作的最小值 + 1
                    // dp[i-1][j] + 1 : 删除
                    // dp[i][j-1] + 1 : 插入
                    // dp[i-1][j-1] + 1 : 替换
                    distance[i][j] = Math.min(distance[i - 1][j - 1],
                            Math.min(distance[i - 1][j], distance[i][j - 1])) + 1;
                }

        // 以下的操作时合并了if语句
        // distance[i][j] = minimum(
        // distance[i - 1][j] + 1,
        // distance[i][j - 1] + 1,
        // distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));

        return distance[lhs.length()][rhs.length()];
    }
}
