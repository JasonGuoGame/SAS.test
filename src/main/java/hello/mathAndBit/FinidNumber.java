package hello.mathAndBit;

/**
 * Created by scnyig on 7/18/2016.
 */
public class FinidNumber {

    public int singleNumber(int[] A, int k, int l) {
        if (A == null) return 0;
        int t;
        int[] x = new int[k];
        x[0] = ~0;
        for (int i = 0; i < A.length; i++) {
            t = x[k-1];
            for (int j = k-1; j > 0; j--) {
                x[j] = (x[j-1] & A[i]) | (x[j] & ~A[i]);
            }
            x[0] = (t & A[i]) | (x[0] & ~A[i]);
        }
        return x[l];
    }


    /**
     * 一个数组里找出出现一次的数字，其他数字都出现偶数次
     * 使用异或操作符
     * 偶数此的异或会直接抵消掉，最后的结果就是出现一次的值
     */
    public int findOnceNumber(int[] data) {
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            result^= data[i];
        }

        return result;
    }
}
