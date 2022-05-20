package AlgorithmsSecret.binaryTree;

/**
 * 二叉搜索树最重要的一点是：一定要明确节点要干嘛，前序遍历是自顶向下，后序遍历是自底向上，后序遍历一般是需要依赖子节点的数据
 */
public class BST {//前序遍历，有重复计算，时间复杂度很高
    int maxSum=0;
    public int MaxSumBST(TreeNode root){
        travers(root);
        return maxSum;
    }
    public void travers(TreeNode root){
        if (root==null)
            return;
        if (isValidBST(root.left)&&isValidBST(root.right)){
            int leftMax=findMax(root.left);
            int rightMin=findMin(root.right);
            if (leftMax<root.val&&rightMin>root.val){
                int sum=findSun(root);
                maxSum=Math.max(sum,maxSum);
            }
        }
        travers(root.left);
        travers(root.right);
    }
    public boolean isValidBST(TreeNode root){
        return isValidBST(root,null,null);
    }

    public boolean isValidBST(TreeNode root,TreeNode min,TreeNode max){
        if (root==null) return true;
        if (min!=null&&root.val<min.val) return false;
        if (max!=null&&root.val>max.val) return false;
        return isValidBST(root.left,min,root)&&isValidBST(root.right,root,max);
    }
    public int findMin(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root.val;
    }
    public int findMax(TreeNode root){
        while (root.right!=null){
            root=root.right;
        }
        return root.val;
    }
    public int findSun(TreeNode root){
        int sum=0;
        travers2(root,sum);
        return sum;
    }
    public void travers2(TreeNode root,int sum){
        if (root==null) return;
        sum+=root.val;
        travers2(root.left,sum);
        travers2(root.right,sum);
    }
}


class BST2{//后序遍历，比前序遍历快很多，没有重复计算
    int maxSum=0;
    public int MaxSumBST(TreeNode root){
        traverse(root);
        return maxSum;
    }
    public int[] traverse(TreeNode root){
        if (root==null){
            return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};//数组大小为4，int[0]为判断是否为BST，1为是，0为否，int[1]所有节点中的最小值，int[2]为所有节点中的最大值，int[3]为所有节点值的和
        }
        int[] left=traverse(root.left);
        int[] right=traverse(root.right);
        int[] res=new int[4];
        if (left[0]==1&&right[0]==1&&left[1]<root.val&&right[2]>root.val){
            res[0]=1;
            res[1]=Math.min(left[1],root.val);
            res[2]=Math.max(right[2],root.val);
            res[3]=left[3]+right[3]+root.val;
            maxSum=Math.max(maxSum,res[3]);
        }else {
            res[0]=0;//如果不符合上述条件
        }
        return res;
    }
}