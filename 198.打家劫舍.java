/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // 当n=1时，dp[0] = nums[0];
        dp[0] = nums[0];
        if (n == 1) return dp[0];

        // 当n=2时，dp[1] = Math.max(nums[0], nums[1]);
        dp[1] = Math.max(nums[0], nums[1]);
        if (n == 2) return dp[1];

        // 当n>2时，dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            // 1.dp[i-1]刚好偷到i-1; dp[i-2]刚好偷到i-2; 那么选择两者中较大者即可
            // 2.dp[i-1]刚好偷到i-2; dp[i-2]刚好偷到i-2; 那么选择dp[i-2]+nums[i]即可    
        }
        return dp[n - 1];
    }
}
// @lc code=end