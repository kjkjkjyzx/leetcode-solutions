/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int[][] res = new int[n][n];
        int num = 1;
        while (num <= n * n) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                res[i][right] = num++;
            }
            for (int i = right - 1; i >= left; i--) {
                res[bottom][i] = num++;
            }
            for (int i = bottom - 1; i >= top + 1; i--) {
                res[i][left] = num++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
// @lc code=end

