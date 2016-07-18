package hello.fibonacci;

/**
 * Created by scnyig on 7/18/2016.
 */
public class Fibonacci {
    /*
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
}
