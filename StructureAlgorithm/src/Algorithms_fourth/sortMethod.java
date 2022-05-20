package Algorithms_fourth;

import org.junit.Test;

import java.util.Arrays;

public class sortMethod {
    public static void sort(int[] nums){
        int N=nums.length;
        for (int i = 0; i < N; i++) {
            int min=i;
            for (int j = i+1; j <N ; j++) {
                if (nums[min]>nums[j]) min=j;
            }
            swap(nums,i,min);
        }
    }
    public static void sort1(int[] nums){
        int N=nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j >0&& nums[j]<nums[j-1]; j--) {//i的作用只是用来控制边界
                swap(nums,j,j-1);
            }
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    @Test
    public void test(){
        int[] nums=new int[]{2,5,6,3,9};
        int[] nums1=new int[]{2,5,6,3,9};
        sort(nums);
        sort1(nums1);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums1));
    }
}
