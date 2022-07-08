package study.polymorphic;

/**
 * @author Jason
 * @date 2022/7/8 09:50
 * @Description
 */
public class Computer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Computer(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println(name + "开机了");
    }

    public void installUSB(USB usb){
        //多态
        usb.connect();
        if (usb instanceof Keyboard){
            Keyboard keyboard = (Keyboard) usb;
            keyboard.keydown();
        }else if (usb instanceof Mouse){
            Mouse mouse = (Mouse) usb;
            mouse.click();
        }

        usb.unconnect();
    }
}
