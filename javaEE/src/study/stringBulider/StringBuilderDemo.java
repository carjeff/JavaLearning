package study.stringBulider;

/**
 * @author Jason
 * @date 2022/7/8 16:15
 * @Description
 */
public class StringBuilderDemo {
    public static void main(String[] args) {

    }


    public static String toString(int[] arr){
        if (arr != null) {
            StringBuilder s = new StringBuilder();
            s.append("[");
            for (int i = 0; i < arr.length; i++) {
                s.append(arr[i]).append(i == arr.length - 1 ? "" : ", ");
            }
            s.append("]");
            return s.toString();
        }else {
            return null;
        }
    }
}
