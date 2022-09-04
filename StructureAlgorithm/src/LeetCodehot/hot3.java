package LeetCodehot;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class hot3 {
    public int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0) return 0;
        char[] chars = s.toCharArray();
        HashSet<Character> set=new HashSet<>();
        int n = chars.length;
        int dp_0=0;//注意初始值们需要取0；
        int res=0;
        for (int i = 0; i <n ; i++) {
            for (int j = i; j < n; j++) {
                if (!set.contains(chars[j])){
                    set.add(chars[j]);
                    dp_0++;
                    res=Math.max(res,dp_0);
                }else {
                    set.clear();
                    set.add(chars[j]);
                    dp_0=1;
                }
                if (j==n-1){
                    set.clear();//每循环一次，都需要清空
                    dp_0=0;
                }

            }
        }
        return res;
    }
    /*
    滑动窗口解法
     */
    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        HashSet<Character> set=new HashSet<>();
        int left=0,right=0,res=0;
        while (right<=n-1){
            if (!set.contains(chars[right])){
                set.add(chars[right]);
                right++;
                res=Math.max(res,set.size());
            }else{
                while(set.contains(chars[right])){
                    set.remove(chars[left]);
                    left++;
                }
                set.add(chars[right]);
                right++;
            }
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring2("dvdf"));
    }
}
