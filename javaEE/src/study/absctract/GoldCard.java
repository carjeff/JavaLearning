package study.absctract;

/**
 * @author Jason
 * @date 2022/7/7 15:22
 * @Description
 */
public class GoldCard extends Card{
    @Override
    public void pay(double money) {
        System.out.println("您当前消费" + money);
        System.out.println("您当前的余额为： " + getMoney());
        //优惠价
        double rs = money * 0.8;
        System.out.println("您实际支付：" + rs);
        setMoney(getMoney() - rs);
    }
}
