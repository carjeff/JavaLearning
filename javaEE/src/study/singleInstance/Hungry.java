package study.singleInstance;

/**
 * @author Jason
 * @date 2022/7/7 10:51
 * @Description
 *
 * 饿汉单例设计模式
 */
public class Hungry {

    /*
        必须把构造器私有化
     */
    private Hungry(){}

    //创建一个对象，用静态成员变量存储一个对象
    public static Hungry hungry = new Hungry();
}
