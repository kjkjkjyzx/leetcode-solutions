/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        // 使用布尔数组来标记质数
        boolean[] dp = new boolean[n];
        // 初始化所有数为质数
        Arrays.fill(dp, true);
        for (int i = 2; i < n; i++) {
            // 如果当前数是质数，则将它的倍数标记为非质数
            if (dp[i]) {
                for (int j = i * 2; j < n; j += i) {
                    dp[j] = false;
                }
            }
        }

        // 统计质数个数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (dp[i]) {
                count++;
            }
        }
        
        return count;
    }
}
// @lc code=end
