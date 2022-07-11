package Algorithm;

import java.util.Arrays;

/**
 * @author Jason
 * @date 2022/7/11 13:48
 * @Description 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5,1,3,2};
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = i +1; j<arr.length; j++){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
