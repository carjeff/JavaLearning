package Algorithm;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Jason
 * @date 2022/7/6 14:41
 * @Description  模拟双色球系统
 *
 * 1. 随机生成一组中奖号码，中奖号码由6个红色球，1个蓝色球组成，红色球从1-33中选择，蓝色球从1-16中选择
 * 2. 用户输入一组号码
 * 3. 进行比对判断，是否中奖
 */
public class DoubleBoll {
    public static void main(String[] args) {
        int[] prize = generatePrize();
        System.out.print("中奖号码为：");
        printArray(prize);

        int[] numbers = inputPrize();
        System.out.println("用户号码为：");
        printArray(numbers);

    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] + "\n" : arr[i] + " ");
        }
    }
    //随机生成一组中奖号码
    public static int[] generatePrize(){
        int[] prize = new int[7];

        prize[0] = randomRedBoll();
        int num = 1; //用于计数
        while (num < 6){
            int r = randomRedBoll();
            if (!isExitRed(r,prize)){
                prize[num] = r;
                num++;
            }
        }
        prize[6] = randomBlueBoll();
        return prize;
    }

    //随机生成一个红色号码球
    public static int randomRedBoll(){
        Random random = new Random();
        int i = random.nextInt(33) + 1;
        return i;
    }
    //随机生成一个蓝色号码球
    public static int randomBlueBoll(){
        Random random = new Random();
        int i = random.nextInt(16) + 1;
        return i;
    }
    //判断红色号码球是否出现过
    public static boolean isExitRed(int r, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (r == arr[i]){
                return true;
            }
        }
        return false;
    }

    //用户输入一组号码
    public static int[] inputPrize(){
        int[] numbers = new int[7];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入六个红色球号码");
        for (int i = 0; i < numbers.length - 1; i++) {
            int red = scanner.nextInt();
            if (red > 0 && red < 34) {
                numbers[i] = red;
            }
        }
        System.out.println("请输入1个蓝色球号码");
        int blue = scanner.nextInt();
        if (blue > 0 && blue < 17){
            numbers[6] = blue;
        }
        return numbers;
    }

    //判断是否中奖
    public static void judge(int[] prize, int[] userNumbers) {
        int redHitNumber = 0; //红球命中数
        int blueHitNumber = 0; //蓝球命中数

        for (int i = 0; i < userNumbers.length - 1; i++) {
            for (int j = 0; j < prize.length - 1; j++) {
                if (userNumbers[i] == prize[j]) {
                    redHitNumber++;
                    break;
                }
            }
        }

        blueHitNumber = userNumbers[6] == prize[6] ? 1 : 0;
    }


}


