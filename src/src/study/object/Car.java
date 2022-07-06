package study.object;

/**
 * @author Jason
 * @date 2022/7/6 16:20
 * @Description
 */
public class Car {
    String name;
    double prize;
    public Car(){
        System.out.println("无参数构造器中的this"+ this);
    }
    public Car(String name, double prize){
        this.name = name;
        this.prize = prize;
    }

    public void goWith(String name){
        System.out.println(this.name + "正在和" + name + "比赛");

    }

    public void run(){
        System.out.println("方法中的this" + this);
    }
}
