package study.logback;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jason
 * @date 2022/7/13 10:43
 * @Description
 */
public class LogbackDemo {
    public static final Logger LOGGER = LoggerFactory.getLogger("LogbackDemo.class");
    public static void main(String[] args) {
         LOGGER.debug("main方法开始执行！");
    }
}
