package project.ATM;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Jason
 * @date 2022/7/6 20:38
 * @Description
 *  模拟ATM系统项目
 */
public class ATMSystem {
    public static void main(String[] args) {
        // 定义一个集合，负责存储全部账户
        ArrayList<Account> accounts = new ArrayList<>();

        // 展示系统首页
        while (true) {
            System.out.println("================ATM系统=================");
            System.out.println("1.账户登录");
            System.out.println("2.账户开户");
            Scanner scanner = new Scanner(System.in);
            System.out.println("请您选择操作：");
            int command = scanner.nextInt();
            switch (command){
                case 1:
                    //用户登录
                    login(accounts, scanner);
                    break;
                case 2:
                    //用户开户
                    register(accounts,scanner);
                    break;
                default:
                    System.out.println("您输入的命令不存在！");
            }
        }

    }

    /**
     * 用户登录
     * @param accounts
     * @param scanner
     */
    private static void login(ArrayList<Account> accounts, Scanner scanner) {
        System.out.println("==================系统登录操作========================");
        if (accounts.size() == 0){
            System.out.println("对不起，当前系统中无任何账户，请先开户，再来登录");
            return;
        }

        //正式登录
        while (true) {
            System.out.println("请您输入登录卡号：");
            String cardId = scanner.next();
            Account acc = getAccountByCardId(cardId, accounts);
            if (acc != null){
                while (true) {
                    System.out.println("请您输入密码：");
                    String password = scanner.next();
                    if (acc.getPassword().equals(password)){
                        //登录成功
                        System.out.println("恭喜您，" + acc.getUserName() + "进入系统，您的卡号是：" + acc.getCardId());
                        //展示登录操作页
                        showUserCommand(scanner, acc);
                        return;

                    }else {
                        System.out.println("对不起，您输入的密码不正确，请重新输入。");
                    }
                }
            }else {
                System.out.println("对不起，系统中不存在该卡号");
            }
        }
    }

    /**
     * 展示登录后的操作页
     */
    private static void showUserCommand(Scanner scanner, Account account) {
        while (true) {
            System.out.println("===============用户操作页============================");
            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出");
            System.out.println("7.注销账户");
            System.out.println("请选择您要的操作：");
            int command = scanner.nextInt();
            switch (command){
                case 1:
                    //查询账户
                    showAccount(account);
                    break;
                case 2:
                    //存款
                    depositeMoney(account, scanner);
                    break;
                case 3:
                    //取款
                    drawMoney(account, scanner);
                    break;
                case 4:
                case 5:
                case 6:
                    //退出账户
                    System.out.println("退出成功！");
                    return;
                case 7:
                default:
                    System.out.println("您输入的操作命令不正确！");
            }
        }

    }

    /**
     * 取钱
     * @param account
     * @param scanner
     */
    private static void drawMoney(Account account, Scanner scanner) {
        System.out.println("=============用户取钱操作=================");
        //判断是否有足够钱
        if (account.getMoney() < 100){
            System.out.println("对不起，当前账户中不足100元，不能取钱");
            return;
        }

        while (true) {
            System.out.println("请您输入取款金额：");
            double money = scanner.nextDouble();

            if (money > account.getQuotaMoney()){
                System.out.println("对不起，您当前取款金额超过限额，每次最多取" + account.getQuotaMoney() + "元");
            }else {
                if (money > account.getMoney()){
                    System.out.println("余额不足！");
                }else {
                    //可以取钱
                    System.out.println("恭喜您，取" + money + "元，成功");
                    account.setMoney(account.getMoney() - money);
                    showAccount(account);
                    return;
                }
            }
        }

    }

    /**
     * 存款的方法
     * @param account
     */
    private static void depositeMoney(Account account, Scanner scanner) {
        System.out.println("==================用户存款操作==========================");
        System.out.println("请输入您要存的金额：");
        double money = scanner.nextDouble();
        account.setMoney(account.getMoney() + money);
        System.out.println("恭喜您，存钱成功，当前账户信息如下");
        showAccount(account);
    }

    /**
     * 展示账户信息
     * @param account
     */
    private static void showAccount(Account account) {
        System.out.println("=============当前账户信息如下=============");
        System.out.println("卡号：" + account.getCardId());
        System.out.println("用户名：" + account.getUserName());
        System.out.println("余额：" + account.getMoney());
        System.out.println("限额：" + account.getQuotaMoney());
    }

    /**
     * 用户开户的功能实现
     * @param accounts
     */
    private static void register(ArrayList<Account> accounts, Scanner scanner){
        System.out.println("==================系统开户操作========================");

        Account account = new Account();

        System.out.println("请您输入账户用户名：");
        String userName = scanner.next();
        account.setUserName(userName);

        while (true) {
            System.out.println("请您输入账户密码：");
            String password = scanner.next();
            System.out.println("请您确认密码：");
            String okPassword = scanner.next();
            if (okPassword.equals(password)){
                account.setPassword(password);
                break;
            }else {
                System.out.println("密码不一致，请重新输入");
            }
        }

        System.out.println("请您输入当次限额：");
        double quoteMoney = scanner.nextDouble();
        account.setQuotaMoney(quoteMoney);

        //为账户随机生成一个8位且不重复的卡号
        String randomCardId = getRandomCardId(accounts);
        account.setCardId(randomCardId);

        //账户添加到集合中去
        accounts.add(account);
        System.out.println("恭喜你，" + userName + "您开户成功，您的卡号是：" + randomCardId);

    }

    /**
     * 随机生成一个卡号
     * @param accounts
     * @return
     */
    private static String getRandomCardId(ArrayList<Account> accounts) {
        Random r = new Random();
        while (true) {
            String cardId = "";
            //生成随机的卡号
            for (int i = 0; i < 8; i++){
                cardId += r.nextInt(10);
            }

            //判断卡号和是否和其他账户重复了
            Account acc = getAccountByCardId(cardId, accounts);
            if (acc == null){
                return cardId;
            }
        }
    }

    /**
     * 根据卡号去查询一个账户
     * @param cardId
     * @param accounts
     * @return
     */
    private static Account getAccountByCardId(String cardId, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (account.getCardId().equals(cardId)) {
                return account;
            }
        }
        return null;
    }
}
