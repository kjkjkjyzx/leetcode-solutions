/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
/*class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
            }
        }
        int ll = l;
        for (int i = ll; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
            }
        }
    }
}*/


class Solution {
    public void sortColors(int[] nums) {
        // 数组长度
        int n = nums.length;
        // l指针指向0的右边界，r指针指向2的左边界
        int l = 0, r = n - 1;
        // 遍历数组，i作为当前处理的元素位置
        for (int i = 0; i <= r; ++i) {
            // 如果当前元素是2，就和r指针交换，并将r左移
            while (i <= r && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
                r--;
            }
            // 如果当前元素是0，就和l指针交换，并将l右移
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
            }
            // 如果当前元素是1，不需要处理，继续遍历
        }
    }
}
// @lc code=end
