/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }
}
// @lc code=end

