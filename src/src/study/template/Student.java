package study.template;

/**
 * @author Jason
 * @date 2022/7/7 15:35
 * @Description 模版方法设计模式
 */
public abstract class Student {

    public final void write(){
        System.out.println("标题");
        System.out.println("第一段内容一样");

        System.out.println(writeMain());
        System.out.println("最后一段内容一样");
    }
    public abstract String writeMain();
}
