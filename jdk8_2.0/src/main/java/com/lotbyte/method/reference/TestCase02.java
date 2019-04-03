package com.lotbyte.method.reference;

import com.lotbyte.function.TestCase04;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author lp
 * @Date 2019/4/3 16:29
 * @Version 1.0
 *
 * 静态方法引用
 */
public class TestCase02 {


    public static void main(String[] args) {

        // 加载外部properties 文件到property 对象
        Function<String,Properties> f01 = (fileName)->{
            return readFile(fileName);
        };
        System.out.println(f01.apply("jdbc.properties"));
        // 判断字符串是否为空串
        Function<String,Boolean> f03 = (str)-> StringUtils.isBlank(str);
        System.out.println(f03.apply(""));
        // Base64 对输入字符串执行编码操作
        Supplier<Base64.Encoder> s01 = ()->Base64.getEncoder();
        s01.get().encodeToString("java8 is so easy!!!".getBytes());


        // 等价的静态方法引用实现
        Function<String,Properties> f02 = TestCase02::readFile;
        System.out.println(f02.apply("jdbc.properties"));

        Function<String,Boolean> f04 = StringUtils::isBlank;
        System.out.println(f04.apply(""));

        Supplier<Base64.Encoder> s02 = Base64::getEncoder;
        s02.get().encodeToString("java8 is so easy!!!".getBytes());

    }

    public static Properties readFile(String fileName) {
        Supplier<Properties> supplier = () -> {
            try {
                InputStream is = TestCase04.class.getClassLoader().getResourceAsStream(fileName);
                Properties prop = new Properties();
                prop.load(is);
                return prop;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        };
        return supplier.get();
    }
}
