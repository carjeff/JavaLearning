package study.polymorphic;

/**
 * @author Jason
 * @date 2022/7/8 09:46
 * @Description
 */
public class Keyboard implements USB{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Keyboard(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println(name + "成功连接电脑");
    }

    @Override
    public void unconnect() {
        System.out.println(name + "成功从电脑拔出");
    }

    public void keydown(){
        System.out.println(name + "打字了");
    }
}
