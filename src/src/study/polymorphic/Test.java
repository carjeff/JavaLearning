package study.polymorphic;

/**
 * @author Jason
 * @date 2022/7/8 09:45
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer("外星人");
        computer.run();

        USB usb = new Keyboard("shaung");
        computer.installUSB(usb);
    }
}
