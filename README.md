# JavaLearning
> 本仓库主要存放JAVA学习的一些笔记，演示代码，心得，根据实际学习进行适当的更新。
还会针对LeetCode，牛客网一些具体算法题，进行学习，理解。

[toc]
## Day1 2022/7/5
1. 配置IDEA，Pycharm，vscode等必备软件。准备好JAVA的相关书籍。
2. 重新复习了java的强制类型转换，运算符的一些知识，自增自减，三元运算符，Scanner等。

## Day2 2022/7/6
1. 整体过了一遍java基础的知识，包括数组，集合，方法等
2. 还跟着编写一个ATM的案例
3. String = "kkk", 在字符串常量池中生成独一份，不能被更改
4. 

## Day3 2022/7/7
1. 静态成员变量static，推荐用类去使用，User.onlineNumber.
2. 静态成员方法，如果该方法执行的是一个共用功能，不访问对象的成员变量。
3. 静态方法只能访问静态成员，不可以直接访问实例成员，不能出现this关键词
4. 由于工具类无需创建对象，可以把构造器私有化
5. static {} 静态代码块，可以用于初始化静态资源

### 单例设计模式
可以保证系统中，应用该模式的这个类永远只有一个实例，即一个类永远只能创建一个对象
#### 饿汉单例设计模式
1. 定义一个类，把构造器私有
2. 定义一个静态变量存储一个对象

#### 懒汉单例设计模式
在真正需要该对象的时候，才去创建一个对象（延迟加载对象）
1. 定义一个类，把构造器私有
2. 定义一个静态变量存储一个对象，不能初始化
3. 提供一个返回单例对象的方法

### 继承
extend关键字
提高代码的复用性，减少代码冗余，增强类的功能扩展性
#### 特点
1. 子类可以继承父类的属性和行为，但是不能继承构造器
2. Java是单继承，不支持多继承
3. Object是祖宗类，所有类默认继承Object类
4. 指定找父类成员，用super

#### 方法重写 override
@Override 重写校验注解，更安全，提高程序的可读性
1. 私有方法不能被重写
2. 重写方法的名称，形参都要完全一致
3. 子类访问权限必须大于或等于父类
4. 不能重写静态方法

#### 继承的构造器特点
1. 子类中所有的构造器默认都会先访问父类中的无参数构造器，再执行自己的构造器
2. 初始化父类数据空间
3. 子类构造器的第一行默认语句是 super()

### 权限修饰符
1. 由小到大： private -> 缺省 -> protected -> public

### final 关键词
1. 修饰类：类不能够被继承
2. 修饰方法：方法不能被重写
3. 修饰变量：变量只能赋值一次
4. final修饰的引用类型的变量，地址不能更改，但是地址指向的对象内容是可以更改的

### 常量
1. 使用 public static final 修饰的成员变量
2. 常量全部用大写，多个单词用下划线连接
3. 可以用作信息标识和分类

### 枚举类型 enum
1. ```enum Season{SPRING, SUMMER, AUTUMN, WINTER}```
2. 用作信息的标志和信息的分类
3. 多例模式

### 抽象类 abstract
1. 当父类知道子类一定要完成某些行为，但是每个子类该行为的实现又不同，
2. 抽象类不能创建对象

### 模版方法模式
> 当系统中出现同一个功能多处在开发，而该功能大部分代码都一样，只有其中部分不同的时候，使用模版方法模式
1. 模版方法最好用final修饰，不允许被重写
2. 提高代码的复用性

### 接口 interface
1. jdk8之前，接口只有常量和抽象方法
2. 接口是一种规范，规范一定是公开的
3. 代码层面，public abstract ，public static final可以不写


#### 实现接口 implements 
1. 实现类可以实现多个接口，多实现 implements
2. 一个接口可以继承多个接口，多继承 extends 
3. 接口的静态方法只能自己调用，

#### jdk8之后的接口改变
1. 默认方法，必须default修饰，默认用public修饰。接口不能创建对象，这个方法只能由实现类的对象去调用
2. 静态方法，必须static修饰，默认用public修饰。接口的静态方法必须由接口名自己去调用
3. 私有方法（jdk9之后才支持），必须用private修饰。必须在接口内部才能被访问


## Day4
 
### 多态 polymorphic
> 父类类型 对象名称 = new 子类构造器

#### 多态中成员访问特点
1. 方法调用：编译看左边，运行看右边
2. 变量调用：编译看左边，运行也看左边（多态侧重行为多态）

#### 多态的优势
1. 在多态形势下，右边对象可以实现解耦合（互相依赖不强），便于维护和扩展
2. 定义方法时，使用父类型作为参数，该方法就可以接收这父类的一切子类，体现便利和扩展性

#### 多态下不能使用子类独有的功能
1. 强制类型转换解决此弊端
2. 用instanceof进行判断
3. ClassCastException 类型转换异常

