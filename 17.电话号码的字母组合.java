/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) 
            return new ArrayList<String>();
        int n = digits.length();
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<String>();
        dfs(0, digits, n, map, sb, res);
        return res;
    }
     public void dfs(int index, String digits, int n, String[] map, StringBuilder sb, List<String> res) {
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);//索引为index的数字
        String letters = map[c - '2'];//数字'c'对应的字母
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(index + 1, digits, n, map, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
     }
}
// @lc code=end

