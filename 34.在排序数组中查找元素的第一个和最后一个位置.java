/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = -1;
        int rigth = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                left = i;
                for (int j = left; j < n; j++) {
                    if (nums[j] == target)
                        rigth = j;
                }
                break;
            }
        }
        return new int[]{left, rigth};
    }
}
// @lc code=end

