package hello.sort;

import hello.immutable.SynchronizedRGB;

/**
 * Created by scnyig on 6/16/2016.
 */
public class TestSort {
    public static void main0(String[] args) {
        int[] data = {3,2,5,6,7,5,1,4,9,6,2};
        SelectSort.sort(data);
        printD(data);
    }

    private static void printD(int[] data) {
        for (int a : data) {
            System.out.println(a);
        }
    }
}
