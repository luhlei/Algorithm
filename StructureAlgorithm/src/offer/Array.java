package offer;

/**
 * 一个二维数组，每一行从左到右递增，每一列从上到下递增．
 *  输入一个该类二维数组和一个整数，判断数组中是否含有这个整数
 */
public class Array {
    public static boolean find(int[][] array,int target){
        //解法一：双指针

        /*
        //需要用null和length判断的原因，null判断array有没有分配空间，array.length
         */
        if (array==null||array.length==0)
            return false;
        int row=0;
        int column=array[0].length-1;
        while (row<array.length&&column>=0){
            if (target==array[row][column]){
                return true;
            }
            if (target<array[row][column]){
                column--;
            }
            else {
                row++;
            }
        }
        return false;
    }
    //解法二：二分法
    //关键问题：如何很好的确定中间位置。
    //不太懂这个算法
    public static boolean find2(int[][] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        int left = 0;
        int right = array.length * array[0].length - 1;
        int col = array[0].length;
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = array[mid / col][mid % col];
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
