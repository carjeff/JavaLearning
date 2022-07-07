package study.absctract;

/**
 * @author Jason
 * @date 2022/7/7 15:20
 * @Description
 * 抽象类
 */
public class Test {
    public static void main(String[] args) {
        GoldCard goldCard = new GoldCard();
        goldCard.setMoney(10000);
        goldCard.pay(300);
        System.out.println("您当前的余额：" + goldCard.getMoney());
    }
}
