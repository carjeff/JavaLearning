package study.anomymousInnerClass;

/**
 * @author Jason
 * @date 2022/7/8 10:54
 * @Description
 */
public class Test2 {
    public static void main(String[] args) {
        Swimming swimming = new Swimming() {
            @Override
            public void swim() {
                System.out.println("学生快乐的自由游泳");
            }
        };
        go(swimming);
        go(new Swimming() {
            @Override
            public void swim() {
                System.out.println("运动员参加游泳比赛");
            }
        });
    }
    public static void go(Swimming swimming){
        System.out.println("开始");
        swimming.swim();
        System.out.println("结束");
    }
}


interface Swimming{
    void swim();
}