/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        // 将字符串转换为小写并去除非字母数字字符
        String cleanStr = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        // 使用双指针判断是否回文
        int left = 0;
        int right = cleanStr.length() - 1;
        
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
// @lc code=end

