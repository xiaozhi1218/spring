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
 */
public class BeanFactory2 {
    private static Map<String,String> map = new HashMap();
    static {
        try {
            //解析beans.xml配置文件
            SAXReader saxReader = new SAXReader();
            InputStream is = BeanFactory2.class.getClassLoader().getResourceAsStream("beans.xml");
            Document document = saxReader.read(is);
            //获取beans.xml中的所有bean标签
            List<Element> beanList = document.selectNodes("//bean");
            //将遍历出来的每一个bean标签的id和class存储到内存中
            if (beanList != null) {
                for (Element element : beanList) {
                    map.put(element.attributeValue("id"),element.attributeValue("class"));
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
            //从map中根据id获取class的值
            String className = map.get(id);
            //使用反射创建对象
            return Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
