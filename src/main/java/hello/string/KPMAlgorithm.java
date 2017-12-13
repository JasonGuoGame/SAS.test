package hello.string;

/**
 * Created by scnyig on 12/13/2017.
 */
public class KPMAlgorithm {
    static int[] next;

    public static int indexOf(String source, String pattern) {
        int i = 0, j = 0;
        int slength = source.length();
        int plength = pattern.length();
        generateNext(pattern);
        while (i < slength && j < plength) {
            if(j == -1 || source.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if(j == plength) {
            return i - j;
        }else {
            return -1;
        }
    }

    public static void generateNext(String pattern) {
        next = new int[pattern.length()];

        int plength = pattern.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < plength - 1) {
            //p[k]表示前缀，p[j]表示后缀
            if (k == - 1 || pattern.charAt(k) == pattern.charAt(j)) {
                //若p[k] == p[j]，则next[j + 1 ] = next [j] + 1 = k + 1；
                k++;
                j++;
                next[j] = k;
            }else {
                //若p[k ] ≠ p[j]，如果此时p[ next[k] ] == p[j ]，则next[ j + 1 ] =  next[k] + 1，否则继续递归前缀索引k = next[k]，而后重复此过程
                k = next[k];
            }
        }
    }
}
