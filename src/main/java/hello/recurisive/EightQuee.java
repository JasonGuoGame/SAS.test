package hello.recurisive;

/**
 * Created by scnyig on 9/23/2017.
 */
public class EightQuee {
    private static final int ROW = 8, COL = 8, START_ROW = 0, START_COL = 0;
    private static boolean[][] board = new boolean[8][8];

    private static void nextRowPlace(final int row) {
        if(row == ROW){
            print();
            return;
        }
        for(int j=START_COL; j!=COL; ++j)
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
        for(int i=START_ROW; i!=ROW; ++i)
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
    }
}
