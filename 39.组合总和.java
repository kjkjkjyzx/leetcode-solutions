/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res =  new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, 0, 0,list, res);
        return res;
    }

    public static void dfs (int[] candidates, int target, int index, int sum, List<Integer> list, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, target, i, sum + candidates[i], list, res);
            list.remove(list.size() - 1);
        }   
    }
}
// @lc code=end

