package AlgorithmsSecret;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class MonotonousStack {
    /**
     * 单调栈，数组中该元素之后最大元素，如果没有则为-1；
     * @param nums
     * @return
     */
    public ArrayList<Integer> nextGreaterElement(ArrayList<Integer> nums){
        ArrayList<Integer> res=new ArrayList<>(nums.size());
        Stack<Integer> s=new Stack<>();
        for (int i = nums.size()-1; i >=0; i--) {
            while(!s.isEmpty()&&s.peek()<=nums.get(i)){
                s.pop();
            }
            res.add(i,s.isEmpty()?-1:s.peek());
            s.push(nums.get(i));
        }
        return res;
    }
}
class MonotonousQueue{
    LinkedList<Integer> queue=new LinkedList<>();
    public void push(int n){
        if (!queue.isEmpty()&&queue.getLast()<n){
            queue.pollLast();
        }

        queue.addLast(n);
    }
    public int Max(){
        return queue.getFirst();
    }
    public void poll(int n){
        if (queue.getFirst()==n) queue.pollFirst();
    }
}
