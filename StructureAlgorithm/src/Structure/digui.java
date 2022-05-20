package Structure;

import org.junit.Test;

import java.util.*;

public class digui {
    int n;
    public int fix(int i){
        if (i<2){
            return 1;
        }
        n=i*fix(i-1);
        System.out.println(n);
        return n;
    }
    int fb(int i){
        int n;
        if (i==1||i==2){
            return 1;
            }
        n=fb(i-1)+fb(i-2);
        return n;
    }
    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }

    public static void main(String[] args) {
        digui digui = new digui();
        int fix = digui.fix(10);

//        int fb = digui.fb(10);
//        System.out.println(fb);
    }

    @Test
    public void test(){
        int i=1;
        int j=3;
        int n;
        n=i/j;
        System.out.println(n);
    }
}
