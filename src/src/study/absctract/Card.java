package study.absctract;

/**
 * @author Jason
 * @date 2022/7/7 15:20
 * @Description
 */
public abstract class Card {
    private String userName; //用户名
    private double money; //余额


    //定义一个支付方法

    public abstract void pay(double money);

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
