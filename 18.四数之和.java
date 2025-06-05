/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
import java.util.*;
class Solution {
    // 四数之和方法，用于查找数组中所有不重复的四元组，使得它们的和等于给定的目标值
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result; // 如果数组为空或长度小于4，直接返回空列表
        Arrays.sort(nums); // 对数组进行排序，以便于后续的双指针查找



        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复元素，避免结果重复

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // 跳过重复元素，避免结果重复
                // 使用 long 类型来避免整数溢出
                long newTarget = (long) target - nums[i] - nums[j];
                int left = j + 1, right = nums.length - 1; // 初始化左右指针
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == newTarget) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right])); // 找到四元组，加入结果列表
                        while (left < right && nums[left] == nums[left + 1]) left++; // 跳过重复元素
                        while (left < right && nums[right] == nums[right - 1]) right--; // 跳过重复元素
                        left++;
                        right--;
                    } else if (sum < newTarget) {
                        left++; // 如果当前和小于目标值，移动左指针以增加和
                    } else {
                        right--; // 如果当前和大于目标值，移动右指针以减小和
                    }
                }
            }

        }

        

        return result; // 返回所有找到的四元组列表
    }
}
// @lc code=end