package LeetCode;

import java.util.HashMap;

/**
 * 前序遍历和中序遍历的结果：
 * *根节点在前序遍历数组的头部，接下来依次是每颗子树的根节点，再之后是右子树
 * 根节点在中序遍历的中间部位，其左边是左子树，左边是右子树，以此推类。
 */
public class rebuildBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    HashMap<Integer,Integer> map=new HashMap<>();//用于存放中序遍历的结果
    int[] pre;//用于引用前序遍历数组

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre=preorder;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(0,pre.length-1,0,inorder.length-1);
    }

    /**
     *
     * @param prelo 前序遍历数组的起始索引
     * @param prehi 前序遍历数组的尾部索引
     * @param inlo  中序遍历数组的起始索引
     * @param inhi  中序遍历数组的起始索引
     * @return
     */
    public TreeNode build(int prelo,int prehi,int inlo,int inhi){
        if(prelo>prehi||inlo>inhi) return null;

        int rootVal=pre[prelo];
        int index=map.get(rootVal);

        TreeNode root=new TreeNode(rootVal);
        root.left=build(prelo+1,prelo+index-inlo,inlo,index-1);//递归，双重递归
        root.right=build(prelo+index+1-inlo,prehi,index+1,inhi);

        return root;
    }
}

