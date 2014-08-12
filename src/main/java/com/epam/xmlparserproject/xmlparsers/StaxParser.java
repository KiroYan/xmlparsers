package com.epam.xmlparserproject.xmlparsers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StaxParser implements Parser {
	private String parserType = "StAX";

	public String getParserType() {
		return parserType;
	}

	public String parseXML(String fileName) {
		String xmlDoc = "";
		String test = "";
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			XMLEventReader xmlEventReader = xmlInputFactory
					.createXMLEventReader(new FileInputStream(fileName));
			while (xmlEventReader.hasNext()) {
				XMLEvent xmlEvent = xmlEventReader.nextEvent();
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart()
							.equals("categoryName")) {
						xmlEvent = xmlEventReader.nextEvent();
						xmlDoc += "Category :"
								+ xmlEvent.asCharacters().getData() + "\n";
					} else if (startElement.getName().getLocalPart()
							.equals("subcategoryName")) {
						xmlEvent = xmlEventReader.nextEvent();
						xmlDoc += "Subcategory :"
								+ xmlEvent.asCharacters().getData() + "\n";
					} else if (startElement.getName().getLocalPart()
							.equals("name")) {
						xmlEvent = xmlEventReader.nextEvent();
						xmlDoc += "Name :" + xmlEvent.asCharacters().getData()
								+ "\n";
					} else if (startElement.getName().getLocalPart()
							.equals("producer")) {
						xmlEvent = xmlEventReader.nextEvent();
						xmlDoc += "Producer :"
								+ xmlEvent.asCharacters().getData() + "\n";
					} else if (startElement.getName().getLocalPart()
							.equals("model")) {
						xmlEvent = xmlEventReader.nextEvent();
						xmlDoc += "Model :" + xmlEvent.asCharacters().getData()
								+ "\n";
					} else if (startElement.getName().getLocalPart()
							.equals("dateOfIssue")) {
						xmlEvent = xmlEventReader.nextEvent();
						xmlDoc += "DateOfIssue :"
								+ xmlEvent.asCharacters().getData() + "\n";
					} else if (startElement.getName().getLocalPart()
							.equals("color")) {
						xmlEvent = xmlEventReader.nextEvent();
						xmlDoc += "Color :" + xmlEvent.asCharacters().getData()
								+ "\n";
					} else if (startElement.getName().getLocalPart()
							.equals("inStock")) {
						xmlEvent = xmlEventReader.nextEvent();
						test = xmlEvent.asCharacters().getData();
						xmlDoc += "inStock :" + test + "\n";
					} else if (test.equalsIgnoreCase("in stock")) {
						if (startElement.getName().getLocalPart()
								.equals("price")) {
							xmlEvent = xmlEventReader.nextEvent();
							xmlDoc += "Price :"
									+ xmlEvent.asCharacters().getData() + "\n"
									+ "---------------" + "\n";
						} else {
							break;
						}
					}
				}

			}
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}

		return xmlDoc;
	}
}
