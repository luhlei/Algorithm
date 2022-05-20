package AlgorithmsSecret.backTrack;

import org.junit.Test;

import java.util.ArrayList;

public class solveNQueens {
    public static ArrayList<ArrayList<String>> res=new ArrayList<>();
    public static ArrayList<ArrayList<String>> solveNQueens(int n){
        ArrayList<String> board=new ArrayList<>(n);
        char[] chars=new char[n];
        for (char c : chars) {
            c='.';
        }
        for (String s : board) {
            s=new String(chars);
        }
        backTrack(board,0);
        return res;
    }
    public static void backTrack(ArrayList<String> board,int row){
        if (row==board.size()){
            res.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < board.get(row).length(); col++) {
            if (!isValid(board,row,col)){
                continue;
            }
            StringBuffer sb=new StringBuffer(board.get(row));//String不可修改，需要将String转化为StringBuffer后，再进行修改。
            sb.setCharAt(col,'Q');
            board.set(row,sb.toString());

            backTrack(board,row+1);

            sb=new StringBuffer(board.get(row));
            sb.setCharAt(col,'.');
            board.set(row,sb.toString());
        }
    }
    public static boolean isValid(ArrayList<String> board,int row,int col){
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col)=='Q'){
                return false;
            }
        }
        for (int i=row-1,j=col+1;i>0&&j<board.get(row).length();i--,j++){
            if (board.get(i).charAt(j)=='Q') return false;
        }
        for (int i=row-1,j=col-1;i>0&&j>0;i--,j++){
            if (board.get(i).charAt(j)=='Q') return false;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(solveNQueens(8));
    }
}
