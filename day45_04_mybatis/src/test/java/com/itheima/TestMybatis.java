package com.itheima;

import com.itheima.dao.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * 包名:com.itheima
 *
 * @author Leevi
 * 日期2020-11-11  10:09
 * 哪个对象是我们需要的? Dao代理对象、SqlSession对象、sqlSessionFactory对象
 * 目标1: 将SqlSessionFactory对象创建出来，放到spring的核心容器中
 * 目标2: 将项目中的所有Dao接口的代理对象创建出来，放到spring的核心容器中
 * 目标3: 直接从spring的核心容器中获取Dao接口的代理对象
 *
 * 具体实现步骤:
 * 1. 引入mybatis-spring的依赖
 * 2. 在spring的配置文件中:
 *    1. 对DataSource进行IOC
 *    2. 对SqlSessionFactoryBean进行IOC
 *       1. 注入dataSource
 *       2. 注入typeAliasesPackage指定要配置别名的包扫描
 *    3. 对MapperScannerConfigurer进行IOC
 *       1. 注入basePackage，指定要创建代理对象的Dao接口所在的包名
 */
public class TestMybatis {
    @Test
    public void testFindAll() throws IOException {
        //1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //2. 加载主配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //3. 构建出SqlSessionFactory对象,每一个项目中只有一个
        SqlSessionFactory sqlSessionFactory = factoryBuilder.build(is);
        //4. 每次执行SQL语句，就要先创建一个SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //5. 使用sqlSession对象创建Dao的对象对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        System.out.println(accountDao.findAll());

        //6. 关闭资源
        sqlSession.close();
        is.close();
    }

    @Test
    public void test02(){
        //从spring的核心容器中获取AccountDao的代理对象
        ApplicationContext act = new ClassPathXmlApplicationContext("spring-mybatis.xml");

        AccountDao accountDao = (AccountDao) act.getBean("accountDao");

        System.out.println(accountDao.findAll());
    }
}
