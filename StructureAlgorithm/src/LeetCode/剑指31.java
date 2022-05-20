package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class 剑指31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack=new ArrayDeque<>();
        int j=0;
        for (int value : pushed) {
            stack.push(value);
            while(j<popped.length&& !stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return j==popped.length;
    }
}