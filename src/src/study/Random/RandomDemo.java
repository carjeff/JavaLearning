package study.Random;

import java.util.Random;

/**
 * @author Jason
 * @date 2022/7/6
 * @apiNote
 * 随机数类
 */
public class RandomDemo {
    public static void main(String[] args) {
        Random r = new Random();
        int i = r.nextInt(10);
        System.out.println(i);
    }
}
