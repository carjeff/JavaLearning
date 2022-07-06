package study.array;

/**
 * @author Jason
 * @date 2022/7/6
 * @apiNote
 * 冒泡排序算法
 */
public class BubbleArray {
    public static void main(String[] args) {
        //定义一个初始数组
        int[] arr = {5, 2, 3, 1};
        //第一个for是外面的轮数
        //
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++){
                //判断当前j位置的元素值
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
