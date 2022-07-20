package study.singleInstance;

/**
 * @author Jason
 * @date 2022/7/7 10:57
 * @Description
 *
 * 懒汉单例设计模式
 */
public class Lan {
    //私有化构造器
    private Lan(){
    }

    //定义一个静态成员变量，存储单例对象,不初始化
    private static Lan instance;

    //定义一个方法，对外返回单例对象
    public static Lan getInstance(){
        if (instance == null){
            instance = new Lan();
        }
        return instance;
    }

}
