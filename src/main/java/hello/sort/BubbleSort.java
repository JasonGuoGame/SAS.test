package hello.sort;

/**
 * Created by scnyig on 6/16/2016.
 */
public class BubbleSort {
    public static int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for(int j = 1; j < data.length - i; j++) {
                if(data[j] < data[j - 1]) {
                    int temp = data[j];
                    data[j]= data[j -1];
                    data[j-1] = temp;
                }
            }
        }

        return data;
    }
}
