/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int len = nums.length;
        int n;
        int i , j;
        for (i = 0; i < len; i++) {
            count = 0;
            n = nums[i];
            for (j = 0; j < len; j++){
                if (n == nums[j])
                    count++;
            }
            if (count > len/2)
                break;
        }
        return nums[i];
    }
}
// @lc code=end

