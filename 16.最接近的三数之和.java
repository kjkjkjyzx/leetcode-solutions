/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
       int len = nums.length;
       int abs = 1000000000;
       int result = 0;
       for (int i = 0; i < nums.length - 2; i++) {
        for (int j = i + 1; j < nums.length - 1; j++) {
            for (int k = j + 1; k < nums.length; k++){
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < abs) {
                    abs = Math.abs(sum - target);
                    result = sum;
                }
            }
        }
       }
       return result;
    }
}
// @lc code=end