package Structure;

public class AVL <AnyTye extends Comparable<?super AnyTye>>{
    private static class Node<AnyTye>{
        Node<AnyTye> left;
        AnyTye element;
        Node<AnyTye> right;
        int height;

        public Node(Node<AnyTye> left, AnyTye element, Node<AnyTye> right) {
            this.left = left;
            this.element = element;
            this.right = right;
            height=0;
        }

        public Node(AnyTye anyTye) {
            this(null,anyTye,null);
        }
    }
    private Node<AnyTye> root;
    public void insert(AnyTye x){
        root=insert(x,root);
    }
    public void  remove(AnyTye x){
        root=remove(x,root);
    }
    public AnyTye finMin(){
        return findMin(root).element;
    }
    public AnyTye finMx(){
        return findMax(root).element;
    }
    public void printf(){
        printf(root);
    }
    public int height(Node<AnyTye> t){
        return t==null?-1:t.height;
    }

    private Node<AnyTye> insert(AnyTye x,Node<AnyTye> t){
        if (t==null){
            return new Node<>(x);
        }
        int compareTo = x.compareTo(t.element);
        if (compareTo<0){
            t.left=insert(x,t.left);
        }
        else if (compareTo>0){
            t.right=insert(x,t.right);
        }
        return balance(t);
    }
    private Node<AnyTye> rotateWithLeftChild(Node<AnyTye> k2){
        Node<AnyTye> k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.left),k2.height)+1;
        return k1;
    }
    private Node<AnyTye> rotateWithRightChild(Node<AnyTye> k2){
        Node<AnyTye> k1=k2.right;
        k2.right=k1.left;
        k1.left=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.right),k2.height)+1;
        return k1;
    }
    private Node<AnyTye> doubleWithLeftChild(Node<AnyTye> k3){
        k3.left=rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
    private Node<AnyTye> doubleWithRightChild(Node<AnyTye> k3){
        k3.right=rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }
    //主要就是这一步，平衡二叉树
    private static final int ALLOWED_IMBALANCE=1;
    private Node<AnyTye> balance(Node<AnyTye> t){
        if (t==null)
            return null;
        if (height(t.left)-height(t.right)>ALLOWED_IMBALANCE){
            if (height(t.left.left)>=height(t.left.right))//注意这一步，判断了是单旋还是双旋，即插入的元素的大小，是否在其路径上方的两个节点之间！
                t=rotateWithLeftChild(t);
            else
                t=doubleWithLeftChild(t);
        }
        else if (height(t.right)-height(t.left)>ALLOWED_IMBALANCE){
            if (height(t.right.right)>=height(t.right.left))
                t=rotateWithRightChild(t);
            else
                t=doubleWithRightChild(t);
        }
        t.height=Math.max(height(t.left),height(t.right))+1;
        return t;
    }

    public Node<AnyTye> remove(AnyTye x,Node<AnyTye> t){
        if (t==null)
            return null;
        int compare = x.compareTo(t.element);
        if (compare<0){
            t.left=remove(x,t.left);
        }
        else if (compare>0){
            t.right=remove(x,t.right);
        }
        else if (t.left!=null&&t.right!=null){
            t.element=findMin(t.right).element;
            t.right=remove(t.element,t.right);//这两步效率比较低，直接可以找右枝最小点后，直接删除，并返回其值。
        }
        else
            t=(t.left!=null)?t.left:t.right;
        return balance(t);
    }
    public Node<AnyTye> findMin(Node<AnyTye> t){
        if (t==null)
            return null;
        if (t.left==null)
            return t;
        return findMin(t.left);
    }
    public Node<AnyTye> findMax(Node<AnyTye> t){
        if (t==null)
            return null;
        while(t.right!=null)
            t=t.right;
        return t;
    }
    private void printf(Node<AnyTye> t) {
        if (t != null) {
            printf(t.left);
            System.out.println(t.element);
            printf(t.right);
        }
    }
}