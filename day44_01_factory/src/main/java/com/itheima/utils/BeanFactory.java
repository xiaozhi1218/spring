package com.itheima.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * 包名:com.itheima.utils
 *
 * @author Leevi
 * 日期2020-11-10  09:54
 */
public class BeanFactory {
    /**
     * 根据类的全限定名，创建对象
     * @return
     */
    /*public static Object createBean(String ClassName){
        try {
            return Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }*/

    public static Object createBean(String id){
        //1. 解析beans.xml，根据id获取要创建对象的类的全限定名
        //使用DOM4J解析xml
        try {
            SAXReader saxReader = new SAXReader();
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
            Document document = saxReader.read(is);

            //使用document对象，根据id查找class属性的值
            Element beanElement = (Element) document.selectSingleNode("//bean[@id='" + id + "']");
            //获取class属性的值,就是类的全限定名
            String className = beanElement.attributeValue("class");
            //使用反射创建对象
            return Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
