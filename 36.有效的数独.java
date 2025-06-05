/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;


        for (int i = 0; i < n; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                // 检查行约束
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }
                // 检查列约束
                if (board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }
            }
        }
        

        boolean flag = true;
        for (int i = 1; i < n; i += 3) {
            for (int j = 1; j < n; j += 3) {

                HashSet<Character> set = new HashSet<>();
                for (int p = i - 1; p < i + 2; p++) {
                    for (int q = j - 1; q < j + 2; q++) {
                        if (board[p][q] != '.') {
                            if (!set.contains(board[p][q])) {
                                set.add(board[p][q]);
                            } else {
                                return false;
                            }
                        }
                    }
                }
                
                set.clear();
            }
        }
        return flag;


    }
}

// @lc code=end
