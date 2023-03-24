package com.itheima.day05.test.demo1;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class ElementReaderTest {
    @Test
    public void method1() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("src/main/resources/demo1.xml"));
        Element rootElement = read.getRootElement();
        List<Element> groups = rootElement.elements("group");
        System.out.println(groups);
        for (Element group : groups) {
            Element students = group.element("students");
            List<Element> student = students.elements("student");
            for (Element stu : student) {
                Element name = stu.element("name");
                Element age = stu.element("age");
                String text1 = name.getText();
                String text2 = age.getText();
                System.out.println(text1);
                System.out.println(text2);
            }
        }

    }
}
