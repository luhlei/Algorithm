package AlgorithmsSecret.dynamicPlanning;

import java.util.Arrays;
import java.util.Comparator;

public class doubleMax {
    int maxEnvelopes(int[][] envelopes){
        int length = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]==b[0]?b[1]-a[1]:a[0]-b[0];//默认正序排序，如果要倒叙排序，则要相反相减
            }
        });
        int[] height=new int[length];
        for (int i = 0; i < length; i++) {
            height[i]=envelopes[i][1];
        }
        int[] dp=new int[height.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                if (height[i]>height[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res=0;
        for (int i = 0; i < height.length; i++) {
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
