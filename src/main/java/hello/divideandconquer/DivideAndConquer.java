package hello.divideandconquer;

import hello.tree.BinaryTree;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scnyig on 9/7/2016.
 */
public class DivideAndConquer {
    /**
     * x~n
     */
    public static int pow(int x, int n) {
        if(n==0) return 1;
        else if(n == 1) return x;
        else {
            if(n % 2 == 1) {
                return pow(x, (n-1)/2)*pow(x,(n-1)/2)*x;
            }else {
                return pow(x,n/2)*pow(x,n/2);
            }
        }
    }

    public static void mergeSort(int[] arry) {
        //divide tow array
        //sort two array
        //merge two array
        int middle = (arry.length -1)/2;
        sort(arry, 0,middle);
        sort(arry, middle+1, arry.length - 1);
        merge(arry, 0,middle,arry.length -1);
    }

    public static void sort(int[] array, int low, int hight) {
        //recursive sort
        if(low>=hight) return;
        int middle = low + (hight - low)/2;
        sort(array, low, middle);
        sort(array, middle+1, hight);
        merge(array, low,middle,hight);
    }

    public static void merge(int[] array, int low, int middle, int height) {
        int[] helper = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            helper[i] = array[i];
        }

        int i = low, j = middle+1;
        for(int k = low;k<=height;k++) {
            if(i> middle) {
                array[k] = helper[j];
                j++;
            } else if(j > height) {
                array[k] = helper[i];
                i++;
            } else if(helper[i] > helper[j]) {
                array[k] = helper[j];
                j++;
            }else {
                array[k] = helper[i];
                i++;
            }
        }

    }

    /*public static void mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        merge(array, low, mid, high);
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] helper = new int[array.length];
        // copy array to helper
        for (int k = low; k <= high; k++) {
            helper[k] = array[k];
        }
        // merge array[low...mid] and array[mid + 1...high]
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            // k means current location
            if (i > mid) {
                // no item in left part
                array[k] = helper[j];
                j++;
            } else if (j > high) {
                // no item in right part
                array[k] = helper[i];
                i++;
            } else if (helper[i] > helper[j]) {
                // get smaller item in the right side
                array[k] = helper[j];
                j++;
            } else {
                // get smaller item in the left side
                array[k] = helper[i];
                i++;
            }
        }
    }*/


    public static void main(String[] args) {
        int unsortedArray[] = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        mergeSort(unsortedArray);
        int pow = pow(3, 5);
        System.out.println("After sort: ");
        for (int item : unsortedArray) {
            System.out.print(item + " ");
        }
    }

    /*
    * Given a binary tree, return the preorder traversal of its nodes' values.
     */
    public static List preOrderTraversal(BinaryTree.TreeNode root) {
        List result = new ArrayList<>();
        if(root != null) {
            List left = preOrderTraversal(root.left);
            List right = preOrderTraversal(root.right);

            //merge
            result.add(root);
            result.addAll(left);
            result.addAll(right);
        }



        return result;
    }
}
