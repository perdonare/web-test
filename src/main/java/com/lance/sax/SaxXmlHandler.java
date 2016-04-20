package com.lance.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by perdonare on 2016/4/18.
 */
public class SaxXmlHandler extends DefaultHandler{
    private Map<String,String> parseMap = null;
    private List<Map<String,String>> parsedList = null;
    String currentTag = null;
    String currentValue = null;
    String nodeName = null;

    public SaxXmlHandler(String nodeName) {
        this.nodeName = nodeName;
    }


    @Override
    public void startDocument() throws SAXException {
        parsedList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (nodeName.equals(qName)) {
            parseMap = new HashMap<>();
        }

        if (attributes!=null && parseMap!=null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                parseMap.put(attributes.getQName(i),attributes.getValue(i));
            }
        }
        currentTag = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if ( currentTag != null && parseMap != null ) {
            currentValue = new String(ch,start,length);

            if ( currentValue != null && !currentValue.trim().equals("") && !currentValue.trim().equals("\n") ) {
                parseMap.put(currentTag,currentValue);
            }
            currentTag = null;
            currentValue = null;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ( qName.equals(nodeName) ) {
            parsedList.add(parseMap);
            parseMap = null;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("完成 document 解析");
        super.endDocument();
    }



    public List<Map<String, String>> getParsedList() {
        return parsedList;
    }
}
