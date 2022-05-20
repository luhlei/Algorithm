package Algorithms_fourth;

public class outer {
    public static int i=1;
    public static int j;
    static class innerStatic{

    }
    class inner{
        public void test(){
            System.out.println("这是内部类方法");
        }
    }

    public static void main(String[] args) {
        innerStatic innerStatic = new innerStatic();//必须手动创建静态内部类，静态内部类不随着外部类的加载而被创建，和静态字段完全不一样
        outer outer = new outer();
        inner inner = outer.new inner();//必须创建内部类
        System.out.println("88");
        int[][] a =new int[10][8];
        int length = a.length;
    }
}
