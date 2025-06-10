/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 多数元素 II
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // 定义一个map，key为元素，value为元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 定义一个list，用于存储元素
        List<Integer> list = new ArrayList<>();
        // 计算每个元素出现的次数
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                // 如果map中没有这个元素，就添加到map和temp中
                map.put(nums[i], 1);
                list.add(nums[i]);
            } else {
                // 如果map中已经有这个元素，就将其出现的次数加1
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        // 定义一个list，用于存储出现次数超过n/3的元素
        List<Integer> res = new ArrayList<>();
        // 遍历temp，找到出现次数超过n/3的元素
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) > nums.length / 3) {
                res.add(list.get(i));
            }
        }
        return res;
    }
}

