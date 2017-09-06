package hello.dynamicprogram;

/**
 * Created by scnyig on 9/1/2017.
 * https://leetcode.com/problems/maximal-square/solution/#approach-2-dynamic-programming-accepted
 */
public class MaxSquare {
    public static int solution(int[][] matrix) {
        int n = matrix.length;
        int m = n > 0 ? matrix[0].length : 0;
        int max = 0;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    max = Math.max(dp[i][j],max);
                }
            }
        }

        return max*max;
    }
}
