/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[] state = new int[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, state, res, list);
        return res;
    }
    public void dfs(int[] nums, int[] state, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (state[i] == 0) {
                state[i] = 1;
                list.add(nums[i]);
                dfs(nums, state, res, list);
                list.remove(list.size() - 1);
                state[i] = 0;
            }
        }
    }
}
// @lc code=end

