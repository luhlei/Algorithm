package LeetCodehot;

import org.junit.Test;

public class hot7 {
    StringBuffer numbers=new StringBuffer();
    public int reverse(int x) {
        int a;
        track(Math.abs(x));
        if (x>0){
            a=Integer.parseInt(numbers.toString());
        }else{
            a=-Integer.parseInt(numbers.toString());
        }
        return a<Math.pow(-2,31)||a>Math.pow(2,31)-1?0:a;
    }
    public void track(int x){
        numbers.append(x%10);
        if (x<10) return;
        track(x/10);
    }
//    public StringBuffer reverse(StringBuffer nums){
//        int n=nums.length();
//        int flag=n%2;//奇偶数
//        if (flag==1){
//            for (int i = 0; i <=n/2 ; i++) {
//                int j=n-1-i;
//                exchange(nums,i,j);
//            }
//        }else {
//            for (int i = 0; i <n/2 ; i++) {
//                int j=n-1-i;
//                exchange(nums,i,j);
//            }
//        }
//        return nums;
//    }
//    public void exchange(StringBuffer buffer,int i,int j){
//        char c=buffer.charAt(i);
//        buffer.setCharAt(i,buffer.charAt(j));
//        buffer.setCharAt(j,c);
//    }
    @Test
    public void test(){
        System.out.println(reverse(1534236469));
    }
}
