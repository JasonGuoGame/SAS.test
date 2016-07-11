package hello.leetcode;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by scnyig on 5/30/2016.
 */
public class PascalsTriangle {
    public static Vector<Vector<Integer> > generate(int numRows) {
        Vector<Vector<Integer> > vals = new Vector<Vector<Integer>>(numRows);;

        for(int i = 0; i < numRows; i++) {
            vals.set(i, new Vector<Integer>(i + 1));

            vals.get(i).set(0, 1);
            vals.get(i).set(vals.get(i).size() - 1, 1);
            for(int j = 1; j < vals.get(i).size() - 1; j++) {
                vals.get(i).set(j, vals.get(i - 1).get(j - 1) + vals.get(i - 1).get(j));
            }
        }

        return vals;
    }

    //Given an index k, return the kth row of the Pascal's triangle.
    /*
    * A[k][n] = A[k-1][n-1] + A[k-1][n]
    * O(n^2)
     */
    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (rowIndex < 0)
            return result;

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> vector = getRow(4);
        System.out.println(vector);
    }
}
