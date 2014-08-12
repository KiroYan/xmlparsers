package com.epam.xmlparserproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.xmlparserproject.xmlparsers.Parser;
import com.epam.xmlparserproject.xmlparsers.StaxParser;
@WebServlet(urlPatterns={"/controller"})
public class MainServlet extends HttpServlet {
	private static final String FILE_PATH = "C:/Users/Kiryl_Kazimirchyk@epam.com/Documents/GitHub/EpamTasks/xmlparsers/productlist.xml";
	private Parser parser;
	String xmlFile;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HERE!");
		processRequest(request, response); 

    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	processRequest(request, response); 

    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException { 
    	System.out.println("HERE! in pro");
    	String parserType = request.getParameter("type");
    	System.out.println(parserType);
    	if (parserType.equals("stax")) {
    		parser = new StaxParser();
    		xmlFile = parser.parseXML(FILE_PATH);
    		request.setAttribute("xmlFile", xmlFile);
    		RequestDispatcher rd = request.getRequestDispatcher("xmlview.jsp");
    		rd.forward(request, response);
    	}
    }
}
