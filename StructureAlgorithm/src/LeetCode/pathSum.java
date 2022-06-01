package LeetCode;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class pathSum {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root==null) return res;
        LinkedList<Integer> track=new LinkedList<>();
        int sum=0;
        backtrack(root,track,sum,target);
        return res;
    }
    public void backtrack(TreeNode root,LinkedList<Integer> Track,int sum,int target){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            sum+=root.val;
            Track.add(root.val);
            if(sum==target){
                res.add(new LinkedList(Track));
            }
            return;
        }
        sum+=root.val;
        Track.add(root.val);
        backtrack(root.left,Track,sum,target);//记住sum是int基本变量，所以是值传递，不需要，再次修改，而target是引用传递，所以需要修改
        if(root.left!=null){
            Track.removeLast();
        }
        backtrack(root.right,Track,sum,target);
        if(root.right!=null){
            Track.removeLast();
        }
    }
    StringBuffer data1=new StringBuffer();
    StringBuffer data2=new StringBuffer();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        traverse(root);
        data1.append(data2);
        return data1.toString();
    }
    public void traverse(TreeNode root){
        if(root==null){
            return;
        }
        data1.append(root.val);
        traverse(root.left);
        data2.append(root.val);
        traverse(root.right);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int i=data.length()/2;
        String s1 = data.substring(0, i);
        String s2 = data.substring(i, data.length());
        int[] pre=new int[i];
        int[] in=new int[i];
        for(int j=0;j<i;j++){
            pre[j]=s1.charAt(j);
            in[j]=s2.charAt(j);;
        }
        return buildTree(pre,in);
    }
    public TreeNode buildTree(int[] pre,int[] in){
        return buildTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    public TreeNode buildTree(int[] pre,int prelo,int prehi,int[] in,int inlo,int inhi){
        if(prelo>prehi) return null;
        int rootVal=pre[inlo];
        int index=0;
        for(int i=inlo;i<inhi;i++){
            if(in[i]==rootVal){
                index=index;
                break;
            }
        }
        int leftSize=index-inlo;
        TreeNode root=new TreeNode(rootVal);
        root.left=buildTree(pre,prelo+1,prelo+leftSize,in,inlo,index-1);
        root.right=buildTree(pre,prelo+leftSize+1,prehi,in,index+1,inhi);
        Integer.valueOf(root.val).toString();
        return root;
    }
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null){
                return "null";
            }
            String res=root.val+",";
            res+=serialize(root.left);
            res+=serialize(root.right);
            return res;
        }
        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");
            Queue<String> queue = new LinkedList<>();
            for(int i = 0; i < arr.length; i++){
                queue.offer(arr[i]);
            }
            return help(queue);
        }
        public TreeNode help(Queue<String> queue){
            String val = queue.poll();
            if(val.equals("null")){
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(val));
            root.left = help(queue);
            root.right = help(queue);
            return root;
        }
    }
}
