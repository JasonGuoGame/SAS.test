package hello.sum;

/**
 * Created by scnyig on 7/24/2017.
 */
public class GuessGame {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        // Write your code here
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            }

            if (res == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * three type of resutls, 1,0, -1
     * @param value
     * @return
     */
    public int guess(int value) {
        return 1;
    }
}
