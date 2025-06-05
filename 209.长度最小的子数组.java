/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口
        int n = nums.length;
        int l = 0, r = 0;
        int sum = 0;
        int res = n + 1;
        while (sum < target && r < n) {
            sum += nums[r];
            r++;
            while (sum >= target) {
                res = Math.min(res, r - l);
                sum -= nums[l];
                l++;
            }
        }

        if (res == n + 1) { // 没有找到
            return 0;
        }
        return res;
    }
}
// @lc code=end
