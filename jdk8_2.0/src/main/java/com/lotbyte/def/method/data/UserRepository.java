package com.lotbyte.def.method.data;

import com.lotbyte.def.method.po.User;
import org.springframework.data.domain.Page;

import java.util.List;

public class UserRepository implements  MyJpaRepository<User,Integer>{
    @Override
    public List<User> getList() {
        System.out.println("实现MyJpaRepository getList接口方法");
        return null;
    }

    @Override
    public User getOne(Integer integer) {
        System.out.println("实现MyJpaRepository getOne方法");
        return null;
    }

    @Override
    public Page<User> findAll() {
        System.out.println("重写MyPagingAndSortingRepository.findAll 方法");
        return null;
    }
}
