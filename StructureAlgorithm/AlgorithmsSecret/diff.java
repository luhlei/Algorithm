package AlgorithmsSecret;

/**
 * 差分数组：
 * 主要应用场合：频繁对原始数组的某个区间的元素进行增减
 */
public class diff {
    private int[] diff;

    public diff(int[] nums) {
        assert nums.length>0;
        diff=new int[nums.length];
        diff[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i]=nums[i]-nums[i-1];
        }
    }
    public void increase(int i,int j,int val){
        diff[i]=diff[i]+val;
        diff[j]=diff[j+1]-val;
    }
    public int[] result(){
        int[] res=new int[diff.length];
        res[0]=diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i]=res[i-1]+diff[i];
        }
        return res;
    }

    /**
     *
     * @param length 所操作数组的长度
     * @param updates 是操作数组的一个集合
     * @return 返回多次更新后数组的结果
     */
    public int[] getModifiedArray(int length,int[][] updates){
        int[] nums=new int[length];
        AlgorithmsSecret.diff diff = new diff(nums);
        for (int[] update : updates) {
            int i=update[0];
            int j=update[1];
            int val=update[2];
            diff.increase(i,j,val);
        }
        return diff.result();
    }
}