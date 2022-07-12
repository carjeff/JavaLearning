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

