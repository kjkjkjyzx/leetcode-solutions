/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        // 获取数组长度
        int n = nums.length;
        // 如果数组只有一个元素，直接返回该元素
        if (n == 1) {
            return nums[0];
        }
        
        // max[i]表示以第i个元素结尾的子数组的最大乘积
        int[] max = new int[n];
        // min[i]表示以第i个元素结尾的子数组的最小乘积
        int[] min = new int[n];
        
        // 初始化第一个元素的最大最小值
        max[0] = nums[0];
        min[0] = nums[0];
        // 记录全局最大乘积
        int res = nums[0];
        
        // 动态规划求解
        for (int i = 1; i < n; i++) {
            // 当前位置的最大值可能来自：
            // 1. 前一个位置的最大值乘以当前值
            // 2. 前一个位置的最小值乘以当前值（当前值为负数时）
            // 3. 当前值本身（前面的乘积比当前值还小）
            max[i] = Math.max(Math.max(max[i-1] * nums[i], min[i-1] * nums[i]), nums[i]);
            // 当前位置的最小值可能来自：
            // 1. 前一个位置的最大值乘以当前值（当前值为负数时）
            // 2. 前一个位置的最小值乘以当前值
            // 3. 当前值本身
            min[i] = Math.min(Math.min(max[i-1] * nums[i], min[i-1] * nums[i]), nums[i]);
            // 更新全局最大乘积
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
// @lc code=end 

