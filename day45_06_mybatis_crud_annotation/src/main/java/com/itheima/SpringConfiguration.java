package com.itheima;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 包名:com.itheima
 * @author Leevi
 * 日期2020-11-11  11:17
 * 配置类用于替代spring.xml
 * 1. 添加Configuration注解
 * 2. 完成本应该由spring.xml完成的工作
 *    2.1 包扫描,使用ComponentScan注解
 *    2.2 创建对象，IOC: 添加一个方法，方法的返回值就是要创建的对象，方法上添加Bean注解
 *        2.2.1 DataSource
 *        2.2.2 SqlSessionFactoryBean
 *
 *
 * 使用纯注解开发，就不能再使用原来的核心容器(ClassPathXmlApplicationContext),而应该使用AnnotationConfigApplicationContext
 */
@Configuration
@ComponentScan("com.itheima")
public class SpringConfiguration {
    @Bean
    public DataSource createDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///day29?characterEncoding=utf8");
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean createFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.itheima.pojo");
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer createMapperScanner(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.itheima.dao");
        return mapperScannerConfigurer;
    }
}
