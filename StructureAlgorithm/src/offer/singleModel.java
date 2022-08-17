package offer;

/**
 * 单例设计模式
 * 设计一个类，只能生成该类的一个实列
 *
 *
 * 设计思想：
 * 其实只需要三步就可以保证对象的唯一性
 *
 * (1)不允许其他程序用new对象。
 *
 *     因为new就是开辟新的空间，在这里更改数据只是更改的所创建的对象的数据，如果可以new的话，每一次new都产生一个对象，这样肯定保证不了对象的唯一性。
 *
 * (2)在该类中创建对象
 *    因为不允许其他程序new对象，所以这里的对象需要在本类中new出来
 *
 * (3)对外提供一个可以让其他程序获取该对象的方法
 *
 *    因为对象是在本类中创建的，所以需要提供一个方法让其它的类获取这个对象。
 *
 * 那么这三步怎么用代码实现呢？将上述三步转换成代码描述是这样的
 *
 * (1)私有化该类的构造函数
 * (2)通过new在本类中创建一个本类对象
 * (3)定义一个公有的方法，将在该类中所创建的对象返回
 * ————————————————
 * 版权声明：本文为CSDN博主「奋斗之路」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/dmk877/article/details/50311791
 */
class Algorithm {
    public static void main(String[] args) {
        Singleton5 instance = Singleton5.instance;
    }
}

/**
 * 1、饿汉式：线程安全，耗费资源
 */
class HugerSingleton1{
    //该对象的引用不可修改
    private static final HugerSingleton1 Instance=new HugerSingleton1();
    public static HugerSingleton1 getInstance(){
        return Instance;
    }

    private HugerSingleton1() { }
}
/**
 * 2、饿汉式：在静态代码块中实例化对象
 */
class HugerSingleton2{
    private static HugerSingleton2 instance;
    static {
        instance=new HugerSingleton2();
    }
    public static HugerSingleton2 getInstance(){
        return instance;
    }
    private HugerSingleton2(){};//构造器不能是静态的
}

/**
 * 3、懒汉式：线程不安全,不能使用
 */
class SingleTon1{
    private static SingleTon1 instance;
    public static SingleTon1 getInstance(){
        if (instance==null){
            instance=new SingleTon1();
        }
        return instance;
    }

    private SingleTon1() { }
}

/**
 * 4、线程安全的懒汉式：给方法加锁，效率低
 */
class Singleton2{
    private static Singleton2 instance;
    public static synchronized Singleton2 getInstance(){
        if (instance==null)
            instance=new Singleton2();
        return instance;
    }

    private Singleton2() { }
}

/**
 * 5、线程安全的懒汉式：双重检查锁（同步代码块）
 */
class Singleton3{
    private static Singleton3 instance;
    public static Singleton3 getInstance(){
        if (instance==null){
            synchronized (Singleton3.class){
                if (instance==null)
                    instance=new Singleton3();
            }
        }
        return instance;
    }

    private Singleton3() { }
}
/**
 * 5、线程安全的懒汉式：静态内部类（推荐）,静态内部类和内部类，都是在被调用时才会加载，不是随着外部类的加载和加载的，其实和静态方法类似
 */
class Singleton4{
    private static class instance{
        static Singleton4 Instance=new Singleton4();
    }
    public static Singleton4 getInstance(){
        return instance.Instance;
    }

    private Singleton4() { }
}
/**
 * 6、线程安全的懒汉式：枚举
 */
enum Singleton5{
    instance;
}