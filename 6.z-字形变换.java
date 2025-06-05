/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;


        StringBuilder sb = new StringBuilder();
        int k = s.length() / (2 * numRows - 2);
        if (k * (2 * numRows - 2) != s.length())
            k++;

        for (int i = 0; i < k; i ++) {
            if (i * 2 * (numRows-1) < s.length()) {
                sb.append(s.charAt(i * 2 * (numRows-1)));
            }
        }
        for (int j = 1; j < numRows - 1; j ++) {
            for (int i = 0; i < k; i ++) { 
                if (j + i * 2 * (numRows-1) < s.length()) {
                    sb.append(s.charAt(j + i * 2 * (numRows-1)));
                }
                if (2 * (numRows-1) - j + i * 2 * (numRows-1) < s.length()) {
                    sb.append(s.charAt(2 * (numRows-1) - j + i * 2 * (numRows-1)));
                }
            }
        }
        for (int i = 0; i < k; i ++) {
            if ((numRows-1) + i * 2 * (numRows-1) < s.length()) {
                sb.append(s.charAt((numRows-1) + i * 2 * (numRows-1)));
            }
        }


        return sb.toString();
    }    
} 
// @lc code=end

