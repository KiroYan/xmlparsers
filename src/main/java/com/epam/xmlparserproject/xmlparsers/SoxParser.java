package com.epam.xmlparserproject.xmlparsers;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SoxParser extends DefaultHandler {
	private String temp;
	public static void main(String argv[]) throws IOException, SAXException,
    ParserConfigurationException {
		SAXParserFactory spfac = SAXParserFactory.newInstance();
		SAXParser sp = spfac.newSAXParser();
		SoxParser handler = new SoxParser();
		sp.parse("productlist.xml", handler);
		
	}
	public void characters(char[] buffer, int start, int length) {
        temp = new String(buffer, start, length);
    }
	public void startElement(String uri, String localName,
            String qName, Attributes attributes) throws SAXException {
     temp = "";
     }
	
	public void endElement(String uri, String localName, String qName)
            throws SAXException {

     if (qName.equalsIgnoreCase("categoryName")) {
            System.out.println("category :" + temp);

     } else if (qName.equalsIgnoreCase("subcategoryName")) {
    	 System.out.println("subcategory :" + temp);
     } else if (qName.equalsIgnoreCase("name")) {
    	 System.out.println("name :" + temp);
     }
     else if (qName.equalsIgnoreCase("producer")) {
           	 System.out.println("producer :" + temp);
     }
	 else if (qName.equalsIgnoreCase("model")) {
	 System.out.println("model :" + temp);
	}
	 else if (qName.equalsIgnoreCase("dateOfIssue")) {
	 System.out.println("dateOfIssue :" + temp);
	}
	 else if (qName.equalsIgnoreCase("inStock")) {
		 System.out.println("inStock :" + temp);
	}
	 else if (qName.equalsIgnoreCase("price")) {
		 System.out.println("price :" + temp);
	}
	}
}
     




