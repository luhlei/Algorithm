package LeetCode;

import java.util.Arrays;

public class lc42 {
    public int maxSubArray(int[] nums) {
        int resMax=nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i]=Math.max(nums[i],nums[i-1]+nums[i]);
            resMax=Math.max(resMax,nums[i]);
        }
        return resMax;
    }
}
