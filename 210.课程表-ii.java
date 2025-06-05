/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses]; //入度数组
        List<Integer> list = new ArrayList<>(); //所有课程
        //初始化入度数组
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
        }
        //初始化所有课程
        for (int i = 0; i < numCourses; i++) {
            list.add(i);
        }

        List<Integer> temp = new ArrayList<>(); //保存入度为0的课程
        List<Integer> res = new ArrayList<>(); //保存结果
        while (list.size() > 0) {
            //遍历入度数组，找到入度为0的课程
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    res.add(i);
                    temp.add(i);
                    indegree[i] = -1;
                }
            }
            //如果没有入度为0的课程，说明有环，返回空数组
            if (temp.size() == 0) {
                return new int[0];
            }
            //遍历入度为0的课程，将其指向的课程的入度减1
            for (int i = 0; i < temp.size(); i++) {
                for (int j = 0; j < prerequisites.length; j++) {
                    if (prerequisites[j][1] == temp.get(i)) {
                        indegree[prerequisites[j][0]]--;
                    }
                }
            }
            //将入度为0的课程从list中移除
            list.removeAll(temp);
            //清空temp
            temp.clear();
        }
        //将结果转换为数组
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
// @lc code=end

