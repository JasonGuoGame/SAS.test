package hello.sort;

import hello.immutable.SynchronizedRGB;

import java.lang.reflect.Array;

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


}
