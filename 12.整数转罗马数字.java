/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // 定义罗马数字及其对应的值，包括特殊情况如4, 9等
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        // 处理每个数值下的罗马数字表示
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(roman[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}

// @lc code=end
