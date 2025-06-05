/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            }
            return 1;
        }


        int index = 0;
        if (nums[0] > nums[1]) {
            index = 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            index = n - 1;
        }
        for(int i = 1; i < n - 1; i++){
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
// @lc code=end 

