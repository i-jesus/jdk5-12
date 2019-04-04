package com.lotbyte.optinal;

import com.lotbyte.optinal.model.ResultInfo;
import com.lotbyte.optinal.po.User;
import com.lotbyte.optinal.service.UserService;
import com.lotbyte.optinal.utils.MD5Util;

import java.util.Optional;

/**
 * @author lp
 * @Date 2019/4/3 20:48
 * @Version 1.0
 * Optinal 逻辑判断操作
 */
public class TestCase02 {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user= userService.queryUserById(10);
        if(null != user){
            System.out.println("匹配到该用户");
            /**
             * 执行其他操作
             */
        }else{
            System.out.println("用户不存在");
        }



        Optional<User> userOptional =   Optional.ofNullable(user);
        // 使用isPresent 方法进行判断
        if(userOptional.isPresent()){
            System.out.println("匹配到该用户");
            /**
             * 执行其他操作
             */
        }else{
            System.out.println("用户不存在");
        }


        // 使用ifPresent 执行if 判断操作
        userOptional.ifPresent((u)->{
            System.out.println("匹配到该用户");
            /**
             * 执行其他操作
             */
        });

        //  使用orELse 方法 返回结果  存在返回该对象 不存在返回null
        System.out.println(userOptional.orElse(null));

        /**
         * 使用 map orElse 方法 执行if else 逻辑判断
         *   当user 对象非空时 执行map 操作  否则 执行orElseGet 操作
         */
        userOptional.map((u) -> {
            System.out.println("匹配到该用户!");
            /**
             * 执行其他操作
             */
            return u;
        }).orElse(null);


        // 用户登录判断  原始代码
        String uname="";
        String upwd="";
        ResultInfo resultInfo=null;
        user  = userService.queryUserByUnameAndUpwd(uname,upwd);
        // 判断user对象是否为空
        if (user == null) { // 用户不存在
            resultInfo=new ResultInfo(300,"登录失败,用户名或密码错误",null);
        }else{
            resultInfo=new ResultInfo(200,"登录成功",user);
        }






        // 用户登录判断  返简单回登录结果-->map orElse
        userOptional= Optional.ofNullable(userService.queryUserByUnameAndUpwd(uname,upwd));
        // 执行 map orElse 判断
        userOptional.map((u)->{
            /**
             * 如果用户记录存在
             */
            return new ResultInfo(200,"登录成功",u);
        }).orElse(new ResultInfo(300,"登录失败,用户名或密码错误",null));
    }
}
