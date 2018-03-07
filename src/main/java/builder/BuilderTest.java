package builder;

/**
 * Created by lmandy on 2018/3/5.
 * 建造者模式 http://www.cnblogs.com/java-my-life/archive/2012/04/07/2433939.html
 *
 *  四种角色
 *
 * 抽象建造者（Builder）角色：给 出一个抽象接口，以规范产品对象的各个组成成分的建造。一般而言，此接口独立于应用程序的商业逻辑。模式中直接创建产品对象的是具体建造者 (ConcreteBuilder)角色。具体建造者类必须实现这个接口所要求的两种方法：一种是建造方法(buildPart1和 buildPart2)，另一种是返还结构方法(retrieveResult)。一般来说，产品所包含的零件数目与建造方法的数目相符。换言之，有多少 零件，就有多少相应的建造方法。

 * 具体建造者（ConcreteBuilder）角色：担任这个角色的是与应用程序紧密相关的一些类，它们在应用程序调用下创建产品的实例。这个角色要完成的任务包括：1.实现抽象建造者Builder所声明的接口，给出一步一步地完成创建产品实例的操作。2.在建造过程完成后，提供产品的实例。

 * 导演者（Director）角色：担任这个角色的类调用具体建造者角色以创建产品对象。应当指出的是，导演者角色并没有产品类的具体知识，真正拥有产品类的具体知识的是具体建造者角色。

 *　产品（Product）角色：产品便是建造中的复杂对象。一般来说，一个系统中会有多于一个的产品类，而且这些产品类并不一定有共同的接口，而完全可以是不相关联的。
 */


//1产品
class Product{
    public String part1;
    public String part2;

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public String toString() {
        return "Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                '}';
    }
}
//2抽象建造者
interface Builder{
    public void builderPart1();
    public void builderPart2();
    public Product retrieveResult();
}
//具体建造者
class ConcreteBuilder implements Builder{

    Product product  = new Product();
    /**
     * 构建第一个零件
     */
    @Override
    public void builderPart1() {
        product.setPart1("part1");
    }

    /**
     * 构建第二个零件
     */
    @Override
    public void builderPart2() {
        product.setPart2("part2");
    }

    /**
     * 返回产品
     * @return
     */
    @Override
    public Product retrieveResult() {
        return product;
    }
}
//导演者
class Director{
    public Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(){
        builder.builderPart1();
        builder.builderPart2();
    }

    
}
public class BuilderTest {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.retrieveResult();
        System.out.println(product.toString());
    }

}
