package hello.algorithm.blacktracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scnyig on 10/11/2017.
 */
public class NQueens {
    private static int count = 0;;
    private static List<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        boolean solve = solve1(0, data, 8);
        System.out.println(solve);

        int totalNQueens = totalNQueens(6);

        System.out.println(totalNQueens);
    }

    public static int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        List<Integer> matrix = new ArrayList<>(n);

        solve2(0,matrix,n);


        return count;
    }

    public static void solve3(int i, List<Integer> matrix, int n) {
        if (i == n) {
            if (isValid(matrix))
                result.add(new ArrayList<Integer>(matrix));
            return;
        } else {
            for (int j = 0; j < n; j++) {
                matrix.add(j);
                if (isValid(matrix)) {    //剪枝
                    solve3(i + 1, matrix, n);
                }
                matrix.remove(matrix.size() - 1);
            }
        }
    }

    public static void solve2(int i, List<Integer> matrix, int n) {
        if (i == n) {
            if (isValid(matrix))
                count++;
            return;
        } else {
            for (int j = 0; j < n; j++) {
                matrix.add(j);
                if (isValid(matrix)) {    //剪枝
                    solve2(i + 1, matrix, n);
                }
                matrix.remove(matrix.size() - 1);
            }
        }
    }

    public static boolean solve1(int i, List<Integer> matrix, int n) {
        if (i == n) {
            if (isValid(matrix))
                return true;
            return false;
        } else {
            for (int j = 0; j < n; j++) {
                matrix.add(j);
                if (isValid(matrix)) {    //剪枝
                    if (solve1(i + 1, matrix, n))
                        return true;
                }
                matrix.remove(matrix.size() - 1);
            }
            return false;
        }
    }

    public static boolean isValid(List<Integer> list){
        int row = list.size() - 1;
        int col = list.get(row);
        for (int i = 0; i <= row - 1; i++) {
            int row1 = i;
            int col1 = list.get(i);
            if (col == col1)
                return false;
            if (row1 - row == col1 - col)
                return false;
            if (row1 - row == col - col1)
                return false;
        }
        return true;

    }
}
