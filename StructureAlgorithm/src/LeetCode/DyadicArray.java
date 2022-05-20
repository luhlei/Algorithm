package LeetCode;

import java.util.HashMap;

public class DyadicArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        for(int i=0;i<matrix.length;i++){
            if(target>matrix[i][0]&&target<matrix[i][matrix[0].length-1]){
                return rank(matrix[i],target,0,matrix[0].length-1);
            }
        }
        return false;
    }
    public boolean rank(int[] a,int target,int lo,int hi){
        if(a.length==0||a==null){
            return false;
        }
        if(lo>hi){
            return false;
        }
        int mid=lo+(hi-lo)/2;
        int cmp=Integer.compare(a[mid],target);
        if(cmp>0){
            return rank(a,target,lo,mid-1);
        }else if(cmp<0){
            return rank(a,target,mid+1,hi);
        }else return true;
    }
    public char firstUniqChar(String s) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer integer = hashMap.get(s.charAt(i));
            if (integer!=null){
                hashMap.put(s.charAt(i), integer+1);
            }else hashMap.put(s.charAt(i), 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
