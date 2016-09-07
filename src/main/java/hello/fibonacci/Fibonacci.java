package hello.fibonacci;

/**
 * Created by scnyig on 7/18/2016.
 * http://hahack.com/wiki/algorithms-divide-and-conquer.html
 */
public class Fibonacci {
    /*
    * 朴素解法（直接递归求解）需要指数级[1]的时间（准确点讲是 Ω(ϕn)Ω(ϕn)，其中 ϕϕ 是黄金分割比 1+5√21+52）
    * recursive
    * O(n2)
     */
    public static int recrisiveFibonacci(int n)
    {
        if (n <= 1)
        return n;
        else
        return recrisiveFibonacci(n - 1) + recrisiveFibonacci(n - 2);
    }

    /*
    * 线性的解法朴素解法在计算斐波那契数列的时候做了很多不必要的重复计算。
    * 使用动态规划、自底向上递归求解的策略可以将Fibonacci数列的计算规模降低到线性级别，即 O(n)O(n) 的时间复杂度。
    * 主要的思想基于这点：计算新的值时，用到前两个数的结果。可以用借助一维数组来实现。
    * O(n)
     */
    public static int Fibonacci(int n)
    {
        if (n <= 1)
            return n;
        else{
            int[] f = new int[n + 1];
            f[0] = 0;
            f[1] = 1;

            for (int i = 2; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }

            return f[n];
        }
    }

    /**
     *
     * 显然对斐波那契数列的求解变成了求矩阵 (1110)(1110) 的 nn 次幂，用到上面求乘方的算法可以将时间复杂度将为 O(lgn)O(lgn) 。
     * 两矩阵相乘
     * @param matrix1
     * @param matrix2
     * @return
     */
    public static int[][] matrixMutiple(int[][] matrix1,int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for(int i = 0; i < matrix1.length; i++) {
            for(int j = 0; j < matrix2[i].length; j++) {
                int temp = 0;
                for(int k = 0; k < matrix1[0].length; k++) {
                    temp = matrix1[i][k] * matrix2[k][j] + temp;
                }
                result[i][j] = temp;
            }
        }
        return result;
    }
}
