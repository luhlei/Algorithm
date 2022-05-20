package offer;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表，从尾到头打印链表每个节点的值
 */
public class PrintListReversing {
    /**
     * 解法一：利用栈输出
     * @param LinkList
     * @return
     */
    public static ArrayList<Integer> printList(LinkedList<Integer> LinkList){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int size = LinkList.size();
        for (int i = 0; i <size ; i++) {
            Integer integer = LinkList.pop();
            stack.push(integer);
        }
        while(!stack.empty())
            arrayList.add(stack.pop());
        return arrayList;
    }
    
}
