package hello.recurisive;

import java.util.ArrayList;
import java.util.List;

/**
 * backtracking
 * Created by scnyig on 9/23/2017.
 * https://www.bbsmax.com/A/A7zgEgqn54/
 */
public class EightQuee {
    private static final int ROW = 6, COL = 6, START_ROW = 0, START_COL = 0;
    private static boolean[][] board = new boolean[6][6];
    private static List result = new ArrayList<>();

    private static void nextRowPlace(final int row) {
        if(row == ROW){
            print();
            return;
        }
        for(int j=START_COL; j<COL; ++j)
            if(checkPosValid(row, j)){
                board[row][j] = true;
                nextRowPlace(row+1);
                board[row][j] = false;
            }
        return;
    }

    //右上方和左下方不用判断，因为已经判断过了
    private static boolean checkPosValid(final int row, final int col) {
        //判断上下列的方向
        for(int i=START_ROW; i<ROW; ++i)
            if(board[i][col])
                return false;

        //左上方
        for(int i=row, j=col; i!=START_ROW-1 && j!=START_COL-1; --i, --j)
            if(board[i][j])
                return false;

        //左下方
        for(int i=row, j=col; i!=START_ROW-1 && j!= COL; --i, ++j)
            if(board[i][j])
                return false;
        return true;
    }

    private static int count = 0;
    private static void print() {
        System.out.println("--- --- --- --- --- " + ++count +" --- ---");
        for(int i=START_ROW; i!=ROW; ++i){
            for(int j=START_COL; j!=COL; ++j)
                System.out.print(board[i][j] ? "O " : "X ");
            System.out.println();
        }
        System.out.println();
        return;
    }

    public static void main(String[] args) {
        nextRowPlace(START_ROW);
        List<Integer> matrix = new ArrayList<Integer>();


        solve3(0, matrix, ROW);
        System.out.println(result);
    }

    public static void solve3(int i, List<Integer> matrix, int n) {
        if (i == n) {
            if (isValid(matrix))
                result.add(new ArrayList<Integer>(matrix));
            return;
        }
        else {
            for (int j = 0; j < n; j++) {
                matrix.add(j);
                if (isValid(matrix)) { //剪枝
                    solve3(i + 1, matrix, n);
                }
                matrix.remove(matrix.size() - 1);
            }
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
