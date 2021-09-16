package com.itheima;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * 包名:com.itheima
 * @author Leevi
 * 日期2020-11-10  10:59
 * Spring会创建很多对象，在spring创建的那些对象中有没有需要使用dataSource的
 */
public class TestSpring {
    @Test
    public void test01(){
        //目标:获取druid的连接池对象
        //将项目中几乎所有的对象都交给spring管理,在这里我需要将DruidUtil创建出来的dataSource交给spring管理
        //那么就应该由spring去调用DruidUtil.getDataSource()，这其实就是spring的第二种创建对象的方式:静态工厂
        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");
        DataSource dataSource = (DataSource) act.getBean("dataSource");
        System.out.println(dataSource);
    }

    @Test
    public void test02(){
        //目标: 通过DruidUtil2获取dataSource对象,并且将获取到的dataSource对象交给spring管理
        //DruidUtil2 druidUtil2 = new DruidUtil2();
        //DataSource dataSource = druidUtil2.getDataSource();

        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");
        DataSource dataSource = (DataSource) act.getBean("dataSource");
        System.out.println(dataSource);
    }
}
