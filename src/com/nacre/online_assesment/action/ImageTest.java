package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.codec.binary.Base64;

import com.nacre.online_assesment.exception.ImageStreamToByteException;
import com.nacre.online_assesment.util.ImageUtil;

/**
 * Servlet implementation class ImageTest
 */
@WebServlet("/ImageTest")
@MultipartConfig
public class ImageTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Base64 b = new Base64();
	Part p  =	request.getPart("img");
	InputStream is = p.getInputStream();
	
response.setContentType("text/html");
	try {
		response.getWriter().write("<img src='"+ImageUtil.encodeImage(is)+"'></img>");
	} catch (ImageStreamToByteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