### 内部类
1. 静态内部类，static修饰，
2. 成员内部类，不能用static修饰 ``` Outer.Inner in = new Outer().new Inner();```
3. 局部内部类，

#### 匿名内部类
1. 本质上是一个没有名字的局部内部类，定义在方法中，代码块中
2. 作用，方便创建子类对象，最终目的为了简化代码编写
3. 监听器普遍使用

### Object类
1. toString 方法 
2. equals 方法

### StringBuilder
1. 是一个可变的字符串类
2. 提高字符串的操作效率，如拼接，修改
3. 支持链式编程 ```s.append("a").append("b").append("c");```

### BigDecimal 大数据对象
解决浮点型运算精度失真问题
```java
class BigDecimal {
        BigDecimal b = BigDecimal.valueOf(a);  
        }
```
## Day5 2022/7/11

### SimpleDateFormat 格式化时间对象类
1. ```
    SimpleDateFormat sdf = new SimpleDateFromat("yyyy年MM月dd日");
    ```
### Calendar 日历抽象类
``` Calendar cal = Calendar.getInstance();```

### 包装类
1. 8种基本数据类型对应的引用类型
2. 自动装箱和自动拆箱
3. 可以把字符串类型的数值转换成真实的整数

### 正则表达式 regex
1. 用于校验数据
2. String.matches 匹配正则表达式

### Arrays 数组类
1. Arrays.sort()
2. Arrays.binarySearch()
3. 使用Comparator 进行规则的制定

### Lambda 表达式
1. 简化匿名内部类的代码写法
2. 只能简化函数式接口的匿名内部类写法
3. 函数式接口：必须是接口，其次接口只有一个抽象方法,一般用@FunctionalInterface注解
4. 省略规则！

### 集合 
1. collection 单列集合
2. map 双列集合

#### Collection
1. List系列集合，添加的元素是有序的可重复的，有索引。ArrayList,LinkedList
2. Set系列集合,添加的元素是无序，不重复，无索引。
3. HashSet 无序，不重复，无索引
4. LinkedHashSet 有序
5. TreeSet 有排序

#### 集合的遍历
1. iterator 迭代器
2. 增强for 遍历
3. forEach 

### 数据结构
1. 栈：后进先出，先进后出
2. 队列： 先进先出，后进后出
3. 数组
4. 链表
5. 二叉查找/排序/搜素树： 
6. 平衡二叉树：左旋右旋
7. 红黑树


## Day6 2022/7/12
### Map集合
1. Map集合是一种双列集合，健值对 key = value
2. 健是无序，不重复的，无索引
3. 健值都可以为null

### 不可变集合
1. 使用 of ``` List<Integer> list = List.of(122,12,423,443)```

### Stream流
1. 支持链式编程，
2. 有终结方法
3. map.entrySet().stream(); 健值对流

#### stream 方法
1. filter()
2. map() 加工方法

### 运行时异常
1. ArrayIndexOutOfBoundsException 数组越界异常
2. NullPointerException 空指针异常
3. ClassCastException 类型转换异常
4. ArithmeticException 数学操作异常
5. NumberFormatException 数字转换异常

### 编译时异常
1. throws Exception 抛异常
2. try/catch
3. 方法去抛异常，调用者处理异常

### 自定义异常
1. throw new 异常 抛出
2. 

## Day7 
### 日志
1. 常见的规范：commons logging 和 simple logging facade for java 
2. logback 日志框架

#### Logback 需要的模块
1. slf4j-api
2. logback-core
3. logback-classic

#### Logback  日志输出位置，格式
1. logback.xml 中的<append>标签可以设置
2. 通常可以设置两个位置，控制台，和系统文件

### File 文件对象
1. 定位文件，获取文件信息，删除文件，创建文件
2. 支持绝对路径
3. 也支持相对路径！！相对到工程下！从模块开始，模块名/a.txt

#### listFiles()
只能遍历一级文件对象

### recursion 递归
1. 直接递归
2. 间接递归
3. 如果没有控制好终止，会出现递归死循环，出现栈内存溢出


## Day8
### io流
#### 按照内容分
1. InputStream 字节输入流，来自磁盘文件/网络中的数据以字节的形式读到内存中去
2. OutputStream 字节输出流，
3. Reader 字符输入流
4. Writer 字符输出流

#### 资源释放的方式
1. try-catch-finally,finally 一定会被执行
2. try(资源)  资源是实现了Closeable/AutoCloseable接口

#### 字节流，字符流
1. 字节流更适合音视频
2. 字符流更适合文本

### 缓冲流 Buffered
1. 自带缓冲区（默认8kb）、可以提高原始字节流、字符流读写数据的性能
2. 字符，用行读，readLine

### 转换流
1. 当代码编码和文件编码 不一样时

