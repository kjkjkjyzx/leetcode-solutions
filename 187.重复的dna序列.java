/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // 如果字符串长度小于10，直接返回空列表
        if (s.length() <= 10) {
            return new ArrayList<>();
        }

        String[] str = new String[s.length() - 9];// 因为substring(i,i+10)，所以需要-9
        for (int i = 0; i < str.length; i++) {
            str[i] = s.substring(i, i + 10);
        }

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < str.length; i++) {
            if (!set1.contains(str[i])) {
                set1.add(str[i]);
            } else {
                set2.add(str[i]);
            }
        }

        // 直接将HashSet转换为ArrayList
        return new ArrayList<>(set2);
    }

}

// @lc code=end
