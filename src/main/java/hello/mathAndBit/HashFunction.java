package hello.mathAndBit;

/**
 * 33即是素数（质数），也是奇数。除了33，还有131, 1313, 5381等。
 * Created by scnyig on 7/18/2016.
 * 这道题的关键是大整数溢出，
 * 整数求模公式(a * b) % m = a % m * b % m
 */
public class HashFunction {
    public static void main(String[] args) {
        int has = hashCode2("abcd".toCharArray(), 100);
        System.out.println(has);
    }

    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     * O(nlogn) O(1)
     */
    public static int hashCode(char[] key,int HASH_SIZE) {
        if (key == null || key.length == 0) return -1;

        long hashSum = 0;
        for (int i = 0; i < key.length; i++) {
            hashSum += key[i] * modPow(33, key.length - i - 1, HASH_SIZE);
            hashSum %= HASH_SIZE;
        }

        return (int)hashSum;
    }

    private static long modPow(int base, int n, int mod) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return base % mod;
        } else if (n % 2 == 0) {
            long temp = modPow(base, n / 2, mod);
            return (temp % mod) * (temp % mod) % mod;
        } else {
            return (base % mod) * modPow(base, n - 1, mod) % mod;
        }
    }


    /*
    * time:O(n) space:O(1)
     */
    public static int hashCode2(char[] key,int HASH_SIZE) {
        if (key == null || key.length == 0) return -1;

        long hashSum = 0;
        for (int i = 0; i < key.length; i++) {
            hashSum = 33 * hashSum + key[i];
            hashSum %= HASH_SIZE;
        }

        return (int)hashSum;
    }
}
