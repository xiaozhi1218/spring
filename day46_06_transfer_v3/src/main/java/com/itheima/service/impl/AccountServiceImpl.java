package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * 包名:com.itheima.service.impl
 * @author Leevi
 * 日期2020-11-12  10:55
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private DataSource dataSource;

    /**
     * 声明式事务的规则
     * 1. rollbackFor 表示该事务遇到什么就回滚，默认是遇到所有的异常都回滚
     * 2. noRollbackFor 表示该事务遇到什么不回滚
     * 3. timeout 表示事务的超时时间，默认为-1
     * 4. readOnly 表示该事务是只读事务，所以配置了readOnly的事务属性的方法中不能进行数据库的增删改操作
     * 5. isolation 表示该事务的隔离级别:
     *              1. READ_UNCOMMITTED 读取到未提交的事务
     *              2. READ_COMMITTED 读取到已提交的事务
     *              3. REPEATABLE_READ 可重复读
     *              4. SERIALIZABLE 串行化
     *
     * 6. propagation 表示该事务的传播行为
     *
     * @param fromName
     * @param toName
     * @param money
     */
    @Override
    @Transactional
    public void transfer(String fromName, String toName, Double money) {
        //1. 调用dao的方法进行转出账户扣款
        accountDao.updateAccount(fromName,-money);
        int num = 10/0;
        //2. 调用dao的方法进行转入账户收款
        accountDao.updateAccount(toName,money);
    }
}
