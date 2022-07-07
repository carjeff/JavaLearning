package study.verificationCode;

import java.util.Random;

/**
 * @author Jason
 * @date 2022/7/7 10:15
 * @Description
 * 简单的验证码生成
 *
 */
public class VerificationCode {

    public static void main(String[] args) {
        //1. 定义一个变量记住验证码
        String code = "";
        //2. 定义一个变量记住全部验证码字符
        String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        //3. 定义一个循环生成几个随机索引，去得到几个字符
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            //4. 获取随机索引对应的字符，链接给code
            int index = r.nextInt(data.length());
            code += data.charAt(index);
        }
        System.out.println("验证码：" + code);
    }
}
