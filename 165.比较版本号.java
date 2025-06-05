/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\."); //在Java中点号(.)是正则表达式的特殊字符，
        String[] str2 = version2.split("\\."); //需要用反斜杠转义，而反斜杠本身在字符串中也需要转义。
        int n = Math.max(str1.length, str2.length);
        int[] s1 = new int[n];
        int[] s2 = new int[n];
        for (int i = 0; i < n; i ++) {
            if (i < str1.length) {
                s1[i] = Integer.parseInt(str1[i]);
            } else {
                s1[i] = 0;
            }
            if (i < str2.length) {
                s2[i] = Integer.parseInt(str2[i]);
            } else {
                s2[i] = 0;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i ++) {
            if (s1[i] > s2[i]) {
                res = 1;
                break;
            } else if (s1[i] < s2[i]) {
                res = -1;
                break;
            }
        }
        return res;
    }
}
// @lc code=end

