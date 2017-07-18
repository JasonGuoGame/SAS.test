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

    /*
    * 将2的幂次方写成二进制形式后，很容易就会发现有一个特点：二进制中只有一个1，并且1后面跟了n个0； 因此问题可以转化为判断1后面是否跟了n个0就可以了。
    * 如果将这个数减去1后会发现，仅有的那个1会变为0，而原来的那n个0会变为1；因此将原来的数与去减去1后的数字进行与运算后会发现为零。
    */
    public boolean isPowerOfTwo(int n) {
        return  n > 0 && (n & (n -1)) == 0;
    }
}
