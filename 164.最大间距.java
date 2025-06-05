/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] temp = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            temp[i] = nums[i+1] - nums[i];
        }
        Arrays.sort(temp);
        return temp[n-2];

    }
}
// @lc code=end

