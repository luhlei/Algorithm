
public class ExactLineSearch {
    /*
    需要计算的方程，如果要计算不同的方程，修改这部分即可！
     */
    public static double function(double x){
        return Math.pow(x,3)-2*x+1;
    }
    /**
     * 精确线搜索，黄金分割法
     * @param a 搜索区间左端
     * @param b 搜索区间右端
     * @param c 区间精度
     */
    public static void search(double a,double b,double c){
        double x1,x2,f1,f2;
        int n=1;//迭代次数
        double t=(Math.sqrt(5)-1)/2;
        x1=a+(1-t)*(b-a);
        x2=a+t*(b-a);

        f1=function(x1);//方程计算
        f2=function(x2);
        while (b-a>c){
            if (f1>f2){
                a=x1;
                if (b-a<c){
                    n++;
                    System.out.printf("第 %d 次迭代",n);
                    System.out.println();//换行
                    System.out.println("近似极小点为："+x2);
                    System.out.println("b-a的值为："+(b-a));
                    System.out.println("function(b) - function(a)的值为"+(function(b) - function(a)));
                    break;
                }else{
                    f1=f2;
                    x1=x2;
                    x2=a+t*(b-a);
                    f2=function(x2);
                }
            }else{
                b=x2;
                if (b-a<c) {
                    n++;
                    System.out.printf("第 %d 次迭代",n);
                    System.out.println();//换行
                    System.out.println("近似极小点"+x1);
                    System.out.println("b-a的值为："+(b-a));
                    System.out.println("function(b) - function(a)的值为"+(function(b) - function(a)));
                    break;
                }else{
                    f2=f1;
                    x2=x1;
                    x1=a+(1-t)*(b-a);
                    f1=function(x1);
                }
            }
            n++;
            System.out.printf("第 %d 次迭代",n);
            System.out.println();//换行
        }
    }

    /*
    启动计算！！！
    */
    public static void main(String[] args) {
        double c =0.15;
        search(0,3,c);
    }
}
