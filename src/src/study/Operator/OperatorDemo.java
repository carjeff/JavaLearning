package study.Operator;

/**
 * @author Jason
 * @date 2022/7/5
 * @apiNote
 * 自增自减运算符
 */
public class OperatorDemo {
    public static void main(String[] args) {

        //++在左边，先加上1在运算，
        //右边++， 先运算再自己加1
        int k = 3;
        int p = 5;
        // k  3 4 5 4
        // p  5 4 3 4
        // rs    3     5     4     4     5     4
        int rs = k++ + ++k - --p + p-- - k-- + ++p + 2;
        System.out.println(k); //4
        System.out.println(p); //4
        System.out.println(rs); //9
    }
}
