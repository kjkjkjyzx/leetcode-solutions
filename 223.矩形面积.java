/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 */

// @lc code=start
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 计算两个矩形的面积
        int s1 = (ax2 - ax1) * (ay2 - ay1);
        int s2 = (bx2 - bx1) * (by2 - by1);

        // 计算两个矩形的交集面积
            // 用右边界最小值减去左边界最大值，得到重叠部分的宽度，如果没有重叠则为0
        int x = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
            // 用上边界最小值减去下边界最大值，得到重叠部分的高度，如果没有重叠则为0
        int y = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        
        return s1 + s2 - x * y;
    }
}
// @lc code=end

