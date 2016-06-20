package hello.sort;

/**
 * Created by scnyig on 6/16/2016.
 */
public class QuickSort {

    public static void sort(int[] data) {
        quicksort(data, 0, data.length - 1);
    }

    private static void quicksort(int[] data, int left, int right) {
        int index = partition(data, left, right);
        if (left < index - 1)
            quicksort(data, left, index - 1);
        if (right > index)
            quicksort(data, index, right);

    }

    private static int partition(int[] data, int left, int right) {
        int i = left, j = right;
        int temp;
        int pivoit = data[(left + right) / 2];
        while (i<= j) {
            while (data[i] < pivoit)
                i++;
            while (data[j] > pivoit)
                j--;
            if(i <= j) {
                temp = data[j];
                data[j] = data[i];
                data[i] = temp;
                i++;
                j--;
            }
        }

        return i;
    }
}
