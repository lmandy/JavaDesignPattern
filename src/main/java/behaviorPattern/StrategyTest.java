package behaviorPattern;

/**
 * 策略模式
 * http://www.cnblogs.com/java-my-life/archive/2012/05/10/2491891.html
 * Created by lmandy on 2018/3/15.
 *这个模式涉及到三个角色：

 　　●　　环境(Context)角色：持有一个Strategy的引用。

 　　●　　抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。

 　　●　　具体策略(ConcreteStrategy)角色：包装了相关的算法或行为。
 */

/**
 * 假设现在要设计一个贩卖各类书籍的电子商务网站的购物车系统。一个最简单的情况就是把所有货品的单价乘上数量，但是实际情况肯定比这要复杂。比如，本网站可能对所有的高级会员提供每本20%的促销折扣；对中级会员提供每本10%的促销折扣；对初级会员没有折扣。

 　　根据描述，折扣是根据以下的几个算法中的一个进行的：

 　　算法一：对初级会员没有折扣。

 　　算法二：对中级会员提供10%的促销折扣。

 　　算法三：对高级会员提供20%的促销折扣。
 */


/**
 * 抽象策略
 */
interface MemberStrategy{
    //打折
    double calcPrice(double price);
}
/**
 * 具体策略角色(初级会员) 不打折
 */
class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double price) {
        return price;
    }
}
/**
 * 具体策略角色(中级会员) 打折10%
 */
class IntermediateMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double price) {
        return price*0.9;
    }
}
/**
 * 具体策略角色(高级会员) 打折20%
 */
class AdvancedMemberStrategy  implements MemberStrategy {

    @Override
    public double calcPrice(double price) {
        return price*0.8;
    }
}

/**
 * 环境角色（持有策略角色的引用）
 */
class Price{
    private MemberStrategy strategy;

    public Price(MemberStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * @param price 原价
     * @return
     */
    public double price(double price){
        return strategy.calcPrice(price);
    }
}


public class StrategyTest {
    public static void main(String[] args) {
        //初级会员
        Price price1 = new Price(new PrimaryMemberStrategy());
        System.out.println(price1.price(100));
        //中级会员
        Price price2 = new Price(new IntermediateMemberStrategy());
        System.out.println(price2.price(100));
        //高级会员
        Price price3 = new Price(new AdvancedMemberStrategy());
        System.out.println(price3.price(100));
    }

}
