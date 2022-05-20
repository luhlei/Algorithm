package niuKe;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class meiTuan2 {
    public static int count(int n,int[] nums){
        int sum=0;
        int index=0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(nums[i]);
        }
        while(!queue.isEmpty()){
            int i = queue.poll();
            index++;
            sum+=Math.abs(index-i);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums);
        System.out.println(count(n,nums));
    }
}
