package factory_Method;

/**
 * Created by lmandy on 2018/3/2.
 * 工厂方法模式 也叫工厂模式
 *  共分为 简单工厂 ，多工厂 ，静态工厂 3种模式
 */

/**
 * 1 抽象产品  发送工具
 */

interface Sender{
    void send();
}

/**
 * 2 具体产品  邮件
 */

class MailSender implements Sender{

    @Override
    public void send() {
        System.out.println("发送邮件");
    }
}

/**
 * 2 具体产品 信息
 */
class SmsSender implements Sender{

    @Override
    public void send() {
        System.out.println("发送信息");
    }
}

/**
 * 简单工厂
 */
class SimpleFactory{
    Sender getSender(String type){
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }
}
/**
 * 多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，
 * 而多个工厂方法模式是提供多个工厂方法，分别创建对象
 */
/**
 * 多个工厂
 */
class MoreFactory{
    Sender getMailSender(){
        return new MailSender();
    }
    Sender getSmsSender(){
        return new SmsSender();
    }
}
/**
 * 静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
 */

class StaticFactory{
    static Sender getMailSender(){
        return new MailSender();
    }
    static Sender getSmsSender(){
        return new SmsSender();
    }
}

/**
 * 测试
 *
 * 凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
 * 在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象，
 * 第三种相对于第二种，不需要实例化工厂类，所以，大多数情况下，我们会选用第三种——静态工厂方法模式。
 */
public class TestFactoryMetod {
    public static void main(String[] args) {
        //测试简单工厂
        SimpleFactory simpleFactory = new SimpleFactory();
        Sender mail = simpleFactory.getSender("mail");
        mail.send();
        Sender sms = simpleFactory.getSender("sms");
        sms.send();
    }
}
