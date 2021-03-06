package hello.divideandconquer;

/**
 * Created by scnyig on 7/13/2016.
 */
public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = -1, end = nums.length;
        int mid;
        while (start + 1 < end) {
            // avoid overflow when (end + start)
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end == nums.length || nums[end] != target) {
            return -1;
        } else {
            return end;
        }
    }
}
