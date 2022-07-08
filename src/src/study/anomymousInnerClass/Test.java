package study.anomymousInnerClass;

/**
 * @author Jason
 * @date 2022/7/8 10:48
 * @Description 匿名内部类
 */
public class Test {
    public static void main(String[] args) {
        Animal a = new Animal() {
            @Override
            public void run() {
                System.out.println("老虎跑的快");
            }
        };
        a.run();
    }
}
