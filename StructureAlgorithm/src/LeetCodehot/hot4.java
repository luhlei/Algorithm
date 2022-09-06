package LeetCodehot;

import org.junit.Test;

public class hot4 {
    /*
    时间复杂度：O(m+n)
    空间复杂度：O(m+n)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a=new int[nums1.length+nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            a[i]=nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            a[i+nums1.length]=nums2[i];
        }
        merge(a,0,nums1.length-1,nums1.length+nums2.length-1);
        int mid=a.length%2;
        int res=a.length/2;
        if(mid==1) return a[res];
        else return ((double)a[res-1]+(double) a[res])/2;
    }
    public void merge(int[] a,int lo, int mid ,int hi){
        int i=lo,j=mid+1;
        int n=a.length;
        int[] copy=new int[n];
        for(int k=0;k<n;k++){
            copy[k]=a[k];
        }
        for(int k=0;k<n;k++){
            if(i>mid) a[k]=copy[j++];
            else if(j>hi) a[k]=copy[i++];
            else if(copy[i]<copy[j]) a[k]=copy[i++];
            else a[k]=copy[j++];
        }
    }
    /*
    时间复杂度为：O(log(m+n)
    空间复杂度为：O(1)
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2){
        int m=nums1.length,n=nums2.length;
        int len=(m+n)/2;
        int right=-1,left=-1;
        int Aright=0,Bright=0;
        for (int i = 0; i <= len; i++) {
            left=right;//上一次的值
            if (Aright<m&&(Bright>=n||nums1[Aright]<nums2[Bright])){//注意这一步的条件
                right=nums1[Aright];
                Aright++;
            }else {
                right=nums2[Bright];
                Bright++;
            }
        }
        int mid=(m+n)%2;
        if (mid==1) return right;
        else return ((double)right+(double)left)/2;
    }

    @Test
    public void test(){
        System.out.println(findMedianSortedArrays2(new int[]{1, 2}, new int[]{3,4}));
    }
}
