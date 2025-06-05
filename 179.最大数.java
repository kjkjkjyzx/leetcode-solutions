/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        int[] state = new int[nums.length];
        List<List<String>> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(list, temp, strs, state);
        String res = "";
        for (int i = 0; i < list.size(); i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < list.get(i).size(); j++){
                sb.append(list.get(i).get(j));
            }
            if (res.compareTo(sb.toString()) < 0){
                res = sb.toString();
            }
        }
        return res;
    }

    public static void dfs(List<List<String>> list, List<String> temp, String[] strs, int[] state){
        if (temp.size() == strs.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < strs.length; i++){
            if (state[i] == 1) continue;
            state[i] = 1;
            temp.add(strs[i]);
            dfs(list, temp, strs, state);
            state[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

