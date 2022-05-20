package LeetCode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class zhengze {
    private String s;
    private String p;

    public boolean isMatch(String s, String p) {
        if (".*".equals(p) || "".equals(s) && "".equals(p)) return true;
        this.s = s;
        this.p = p;

        /**
         * 思路：递归
         * 对应位置比较是否匹配，碰到s*这种需要for循环递归匹配，相当于dfs.
         */
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        //情况1：递归出口1，规则末尾，表达式未末尾，返回false
        if (j >= p.length() && i < s.length()) {
            return false;
        }
        //情况2：递归出口2，规则末尾，表达式末尾，返回true
        if (j >= p.length() && i >= s.length()) {
            return true;
        }
        //情况3：递归出口3，规则未末尾，表达式末尾，此时的规则必须是带*号的
        if (j < p.length() && i >= s.length()) {
            for (int n = j; n < p.length(); ) {
                if (n + 1 >= p.length() || p.charAt(n + 1) != '*')
                    return false;
                n+=2;//很关键
            }
            return true;
        }
        //情况4：正式递归，规则未末尾，表达式未末尾，此时要根据是否有’*‘来for循环递归，或者无’*‘的简单递归
        if (j + 1 < p.length()) {
            char ch = p.charAt(j + 1);
            if (ch != '*') {
                //点或字符的匹配
                char ch1 = s.charAt(i);
                char ch2 = p.charAt(j);
                if (ch2 == '.' || ch1 == ch2)
                    return dfs(i + 1, j + 1);
                else return false;
            } else {
                for (int n = -1; n < s.length() - i; n++) {
                    boolean flag = false;
                    //不用比
                    if (n == -1) {
                        flag = dfs(i, j + 2);
                    } else if (p.charAt(j) == '.' || s.charAt(i + n) == p.charAt(j)) {
                        //比较成功，同时进位
                        flag = dfs(i + n + 1, j + 2);
                    }else{
                        return false;
                    }
                    //如果成功就return，没必要循环了。
                    if (flag)
                        return true;
                }
                //带’*‘的能把所有都匹配了，即s中后面的字符都一样。但是字符规则还需字符去匹配，根据出口返回的是false。
                return false;
            }
        }
        //j+1越界，此时看i和j是否相等就可以了
        else if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
            return dfs(i + 1, j + 1);
            //j又是最后一位，i又不匹配，所以返回false
        else return false;
    }
    public int[] exchange1(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]%2==1){
                        int old=nums[i];
                        nums[i]=nums[j];
                        nums[j]=old;
                        break;
                    }
                }
            }
        }
        return nums;
    }
    public int[] exchange(int[] nums) {
        ArrayList<Integer> odd=new ArrayList<>();
        ArrayList<Integer> even=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                odd.add(nums[i]);
            }else{
                even.add(nums[i]);
            }
        }
        odd.addAll(even);
        return nums;
    }
     public static class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
         }
     }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        while(l1!=null){
            queue.add(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            queue.add(l2.val);
            l2=l2.next;
        }
        ListNode l3=new ListNode(0);
        ListNode l4=l3;
        ListNode l5 = null;
        while(queue.size()!=0){
            l4.val=queue.poll();
            l4.next=new ListNode(0);
            l5=l4;
            l4=l4.next;
        }
        l5.next=null;
        return l3;
    }
}
