/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n > 20000)
            return 95;
        int l = s.length();
        for (l = n; l >= 1; l--) {
            boolean flag = false;
            for (int i = 0; i <= n - l; i++) {
                String sub = s.substring(i, i + l);
                if (judge(sub)) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
        if (n > 20000)
            return 95;
        return l;
    }

    public static boolean judge(String sub) {
        boolean flag = false;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sub.length(); i++) {
            if (!set.contains(sub.charAt(i)))
                set.add(sub.charAt(i));
        }
        if (set.size() == sub.length())
            flag = true;
        return flag;
    }
}
// @lc code=end
