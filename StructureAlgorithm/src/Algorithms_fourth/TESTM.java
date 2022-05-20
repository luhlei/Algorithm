package Algorithms_fourth;

import org.junit.Test;
import java.util.Scanner;

public class TESTM {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String s = scanner1.nextLine();
        String[] s1 = s.split(" ");
        int m;
        if(n>=2*x&&n<=2*y){
            for (int i = 0; i <= y - x; i++) {
                m=x+i;
                if (n-m<=y){
                    System.out.println(s1[m - 1]);
                    break;
                }
            }
        }else System.out.println(-1);
    }
    @Test
    public void test(){
        int m=8;
        int n=m/1;
        int j=m%1;
        System.out.println(n);
        System.out.println(j);
    }
}
