package AlgorithmsSecret.dynamicPlanning;

import org.junit.Test;


public class longestCommonSubsequence {
    public int longestSubsequence(String str1,String str2){
        int m=str1.length(),n=str2.length();
        if (m==0||n==0) return 0;
        //base case
        int[][] dp=new int[m+1][n+1];//赋值之后，将会初始化0
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                /*
                状态转移方程
                 */
                if (str1.charAt(i-1)==str2.charAt(j-1)){//注意String的脚标，不能越界
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    @Test
    public void test(){
        String s1="babcde";
        String s2="acze";
        System.out.println(longestSubsequence(s1, s2));
    }
}
