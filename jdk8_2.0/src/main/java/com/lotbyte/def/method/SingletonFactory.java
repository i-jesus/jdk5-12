package com.lotbyte.def.method;


import java.util.HashMap;
import java.util.Map;

/**
 * 借助工厂创建单例对象
 */
public  interface SingletonFactory {
    /**
     * 定义静态变量HashMap  存放已实例化对象
     */
    public static Map<String,Object> beans = new HashMap<String, Object>();

    /**
     * 定义静态方法 返回创建的单例对象
     * @param c
     * @param <T>
     * @return
     */
    public static  <T> T getInstance(Class<T> c){
        String key = c.toString();
        Object instance= beans.get(key);
        if(instance == null){
            /**
             * 加锁操作
             */
            synchronized (c) {
                try{
                    instance = c.newInstance();
                    beans.put(key, instance);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return c.cast(instance);
    }



}
