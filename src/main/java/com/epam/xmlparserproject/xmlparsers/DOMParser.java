package com.epam.xmlparserproject.xmlparsers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {
	public static void main(String argv[]) throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = new File("D:/workspace1/xmlproject/productlist.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		StringBuilder xmlDoc = new StringBuilder();
		doc.getDocumentElement().normalize();
		Element rootElement = doc.getDocumentElement(); 
		NodeList nList = rootElement.getChildNodes();
		
		Element categories = (Element) nList.item(0);
		NodeList category = categories.getElementsByTagName("category");
			for (int i = 0; i < category.getLength(); i++) {
				xmlDoc.append("Category :" + category.item(i).getFirstChild().getTextContent() + "\n");
				NodeList subcategories = ((Element)category.item(i)).getElementsByTagName("subcategory");
				for (int j = 0; j < subcategories.getLength(); j++) {
					xmlDoc.append("Subcategory :" + subcategories.item(j).getFirstChild().getTextContent() + "\n");
					NodeList products = ((Element)subcategories.item(j)).getElementsByTagName("product");
					for (int z = 0; z < products.getLength(); z++) {
						xmlDoc.append("Product name :" + ((Element)products.item(z)).getElementsByTagName("name").item(0).getTextContent() + "\n");
						xmlDoc.append("Product producer :" + ((Element)products.item(z)).getElementsByTagName("producer").item(0).getTextContent() + "\n");
						xmlDoc.append("Product model :" + ((Element)products.item(z)).getElementsByTagName("model").item(0).getTextContent() + "\n");
						xmlDoc.append("Product dateOfIssue :" + ((Element)products.item(z)).getElementsByTagName("dateOfIssue").item(0).getTextContent() + "\n");
						xmlDoc.append("Product color :" + ((Element)products.item(z)).getElementsByTagName("producer").item(0).getTextContent() + "\n");
						xmlDoc.append("Product inStock :" + ((Element)products.item(z)).getElementsByTagName("model").item(0).getTextContent() + "\n");
						xmlDoc.append("Product price :" + ((Element)products.item(z)).getElementsByTagName("dateOfIssue").item(0).getTextContent() + "\n");
						xmlDoc.append("-------------------------------------------" + "\n");
					}
				}
			}
		
		System.out.println(xmlDoc);
	}
}

/*File fXmlFile = new File("D:/workspace1/xmlproject/productlist.xml");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
dbFactory.setIgnoringElementContentWhitespace(true);
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(fXmlFile);
StringBuilder xmlDoc = new StringBuilder();
doc.getDocumentElement().normalize();
Element rootElement = doc.getDocumentElement(); 
NodeList nList = rootElement.getChildNodes();

for (int temp = 0; temp < nList.getLength(); temp++) {
	Element categories = (Element) nList.item(temp);
	NodeList category = categories.getElementsByTagName("category");
	for (int i = 0; i < category.getLength(); i++) {
		xmlDoc.append("Category :" + category.item(i).getFirstChild().getTextContent() + "\n");
		NodeList subcategories = categories.getElementsByTagName("subcategory");
		for (int j = 0; j < subcategories.getLength(); j++) {
			xmlDoc.append("Subcategory :" + subcategories.item(i).getFirstChild().getTextContent() + "\n");
			NodeList products = ((Element)subcategories.item(j)).getElementsByTagName("product");
			for (int z = 0; z < products.getLength(); z++) {
				xmlDoc.append("Product name :" + ((Element)products.item(z)).getElementsByTagName("name").item(0).getTextContent() + "\n");
				xmlDoc.append("Product producer :" + ((Element)products.item(z)).getElementsByTagName("producer").item(0).getTextContent() + "\n");
				xmlDoc.append("Product model :" + ((Element)products.item(z)).getElementsByTagName("model").item(0).getTextContent() + "\n");
				xmlDoc.append("Product dateOfIssue :" + ((Element)products.item(z)).getElementsByTagName("dateOfIssue").item(0).getTextContent() + "\n");
				xmlDoc.append("Product color :" + ((Element)products.item(z)).getElementsByTagName("producer").item(0).getTextContent() + "\n");
				xmlDoc.append("Product inStock :" + ((Element)products.item(z)).getElementsByTagName("model").item(0).getTextContent() + "\n");
				xmlDoc.append("Product price :" + ((Element)products.item(z)).getElementsByTagName("dateOfIssue").item(0).getTextContent() + "\n");
				xmlDoc.append("-------------------------------------------" + "\n");*/

