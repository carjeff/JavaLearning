package study.Switch;

/**
 * @author Jason
 * @date 2022/7/6
 * @apiNote
 */
public class SwitchDemo {
    public static void main(String[] args) {
        //需求：用户输入月份可以展示该月份的天数。
        //

        int month = 7;
        switch (month){
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("switch的穿透性");
                break;
        }
    }
}
