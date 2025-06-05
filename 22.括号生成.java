/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, n, sb, list);
        return list;
    }


    public static void dfs(int num1, int num2, StringBuilder sb, List<String> list) {
        if (num1 == 0 && num2 == 0) {
            if (judge(sb)) {
                list.add(sb.toString());
            }
        }
        if (num1 > 0) {
            sb.append("(");
            dfs(num1 - 1, num2, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (num2 > 0) {
            sb.append(")");
            dfs(num1, num2 - 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static boolean judge (StringBuilder sb) {
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            flag = false;
        }
        return flag;
    }
}
// @lc code=end

