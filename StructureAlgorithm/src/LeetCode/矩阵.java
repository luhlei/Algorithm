package LeetCode;

import org.junit.Test;

public class 矩阵 {
    boolean[][] visited;
    int[] save;
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return new int[0];
        }
        visited=new boolean[matrix.length][matrix[0].length];
        save=new int[matrix.length*matrix[0].length];
        visited[0][0]=true;
        save[0]=matrix[0][0];
        return print(matrix,0,0,0);
    }
    public int[] print(int[][] matrix,int i,int j,int z){
        if(matrix.length==1){
            for (int matrix1 : matrix[0]) {
                save[++z]=matrix1;
            }
            return save;
        }
        if (matrix[0].length==1){
            for (int[] ints : matrix) {
                save[++z]=ints[0];
            }
            return save;
        }
        if (j+1>=matrix[0].length&&i+1>=matrix.length) return save;
        if(j+1<matrix[0].length&&visited[i][j+1]||i+1<matrix.length&&visited[i][j+1]) return save;

        while(j+1<matrix[0].length&&visited[i][j+1]==false){
            visited[i][j+1]=true;
            save[++z]=matrix[i][j+1];
            j++;
        }
        while(i+1<matrix.length&&visited[i+1][j]==false){
            visited[i+1][j]=true;
            save[++z]=matrix[i+1][j];
            i++;
        }
        while(j-1>-1&&visited[i][j-1]==false){
            visited[i][j-1]=true;
            save[++z]=matrix[i][j-1];
            j--;
        }
        while(i-1>0&&visited[i-1][j]==false){
            visited[i-1][j]=true;
            save[++z]=matrix[i-1][j];
            i--;
        }
        return print(matrix,i,j,z);
    }
    @Test
    public void test(){
        int[][] a=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiralOrder(a);
        for (int i : save) {
            System.out.println(i);
        }
    }
}
