package structurePattern;

/**
 * 代理对象
 * Created by lmandy on 2018/3/12.
 * 所谓代理，就是一个人或者机构代表另一个人或者机构采取行动。在一些情况下，
 * 一个客户不想或者不能够直接引用一个对象，而代理对象可以在客户端和目标对象之间起到中介的作用。
 * 　在代理模式中的角色：

 　　●　　抽象对象角色：声明了目标对象和代理对象的共同接口，这样一来在任何可以使用目标对象的地方都可以使用代理对象。

 　　●　　目标对象角色：定义了代理对象所代表的目标对象。

 　　●　  代理对象角色：代理对象内部含有目标对象的引用，从而可以在任何时候操作目标对象；
         代理对象提供一个与目标对象相同的接口，以便可以在任何时候替代目标对象。
        代理对象通常在客户端调用传递给目标对象之前或之后，执行某个操作，而不是单纯地将调用传递给目标对象。
 */

abstract class AbstractObject{
    //操作
    public abstract void operation();
}

class RealObject extends AbstractObject {
    @Override
    public void operation() {
        //一些操作
        System.out.println("一些操作");
    }
}

class ProxyObject extends AbstractObject{

    private AbstractObject realObject;

    public ProxyObject(AbstractObject realObject) {
        this.realObject = realObject;
    }

    @Override
    public void operation() {
        System.out.println("前");
        realObject.operation();
        System.out.println("后");
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        ProxyObject proxyObject = new ProxyObject(new RealObject());
        proxyObject.operation();
    }
}
