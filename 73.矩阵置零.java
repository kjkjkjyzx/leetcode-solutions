/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < n; k ++) {
                        if (matrix[i][k] != 0) {
                            temp[i][k] = -1;
                        }
                    }
                    for (int k = 0; k < m; k ++) {
                        if (matrix[k][j] != 0) {
                            temp[k][j] = -1;
                        }
                    }
                }
            }
        }    
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (temp[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
// @lc code=end

