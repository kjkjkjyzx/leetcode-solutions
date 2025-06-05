/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int n = intervals.length;
        for (int i = 0; i < n - 1; i++) {
            if (intervals[i + 1][0] <= intervals[i][1]) {
                intervals[i + 1][0] = Math.min(intervals[i + 1][0], intervals[i][0]);
                intervals[i + 1][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
                intervals[i][0] = -1;
                intervals[i][1] = -1;
            }
        }
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] != -1) {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}
// @lc code=end
