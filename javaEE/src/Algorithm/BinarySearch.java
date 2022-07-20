package Algorithm;

import java.util.Arrays;

/**
 * @author Jason
 * @date 2022/7/11 13:55
 * @Description 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {12,3,4,53,2,34,22,55};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, 355));
    }

    /**
     *
     * @param arr
     * @param data
     * @return
     */
    public static int binarySearch(int[] arr, int data){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left+right)/2;
            if (arr[mid] < data) {
                left = mid + 1;
            }else if (arr[mid] > data){
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
