package com.lotbyte.def.method;

import java.util.Optional;
import java.util.Properties;

/**
 * @author lp
 * @Date 2019/4/1 11:42
 * @Version 1.0
 * 案例1-properties 文件读取
 */
public class TestCase01 {
    public static void main(String[] args) {
        // 使用Optinal 防止空指针
       Optional<Properties> optinal= BaseRepository.getPropertiesInfo02("jdbc.properties");
       optinal.ifPresent((prop)->{
           System.out.println("driver-->"+prop.get("jdbc.driver")
                   +"-->"+prop.get("jdbc.url")
                   +"-->"+prop.get("jdbc.user")
                   +"-->"+prop.get("jdbc.password"));
       });

    }
}
