package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 包名:com.itheima.dao.impl
 * @author Leevi
 * 日期2020-11-12  14:47
 * 创建对象的时候，就应该将父类的DataSource设置好
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        List<Account> accountList = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(Account.class));
        return accountList;
    }

    @Override
    public void add(){
        String sql = "insert into account (name,money) values (?,?)";
        getJdbcTemplate().update(sql,"lisi",1000.0);
    }

    @Override
    public Account findById(int id){
        String sql = "select * from account where id=?";
        Account account = getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), id);
        return account;
    }
}
