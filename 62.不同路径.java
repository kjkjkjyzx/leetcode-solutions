/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int a = m + n - 2;
        int b = Math.min(m, n) - 1;
        long res = 1;
        for (int i = 1; i <= b; i++) {
            res *= (a - i + 1);
            res /= i;
        }
        return (int) res;
    }
}
// @lc code=end
