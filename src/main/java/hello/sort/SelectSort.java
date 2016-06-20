package hello.sort;

/**
 * Created by scnyig on 6/16/2016.
 */
public class SelectSort {
    public static void sort(int[] data) {
        int minindex;
        int temp;
        for (int i = 0; i < data.length; i++) {
            minindex = i;
            for (int j = i + 1; j < data.length; j++) {
                if(data[j] < data[minindex]) {
                    minindex = j;
                }
            }
            if (minindex != i) {
                temp = data[minindex];
                data[minindex] = data[i];
                data[i] = temp;
            }
        }
    }
}
