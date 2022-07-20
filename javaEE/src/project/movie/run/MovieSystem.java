package project.movie.run;

import project.movie.bean.Business;
import project.movie.bean.Customer;
import project.movie.bean.Movie;
import project.movie.bean.User;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Jason
 * @date 2022/7/13 13:45
 * @Description
 */
public class MovieSystem {

    //定义系统的数据容器用于用户存储数据

    public static final List<User> ALL_USERS = new ArrayList<>();

    //存储系统全部商家和排片信息
    public static final Map<Business, List<Movie>> ALL_MOVIES = new HashMap<>();

    public static final Scanner SCANNER = new Scanner(System.in);

    //定义一个静态的user变量记住当前登录的用户
    public static User LOGIN_USER = new User();

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    //准备一些测试数据
    static {
        Customer c1 = new Customer();
        c1.setLoginName("zyf888");
        c1.setPassword("123456");
        c1.setUserName("黑马刘德华");
        c1.setSex('男');
        c1.setMoney(10000);
        c1.setPhone("12321312");
        ALL_USERS.add(c1);

        Customer c2 = new Customer();
        c2.setLoginName("gzl888");
        c2.setPassword("1234526");
        c2.setUserName("黑马关之琳");
        c2.setSex('女');
        c2.setMoney(2000);
        c2.setPhone("1231312");
        ALL_USERS.add(c2);

        Business b = new Business();
        b.setLoginName("baozupo");
        b.setPassword("123456");
        b.setUserName("包租婆");
        b.setMoney(0);
        b.setSex('男');
        b.setPhone("12314141");
        b.setAddress("火星6号三楼");
        b.setShopName("甜甜圈国际影城");
        ALL_USERS.add(b);
        List<Movie> movies = new ArrayList<>();
        ALL_MOVIES.put(b, movies);

        Business b1 = new Business();
        b1.setLoginName("chezijie");
        b1.setPassword("1234526");
        b1.setUserName("车子杰");
        b1.setMoney(0);
        b1.setSex('女');
        b1.setPhone("123142341");
        b1.setAddress("火星三号楼三层");
        b1.setShopName("万达国际影城");
        ALL_USERS.add(b1);
        List<Movie> movies3 = new ArrayList<>();
        ALL_MOVIES.put(b1, movies3);

    }
    public static void main(String[] args) {
        showMain();

    }

    /**
     * 展示首页
     */
    private static void showMain() {
        while (true) {
            System.out.println("===============电影购票首页=======================");
            System.out.println("1. 登录");
            System.out.println("2. 用户注册");
            System.out.println("3. 商家注册");
            System.out.println("请输入操作命令");
            String command = SCANNER.nextLine();

            switch (command){
                case "1":
                    //登录
                    login();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    System.out.println("命令有误，请重新输入！");

            }
        }
    }

    /**
     * 登录
     */
    private static void login() {
        while (true) {
            System.out.println("请输入登录名称：");
            String loginName = SCANNER.nextLine();
            System.out.println("请输入密码：");
            String password = SCANNER.nextLine();
            //根据登录名称查询用户对象
            User user = getUserByLoginName(loginName);
            if (user != null){
                if (user.getPassword().equals(password)){
                    //登录成功
                    LOGIN_USER = user;
                    //判断是用户登录还是商家登录
                    if (user instanceof Customer){
                        //登录普通用户
                        showCustomerMain();
                    }else if (user instanceof Business){
                        //登录商家用户
                        showBusinessMain();
                    }
                    return;
                }else {
                    System.out.println("密码有误，请重新输入!");
                }
            }else {
                System.out.println("登录名称有误，请重新输入！");
            }
        }
    }

    /**
     * 商家后台操作页面
     */
    private static void showBusinessMain() {
        while (true){
            System.out.println("================电影商家后台操作页面=======================");
            System.out.println(LOGIN_USER.getUserName() + (LOGIN_USER.getSex()=='男' ? "先生": "女士") + "欢迎您！");
            System.out.println("1. 展示详情：");
            System.out.println("2. 上架电影：");
            System.out.println("3. 下架电影：");
            System.out.println("4. 修改电影：");
            System.out.println("5. 退出: ");
            System.out.println("请输入您要操作的命令");
            String command = SCANNER.nextLine();
            switch (command){
                case "1":
                    //展示商家的详细信息
                    showBusinessInfos();
                    break;
                case "2":
                    //上架电影
                    addMovie();
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("退出成功！");
                    return;
                default:
                    System.out.println("您输入的命令有误，请重新输入!");
            }
        }
    }

    /**
     * 添加电影
     */
    private static void addMovie() {
        Business business = (Business) LOGIN_USER;
        List<Movie> movies = ALL_MOVIES.get(business);

        System.out.println("请您输入新片名：");
        String name = SCANNER.nextLine();
        System.out.println("请您输入主演：");
        String actor = SCANNER.nextLine();
        System.out.println("请您输入时长：");
        String time = SCANNER.nextLine();
        System.out.println("请您输入票价：");
        String price = SCANNER.nextLine();
        System.out.println("请您输入票数：");
        String totalNumber = SCANNER.nextLine();


        while (true) {
            try {
                System.out.println("请您输入影片放映时间：");
                String startTime = SCANNER.nextLine();
                Movie movie = new Movie(name, actor, Double.valueOf(time), Double.valueOf(price),
                        Integer.valueOf(totalNumber), sdf.parse(startTime));
                movies.add(movie);
                System.out.println("您已经成功上架了"+movie.getName()+"影片");
                return;
            } catch (Exception e) {
                System.out.println("输入信息有误，请重新输入");
                e.printStackTrace();
            }
        }

    }

    /**
     * 展示商家的详细信息
     */
    private static void showBusinessInfos() {
        Business business = (Business) LOGIN_USER;
        System.out.println(business.getShopName()+"   "+ "地址： " + business.getAddress());
        //根据商家对象，作为map的键，提取对应的值
        List<Movie> movies = ALL_MOVIES.get(LOGIN_USER);
        if (movies.size() > 0) {
            for (Movie movie : movies) {
                System.out.println(movie.getName()+"\t\t\t" + movie.getActor()+"\t\t\t" + movie.getTime()+"\t\t\t"+movie.getScore()+"\t\t\t"
                + sdf.format(movie.getStartTime()));
            }
        }else {
            System.out.println("您的店铺当前无片可播！");
        }

    }

    /**
     * 普通用户操作页面
     */
    private static void showCustomerMain() {
        System.out.println("================电影用户操作页面=======================");
        System.out.println(LOGIN_USER.getUserName() + (LOGIN_USER.getSex()=='男' ? "先生": "女士") + "欢迎您！");
        System.out.println("1. 展示全部影片信息：");
        System.out.println("2. 根据电影名称查询电影信息：");
        System.out.println("3. 评分功能：");
        System.out.println("4. 购票系统：");
        System.out.println("5. 退出系统: ");
        while (true){
            System.out.println("请输入您要操作的命令");
            String command = SCANNER.nextLine();
            switch (command){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    return;
                default:
                    System.out.println("您输入的命令有误，请重新输入!");
            }
        }
    }

    public static User getUserByLoginName(String loginName){
        for (User user : ALL_USERS) {
            if (user.getLoginName().equals(loginName)){
                return user;
            }
        }
        return null;
    }
}
