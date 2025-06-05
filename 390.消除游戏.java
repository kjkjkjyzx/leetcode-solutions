/*
 * @lc app=leetcode.cn id=390 lang=java
 *
 * [390] 消除游戏
 */

// @lc code=start
/*class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;
        
        while (n > 1) {
            //从左边开始移除 or（从右边开始移除，数列总数为奇数）
            if (left || n % 2 != 0) {
                head += step;
            }
            step *= 2; //步长 * 2
            left = !left; //取反移除方向
            n /= 2; //总数 / 2
        }

        return head;
    }
}*/



class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean towards = true;

        while (n > 1) {
            if (towards) {
                head += step;
            } else if (n % 2 != 0) {
                head += step;
            }
            step *= 2;
            towards = !towards;
            n /= 2;
        }
        return head;
    }
}
// @lc code=end
