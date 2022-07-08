package study.anomymousInnerClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jason
 * @date 2022/7/8 11:00
 * @Description 通过gui编程，理解匿名内部类的真实使用场景
 */
public class Test3 {
    public static void main(String[] args) {
        JFrame win = new JFrame("登录界面");

        JButton button = new JButton("登录");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击一下");
            }
        });

        win.add(new JPanel());

        win.add(button);
        win.setSize(400,400);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
    }
}
