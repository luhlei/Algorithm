package LeetCode;

import java.util.Arrays;

public class lc40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] a=new int[k];
        for (int i = 0; i < k; i++) {
            a[i]=arr[i];
        }
        return a;
    }
}
