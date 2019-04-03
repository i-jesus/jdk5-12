package com.lotbyte.function;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author lp
 * @Date 2019/4/3 10:45
 * @Version 1.0
 * Supplier 接口  读取外部Properties 文件
 */
public class TestCase04 {
    public static void main(String[] args) {
        Properties prop = readFile("jdbc.properties");
        System.out.println(prop);
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
