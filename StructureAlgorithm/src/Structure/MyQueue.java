package Structure;

import java.util.ArrayList;

public class MyQueue<T> {
    private Node first;
    private Node last;
    private int N = 0;

    /*
    注意：外部类可以访问内部类所有权限的字段，所以一般来说，内部类声明为private之后，就不用再特地声明字段的权限了
     */
    private class Node {
        private T item;
        private Node next;
    }

    public MyQueue() {
        create();
    }

    private void create() { //注意：建立联系
        first=new Node();
        last=new Node();
        first.next=last;
    }

    public boolean isEmpty() {
        return N==0;// 错误：return first==null，first已经应用对象，那么不为null；
    }

    public int size() {
        return N;
    }

    public void add(T a) {
        Node oldLast = last;
        last = new Node();
        last.item = a;
        if (isEmpty()){//注意：一开始错误的地方在，isEmpty()判断错误
            first = last;
        }
        else
            oldLast.next = last;
        N++;
    }

    public void delete() {
        first = first.next;
        N--;
    }

    public ArrayList<T> print() {
        ArrayList<T> arrayList = new ArrayList<>();
        Node p = first;
        for (int i = 0; i < N; i++) {
            arrayList.add(p.item);
            p = p.next;
        }
        return arrayList;
    }
}
