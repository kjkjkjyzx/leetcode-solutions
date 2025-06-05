/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
import java.util.*;

class Solution {
    /**
     * 字符串相乘
     * @param num1 第一个数字字符串
     * @param num2 第二个数字字符串
     * @return 相乘结果的字符串表示
     */
    public String multiply(String num1, String num2) {
        // 将num1转换为整数数组
        int[] m = new int[num1.length()];
        for (int i = 0; i < num1.length(); i++) {
            m[i] = num1.charAt(i) - '0';
        }
        // 将num2转换为整数数组
        int[] n = new int[num2.length()];
        for (int i = 0; i < num2.length(); i++) {
            n[i] = num2.charAt(i) - '0';
        }

        // 存储最终结果
        List<Integer> result = new ArrayList<>();

        // 从右向左遍历num2的每一位
        for (int i = num2.length() - 1; i >= 0; i--) {
            // 计算当前位需要移动的位数
            int move = num2.length() - 1 - i;
            List<Integer> temp = new ArrayList<>();
            // 添加前导零
            for (int j = 0; j < move; j++) {
                temp.add(0);
            }
            
            // 计算当前位与num1的乘积
            int s = 0;  // 当前位的和
            int c = 0;  // 进位
            for (int j = num1.length() - 1; j >= 0; j--) {
                s = m[j] * n[i] + c;
                c = s / 10;
                temp.add(s % 10);
            }
            // 处理最后的进位
            if (c > 0) {
                temp.add(c);
            }

            // 将当前乘积加到结果中
            c = 0;
            List<Integer> res = new ArrayList<>();
            for (int j = 0; j < temp.size(); j++) {
                if (j < result.size()) {
                    s = result.get(j) + temp.get(j) + c;
                    c = s / 10;
                    res.add(s % 10);
                } else {
                    s = temp.get(j) + c;
                    c = s / 10;
                    res.add(s % 10);
                }
            }
            // 处理最后的进位
            if (c > 0) {
                res.add(c);
            }
            result = res;
        }

        // 将结果转换为字符串
        StringBuilder sb = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i));
        }
        
        // 去除前导零
        int k = 0;
        while (k < sb.length() && sb.charAt(k) == '0') {
            sb.deleteCharAt(k);
        }
        // 如果结果全为0，返回"0"
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
