package niuKe.huawei;

import java.util.Scanner;

public class Main{
    public int sum=0;
    public int res=0;
    public int count(int n){
        if(n<2)
            return res;
        if (n==2)
            n++;
        sum=n/3;
        res+=sum;
        n=n%3+sum;
        return count(n);
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int i = input.nextInt();
        while(i!=0){
            System.out.println(new Main().count(i));
            i=input.nextInt();
        }
    }
}
