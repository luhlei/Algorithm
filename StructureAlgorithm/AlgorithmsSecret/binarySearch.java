package AlgorithmsSecret;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 左边界的二分查找
 */
public class binarySearch {
    public static int leftBound(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;//可防止整型溢出
            int cmp=Integer.compare(nums[mid],target);
            if (cmp==0) right=mid-1;//收缩右侧边界，而且因为数组是有序的，如果没有target，那么意味着nums剩下的元素都比target小,然后left=mid+1一直循环，直到不符合left<right;
            else if (cmp>0) right=mid-1;
            else left=mid+1;
        }
        if (left>nums.length-1||nums[left]!=target) return -1;
        return left;
    }
    /*
    右边界的二分查找
     */
    public static int rightBound(int[] nums,int target){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            int cmp=Integer.compare(nums[mid],target);
            if (cmp==0) left=mid+1;//收缩左侧边界，而且因为数组是有序的，如果没有target，那么意味着nums剩下的元素都比target大，然后right=mid-1一直循环，直到不符合left<right;
            else if (cmp>0) right=mid-1;
            else left=mid+1;
        }
        if (right<0||nums[right]!=target) return -1;
        return right;
    }

    /**
     * 测试左右边界二分查找
     */
    @Test
    public void test(){
        int[] nums={1,2,2,2,3,5,6,8,9};
        int target=2;
        System.out.println(leftBound(nums, target));
        System.out.println(rightBound(nums, target));
    }

    /**
     * 田忌赛马、打牌，最优策略
     * @param nums1 田忌的马
     * @param nums2 齐王的马
     * @return 田忌的马的出场顺序
     */
    public int[] advantageCount(int[] nums1,int[] nums2){
        if (nums1.length!=nums2.length) return null;
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] pair1,int[] pair2)-> pair2[1]-pair1[1]);
        for (int i = 0; i < nums2.length; i++) {
            queue.add(new int[]{i,nums2[i]});
        }
        int left=0,right=nums1.length-1;
        int[] res=new int[nums1.length];
        while(!queue.isEmpty()){
            int[] poll=queue.poll();
            int i=poll[0];
            if (nums1[right]>poll[1]){
                res[i]=nums1[right];
                right--;
            }else{
                res[i]=nums1[left];
                left++;
            }
        }
        return res;
    }
}

