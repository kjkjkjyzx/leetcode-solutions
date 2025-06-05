/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    /**
     * 计算x的n次方
     * @param x 底数
     * @param n 指数
     * @return x的n次方的结果
     */
    public double myPow(double x, int n) {
        // 处理特殊情况
        if (x == 0)
            return 0;  // 0的任何次方都是0
        if (n == 0)
            return 1;  // 任何数的0次方都是1
        if (x == 1)
            return 1;  // 1的任何次方都是1
        if (x == -1)
            return n % 2 == 0 ? 1 : -1;  // -1的偶数次方是1，奇数次方是-1

        // 使用long类型避免n为Integer.MIN_VALUE时的溢出问题
        long N = n;
        if (N < 0) {
            x = 1 / x;  // 负数次方转换为正数次方的倒数
            N = -N;     // 将指数转为正数
        }

        return fastPow(x, N);  // 调用快速幂算法
    }

    /**
     * 使用快速幂算法计算x的n次方
     * 时间复杂度：O(logn)
     * @param x 底数
     * @param n 指数
     * @return x的n次方的结果
     */
    private double fastPow(double x, long n) {
        if (n == 0)
            return 1.0;

        double half = fastPow(x, n / 2);  // 递归计算x的n/2次方
        if (n % 2 == 0) {
            return half * half;  // 如果n是偶数，结果是half的平方
        } else {
            return half * half * x;  // 如果n是奇数，结果是half的平方再乘以x
        }
    }
}
// @lc code=end
