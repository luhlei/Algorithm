package AlgorithmsSecret;

/**
 * 前缀和数组：
 * 应用场景：原始数组不会被修改的情况下，频繁查询某个区间的累加和。
 */
public class preSum {
    private int[] preSum;
    public preSum(int[] nums){
        preSum=new int[nums.length+1];
        for (int i = 1; i < nums.length; i++) {
            preSum[i]=preSum[i-1]+nums[i-1];
        }
    }
    public int sumRange(int left,int right){
        return preSum[right+1]-preSum[left];//注意：角标问题
    }
}
