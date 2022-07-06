# M1Mac下的IDEA配置

[toc]

## 安装流程

### IDEA下载

1. 官网下载。Apple Silicon （M1）mac的电脑安装IDEA时，一定要注意下载软件的版本，要选择Apple Silicon版本的进行下载。进入官网。

https://www.jetbrains.com/zh-cn/idea/

<img src="/Users/car/Desktop/截屏2022-07-05 17.54.40.png" alt="截屏2022-07-05 17.54.40" style="zoom:50%;" />



2. homebrew下载。安装好homebrew之后，使用命令

```brew
brew install --cask intellij-idea
```

homebrew会根据电脑配置下载符合电脑的idea版本。非常方便。

### openJDK 下载

由于现在Orcle的JDK还不适配M1版本，所以使用Zulu的JDK。

进入官网。https://www.azul.com/downloads/?package=jdk

也可以用homebrew直接下载。

### Maven下载



## 插件推荐

**1. Codota 代码智能提示插件** 

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9reExQTJxEnWQbtzO6e5e53cnEyWFFICAxiajcUyxXXbDl6iae9K9w78CA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

只需要打出首字母就能自动联想出一整条语句，非常智能，还能够显示每条语句的使用频率。

**2. Key Promoter X 快捷键提示插件**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rT9Eeerbj7BJ5V6nOXQelRicRB1lLutibuQn7LDVezhnjLWDlNsmro1gA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

每次都会在右下角弹窗提示，帮助我们快速熟悉快捷键。

**3. CodeGlance 显示代码缩略图插件**

