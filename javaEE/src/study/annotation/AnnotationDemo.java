package study.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Jason
 * @date 2022/7/18 09:40
 * @Description
 */

public class AnnotationDemo {
    @Mytest
    public void test1(){
        System.out.println("test1");
    }


    public void test2(){
        System.out.println("test2");
    }


    @Mytest
    public void test3(){
        System.out.println("test3");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        AnnotationDemo t = new AnnotationDemo();
        Class c = AnnotationDemo.class;
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Mytest.class)){
                method.invoke(t);
            }
        }
    }
}
