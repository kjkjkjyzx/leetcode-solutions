/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
                row = i;
                break;
            }
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (matrix[row][left] == target) {
                return true;
            }
            left++;
        }
        return false;
    }
}
// @lc code=end
