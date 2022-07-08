package study.polymorphic;

/**
 * @author Jason
 * @date 2022/7/8 09:48
 * @Description
 */
public class Mouse implements USB{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mouse(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println(name + "成功连接了电脑");
    }

    @Override
    public void unconnect() {
        System.out.println(name + "成功从电脑上拔出");
    }

    public void click(){
        System.out.println(name + "s双击了");
    }
}
