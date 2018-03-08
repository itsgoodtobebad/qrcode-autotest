package com.itsgoodtobebad.qrcode.testcase;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import java.util.Iterator;

/**
 * @author liliangxi.
 *         Created on 2018/3/8.
 */
public class Dom4jTest {

    @Test
    public void readXml() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(this.getClass().getClassLoader().getResource("testcase/QueryMerchantDetail/testcases.xml").getFile());

        Element root = document.getRootElement();
        for(Iterator<Element> it = root.elementIterator("testcase");it.hasNext();){
            Element testcase = it.next();

        }
    }
}
