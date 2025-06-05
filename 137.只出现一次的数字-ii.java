/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
import java.util.*;
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (i + 2 < n && nums[i] == nums[i + 2]) {
                i += 3;
            } else {
                break;
            }
        }
        return nums[i];
    }
}
// @lc code=end
