package LeetCode;

import org.junit.Test;

public class findPath {
/*    boolean[][] mark;
    public boolean exist(char[][] board, String word) {
        mark=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;i<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    search(board,i,j,word);
                }
            }
        }
        return false;
    }
    public void search(char[][] board,int i,int j,String word){

        char[] adj = adj(board, i, j);
        for (int k = 0; k < adj.length; k++) {
            if (adj[i]==word.charAt())
        }

    }
    public char[] adj(char[][] board,int i,int j){
        char[] values;
        if(i>0&&i<board.length-1)
            if (j>0&&j<board[0].length-1){
                values= new char[]{board[i - 1][j], board[i + 1][j], board[i][j - 1], board[i][j + 1]};
                return values;
            }else if (j>0){
                values=new char[]{board[i-1][j],board[i+1][j],board[i][j-1]};
                return values;
            }else {
                values=new char[]{board[i-1][j],board[i+1][j],board[i][j+1]};
                return values;
            }
        else if (i==0){
            if (j>0&&j<board[0].length-1){
                values= new char[]{board[i + 1][j], board[i][j - 1], board[i][j + 1]};
                return values;
            }else if (j>0){
                values=new char[]{board[i+1][j],board[i][j-1]};
                return values;
            }else {
                values=new char[]{board[i+1][j],board[i][j+1]};
                return values;
            }
        }else{
            if (j>0&&j<board[0].length-1){
                values= new char[]{board[i-1][j], board[i][j - 1], board[i][j + 1]};
                return values;
            }else if (j>0){
                values=new char[]{board[i-1][j],board[i][j-1]};
                return values;
            }else {
                values=new char[]{board[i-1][j],board[i][j+1]};
                return values;
            }
        }
    }*/
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从 (0, 0) 点开始进行 dfs 操作，不断地去找，
                // 如果以 (0, 0) 点没有对应的路径的话，那么就从 (0, 1) 点开始去找
                if (dfs(board, chars, visited, i, j, 0)) {//通过dfs判断矩阵内的每个值是否相符
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, boolean[][] visited, int i, int j, int start) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || chars[start] != board[i][j] || visited[i][j]) {//这部判断及其重要，包含边界检查，包含判断是否相等，包含是否访问过
            return false;
        }
        if (start == chars.length - 1) {
            return true;//当查找的元素全部符合时，返回true；
        }
        visited[i][j] = true;
        boolean ans = false;
        ans = dfs(board, chars, visited, i + 1, j, start + 1)//判断一个元素四周的值是否符合
                || dfs(board, chars, visited, i - 1, j, start + 1)
                || dfs(board, chars, visited, i, j + 1, start + 1)
                || dfs(board, chars, visited, i, j - 1, start + 1);
        visited[i][j] = false;//这部也至关重要，当字符不符合时，对之前访问过的继续标记为没有访问
        return ans;
    }
}
}
class Solution {
    boolean[][] visited;
    int number=0;
    public int movingCount(int m, int n, int k) {
        if(k==0||n==0&&m==0) return 1;
        visited=new boolean[m][n];
        count(m,n,0,0,k);
        return number;
    }
    public boolean count(int m,int n,int line,int column,int k){
        int i=line%10;
        int j=column%10;
        int i1=line/10;
        int j1=column/10;
        int sum=i+j+i1+j1;
        if(line<0||line>=m||column<0||column>=n||sum>k||visited[line][column]){
            return false;
        }
        visited[line][column]=true;
        number++;
        /*return count(m,n,line+1,column,k)&&count(m,n,line-1,column,k)&&count(m,n,line,column+1,k)&&count(m,n,line,column-1,k);*///为什么不能用&&，因为&&存在短路效应，&&碰见false短路，当其中一个方法返回false时，将不会继续计算下去
        return count(m,n,line+1,column,k)||count(m,n,line-1,column,k)||count(m,n,line,column+1,k)||count(m,n,line,column-1,k);//为什么能够使用||，即使||也有短路效应，因为||碰见true短路，当其中一个式子返回false时，将会继续计算下去，
    }

    /*public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.movingCount(7, 2, 3);
        System.out.println(i);
    }*/
}
class Solution1 {
    public int cuttingRope(int n) {
        if (n==1) return 0;
        return length(n,2,0);
    }
    public int length(int n,int m,int oldSum){
        if (m>n) return oldSum;
        int[] numberlength=new int[m];
        int i=n/m;
        int j=n%m;

        int newSum=1;
        for(int i1=0;i1<m;i1++){
            numberlength[i1]=i;
        }
        for(int i1=0;i1<j;i1++){//将余数平均分配到各个数
            numberlength[i1]++;
        }
        for(int i2=0;i2<m;i2++){
            newSum=newSum*numberlength[i2];
        }
        if(newSum>oldSum){
            return length(n,m+1,newSum);
        }
        return oldSum;
    }
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int i = solution1.cuttingRope(8);
        System.out.println(i);
    }
}
