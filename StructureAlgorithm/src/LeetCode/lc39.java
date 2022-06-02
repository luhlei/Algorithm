package LeetCode;

import org.junit.Test;

public class lc39 {
    public int majorityElement(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int i;
        for (i = 0; i < nums.length; i++) {
            int n = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    n++;
                    if (n > nums.length / 2) {
                        return nums[i];
                    }
                }
            }
        }
        return nums[i];
    }

    @Test
    public void test() {
        int[] a = new int[]{1};
        System.out.println(majorityElement(a));
    }
}
