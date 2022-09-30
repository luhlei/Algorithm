package LeetCodehot;

import org.junit.Test;

public class hot9 {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        int tol=0;
        int b=x;
        while(x!=0){
            int a=x%10;
            tol=tol*10+a;
            x=x/10;
        }
        return tol==b;
    }
    @Test
    public void test(){
        System.out.println(isPalindrome(121));
    }
}
