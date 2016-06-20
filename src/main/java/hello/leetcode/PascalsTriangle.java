package hello.leetcode;

import java.util.Vector;

/**
 * Created by scnyig on 5/30/2016.
 */
public class PascalsTriangle {
    public Vector<Vector<Integer> > generate(int numRows) {
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
    * O(k)
     */
   /* public Vector<Integer> getRow(int rowIndex) {
        vector<Integer> vals;

        vals.resize(rowIndex + 1, 1);

        for(int i = 0; i < rowIndex + 1; ++i) {
            for(int j = i - 1; j >= 1; --j) {
                vals[j] = vals[j] + vals[j - 1];
            }

        }

        return vals;
    }*/
}
