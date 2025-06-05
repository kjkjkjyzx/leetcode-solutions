/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
import java.util.*;
class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int[] res = new int[2];
        int j = 0;
        while (i < n) {
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                i += 2;
            } else {
                res[j] = nums[i];
                j ++;
                i ++;
            }
        }
        return res;
    }
}
// @lc code=end

