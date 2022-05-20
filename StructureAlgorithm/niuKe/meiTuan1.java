package niuKe;


import java.util.Arrays;
import java.util.Scanner;

public class meiTuan1 {
    public static int findBound(int n,int x,int y,int[] nums){
        if (n<2*x||n>2*y) return -1;
        int[] grade=new int[1000];
        for (int i = 0; i < n; i++) {
            grade[nums[i]-1]++;
        }
        int sum=0;
        for (int i = 0; i < 1000; i++) {
            sum+=grade[i];
            if (sum>=x&&sum<=y){
                if (n-sum<=y&&n-sum>=x) return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums);
        System.out.println(findBound(n, x, y, nums));
    }
}
