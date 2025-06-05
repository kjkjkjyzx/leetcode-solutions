/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start

import java.util.*;

class Solution {
    public int reverse(int x) {

        List<Integer> list = new ArrayList<>();
        int n = Math.abs(x);
        long result = 0;//如果n反转后大于int的最大值，则使用int时会出错，所以使用long类型；

        while(n > 0){
            list.add(n % 10);
            n /= 10;
        }
        int l = list.size();
        
        for(int i = 0; i < l; i++){

            if(list.get(i) == 0 && result == 0){
                result = 0;
            }else{
                result = result * 10 + list.get(i);
            }
        }

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)//记住这俩api；
            return 0;

        if(x < 0)
            result = -result;

        int r = (int)result;//强制转换；
        return r;
    }
}
// @lc code=end