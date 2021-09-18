package com.itheima.proxy;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 包名:com.itheima.proxy
 *
 * @author Leevi
 * 日期2020-11-11  14:53
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        //使用jdk的动态代理，来代理AccountDao接口
        AccountDao accountDao = (AccountDao) Proxy.newProxyInstance(AccountDao.class.getClassLoader(), new Class[]{AccountDao.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //proxy就是代理对象
                //method就是需要被代理的方法
                //args就是方法的参数
                if (method.getName().equals("findAll")) {
                    //执行查询所有的sql语句
                    String sql = "select * from account";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql:///day29?characterEncoding=utf8", "root", "root");
                    PreparedStatement pstm = conn.prepareStatement(sql);
                    ResultSet rst = pstm.executeQuery();
                    List<Account> accountList = new ArrayList<>();
                    while (rst.next()) {
                        int id = rst.getInt("id");
                        String name = rst.getString("name");
                        double money = rst.getDouble("money");
                        Account account = new Account();
                        account.setId(id);
                        account.setName(name);
                        account.setMoney(money);
                        accountList.add(account);
                    }
                    return accountList;
                }
                return null;
            }
        });

        System.out.println(accountDao.findAll());
    }
}
