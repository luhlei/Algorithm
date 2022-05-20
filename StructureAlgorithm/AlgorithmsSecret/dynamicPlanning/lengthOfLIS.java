package AlgorithmsSecret.dynamicPlanning;

import java.util.Arrays;

public class lengthOfLIS {
    public static int length(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);//将数组中的元素初始化为1
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{10,9,2,5,3,7,101,18};
        System.out.println(length(nums));
    }
}
