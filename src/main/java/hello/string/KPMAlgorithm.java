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
            //p[k]��ʾǰ׺��p[j]��ʾ��׺
            if (k == - 1 || pattern.charAt(k) == pattern.charAt(j)) {
                //��p[k] == p[j]����next[j + 1 ] = next [j] + 1 = k + 1��
                k++;
                j++;
                next[j] = k;
            }else {
                //��p[k ] �� p[j]�������ʱp[ next[k] ] == p[j ]����next[ j + 1 ] =  next[k] + 1����������ݹ�ǰ׺����k = next[k]�������ظ��˹���
                k = next[k];
            }
        }
    }
}
