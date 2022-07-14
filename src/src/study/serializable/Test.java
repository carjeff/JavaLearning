package study.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author Jason
 * @date 2022/7/14 14:35
 * @Description
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Student s = new Student("车子杰","chezijie","12312",21);
        //对象序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/src/study/serializable/obj.txt"));

        oos.writeObject(s);
        oos.close();
    }
}
