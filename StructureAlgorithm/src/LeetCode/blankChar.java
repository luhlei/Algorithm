package LeetCode;

import java.util.*;

public class blankChar {
    public char replaceSpace(String s){
        char c = s.charAt(0);
        return c;
    }

    public static void main(String[] args) {
        String a="abc";
        blankChar blankChar = new blankChar();
        System.out.println(blankChar.replaceSpace(a));
    }
    public String replace(String s){
        int n=9;
        String s1 = s.substring(0, n);
        String replace = s.replace(" ", "%20");
        return replace;
    }
}
