package Structure;

import java.util.*;

//注：采取头尾节点的形式，两个节点均不存数据
public class MyLinkedList<T> implements Iterable<T> {
    private int size;
    private int modCount = 0;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    private static class Node<T> {
        public Node pre;
        public T data;
        public Node next;

        public Node(Node pre, T data, Node next) {
            this.pre = pre;
            this.data = data;
            this.next = next;
        }
    }

    public MyLinkedList() {
        doClear();
    }

    private void doClear() {
        beginMarker = new Node<>(null, null, null);//注：注意创建顺序，beginMarker创建时，endMarker还未创建，所以其后指针，不能填写endMarker
        endMarker = new Node<>(beginMarker, null, null);
        beginMarker.next=endMarker;
        size = 0;
        modCount++;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T a) {
        add(size+1,a);
    }

    public boolean add(int idx, T a) {
        if (isEmpty()){
            Node<T> p = new Node<>(beginMarker, a, endMarker);
            beginMarker.next=p;
            endMarker.pre=p;
            size++;
            modCount++;
            return true;
        }
        Node<T> p = get(idx);
        Node<T> newNode = new Node<>(p.pre, a, p);
        p.pre.next=newNode;
        p.pre=newNode;
        size++;
        modCount++;
        return true;
    }

    public boolean remove(int idx) {
        Node<T> node = get(idx);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
        modCount++;
        return true;
    }

    public Node<T> get(int idx) {
        Node<T> p;
        if (idx < 1 || idx > size+1) {
            throw new IndexOutOfBoundsException();
        }
        if (idx <= size / 2) {
            p = beginMarker.next;
            for (int i = 1; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size; i > idx; i--) {
                p = p.pre;
            }
        }
        return p;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int expectModCount=modCount;
        private Node p = beginMarker.next;
        private boolean okToRemove=false;

        @Override
        public boolean hasNext() {
            return p!=endMarker;
        }

        /**
         * 理论上迭代器的位置，是抽象的，next返回的是当前指向的节点的数据，hasNext判断的是当前节点是否是尾节点！
         * @return
         */
        @Override
        public T next() {
            if (expectModCount!=modCount){
                throw new ConcurrentModificationException();
            }
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            T data = (T) p.data;
            okToRemove=true;
            p = p.next;
            return data;
        }

        @Override
        public void remove() {
            if (expectModCount!=modCount)
                throw new ConcurrentModificationException();
            if (!okToRemove){
                throw new IllegalStateException();
            }
            Node node=p.pre;
            node.pre.next=node.next;
            node.next.pre=node.pre;
            okToRemove=false;
        }
        public MyIterator() {
        }
    }
    public ArrayList<T> printf() {
        ArrayList<T> arrayList = new ArrayList<>();
        MyIterator myIterator = new MyIterator();
        while (myIterator.hasNext()){
            arrayList.add(myIterator.next());
        }
        return arrayList;
    }
}
