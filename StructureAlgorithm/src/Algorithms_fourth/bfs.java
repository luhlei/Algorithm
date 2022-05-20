package Algorithms_fourth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class bfs {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        LinkedList<TreeNode> list = new LinkedList<>();//用于储存顺序
        ArrayList<Integer> integers = new ArrayList<>();//用于储存数据
        list.add(root);
        while(!list.isEmpty()){
            TreeNode node = list.remove();
            integers.add(node.val);
            if (node.left!=null){
                list.add(node.left);
            }
            if (node.right!=null){
                list.add(node.right);
            }
        }
        return integers.stream().mapToInt(Integer::intValue).toArray();
    }

    //递归遍历，引入辅助层数作为列表的定位，很牛逼
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> levelOrder1(TreeNode root) {
        level(root,0);
        return list;
    }
    public void level(TreeNode root,int k){
        if(root!=null){
            if(k>=list.size()){//注意这个等号：因为k的起始值为0
                list.add(new ArrayList<Integer>());
            }
            list.get(k).add(root.val);
            level(root.left,k+1);
            level(root.right,k+1);
        }
    }
}
