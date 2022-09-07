package LeetCodehot;

import org.junit.Test;

public class hot5 {
    /**
     * @param s 字符
     * @return 最长回文子串
     * 采用动态规划：
     * 思维步骤：
     * 1、确定dp[i][j]代表的含义
     * 2、确认base case
     * 3、确定状态转移方程
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2 || s == null) return s;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0, len = 1;
        boolean[][] dp = new boolean[n][n];//dp[i][j]：表示子串Sj-Si是否是回文串
        //base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        //注意：在状态转移方程中，我们是从长度较短的字符串向长度较长的字符串进行转移的，因此一定要注意动态规划的循环顺序。
        //也就是说，我们也长度变化为基准
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n; i++) {
                int j = i + L - 1;
                if (j >= n)
                    break;
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (L == 2) dp[i][j] = true;
                    else {
//                        if (dp[i+1][j-1]) dp[i][j]=true;
//                        else dp[i][j]=dp[i+1][j-1];其实可以省略成一步
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && L > len) {
                    start = i;
                    len = L;
                }
            }
        }
        return s.substring(start, start + len);
    }

    /**
     * //还未完成！！！
     * @param s
     * @return
     *
     */
    public String longestPalindrome2(String s){
        if (s.length() < 2 || s == null) return s;
        if (s.length()==2) {
            if (s.charAt(0) == s.charAt(1)) return s;
            else return s.substring(0, 1);
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start=0,len=0;
        int res=n%2;
        if (res==1){
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (i-j<0||i+j>=n) break;
                    if (chars[i-j]==chars[i+j]){
                        if (len<2*j){
                            len=2*j+1;
                            start=i-j;
                        }
                    }else {
                        break;
                    }
                }
            }
        }else {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (i-j<0){

                    }
                }
            }
        }

        return s.substring(start,start+len);
    }
    @Test
    public void test(){
        System.out.println(longestPalindrome2("aaaa"));
    }
}