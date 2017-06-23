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

    //如果轮询一趟都没有交换位置，则排序完成。
    public static int[] bubble_sort(int[] data) {
        if(data == null || data.length ==0) {
            return null;
        }

        boolean flag = false;
        for (int outer = data.length -1; outer >= 0 && !flag; outer--) {
            flag = true;
            for (int inner = 0; inner < outer;inner++) {
                if(data[inner] > data[inner+1]) {
                    int temp = data[inner];
                    data[inner] = data[inner+1];
                    data[inner+1] =temp;

                    flag = false;
                }
            }
        }

        return data;
    }
}
