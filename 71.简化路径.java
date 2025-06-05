/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
import java.util.*;
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        int n = paths.length;
        for (int i = 0; i < n; i ++) {
            if (paths[i].equals(".")) {
                continue;
            } else if (paths[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (paths[i].equals("")) {
                continue;
            } else {
                stack.push(paths[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        for (String s : stack) {
            res.append("/" + s);
        }
        return res.toString();
    }
}
// @lc code=end

