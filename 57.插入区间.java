/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
import java.util.*;
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
       int n = intervals.length;
       int[][] res = new int[n+1][2];
       for (int i = 0; i < n; i ++) {
           res[i][0] = intervals[i][0];
           res[i][1] = intervals[i][1];
       }
       res[n][0] = newInterval[0];
       res[n][1] = newInterval[1];
       Arrays.sort(res, (o1,o2)->o1[0]-o2[0]);
       for (int i = 0; i < n; i ++) {
        if (res[i + 1][0] <= res[i][1]) {
            res[i + 1][0] = Math.min(res[i + 1][0], res[i][0]);
            res[i + 1][1] = Math.max(res[i + 1][1], res[i][1]);
            res[i][0] = -1;
            res[i][1] = -1;
        }
       }
       List<int[]> list = new ArrayList<>();
       for (int i = 0; i < n + 1; i ++) {
            if (res[i][0] != -1) {
                list.add(res[i]);
            }
       }
       return list.toArray(new int[list.size()][]);
    }
}
// @lc code=end

