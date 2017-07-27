package hello.systemdesign.dp;

/**
 * Created by scnyig on 7/27/2017.
 */
public class ShortestSum {
    /**
     * use DP to resolve this problem
     * @param grid
     * @return
     */
    public int shortestSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] sum = new int[M][N];

        sum[0][0] = grid[0][0];
        for (int i = 1; i < M; i++) {
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < N; i++) {
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }

        for (int i = 1; j < M;i++) {
            for (int j = 1; j < N; j++) {
                sum[i][j] = Math.min(sum[i-1][j],sum[i][j-1]) + grid[i][j];
            }
        }

        return sum[M-1][N-1];
    }
}
