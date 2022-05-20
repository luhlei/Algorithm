package Algorithms_fourth;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class searchNumber {
    public static int search(int[] nums, int target) {
        if (nums.length==0){
            return 0;
        }
        int j=0;
        int i=rank(nums,target,0,nums.length-1);
        for(int i1=i;i1>=0;i1--){
            if(nums[i1]==target){
                j++;
            }else break;
        }
        for(int i2=i+1;i2<nums.length;i2++){//避免重复，所以要 i2+1
            if(nums[i2]==target){
                j++;
            }else return j;
        }
        return j;
    }
    public static int rank(int[] nums,int target,int lo,int hi){
        if(target<nums[lo]||target>nums[hi]){
            return 0;
        }
        if(lo>=hi) return lo;
        int mid=lo+(hi-lo)/2;
        int cmp=Integer.compare(target,nums[mid]);
        if(cmp<0){
            return rank(nums,target,lo,mid-1);//为了避免陷入死循环，mid-1
        }else if(cmp>0){
            return rank(nums,target,mid+1,hi);//为了避免陷入死循环，mid+1
        }else return mid;
    }

    public int findRepeatNumber(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public int missingNumber(int[] nums) {
        /*
        if(nums==null||nums.length==0){
            return -1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return nums.length;
         */

        /*if(nums==null||nums.length==0){
            return -1;
        }
        if(nums.length==1){
            if(nums[0]==0){
                return 1;
            }
        }
        if(nums[0]!=0){
            return 0;
        }
        int j;
        for(int i=0;i<nums.length-1;i++){
            j=i+1;
            if((nums[j]-nums[i])>1){
                return nums[i]+1;
            }
        }
        return nums.length;*/

        return rank(nums,0,nums.length-1);
    }
    public int rank(int[] nums,int lo,int hi){
        if(nums==null||nums.length==0){
            return -1;
        }
        if(nums[lo]!=lo){//基准条件一：
            return lo;
        }
        if(nums[hi]==hi){//基准条件二：
            return hi+1;
        }
        int mid=lo+(hi-lo)/2;
        int cmp=Integer.compare(mid,nums[mid]);
        if(cmp<0){
            return rank(nums,lo,mid-1);
        }
        else if(cmp==0){
            return rank(nums,mid+1,hi);
        }else return mid;
    }

    public static void main(String[] args) {
        int[] a=new int[]{2, 3, 1, 0, 2, 5, 3};
        searchNumber number = new searchNumber();
        System.out.println(number.findRepeatNumber(a));
    }
@Test
    public void test(){
        int[] a=new int[]{0,2,3};
        System.out.println(missingNumber(a));
}
}