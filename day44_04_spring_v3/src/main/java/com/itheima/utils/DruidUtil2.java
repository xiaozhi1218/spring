package com.itheima.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 包名:com.itheima.utils
 * @author Leevi
 * 日期2020-08-19  15:43
 */
public class DruidUtil2 {
    private static DataSource dataSource;
    static {
        InputStream is = null;
        try {
            //读取druid的配置文件，并且使用DruidDataSourceFactory创建连接池对象
            //1. 将配置文件转换成流
            is = DruidUtil2.class.getClassLoader().getResourceAsStream("druid.properties");
            //2. 使用Properties对象加载流
            Properties properties = new Properties();
            properties.load(is);
            //3. 使用DruidDataSourceFactory对象调用createDataSource(properties)创建连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 调用的方法不是静态方法
     * @return
     */
    public DataSource getDataSource(){
        return dataSource;
    }
}
