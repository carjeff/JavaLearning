package study.method;

/**
 * @author Jason
 * @date 2022/7/6 14:27
 * @Description 方法重载
 */
public class Overload {
    public static void main(String[] args) {
        fire();

        int n = 5 ;
        String location = "美国";

        fire(location);

        fire(n, location);
    }

    public static void fire(){
//        System.out.println("发射一枚火箭");
        fire("美国");
        //方法重载可以互相调用，简化代码规范
    }

    public static void fire(String location){
        System.out.println("发射一枚火箭到" + location);
    }
    public static void fire(int n, String location){
        System.out.println("发射" + n + "枚火箭到" + location);
    }
}
