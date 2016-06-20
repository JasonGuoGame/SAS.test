package hello.leetcode;

/**
 * Created by scnyig on 5/26/2016.
 */
public class TestArray {
    public static void main(String[] args) {
//        int[] A = {1,2,2,3,2,4};
//        int length = removeElement(A, 6, 2);
        int r = iExponentiatingN(2,3);

    }

    /*
    * i^n
     */
    public static int iExponentiatingN(int i, int n) {
        int result = 1;
        for (int j=0; j <n; j++) {
            result *= i;
        }

        return result;
    }


    public static int removeElement(int A[], int n, int elem) {
        int i = 0;
        int j = 0;
        for(i = 0; i < n; i++) {
            if(A[i] == elem) {
                continue;
            }

            A[j] = A[i];
            j++;
        }

        return j;
    }

    //Remove Duplicates from Sorted Array
    /*
    * Given a sorted array, remove the duplicates in place such that > each element appear only once and return the new length.
     */
    public int removeDuplicates(int A[], int n) {
        if(n == 0) {
            return 0;
        }

        int j = 0;
        for(int i = 1; i < n; i++) {
            if(A[j] != A[i]) {
                A[++j] = A[i];
            }
        }
        return j + 1;
    }

    //Remove Duplicates from Sorted Array
    /*
    * duplicates are allowed at most twice
     */
    public int removeDuplicatesTypeTwo(int A[], int n) {
        if(n == 0) {
            return 0;
        }

        int j = 0;
        int num = 0;
        for(int i = 1; i < n; i++) {
            if(A[j] == A[i]) {
                num++;
                if(num < 2) {
                    A[++j] = A[i];
                }
            } else {
                A[++j] = A[i];
                num = 0;
            }
        }
        return j + 1;
    }
}
