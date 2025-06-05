/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    // 实现字符串转换为整数的功能，类似于C语言的atoi函数
    public int myAtoi(String s) {
        // 去除字符串前后的空白字符
        String str = s.trim();
        // 如果去除空白后字符串为空，返回0
        if (str.isEmpty()) {
            return 0;
        }
        
        StringBuilder sb = new StringBuilder();
        int sign = 1;
        int i = 0;
        
        // 处理符号
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        
        // 处理数字
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                break;
            }
        }
        
        // 如果没有数字被处理，返回0
        if (sb.length() == 0) {
            return 0;
        }
        
        int res = 0;
        // 将字符串转换为整数，并进行溢出判断
        for (i = 0; i < sb.length(); i++) {
            int digit = sb.charAt(i) - '0';
            // 溢出判断
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + digit;
        }
        
        // 返回最终结果，考虑符号
        return res * sign;
    }
        
}
// @lc code=end

