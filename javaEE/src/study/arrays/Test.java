package study.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jason
 * @date 2022/7/11 11:35
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("都看见",23,180);
        students[1] = new Student("呃呃呃",223,170);
        students[2] = new Student("发扣扣",24,180);

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(Arrays.toString(students));


   }
}
