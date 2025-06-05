/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] state = new int[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, state, res, list);
        List<List<Integer>> res2 = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int l = res.size();
        for (int i = 0; i < l; i++) {
            int s = 0;
            for (int j = 0; j < res.get(i).size(); j++) {
                s *= 10;
                s += res.get(i).get(j);
            }
            if (!set.contains(s)) {
                res2.add(res.get(i));
                set.add(s);
            }
        }
        return res2;
    }
    private void dfs(int[] nums, int[] state, List<List<Integer>> res, List<Integer> list) {
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

