package Structure;

import offer.DoubleStack;
import org.junit.Test;

import java.util.ArrayList;


public class test {
    public static void main(String[] args) throws Exception {

        /*
        双向链表已通过测试，很容易出错，记得常看
         */
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(10);
        linkedList.add(3);
        linkedList.add(1,5);
        linkedList.add(9);
        linkedList.add(1);
        linkedList.remove(1);
        ArrayList<Integer> printf = linkedList.printf();
        System.out.println(printf);

        /**
         * 用单向链表，双端口来实现队列，已通过验证，较容易出错
         */
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(4);
        queue.add(6);
        queue.add(2);
        queue.add(10);
        queue.delete();
        ArrayList<Integer> arrayList = queue.print();
        System.out.println(arrayList.toString());

        /**
         * 用两个栈来实现队列，已通过验证
         */
        DoubleStack Myqueue = new DoubleStack();
        Myqueue.push(1);
        Myqueue.push(5);
        Myqueue.push(3);
        Myqueue.push(9);
        Myqueue.push(2);
        Myqueue.push(0);
        int i1 = Myqueue.pop();
        Myqueue.push(11);
        int i2 = Myqueue.pop();
        System.out.println(i2);


        /**
         * 动态数组已经通过验证
         */
        MyArrayList<Integer> integers = new MyArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(6);
        integers.add(9);
        integers.add(0,0);
        System.out.println(integers);
    }

    /**
     * 二叉树已经通过验证
     */
    @Test
    public void test1() {
        BinaryTreeSearch<Integer> treeSearch = new BinaryTreeSearch<>();
        treeSearch.insert(10);
        treeSearch.insert(1);
        treeSearch.insert(17);
        treeSearch.insert(13);
        treeSearch.remove(10);
        treeSearch.insert(20);
        treeSearch.insert(15);
        treeSearch.insert(16);
        treeSearch.insert(10);
        treeSearch.remove(15);

        treeSearch.printTree();
    }

    /**
     * AVL树，已通过测试
     */
    @Test
    public void test2(){
        AVL<Integer> avl = new AVL<>();
        avl.insert(10);
        avl.insert(1);
        avl.insert(14);
        avl.insert(6);
        avl.insert(9);
        avl.insert(7);
        avl.insert(20);
        avl.insert(3);
        avl.insert(2);
        avl.remove(10);
        avl.remove(14);
        avl.printf();
    }
}