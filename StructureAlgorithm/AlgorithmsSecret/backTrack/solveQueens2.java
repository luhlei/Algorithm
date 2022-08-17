package AlgorithmsSecret.backTrack;

import org.junit.Test;

import java.util.ArrayList;

public class solveQueens2 {
    ArrayList<ArrayList<String>> res=new ArrayList<>();
    public ArrayList<ArrayList<String>> solveNQueens(int n){
        ArrayList<String> board=new ArrayList<>();
        char[] chars=new char[n];
        for (int i = 0; i < n; i++) {
            chars[i]='.';
        }
        for (int i = 0; i < n; i++) {
            board.add(new String(chars));
        }
        backTrack(board,0);
        return res;
    }
    public void backTrack(ArrayList<String> board, int row){
        if (row==board.size()){
            res.add(new ArrayList<>(board));//满足条件，添加到结果集中
        }
        for (int col = 0; col < board.size(); col++) {
            if (!valid(board,row,col)){
                continue;
            }
            StringBuffer buffer = new StringBuffer(board.get(row));
            buffer.setCharAt(col,'Q');
            board.set(row,buffer.toString());

            backTrack(board,row+1);

            buffer = new StringBuffer(board.get(row));
            buffer.setCharAt(col,'.');
            board.set(row,buffer.toString());
        }
    }
    public static boolean valid(ArrayList<String> board,int row,int col){
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col)=='Q'){
                return false;
            }
        }
        for (int i = row-1,j=col-1; i >=0&&j>=0 ; i--,j--) {
            if (board.get(i).charAt(j)=='Q'){
                return false;
            }
        }
        for (int i = row-1,j=col+1; i >=0&&j<board.size() ; i--,j++) {
            if (board.get(i).charAt(j)=='Q'){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(solveNQueens(8));
    }
}
