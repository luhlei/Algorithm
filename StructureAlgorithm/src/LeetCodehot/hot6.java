package LeetCodehot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class hot6 {
    public String convert(String s, int numRows) {
        if (numRows<2) return s;
        List<StringBuffer> list=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuffer());
        }
        int row=0,flag=-1;
        for (char c : s.toCharArray()) {
            list.get(row).append(c);
            if (row==0||row==numRows-1) flag=-flag;
            row=row+flag;
        }
        StringBuilder total=new StringBuilder();
        for (StringBuffer buffer : list) {
            total.append(buffer);
        }
        return total.toString();
    }
    @Test
    public void test(){
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
