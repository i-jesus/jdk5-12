package com.lotbyte.lambda;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.function.Supplier;

/**
 * @author lp
 * @Date 2019/3/26 18:56
 * @Version 1.0
 */
public class UserService {
    private static Log logger = LogFactory.getLog(UserService.class);


    /**
     * 添加info方法
     *  判断日志打印级别
     *  当条件成立时 输出日志信息
     * @param logger
     * @param message
     */
    public  static void info(Log logger, Supplier<String> message){
        if(logger.isInfoEnabled()){
            logger.info(message.get());
        }
    }

    public static String login(String userName, String userPwd) {
        //logger.info("UserService 接收到参数-->" + userName + "," + userPwd);
        // 延迟Lambda 表达式执行  只有确定
        info(logger,()->"UserService 接收到参数-->" + userName + "," + userPwd);
        return "login";
    }

    public static void main(String[] args) {
        login("admin", "admin");
    }


}
