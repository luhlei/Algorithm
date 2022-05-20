package LeetCode;

public class useStackFindMin {
        /** initialize your data structure here. */
        Node first;
        private class Node{
            int value;
            Node next;

            public Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }
        public useStackFindMin() {
            first=new Node(0,null);
        }

        public void push(int x) {
            if(first.next==null){
                first.next=new Node(x,null);
                first.value=x;
            }else{
                Node newNode=new Node(x,first.next);
                first.next=newNode;
                first.value=Math.min(first.value,x);
            }
        }

        public void pop() {
            first.next=first.next.next;
        }

        public int top() {
            Node old=first;
            int max=first.value;
            while(old.next!=null){
                max = Math.max(old.value, old.next.value);
                old=old.next;
            }
            return max;
        }

        public int min() {
            return first.value;
        }

    public static void main(String[] args) {
        useStackFindMin min = new useStackFindMin();
        min.push(2);
        min.push(0);
        min.push(6);
        min.push(-5);

        System.out.println(min.min());
        min.pop();
        System.out.println(min.top());
        System.out.println(min.min());
    }
}
