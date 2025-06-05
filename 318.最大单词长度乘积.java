/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
    /*public int maxProduct(String[] words) {
        int n = words.length;
        
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (judge(words[i], words[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public static boolean judge(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (char c : s1.toCharArray()) {
            set.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
        }
        return true;
    }*/


    public int maxProduct(String[] words) {
        int n = words.length;
        // 使用整数数组masks存储每个单词的位掩码表示
        int[] masks = new int[n];
        // 遍历每个单词，将其转换为位掩码
        for (int i = 0; i < n; i++) {
            int mask = 0;
            // 遍历单词中的每个字符
            for (char c : words[i].toCharArray()) {
                // 使用位运算将字符对应的位置设为1
                // 例如：'a' -> 1, 'b' -> 2, 'c' -> 4, ...
                mask = mask | (1 << (c - 'a'));// 将字符c的位掩码设置为1
            }
            masks[i] = mask;
        }
        int max = 0;
        // 双重循环比较每对单词
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 如果两个单词的位掩码按位与为0，说明没有相同字符
                if ((masks[i] & masks[j]) == 0) {
                    // 更新最大乘积
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }


    
}
// @lc code=end

