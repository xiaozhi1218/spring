package com.itheima.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 包名:com.itheima.dao
 *
 * @author Leevi
 * 日期2020-11-12  10:55
 */
public interface AccountDao {
    void updateAccount(@Param("name") String name, @Param("money")Double money);
}
