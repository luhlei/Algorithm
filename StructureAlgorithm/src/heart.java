import org.junit.Test;

public class heart {
    public  static  void heart1(){
        float x,y,a;
        for(y=1.3f;y>-1.1f;y-=0.06f){   //这里的参数皆可以调，条件就是看着顺眼
            for(x=-1.2f;x<=1.2f;x+=0.025f){
                a=x*x+y*y-1;
                System.out.print(a*a*a-x*x*y*y*y<=0.0f?' ':'@');
            }
            System.out.println();
        }
    }

    public static  void heart2(){
        double x,y,a;
        char s[]=new char[]{'I',' ','l','o','v','e',' ','y','o','u','!'};
        int index=0;
        for(y=1.3f;y>-1.1f;y-=0.06f){
            index=0;
            for(x=-1.1f;x<=1.1f;x+=0.025f){
                double result=x*x+Math.pow((5.0*y/4.0-Math.sqrt(Math.abs(x))),2);
                if(result<=1){
                    System.out.print((s[index]));
                    index=(index+1)%11;
                }
                else{
                    System.out.print(' ');
                }
            }
            System.out.println(" ");
        }
    }
    @Test
    public void test(){
        heart2();
    }
}
