package Algorithms_fourth;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class Quit {
    public static void sort(int[] nums){
        shuffle(nums);
        sort(nums,0,nums.length-1);
    }
    public static void sort(int[] nums,int lo,int hi){
        if (lo>=hi) return;
        int p = partition(nums, lo, hi);
        sort(nums,lo,p-1);
        sort(nums,p+1,hi);
    }
    public static int partition(int[] nums,int lo,int hi){
        int p=nums[lo];
        int i=lo+1,j=hi;
        while(i<=j){
            while(i<hi&&nums[i]<p){
                i++;//找到比p大的数
            }
            while(j>lo&&nums[j]>p){
                j--;//找到比p小的数
            }
            if (i>=j) break;
            swap(nums,i,j);
        }
        swap(nums,lo,j);
        return j;
    }
    public static void shuffle(int[] nums){
        Random random = new Random();
        int N=nums.length;
        for (int i = 0; i < N; i++) {
            int j=random.nextInt(N-1);
            swap(nums,i,j);
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{3,8,54,2,4,56,8,90};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    @Test
    public void test(){
        int[] nums=new int[]{1,2,3,4,5};
        System.out.println(partition(nums, 0, 4));
        for (int num : nums) {
            System.out.println(num);
        }
    }
}