![图片](https://mmbiz.qpic.cn/mmbiz_jpg/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rcY4QfZbbl1kmpVLlzPB6PcHCQTRfGlTpFIbxwCq0w1tR9ftRSwvl1g/640?wx_fmt=jpeg&wxfrom=5&wx_lazy=1&wx_co=1)

当代码很多的时候，方便查看，很有用。



**4. Lombok 简化臃肿代码插件**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9r0s7W5rrGSzbdjPmBPazeKA2CO87Jg6tdibYhVEiclbX3KHdG4UiczE3xA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

实体类中的get/set/构造/toString/hashCode等方法，都不需要我们再手动写了



**5. Alibaba Java Coding Guidelines 阿里巴巴代码规范检查插件**

![图片](https://mmbiz.qpic.cn/mmbiz_jpg/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rJ4ex3omCxYQBEsMxVfPRLPCRcFkKdhzMmunnNdr75phMhOvPFafbgQ/640?wx_fmt=jpeg&wxfrom=5&wx_lazy=1&wx_co=1)

会按照阿里Java开发手册上规范帮我们检查代码，然后对代码做不同颜色展示，鼠标放上去，会看到提示内容，帮助我们写出更规范的代码。



**6. CamelCase 驼峰命名和下划线命名转换**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9ryEFbUBoiazrgyYnBKuqC2MTukhGnltnncH3FiaOUkjPbUsKRMib2E8dfg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

这几种风格的命名方式，用快捷键 ⇧ + ⌥ + U / Shift + Alt + U可以进行快速转换，当我们需要修改大量变量名称的时候很方便。



**7. MybatisX 高效操作Mybatis插件**

![图片](https://mmbiz.qpic.cn/mmbiz_jpg/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rBPWyjp5MVIGdgmulicPLGWHbXhxiclWuAfNUhiaL7D2SXU4TFqeXictttA/640?wx_fmt=jpeg&wxfrom=5&wx_lazy=1&wx_co=1)

**8. SonarLint 代码质量检查插件**

![图片](https://mmbiz.qpic.cn/mmbiz_jpg/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rnnnsW1FlrUDxbP62DKLMm59NAsib0Ebx3dmbibNibYkxea6VbMYofKOjg/640?wx_fmt=jpeg&wxfrom=5&wx_lazy=1&wx_co=1)

提示我不要用System.out输出，要用logger输出，诸如此类，帮助我们提升代码质量。

**9. Save Actions 格式化代码插件**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rVNVaKWeGFTq2vIjYsrRzAjxvxOVtyK7X8YtQHJKoPN94xl8A9ic7OGQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

可以帮忙我们优化包导入，自动给没有修改的变量添加final修饰符，调用方法的时候自动添加this关键字等，使我们的代码更规范统一。

**10. Grep Console 自定义控制台输出格式插件**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rdUYdgC00vsZUSjDiaT5wI0mAO5bGjIZSicNUUL35FhLVyqiazujJ3DvyQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**12. MetricsReloaded 代码复杂度检查插件**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9r3AGiac246PbadE8u03g0h1QkiaTRjOF8NgEcU6ibjItKxWlHcZoOyicTVQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**13. Statistic 代码统计插件**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rMFo8oaM2ArV6VemoJt4vjVKdicic2ZFz7NtsmdR4LSjg3WmdG1crejibQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**14. Translation 翻译插件**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9r2ZicSuAvXxr9CI5OK76up6IB5fTAma7KIg4d9bHD33ZxgIoBXBIicWTA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**15. Rainbow Brackets 彩虹括号插件**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rN0fHR9XL1uHBicCiaAQOVamAgLbcQvsvaL4mNo7I7zjdB8WMCqrWPmqw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

成对儿的括号显示相同的颜色，有了这个插件，我的近视都好了。

**16. Wakatime编程跟踪器**

![photo](https://blog.jetbrains.com/wp-content/uploads/2021/04/Waka_time.png)

WakaTime插件具有时间跟踪服务，同时可自动生成整洁有趣的指标和分析。 您可以用它来分析团队生产力，或帮助自己提高编程速度。

**17. Material Theme UI主题**

![4-materialthemui](https://blog.jetbrains.com/wp-content/uploads/2020/05/zh-hant-4-materialthemui.png)

眼睛盯着 IDE 打代码是开发小伙伴的每日工作，挑个顺眼的主题可以让工作时的心情更好些。自从 Google 推出 Material 设计指南后，这股风潮也吹到 IDE 来。这个插件可以将 IntelliJ IDEA 配置成 Material 主题，还可以通过调整主色来符合您的个性。在维持代码品质的同时，别忘了装扮自己的工具

## 修改全局配置

**1. 优化导包配置** 

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9raPwHj9FYelp14f5biaI2KWAicLrgKzOpJvm9BVSTdI5N7ib4YHqoMh29Q/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**2. 取消tab页单行显示**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rAicXWRlCWnG1wqOniaURGgAUfLv9DnPboounHNxehU6W5qicPty4Oy1xA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rvzCds5ibVCeu8zLvpZMibw2axEFjceWRUgMQbs8pKkpG4OWBDfH8LnOg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

可以多行显示更多的文件，方便查看。



**3. 双斜杠注释改成紧跟代码头**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rYpKXXMkJNss27v2kg4zIRYk1iaibV0hY2cKml8lMjPicVhR3kSSiclgaQA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rekibwwUfvz9b1XKgZ69GP5IZUxwOo2ofia85QJ0qKuV1jOhqFFUdg9VA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**4. 选中复制整行**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9ricQ5uWWR2OVlpZ7SSRSlGoyUsPMVE8Zaha6KZdN7ibH2UhZ2uibJbxicwQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rKF9HauT7rYibnsYrqy9p1GkRVUvfEWv8h2CnkFSvlRwy2icOrDWOawhw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

原本只会复制你选中的代码，改完配置后，就能复制整行，无论你是否完全选中。



**5. 取消匹配大小写**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rOwNVnaQ9HmQdQ3Bicduk2plr5K7a6tWyzrlDFnVK9Gicfv68UN64Byog/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

取消勾选后，输入小写 **s**，也能提示出 **String**

**6. 优化版本控制的目录颜色展示**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rAqJ3zkW0qjSSkxVk3kuIwICLOGWZS6vwuTSuib5iauMrr2w491xKINVQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**7. 创建文件时，自动生成作者和时间信息**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rYUIUaqwghwTKPdoMvBQhzbN8kvWgicVUJWj7kEiax9W1ou0P6fTTtzvA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

**8 . 显示行号和方法分割线**

![图片](https://mmbiz.qpic.cn/mmbiz_png/WpLd6CGLSOcjAegECzd4bQdYmUR3YD9rYrvicChCRy2C4hubBoyq9MlZPOvomnibqNZrKvs5mJ0aMO8JW169LryA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

## 快捷键

**1. 文件/类搜索**

根据文件名搜索文件/类

快捷键：shift + shift（连按两次）

![图片](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/106880727cbb414591b93da4d6914bdb~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0.awebp)

**2. 字段搜索**

根据文件内容搜索，可直接定位到目标内容位置，支持局部（当前文件或选中代码段）和全局搜索（项目/模块/目录/作用域等）

局部搜索快捷键：Win: Ctrl + F  Mac: Command + F

全局搜索快捷键：Win: Ctrl + shift + F  Mac: Command + Shift + F

![图片](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/3c9cdcda2cab46a8afd21fef20c8245c~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0.awebp)

**3. 跳转到上/下次光标的位置**

查看源码时，经常需要在两个类中来回跳转，这个功能就变得相当实用！

查看上次光标位置快捷键：Win: Alt + ←  Mac: Option + Command + ←

查看下次光标位置快捷键：Win: Alt + →  Mac: Option + Command + →

**4. 查看接口的实现类（或接口方法的实现）**

如果光标选中接口方法，直接跳转到该方法的具体实现。如果有多个实现，则可以选择跳转到指定的实现类。

快捷键：Win: Ctrl + Alt + B  Mac: Option + Command + B

![图片](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/ac25c1d75df84c1bb2009ba1587303ca~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0.awebp)

**5. 查看方法调用树**

可以查看指定方法的所有调用方和被调方。

快捷键：Win: Ctrl + Alt + H  Mac: Control + Option + H

![图片](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/97456064fe5847b4b4e257381795019c~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0.awebp)

**6. 查看类关系图**

非常实用的功能，直观清晰地展现类的关系，便于分析。

快捷键：Win: Ctrl + Alt + U  Mac: Shift + Option + Command + U

![图片](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/7cb5dd469234448099d416b1001c3232~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0.awebp)

**7. 查看类的继承树**

能够查看类的父类和子类继承关系。 快捷键：Win: Ctrl + H  Mac: Control + H

![图片](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/1d12bc3221a84750be9856cfd5a84af1~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0.awebp)

**8. 查看定义的变量在哪里被声明/调用**

如果光标在变量声明处，则查看使用该变量的代码；如果光标在使用变量处，则查看变量的声明位置。

快捷键：Win: Ctrl + B  Mac: Command + B 或按住 Ctrl / Command 点击鼠标左键

![图片](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/87bd9fed1e454b5398ac96358eb58ddb~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0.awebp)

**9. 查看定义的变量在哪里被调用**

功能和上述功能类似，仅查看变量的调用位置。

快捷键：Win: Ctrl + Alt + F7  Mac: Option + Command + F7

**10. 查看类的结构**

能够查看某一个类的属性、域、方法、继承方法、匿名类、Lambdas，并快速跳转到指定位置。

快捷键：Win: Alt + 7  Mac: Command + 7

![图片](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/316d0a1ea3bc47d391d8703415f93b9c~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0.awebp)

**11. 查看每行代码的提交信息（需被 Git 管理）**

在代码行数列表处右键，点击 Annotate 开启代码提交信息显示：

![图片](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/ee54890de5e840949fa99a1d3890b5e0~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0.awebp)

效果如下，烂代码元凶快快显形！

![图片](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/8f6f4d04bdc044458e1094bd36f8dee9~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0.awebp)





来源：程序员鱼皮