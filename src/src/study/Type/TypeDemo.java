package study.Type;

/**
 * @author Jason
 * @date 2022/7/5
 * @apiNote
 * 了解自动类型转换，表达式的自动类型转换，强制类型转换
 */
public class TypeDemo {
    public static void main(String[] args) {
        //类型范围小的变量，可以直接赋值给类型范围大的变量

        //byte ——> short ——> int -> long -> float -> double
        // char -> int
        byte a = 12;
        int b = a;
        System.out.println(b); //12

        char ch = 'a';
        int c = ch;
        System.out.println(c); //97 输出的是a对应的ascaii码

        //表达式中的自动类型转换
        //表达式中的最终结果由表达式中的最高类型决定。

        double kk = a + b - 2.3;
        //面试题
        byte i = 10;
        byte j = 20;
        int k = i + j; //byte 在运算过程中 由 int 去运算

        //强制类型转换
        //类型范围大的数据或者变量，不能直接赋值给类型范围小的变量
        //浮点型数据类型转换成整形数据类型，直接剔除小数部分，返回整数部分。
        int x = 10;
        byte y = (byte) x;
        System.out.println(y);//10 没有问题

        int r = 1500;
        byte o = (byte) r;
        System.out.println(o); //-36 强制转换会丢失数据  强制转换的快捷键是 win：ALT + enter  mac：option + enter




    }
}
