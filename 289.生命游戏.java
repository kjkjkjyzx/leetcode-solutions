/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        // 复制数组,使用temp数组保存原始状态
        int[][] tmp = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                tmp[i][j] = board[i][j];
            }
        }

        // 遍历数组
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int count = 0;
                // 计算周围活细胞数
                for (int p = Math.max(0, i - 1); p <= Math.min(board.length - 1, i + 1); p++) {
                    for (int q = Math.max(0, j - 1); q <= Math.min(board[0].length - 1, j + 1); q++) {
                        if (p == i && q == j) continue;
                        if (tmp[p][q] == 1) count++;
                    }
                }
                // 更新状态
                if (tmp[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 0;   //这里千万不能用temp[i][j],因为这样会改变temp数组,影响后续的判断
                } else if (tmp[i][j] == 0 && count == 3) {
                    board[i][j] = 1;   //这里千万不能用temp[i][j],因为这样会改变temp数组,影响后续的判断
                }
            }
        }

        
    }
}
// @lc code=end

