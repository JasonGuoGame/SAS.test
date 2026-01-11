package hello.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by scnyig on 9/20/2017.
 * http://www.jiuzhang.com/solution/longest-common-substring/
 * 这个方法是动态规划算法DP
 * 通常DP可以解决背包问题，最长公共子串,最短路径,爬楼梯问题
 * 动态规划一种通过将复杂问题分解为更小的、相互重叠的子问题，并存储子问题的解来避免重复计算的算法优化方法,本质上是空间换时间.
 */
public class LongestCommonSubstring {

    public int solution(String A, String B) {
        // state: f[i][j] is the length of the longest lcs
        // ended with A[i - 1] & B[j - 1] in A[0..i-1] & B[0..j-1]
        int n = A.length();
        int m = B.length();
        int[][] f = new int[n + 1][m + 1];

        // initialize: f[i][j] is 0 by default
        // 1. 确定 dp 数组的含义（一维或二维）

        // 2. 初始化边界条件（Base Case）

        // 3. 状态转移（开始填表）
        // function: f[i][j] = f[i - 1][j - 1] + 1 or 0
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = 0;
                }
            }
        }

        // answer: max{f[i][j]}
        // 找最大值，实际是可以合并这个嵌套循环到以上的循环以减少一次循环。维护一个maxLeg在以上填表的循环里更新
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                max = Math.max(max, f[i][j]);
            }
        }

        return max;
    }

    /**
     * http://www.geeksforgeeks.org/longest-common-substring/
     * 动态规划解法的经典实现，完全符合动态规划的自底向上 (Bottom-Up) 填表法。它将暴力法的 O(N^3) 复杂度直接优化到了O(M*N)
     * 
     * @param X
     * @param Y
     * @param m
     * @param n
     * @return
     */
    public static int LCSubStr(char X[], char Y[], int m, int n) {
        // Create a table to store lengths of longest common suffixes of
        // substrings. Note that LCSuff[i][j] contains length of longest
        // common suffix of X[0..i-1] and Y[0..j-1]. The first row and
        // first column entries have no logical meaning, they are used only
        // for simplicity of program
        int LCStuff[][] = new int[m + 1][n + 1];
        int result = 0; // To store length of the longest common substring

        // Following steps build LCSuff[m+1][n+1] in bottom up fashion
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    LCStuff[i][j] = 0;
                else if (X[i - 1] == Y[j - 1]) {
                    LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
                    result = Integer.max(result, LCStuff[i][j]);
                } else {
                    LCStuff[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();

        System.out.println("Length of Longest Common Substring is " + LCSubStr(X.toCharArray(), Y.toCharArray(), m, n));
    }

}
