package com.lotbyte.def.method.data;


import java.util.List;

public interface MyJpaRepository<T,ID> extends MyPagingAndSortingRepository<T, ID> {

    public  List<T> getList();

    public  T getOne(ID id);
}
