package niuke;

public class javaBase {
}
class StaticStuff{
    static int x=10;
    static {
        x+=5;
    }
    public static void main(String args[ ]){
        System.out.println("x+"+ x);
    }
    static { x/=3;}
}
class Bground extends Thread{
    public static void main(String argv[]){
        Bground b = new Bground();
        b.run();
    }
    public void start(){
        for(int i=0;i<10;i++){
            System.out.println("Value of i = "+i);
        }
    }
}
