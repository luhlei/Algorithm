package LeetCode;

public class lc54 {
    int value;
    int cont;
    public int kthLargest(TreeNode root, int k) {
        traverse(root,k);
        return value;
    }
    public void traverse(TreeNode root,int k){
        if(root==null){
            return;
        }
        traverse(root.right,k);
        cont++;//注意java是值传递的，所以不能通过修改k，来实现
        if (cont==k) value=root.val;
        traverse(root.left,k);
    }
    //lc55
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftLength=maxDepth(root.left);
        int rightLength=maxDepth(root.right);
        return leftLength>rightLength?leftLength+1:rightLength+1;
    }
}
