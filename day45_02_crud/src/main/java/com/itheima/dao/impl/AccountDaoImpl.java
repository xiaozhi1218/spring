package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.dao.impl
 *
 * @author Leevi
 * 日期2020-11-10  15:18
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner queryRunner;
    @Override
    public List<Account> findAll() throws SQLException {
        //执行SQL语句
        String sql = "select * from account";
        List<Account> accountList = queryRunner.query(sql, new BeanListHandler<>(Account.class));
        return accountList;
    }
}
