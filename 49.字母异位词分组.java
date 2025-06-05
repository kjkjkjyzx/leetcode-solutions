/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[][] str = new String[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            str[i][0] = strs[i];
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            str[i][1] = new String(chars);
        }

        Arrays.sort(str, (a, b) -> a[1].compareTo(b[1]));
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            if (i == 0 || !str[i][1].equals(str[i - 1][1])) {
                if (i > 0) {
                    res.add(temp);
                    temp = new ArrayList<>();
                }
            }
            temp.add(str[i][0]);
        }
        res.add(temp);
        return res;
    }
            
}
// @lc code=end

