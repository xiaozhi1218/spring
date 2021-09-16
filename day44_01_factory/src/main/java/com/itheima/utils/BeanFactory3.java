package com.itheima.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 包名:com.itheima.utils
 *
 * @author Leevi
 * 日期2020-11-10  09:54
 * 间配置文件读取的代码写到静态代码块中
 * 容器式单例
 */
public class BeanFactory3 {
    private static Map<String,Object> map = new HashMap();
    static {
        try {
            //解析beans.xml配置文件
            SAXReader saxReader = new SAXReader();
            InputStream is = BeanFactory3.class.getClassLoader().getResourceAsStream("beans.xml");
            Document document = saxReader.read(is);
            //获取beans.xml中的所有bean标签
            List<Element> beanList = document.selectNodes("//bean");
            //将遍历出来的每一个bean标签的id和class存储到内存中
            if (beanList != null) {
                for (Element element : beanList) {
                    //为什么要将类的全限定名存储到map中,为了到时候取出全限定名然后使用反射创建对象
                    //直接存对象
                    Object obj = Class.forName(element.attributeValue("class")).newInstance();
                    map.put(element.attributeValue("id"),obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据bean标签的id获取bean标签的class属性的值，然后再用反射
     * @param id
     * @return
     */
    public static Object createBean(String id){
        try {
            //从map中根据id获取对象
            Object obj = map.get(id);
            //直接返回对象
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
