package com.lotbyte.def.method;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

@SuppressWarnings("all")
public interface BaseRepository{

    public  static Properties getPropertiesInfo01(String fileName){
        Properties prop = null;
        try {
            InputStream is = BaseRepository.class.getClassLoader().getResourceAsStream(fileName);
            prop=new Properties();
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }


    /**
     * 改进写法
     * @param fileName
     * @return
     */
    public  static Optional<Properties> getPropertiesInfo02(String fileName){
        Properties prop = null;
        try {
            InputStream is = BaseRepository.class.getClassLoader().getResourceAsStream(fileName);
            prop=new Properties();
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(prop);
    }



}
