package study.lambda;


/**
 * @author Jason
 * @date 2022/7/11 14:02
 * @Description
 */
public class LambdaDemo {
    public static void main(String[] args) {
        Animal a = new Animal() {
            @Override
            public void run() {
                System.out.println("乌龟跑得快");
            }
        };

        Swimming s1 = new Swimming() {
            @Override
            public void swim() {
                System.out.println("djkd");
            }
        };


        Swimming s2 = () -> {
            System.out.println("老师");
        };
        go(s2);


        go(() -> {
            System.out.println("jsdljkj");
        });
    }
    public static void go(Swimming swimming){
        System.out.println("skdj");
    }
}
abstract class Animal{
    public abstract void run();
}

@FunctionalInterface
interface Swimming{
    void swim();
}