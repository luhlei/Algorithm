package AlgorithmsSecret;

import java.util.HashMap;

public class doublePointer {
    /**
     * 作用：原地修改数组
     * @param nums 原数组
     * @param val 要删除的值
     * @return 修改后数组的长度，但其实数组的隐式长度依旧为原长度
     */
    public static int removeElement(int[] nums,int val){
        int slow=0,fast=0;
        while(fast<nums.length){
            if (nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
    public static int[] twoSum(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<right){
            int sum=nums[right]-nums[left];
            if (sum==target) return new int[]{left+1,right+1};
            else if (sum<target) left++;
            else right--;
        }
        return new int[]{-1,-1};
    }
    public static void reverseString(char[] s){
        int left=0,right=s.length-1;
        while(left<right){
            char tmp=s[left];
            s[left]=s[right];
            s[right]=tmp;
            left++;
            right--;
        }
    }
    public static boolean isPalindrome(String s){
        int left=0,right=s.length()-1;
        while(left<right){
            if (s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static String Palindrome(String s,int l,int r){
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }
    /*
    核心问题：从中心向两端扩散的双指针
    细节：如果回文串的长度为奇数，则它有一个中心字符；如果回文串的长度为偶数，则它有两个中心字符
     */
    public static String longestPalindrome(String s){
        String res="";
        for (int i = 0; i < s.length(); i++) {
            String s1 = Palindrome(s, i, i);//字符串长度为奇数
            String s2 = Palindrome(s, i, i + 1);//字符串为偶数
            res=res.length()>s1.length()?res:s1;
            res=res.length()>s2.length()?res:s2;
        }
        return res;
    }

    /**
     * 双指针：滑动窗口，难点在于很多细节问题，需要背模板
     * @param s 原字符串
     * @param t 搜索字符串
     * @return 最小字串
     */
    public static String minWindow(String s,String t){
        if (s==null||s.length()==0||t.length()==0) return "";
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character,Integer> window=new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
        int start=0,len=Integer.MAX_VALUE;
        int left=0,right=0;//区间是左开右闭
        int valid=0;//用于判断字符个数和需匹配的数量是否相等
        while(right<s.length()){
            //取到需要右移进入窗口的元素
            char c=s.charAt(right);
            //右移窗口
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            while (valid==need.size()){
                if (right-left<len){
                    start=left;
                    len=right-left;
                }
                char a=s.charAt(left);
                left++;
                if (need.containsKey(a)){
                    if (need.get(a).equals(window.get(a))){
                        window.put(a,window.getOrDefault(a,0)-1);
                        valid--;
                    }
                }
            }
        }
        return s.substring(start,start+len);
    }
}
