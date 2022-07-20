package study.method;

/**
 * @author Jason
 * @date 2022/7/6
 * @apiNote
 */
public class MethodDemo1 {
    public static void main(String[] args) {
        int sum = sum(100, 200);
        System.out.println(sum);
    }

    public static int sum(int a, int b){
        int c = a + b;
        return c;
    }

    //求1——n的和
    public static int sumN(int n){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i+1;
        }
        return sum;
    }
}
