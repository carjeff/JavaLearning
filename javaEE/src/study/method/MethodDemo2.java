package study.method;

/**
 * @author Jason
 * @date 2022/7/6 14:16
 * @Description   引用类型的参数传递机制
 */
public class MethodDemo2 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};

        change(arr);

        System.out.println(arr[1]); //222
    }

    public static void change(int[] arrs){
        System.out.println(arrs[1]); //20

        arrs[1] = 222;

        System.out.println(arrs[1]); //222
    }


}
