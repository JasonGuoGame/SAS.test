package hello.sort;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by scnyig on 6/16/2016.
 */
public class TestSort {
    public static void main(String[] args) {
        int[] data = {3,2,5,6,7,5,1,4,9,6,2};
        int[] sortData = {0,1,2,4,3,5,6,7,8,9};
//        SelectSort.sort(data);
        int[] ss = BubbleSort.bubble_sort(sortData);
//        QuickSort.sort(data);
//        printD(data);
        try {
            String content = new String(Files.readAllBytes(Paths.get("C:\\score.sas")));
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* String a = "aaadddeee";
        String b = "efadfe";
        int length = distance(a, b);
        System.out.println(length);*/
    }

    private static void printD(int[] data) {
        for (int a : data) {
            System.out.println(a);
        }
    }

    class Tnode {
        int value;
        Tnode left;
        Tnode right;
        public Tnode(int value) {
            this.value = value;
        }
    }

    class Ttree{
        Tnode root;
        public Ttree(int[] array, int index) {
            root = makeTtree(array, index);
        }

        private Tnode makeTtree(int[] array, int index) {
            Tnode root = null;
            if(index < array.length) {
                if(array[index] != 0) {
                    root = new Tnode(array[index]);
                    array[index] = 0;
                    root.left = makeTtree(array, index * 2);
                    root.right = makeTtree(array, index * 2 + 1);
                }
            }

            return root;
        }
    }

    public static int minium(int a, int b, int c){
        return Math.min(Math.min(a,b),c);
    }

    public static int distance(String a, String b) {
        if(a == null || b == null) return a == null ? b.length() : a.length();

        int[][] dis = new int[a.length() + 1][b.length() +1];
        for (int i = 0; i <= a.length(); i++)
            dis[i][0] = i;
        for (int j = 1; j <= b.length(); j++)
            dis[0][j] = j;

        for (int i = 1; i <= a.length();i++) {
            for (int j = 1; j <= b.length(); j++) {
                dis[i][j] = minium(dis[i-1][j] + 1, dis[i][j -1] + 1, dis[i-1][j-1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1));
            }
        }

        return dis[a.length()][b.length()];
    }
}
