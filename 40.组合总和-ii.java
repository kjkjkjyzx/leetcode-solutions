/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, list, res);
        return res;
    }

    public static void dfs(int[] candidates, int target, int index, int sum, List<Integer> list, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 剪枝：如果当前和加上当前数字已经超过target，后面的数字只会更大，直接break
            if (sum + candidates[i] > target) {
                break;
            }

            // 跳过重复元素，避免重复组合
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            list.add(candidates[i]);
            dfs(candidates, target, i + 1, sum + candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end
