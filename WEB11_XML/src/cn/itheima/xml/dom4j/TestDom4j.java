package cn.itheima.xml.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestDom4j {
	
	@Test
	public void testeReadWebXML() {
		try {
			//1.获取解析器
			SAXReader saxReader = new SAXReader();
			//2.获得document
			Document doc = saxReader.read("src/cn/itheima/xml/schema/web.xml");
			//3.获取根元素
			Element rootElement = doc.getRootElement();
//			System.out.println(rootElement.getName());//获取根元素的名称
//			System.out.println(rootElement.attributeValue("version") ); //获取根元素的属性值
			//4.获取根元素下的子元素
			List<Element> childElement = rootElement.elements();
			//5.遍历子元素
			for (Element element : childElement) {
				//6.判断元素名称为servlet的元素
				if ("servlet".equals(element.getName())) {
					//获取servlet-name元素
					//获取servlet-class元素
					Element servletName = element.element("servlet-name");
					Element servletClass = element.element("servlet-class");
					System.out.println(servletName.getText());
					System.out.println(servletClass.getText());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
