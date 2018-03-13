package abstract_Factory;

/**
 * Created by lmandy on 2018/3/2.
 *
 工厂父类（接口）负责定义产品对象的公共接口，而子类工厂则负责创建具体的产品对象。

 工厂方法模式包含四个部分：

 1.抽象产品：产品对象同一的基类，或者是同一的接口。  car

 2.具体的产品：各个不同的实例对象类  总共定义两个，bike 和bus 分别表示不同的交通工具类

 3.抽象工厂：所有的子类工厂类的基类，或是同一的接口  Factory 定义产品对象的公共接口

 4.具体的工厂子类：负责每个不同的产品对象的实际创建
 */
public class TestAbFactory {
    public static void main(String[] args) {
        CarFactory bikeFactory = new BikeFactory();
        Car bike = bikeFactory.getCar();
        bike.goWork();

        CarFactory busFactory = new BusFactory();
        Car bus = busFactory.getCar();
        bus.goWork();
    }
}

interface Car{
    void goWork();
}
class Bike implements Car{

    @Override
    public void goWork() {
        System.out.println("骑着自行车去上班");
    }
}
class Bus implements Car{

    @Override
    public void goWork() {
        System.out.println("做着公交车去上班");
    }
}
interface CarFactory{
    Car getCar(); //生产汽车
}
class BikeFactory implements CarFactory{

    @Override
    public Car getCar() {
        return new Bike();
    }
}
class BusFactory implements CarFactory{

    @Override
    public Car getCar() {
        return new Bus();
    }
}

