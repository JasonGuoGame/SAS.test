package hello.sort;

import java.lang.reflect.Array;

/**
 * Created by scnyig on 6/16/2016.
 */
public class InsertSort {
    public static int[] sort(int[] data) {
       for(int i = 1; i < data.length; i++) {
           int temp = data[i];
           int j = i;
           while (j > 0 && data[j - 1] > temp) {
                data[j] = data[j - 1];
               j--;
           }
           data[j] = temp;
       }

        return data;
    }
}
