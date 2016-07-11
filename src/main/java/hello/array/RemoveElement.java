package hello.array;

/**
 * Created by scnyig on 7/11/2016.
 */
public class RemoveElement {
    /*
    * remove specify value and don't new array
    * [1，2，2，3，2，4]
     */

    public static int removeEle(int[] array, int value) {
        int i = 0;
        int j = 0;
        for (i = 0; i < array.length; i++) {
            if (array[i] == value) {
                continue;
            }

            array[j] = array[i];
            j++;
        }

        return j;
    }

    /**
     * sorted array
     * @param A
     * @return
     */
    static int removeDuplicates(int A[]) {
        int j = 0;
        for(int i = 1; i < A.length; i++) {
            if(A[j] != A[i]) {
                A[++j] = A[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,3,2,4};
        int in = removeEle(a,2);
        System.out.println(in);
        int[] b = {1,2,2,3,3,4,4};
        int ib = removeDuplicates(b);
        System.out.println(ib);
    }
}
