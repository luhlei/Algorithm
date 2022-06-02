package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

/*
    public int countDigitOne(int n) {
        int res=0;
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=i+1;
        }
        ArrayList<ArrayList<Integer>> a=new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            help(i,nums[i],a,0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j)==1) res++;
            }
        }
        return res;
    }
    public void help(int i,int n,ArrayList<ArrayList<Integer>> a,int j){
        if (n<10){
            a.get(i).add(n);
        }
        else if (n>=10){
            a.get(i).add(n%10);
            j++;
            help(i,n/10,a,j);
        }
    }
 */

/*
 public int countDigitOne(int n) {
        int res=0;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> a=new ArrayList<>();
            help(i+1,a,0);
            for (int j = 0; j < a.size(); j++) {
                if (a.get(j)==1) res++;
            }
        }
        return res;
    }
    public void help(int n,ArrayList<Integer> a,int j){
        if (n<10){
            a.add(n);
        }
        else if (n>=10){
            a.add(n%10);
            j++;
            help(n/10,a,j);
        }
    }
 */
/*
    int res=0;
    public int countDigitOne(int n) {
        for (int i = 0; i < n; i++) {
            help(i+1,0);
        }
        return res;
    }
    public void help(int n,int j){
        if (n<10){
            if (n==1){
                res++;
            }
        }
        else if (n>=10){
            if (n%10==1){
                res++;
            }
            j++;
            help(n/10,j);
        }
    }
 */
public class lc43 {
    int res=0;
    public int countDigitOne(int n) {
        for (int i = 0; i < n; i++) {
            help(i+1,0);
        }
        return res;
    }
    public void help(int n,int j){
        if (n<10){
            if (n==1){
                res++;
            }
        }
        else if (n>=10){
            if (n%10==1){
                res++;
            }
            j++;
            help(n/10,j);
        }
    }
    @Test
    public void test(){
        System.out.println(countDigitOne(12));
    }
}
