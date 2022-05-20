package AlgorithmsSecret.backTrack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class fullPermutation {
    private static List<List<Integer>> res=new LinkedList<>();
    public static List<List<Integer>> permute(int[] nums){
        LinkedList<Integer> track=new LinkedList<>();
        backTrack(nums,track);
        return res;
    }
    public static void backTrack(int[] nums,LinkedList<Integer> track){
        //触发结束条件
        if (track.size()==nums.length){
            res.add(new LinkedList<>(track));//要创建新的元素，否则会出现引用未消除，res内的track还会改变
            return;
        }
        for (int num : nums) {
            if (track.contains(num))
                continue;
            //做出选择
            track.add(num);
            //进入下一层决策，入栈
            backTrack(nums, track);
            //撤销选择
            track.removeLast();

            //选择出栈
        }
    }
    @Test
    public void test(){
        int[] nums=new int[]{2,5,6,8};
        List<List<Integer>> list = permute(nums);
        System.out.println(list);
    }

    public static void main(String[] args) {
        System.out.println("GitHub");
    }
}
