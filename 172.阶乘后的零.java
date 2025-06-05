/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int k = 1;
        int count = 0;
        while (k * 5 <= n) {
            count ++;
            if (k % 5 == 0) {
                int temp = k;
                while (temp % 5 == 0) {
                    temp /= 5;
                    count ++;
                }
            }
            k ++;
        }
        return count;
    }
}
// @lc code=end

