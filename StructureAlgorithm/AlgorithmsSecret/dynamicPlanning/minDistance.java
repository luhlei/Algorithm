package AlgorithmsSecret.dynamicPlanning;

import org.junit.Test;

import java.util.ArrayList;

public class minDistance {
    public int minDistance(String s1,String s2){
        int m=s1.length(),n=s2.length();
        int[][] dp=new int[m+1][n+1];//明确dp数组的含义
        //base case
        for (int i = 0; i <= m; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i]=i;
        }
        //状态转移方程
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];//当字符相同时，操作数不变
                }else{
                    dp[i][j]=min(dp[i][j-1]+1,dp[i-1][j]+1,dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }
    public int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
    String s1="radle";
    String s2="apple";
    int[][] memo=new int[s1.length()][s2.length()];
    ArrayList<Integer> record=new ArrayList<>();//用于记录已经计算的脚标
    public int dp(int i,int j){
        //base case
        if (record.contains(10*i+j)) return memo[i][j];
        if (i==-1) return j+1;
        if (j==-1) return i+1;
        if (s1.charAt(i)==s2.charAt(j)){
             memo[i][j]=dp(i-1,j-1);
             record.add(10*i+j);
        }else{
            memo[i][j]=min(dp(i,j-1)+1,//删除
                    dp(i-1,j)+1,//插入
                    dp(i-1,j-1)+1);//替换
            record.add(10*i+j);
        }
        return memo[i][j];
    }

    @Test
    public void test1(){
        System.out.println(dp(s1.length() - 1, s2.length() - 1));
    }

    @Test
    public void test(){
        String s1="radle";
        String s2="apple";
        System.out.println(minDistance(s1, s2));
    }
}
