package myssm.util;

/**
 * @author Jason
 * @date 2022/7/25 19:48
 * @Description
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     * @param str
     * @return 空为 true
     */
    public static boolean isEmpty(String str){
        return str==null && str.equals("");
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
