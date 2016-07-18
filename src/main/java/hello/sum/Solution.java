package hello.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by scnyig on 7/18/2016.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        Map<Integer, Integer> vi = new HashMap<>();
        for (int ii = 0; ii < nums.length; ii++) {
            vi.put(nums[ii], ii);
        }

        for (int ii = 0; ii < nums.length; ii++) {
            int first = nums[ii];
            int second = target - first;
            Integer second_index = vi.get(second);
            //don't be same item and null
            if (second_index != null && ii != second_index) {
                return new int[] {ii+1, second_index + 1};
            }
        }

        return null;
    }
}
