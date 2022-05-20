package AlgorithmsSecret;

import org.junit.Test;

import java.util.Stack;

public class calculator {
    public static int number(String s){
        int n=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            n=10*n+(c-'0');//这一步及其重要！！！
        }
        return n;
    }
    public static int calculator(String s){
        Stack<Integer> stack=new Stack<>();
        int pre;
        int num=0;
        char sign='+';
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (isDigit(c)){
                num=num*10+(c-'0');
            }
            if (!isDigit(c)&&c!=' '||i==s.length()-1){//注意：当运算进行到字符串的尾部时，没有符号的触发条件了，需要进行尾部判断！
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre= stack.pop();
                        stack.push(pre*num);
                        break;
                    case '/':
                        pre=stack.pop();
                        stack.push(pre/num);
                        break;
                }
                num=0;
                sign=c;//更新符号
            }
        }
        int res=0;
        while (!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
    /**
     *  判断字符是数字还是符号
     * @param c 字符
     * @return 判断
     */
    public static boolean isDigit(char c){
        int n=(c-'0');
        return n >= 0 && n <= 9;
    }
    @Test
    public void test(){
        System.out.println(calculator("1*12/1-11"));
    }
}