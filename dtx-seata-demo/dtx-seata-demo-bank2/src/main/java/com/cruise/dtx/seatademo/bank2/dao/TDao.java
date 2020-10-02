package com.cruise.dtx.seatademo.bank2.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 测试插入
 */
@Mapper
@Component
public interface TDao {

    @Insert("INSERT INTO t(name) VALUES(#{name})")
    int save(@Param("name") String name);
}
