package behaviorPattern;

/**
 * http://www.cnblogs.com/java-my-life/archive/2012/05/16/2502279.html
 * Created by lmandy on 2018/3/15.
 * 观察者模式（2种模型，推模型和拉模型）
 */

/**  涉及到的角色
 *
 * 　●　　抽象主题(Subject)角色：抽象主题角色把所有对观察者对象的引用保存在一个聚集（比如ArrayList对象）里，每个主题都可以有任何数量的观察者。抽象主题提供一个接口，可以增加和删除观察者对象，抽象主题角色又叫做抽象被观察者(Observable)角色。

 　　●　　具体主题(ConcreteSubject)角色：将有关状态存入具体观察者对象；在具体主题的内部状态改变时，给所有登记过的观察者发出通知。具体主题角色又叫做具体被观察者(Concrete Observable)角色。

 　　●　　抽象观察者(Observer)角色：为所有的具体观察者定义一个接口，在得到主题的通知时更新自己，这个接口叫做更新接口。

 　　●　　具体观察者(ConcreteObserver)角色：存储与主题的状态自恰的状态。具体观察者角色实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态 像协调。如果需要，具体观察者角色可以保持一个指向具体主题对象的引用。
 */

///////////////////////推模型///////////////////////////

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象观察者
 */
interface ObServer{

    /**
     * 更新状态 (推模型)
     * @param subjectState
     */
    void update(String subjectState);
}

/**
 * 具体观察者
 */
class ConcreteObServer implements ObServer{

    private String obServerState;

    /**
     * 更新状态 (推模型)
     * @param subjectState
     */
    @Override
    public void update(String subjectState) {
        obServerState = subjectState;
        System.out.println("观察者状态："+obServerState);
    }
}

/**
 * 抽象主题（被观察者）
 */
abstract class Subject{
    //保存注册的所有观察者
    private List<ObServer> obServerList = new ArrayList<>();
    //注册观察者
    public void attacObServer(ObServer obServer){
        obServerList.add(obServer);
    }
    //删除观察者
    public void removeObServer(ObServer obServer){
        obServerList.remove(obServer);
    }
    //通知所有观察者(推模型)
    public void nofityAllObServer(String subjectState){
        for (ObServer obServer : obServerList) {
            obServer.update(subjectState);
        }
    }
}

/**
 * 具体观察者
 */
class ConcreteSubject extends Subject{
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }
    public void chanage(String newState){
        this.subjectState = newState;
        System.out.println("主题状态为：" + newState);
        //状态发生改变，通知各个观察者
        this.nofityAllObServer(newState);
    }
}

public class ObServerTest {
    public static void main(String[] args) {
        //创建观察者模式
        ObServer obServer = new ConcreteObServer();
        //创建主题对象
        ConcreteSubject subject = new ConcreteSubject();
        //注册观察者
        subject.attacObServer(obServer);
        //改变主题状态，通知观察者
        subject.chanage("new State");
    }
}
