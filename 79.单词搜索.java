/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    public static boolean dfs(char[][] board, String word, int i, int j, int index) {
        // 探索完成
        if (index == word.length()) return true;
        
        // 数组越界的情况
        if (i < 0 || i == board.length || j < 0 || j == board[0].length)
            return false;

        // 当前位置的字符与目标字符不匹配
        if (board[i][j] != word.charAt(index)) 
            return false;
        // 当前位置的字符与目标字符匹配,标记当前位置为已访问
        board[i][j] = '*';

        // 向四个方向搜索
        if (dfs(board, word, i + 1, j, index + 1))
            return true;
        if (dfs(board, word, i - 1, j, index + 1))
            return true;
        if (dfs(board, word, i, j + 1, index + 1))
            return true;
        if (dfs(board, word, i, j - 1, index + 1))
            return true;
        
        // 回溯：恢复当前位置的原始字符
        board[i][j] = word.charAt(index);
        
        return false;
    }
}
// @lc code=end

