package LeetCode;

public class searchLinkedList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node one=head;
        Node last=new Node(head.next.val);
        Node copy=new Node(head.val);
        copy.next=last;
        Node two=copy;
        head=head.next;
        while(head.next!=null){
            head=head.next;
            last.next=new Node(head.val);
            last=last.next;
        }
        while(one!=null){
            if(one.random==null){
                two.random=null;
            }else{
                two.random=get(one.random.val,copy);
                two=two.next;
                one=one.next;
            }
        }
        return copy;

    }
    public Node get(int val,Node head){
        while(head!=null){
            if(val==head.val){
                return head;
            }else{
                head=head.next;
            }
        }
        return null;
    }
    //正确答案
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return head;
            }
            // 完成链表节点的复制
            Node cur = head;
            while (cur != null) {
                Node copyNode = new Node(cur.val);
                copyNode.next = cur.next;
                cur.next = copyNode;
                cur = cur.next.next;
            }

            // 完成链表复制节点的随机指针复制
            cur = head;
            while (cur != null) {
                if (cur.random != null) { // 注意判断原来的节点有没有random指针
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }

            // 将链表一分为二
            Node copyHead = head.next;
            cur = head;
            Node curCopy = head.next;
            while (cur != null) {
                cur.next = cur.next.next;
                cur = cur.next;
                if (curCopy.next != null) {
                    curCopy.next = curCopy.next.next;
                    curCopy = curCopy.next;
                }
            }
            return copyHead;
        }
    }
}
