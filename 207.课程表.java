/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start

import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];  // 入度数组
        List<Integer> list = new ArrayList<>(); // 保存所有课程
        // 初始化入度数组
        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;
        }
        // 初始化list
        for (int i = 0; i < numCourses; i++) {
            list.add(i);
        }

        List<Integer> temp = new ArrayList<>(); // 保存入度为0的课程
        while (list.size() > 0) {
            // 遍历入度数组，找到入度为0的课程
            for (int i = 0; i < numCourses; i++) {
                if (indegrees[i] == 0) {
                    temp.add(i);
                    indegrees[i] = -1;
                }
            }
            // 如果没有入度为0的课程，说明有环，返回false
            if (temp.size() == 0) {
                return false;
            }
            // 遍历入度为0的课程，将其指向的课程的入度减1
            for (int i = 0; i < temp.size(); i++) {
                for (int j = 0; j < prerequisites.length; j++) {
                    if (prerequisites[j][1] == temp.get(i)) {
                        indegrees[prerequisites[j][0]]--;
                    }
                }
            }
            // 将入度为0的课程从list中删除
            list.removeAll(temp);
            temp.clear();
        }
        return true;
    }
}
// @lc code=end