### 对象序列化
1. 以内存为基准，把内存中的对象存储到磁盘文件中去，称为对象序列化
2. ObjectOutputStream 对象字节输出流
3. ObjectInputStream 反序列化
4. 对象一定要实现Serializable接口。
5. transient 修饰符，可以使该变量不参与序列化。
6. 序列化版本号 serialVersionUID，用户版本更新

### 打印流 printStream printWriter
1. 输出语句的重定向，改变输出语句的位置

### Properties 属性集对象
1. 继承Map集合
2. 代表的是一个属性文件，里面全都是健值对，用于后续做系统配置信息
3. properties.store(),properties.load()

### commons-io 框架


### 线程
#### 线程的三种创建方式
1. 继承 extend Thread类，不能继承其他类了，不利于扩展，必须要用start调用。
2. 实现Runnable接口，run方法 不能返回结果
3. 实现Callable接口,FutureTask.

#### 线程的常用方法
1. Thread.currentThread()
2. setName(),getName()
3. Thread.sleep() 休眠方法

#### 线程安全
#### 线程同步
1. 解决线程安全问题
2. 加锁，共享资源进行上锁
3. 同步代码块 synchronized(同步锁对象)

#### 同步锁对象
1. 规范上，建议使用共享资源作为锁对象
2. 对于实例方法，建议用this作为锁对象
3. 对于静态方法，用 类名.class

#### 同步方法
1. 方法加上 synchronized 修饰符

#### Lock锁
1. 更加灵活，方便
2. 实现类，ReentrantLock ``` private final ReentrantLock lock = new ReentrantLock();```
3. 解锁要放在finally里面 一定执行

#### 线程通信
1. 线程间互相发送数据，通过共享一个数据实现
2. wait()
3. notify()
4. notifyAll()
5. 一定要用当前同步锁对象进行调用

#### 线程池
1. 是一个可以复用线程的技术
2. 方式一：接口：ExecutorService 实现类：ThreadPoolExecutor
3. 方式二：工具类：Executors

#### ThreadPoolExecutor 构造器说明
1. corePoolSize 指定线程池的线程数量   不能小于0
2. maximumPoolSize 线程池可支持的最大线程数   最大数量>=核心线程数量
3. keepAliveTime 临时线程的最大存活时间
4. unit 指定存活时间的单位
5. workQueue 指定任务队列
6. threadFactory 指定那个线程工厂创建线程
7. handler 指定线程忙，任务满的时候，新任务来了怎么办
8. 核心线程都在忙，任务队列也满，并且可以创建临时线程时，才会创建临时线程

### 定时器 Timer

## Day 9 
### 并发
1. 正在运行的程序就是一个独立的进程。
2. cpu同时处理线程的数量有限
3. cpu会轮询为系统的每个线程服务，由于cpu切换速度很快，感觉这些线程在同时执行，这就是并发

### 并行
1. 同一个时刻上，同时有多个线程在被cpu处理并执行

### 生命周期
1. New新建
2. Runnable可运行状态
3. Block 锁阻塞状态
4. Waiting 无限等待状态
5. Timed Waiting 计时等待
6. sleep(时间) 不释放锁
7. wait(时间) 释放锁

### 网络通信
#### IP地址
1. 设备在网络中的地址，唯一标志
2. IPv4(32bit/4byte)
3. IPv6(128bit/16byte) 分为八个整数，用十六进制表达

#### InetAddress IP地址操作类
#### 端口号
1. 标识正在计算机设备上运行的进程，16位，范围是0～65535
2. 周知端口：0～1023 HTTP占用80，FTP占用21
3. 注册端口：1024～49151，Tomcat占用8080，MySQL占用3306
4. 动态端口

#### OSI参考模型
1. 应用层
2. 表示层
3. 会话层
4. 传输层
5. 网络层
6. 数据链路层
7. 物理层

#### TCP/IP参考模型
1. 应用层
2. 传输层
3. 网络层
4. 数据链路—物理层

#### TCP 传输控制协议
1. 双方必须建立连接，面向连接的可靠通信协议
2. 三次握手连接，四次挥手断开连接
3. 文件下载，金融数据

#### UDP 数据报协议
1. 无连接、不可靠的协议
2. 将数据源IP、目的地等封装程数据包，大小限制在64k内
3. 广播、组播
4. DatagramPacket 数据包类
5. DatagramSocket 发送端和接收端对象
6. 广播地址：255.255.255.255，端口9999
7. 组播地址：224.0.1.1,端口9999,

#### TCP 
1. 一个线程只能接受一个人的消息
2. 要并发，多线程

### 单元测试，JUnit
1. 可以实现自动化测试
2. 灵活的执行哪些测试方法
3. 可以生成全部方法的测试报告
4. 单元测试某个方法失败了，不会影响其他方法测试



