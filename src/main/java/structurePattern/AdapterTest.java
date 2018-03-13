package structurePattern;

/**
 * http://www.cnblogs.com/java-my-life/archive/2012/04/13/2442795.html
 * 适配器模式
 * Created by lmandy on 2018/3/12.
 * 2种模式（类适配器和对象适配器）
 * 　模式所涉及的角色有：

 　　●　　目标(Target)角色：这就是所期待得到的接口。注意：由于这里讨论的是类适配器模式，因此目标不可以是类。

 　　●　　源(Adapee)角色：现在需要适配的接口。

 　　●　　适配器(Adaper)角色：适配器类是本模式的核心。适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类
 */



//1.类的适配器模式把适配的类的API转换成为目标类的API。

/**
 * 目标角色
 */
interface Target {
    /**
     * 这是源类Adaptee也有的方法
     */
    public void sampleOperation1();
    /**
     * 这是源类Adapteee没有的方法
     */
    public void sampleOperation2();
}

/**
 * 源角色
 *
 * 上面给出的是目标角色的源代码，这个角色是以一个JAVA接口的形式实现的。
 * 可以看出，这个接口声明了两个方法：sampleOperation1()和sampleOperation2()。
 * 而源角色Adaptee是一个具体类，它有一个sampleOperation1()方法，但是没有sampleOperation2()方法。
 */
class Adaptee {
    public void sampleOperation1(){
        System.out.println("方法1");
    }
}

/**
 * 适配器角色Adapter扩展了Adaptee,同时又实现了目标(Target)接口。
 * 由于Adaptee没有提供sampleOperation2()方法，而目标接口又要求这个方法，因此适配器角色Adapter实现了这个方法。
 */
class Adapter extends Adaptee implements Target{
    public void sampleOperation2(){
        System.out.println("方法2");
    }
}

//对象适配器
interface Target2 {
    /**
     * 这是源类Adaptee也有的方法
     */
    public void sampleOperation1();
    /**
     * 这是源类Adapteee没有的方法
     */
    public void sampleOperation2();
}
class Adaptee2 {

    public void sampleOperation1(){
        System.out.println("方法1");
    }

}
class Adapter2 implements Target2{
    private Adaptee2 adaptee2;

    public Adapter2(Adaptee2 adaptee2) {
        this.adaptee2 = adaptee2;
    }

    public void sampleOperation1(){
        this.adaptee2.sampleOperation1();
    }
    public void sampleOperation2(){
        System.out.println("方法2");
    }
}

/**
 * 测试
 */
public class AdapterTest {
    public static void main(String[] args) {
        /**
         * 类适配器
         */
        Target target = new Adapter();
        target.sampleOperation1();
        target.sampleOperation2();
        System.out.println("-------------------------------------------------");
        /**
         * 对象适配器
         */
        Adaptee2 adaptee2 = new Adaptee2();
        Target2 target2 = new Adapter2(adaptee2);
        target2.sampleOperation1();
        target2.sampleOperation2();

    }

}
