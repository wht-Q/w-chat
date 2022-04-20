package com.example.chat.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 捕获报错日志处理工具类
 */
public class ErrorUtil {

    /**
     * Exception出错的栈信息转成字符串
     * 用于打印到日志中
     * Exception 类的 方法 printStackTrace() 可以带一个参数 ，可以是 PrintStream 或PrintWriter ，因此，可以使用 StringWriter 打印堆栈信息为字符串
     */
    public static String errorInfoToString(Throwable e) {
        //try-with-resource语法糖 处理机制
        try(StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)){
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            return sw.toString();
        }catch (Exception ignored){
            throw new RuntimeException(ignored.getMessage(),ignored);
        }
    }
}
