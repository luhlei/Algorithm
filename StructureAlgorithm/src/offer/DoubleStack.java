package offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class DoubleStack {
    private Stack<Integer> stack1=new Stack<>();
    private Stack<Integer> stack2=new Stack<>();

    public DoubleStack() {
    }

    /**
     * 入栈
     * 时间复杂度：O(1)，空间复杂度：O(n)
     * @param node 要插入的元素
     */
    public void push(int node){
        stack1.push(node);
    }

    /**
     *
     * @return 返回出列的元素
     * @throws Exception 栈为空
     */
    public int pop() throws Exception {
        if (stack1.isEmpty()&&stack2.isEmpty()){
            throw new Exception("栈为空");
        }
        if (stack2.isEmpty()){//注意这个条件，得先进行stack2的清空
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
