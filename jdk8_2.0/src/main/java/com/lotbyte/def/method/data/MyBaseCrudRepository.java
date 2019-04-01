package com.lotbyte.def.method.data;


import java.util.List;

/**
 * 基本crud接口默认方法
 * @param <T>
 * @param <ID>
 */
public interface MyBaseCrudRepository<T,ID> {

    public default T save(T entity){
        System.out.println("添加操作。。。");
        return entity;
    }

    public default int saveAll(List<T> entities){
        System.out.println("批量添加操作。。。");
        return 0;
    }



    public default Iterable<T> findAll(){
        System.out.println("迭代操作。。。");
        return null;
    }


    public default int deleteById(ID id){
        System.out.println("删除操作。。。");
        return 0;
    }

}
