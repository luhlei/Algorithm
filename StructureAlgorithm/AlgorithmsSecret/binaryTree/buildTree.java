package AlgorithmsSecret.binaryTree;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "value="+val;
    }
}
public class buildTree {
    public static TreeNode buildTree(int[] inorder,int[] postOrder){
        return build(inorder,0,inorder.length-1,postOrder,0,postOrder.length-1);
    }
    public static TreeNode build(int[] inorder,int inStart,int inEnd,int[] postOrder,int ptStart,int ptEnd){
        if (inEnd<inStart||ptEnd<ptStart) return null;
        int rootVal=postOrder[ptEnd];
        int index = 0;
        for (int i = 0; i <= inEnd; i++) {
            if (inorder[i]==rootVal){
                index=i;
                break;
            }
        }
        int leftSize=index-inStart;
        TreeNode root=new TreeNode(rootVal);
        root.left=build(inorder,inStart,index-1,postOrder,ptStart,ptStart+leftSize-1);
        root.right=build(inorder,index+1,inEnd,postOrder,ptStart+leftSize,ptEnd-1);
        return root;
    }
    public static void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.println(root.val);
            print(root.right);
        }
    }
    @Test
    public void test(){
        TreeNode treeNode = buildTree(new int[]{8, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        print(treeNode);
    }

    /**
     * 寻找二叉树中的重复子串
     */
    HashMap<String,Integer> memo=new HashMap<>();
    ArrayList<TreeNode> res=new ArrayList<>();
    public ArrayList<TreeNode> findDuplicateSubtrees(TreeNode root){
        traverse(root);
        return res;
    }
    public String traverse(TreeNode root){
        if (root==null) return "#";
        String left=traverse(root.left);
        String right=traverse(root.right);

        String subString=root.val+left+right;
        int freq=memo.getOrDefault(subString,0);
        if (freq==1) res.add(root);
        memo.put(subString,freq+1);
        return subString;
    }

    /**
     * 寻找树中的最长路径
     */
    private int MaxDiameter=0;
    public int diameterOfBinaryTree(TreeNode root){
        maxDepth(root);
        return MaxDiameter;
    }
    public int maxDepth(TreeNode root){
        if (root==null) return 0;
        int leftMax=maxDepth(root.left);
        int rightMax=maxDepth(root.right);
        int myDiameter=leftMax+rightMax;
        MaxDiameter=Math.max(MaxDiameter,myDiameter);
        return 1+Math.max(leftMax,rightMax);//这步及其重要，描述其逻辑，说白了就是赋值的过程！
    }

    /**
     * BFS,层序遍历
     * @param root 根节点
     */
    public void levelTraverse(TreeNode root){
        if (root==null) return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        if (!queue.isEmpty()){
            int sz=queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
        }
    }
}

/**
 * 归并排序
 *
 * 有些题目可以对归并排序进行改造！！！
 */
class Merge{
    private static int[] temp;//节省开销
    public static void sort(@NotNull int[] nums){
        temp=new int[nums.length];
    }
    public static void sort(int[] nums,int lo,int hi){
        if (lo==hi) return;
        int mid=lo+(hi-lo)/2;
        sort(nums,lo,mid);
        sort(nums,mid+1,hi);
        merge(nums,lo,mid,hi);
    }
    public static void merge(int[] nums,int lo,int mid,int hi){
        for (int i = lo; i < hi; i++) {
            temp[i]=nums[i];
        }
        int left=lo,right=mid+1;
        for (int i = lo; i < hi; i++) {
            if (left>mid){
                nums[i]=temp[right++];
            }
            else if (right>hi){
                nums[i]=temp[left++];
            }
            else if (temp[left]>temp[right]){
                nums[i]=temp[right++];
            }else {
                nums[i]=temp[left++];
            }
        }
    }
}
