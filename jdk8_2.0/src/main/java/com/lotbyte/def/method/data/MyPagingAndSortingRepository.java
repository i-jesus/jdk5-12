package com.lotbyte.def.method.data;

import com.lotbyte.def.method.po.Sort;
import org.springframework.data.domain.Page;


/**
 * 引入排序与分页查找方法
 * @param <T>
 * @param <ID>
 */
public interface MyPagingAndSortingRepository<T,ID> extends  MyBaseCrudRepository<T,ID>{
    public default Iterable<T> findAll(Sort sort){
        // 调用父类接口方法
        MyBaseCrudRepository.super.findAll();
        System.out.println("带有排序的查询方法");
        return null;
    }

    public default Page<T> findAll(){
        System.out.println("带有分页的查询方法");
        return null;
    }
}
