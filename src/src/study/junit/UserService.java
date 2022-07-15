package study.junit;

/**
 * @author Jason
 * @date 2022/7/15 15:30
 * @Description
 */
public class UserService {
    public String loginName(String loginName, String password){
        if ("admin".equals(loginName) && "123456".equals(password)){
            return "登录成功";
        }else {
            return "用户名或者密码错误";
        }
    }

    public void selectNames(){
        System.out.println(10/0);
    }
}
