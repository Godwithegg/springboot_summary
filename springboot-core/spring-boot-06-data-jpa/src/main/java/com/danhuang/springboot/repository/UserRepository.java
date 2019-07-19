package com.danhuang.springboot.repository;

import com.danhuang.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {//操作表的名称和主键名称



}
