/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
import java.util.*;

class Solution {
    /**
     * 解码字符串，将形如 "3[a]2[bc]" 的字符串解码为 "aaabcbc"
     * 
     * @param s 待解码的字符串
     * @return 解码后的字符串
     */
    public String decodeString(String s) {
        // 存储重复次数的栈
        Stack<Integer> countStack = new Stack<>();
        // 存储待拼接结果的栈
        Stack<StringBuilder> resStack = new Stack<>();
        // 当前构建的结果
        StringBuilder res = new StringBuilder();
        // 当前处理的字符索引
        int idx = 0;
        
        while (idx < s.length()) {
            char c = s.charAt(idx);
            
            if (Character.isDigit(c)) {
                // 处理数字，可能是多位数
                int count = 0;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                // 将数字压入栈，用于后续重复字符串
                countStack.push(count);
            } else if (c == '[') {
                // 遇到左括号，保存当前结果并重新开始收集括号内的内容
                resStack.push(res);
                res = new StringBuilder();
                idx++;
            } else if (c == ']') {
                // 遇到右括号，处理重复逻辑
                // 取出之前的结果
                StringBuilder temp = resStack.pop();
                // 获取重复次数
                int repeatTimes = countStack.pop();
                // 将当前结果重复指定次数并追加到之前的结果中
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                // 更新当前结果
                res = temp;
                idx++;
            } else {
                // 处理普通字符，直接添加到结果中
                res.append(c);
                idx++;
            }
        }
        
        // 返回最终解码结果
        return res.toString();
    }
}
// @lc code=end
