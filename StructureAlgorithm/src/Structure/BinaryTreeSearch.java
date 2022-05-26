package Structure;


/**
 * 输入二叉树的前序遍历和中序遍历结果,重建该二叉树。
 */

public class BinaryTreeSearch <AnyType extends Comparable<? super AnyType>>{   //对参数类型进行了限制
    private static class BinaryNode<AnyType> {
        BinaryNode<AnyType> left;
        AnyType element;
        BinaryNode<AnyType> right;

        public BinaryNode(AnyType element) {
            this(null, element, null);
        }

        public BinaryNode(BinaryNode<AnyType> left, AnyType element, BinaryNode<AnyType> right) {
            this.left = left;
            this.element = element;
            this.right = right;
        }
    }

    private BinaryNode<AnyType> root;

    public BinaryTreeSearch() {
        this.root = null;
    }
    public void makeEmpty(){
        root=null;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public boolean contains(AnyType x){
        return contains(x,root);
    }
    public AnyType findMin(){
        return findMin(root).element;
    }
    public AnyType findMax(){
        return findMax(root).element;
    }
    public void  insert(AnyType x){
        root=insert(x,root);
    }
    public void remove(AnyType x){
        root=remove(x,root);
    }
    public void printTree(){
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }
    public boolean contains(AnyType x,BinaryNode<AnyType> t) {
        if (t == null)
            return false;
        int i = x.compareTo(t.element);
        if (i < 0) {
            return contains(x, t.left);
        } else if (i > 0) {
            return contains(x, t.right);
        } else
            return true;
    }
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
        if (t==null)
            return null;
        if (t.left==null)
            return t;
        return findMin(t.left);
    }
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
        if (t==null)
            return null;
        while(t.right!=null)
            t=t.right;
        return t;
    }
    private BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t){
        if (t==null) {
            /*t = new BinaryNode<AnyType>(null, x, null);*/ //注：java是按值传递的，不能修改传递的变量的值，比如  将t重新赋值，并不会影响root,如果需改某个对象的值，需要对对象进行引用改变
            return new BinaryNode<AnyType>(null,x,null);
        }
        int compare = x.compareTo(t.element);
        if (compare<0){
            t.left=insert(x,t.left);//注意：这边进行了赋值
        }
        else if (compare>0){
            t.right=insert(x,t.right);
        }
        else
            ;//do nothing
        return t;
    }
    private BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> t){
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
            /*
            这一步可以修改，一般不会通过修改节点内部的值，来交换节点，因为节点内部的储存的数据域是用户自定义的，可以非常复杂，作为数据结构的操作，操作应该和内部存储的数据域解耦
             */
            t.element=findMin(t.right).element;
            t.right=remove(t.element,t.right);//这两步效率比较低，直接可以找右枝最小点后，直接删除，并返回其值。

            /*t=getMin(t.right);
            t.right=remove(t.element,t.right);*/
        }
       else
            t=(t.left!=null)?t.left:t.right;//当t的末端节点为空或者只有一个节点时
       return t;//这部很重要！！！！！
    }
    public BinaryNode<AnyType> getMin(BinaryNode node){
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
    private void printTree(BinaryNode<AnyType> t){
        if (t!=null){
            printTree(t.left);
            System.out.println(t.element);//该递归的基准
            printTree(t.right);
        }
    }
}