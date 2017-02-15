package com.nacre.online_assesment.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.util.StringConstants;

@WebServlet("/Availability")
public class Availability extends HttpServlet {

	private static final long serialVersionUID = -734503860925086969L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

          Connection  connection = DbUtil.getConnection();
            Integer uId = (Integer)request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
            String password = request.getParameter("password");
            
          //  Integer uId= Integer.parseInt(uname);
            PreparedStatement ps = connection.prepareStatement("select password from tbl_user where password=? and user_id=?");
            ps.setInt(2,uId);
            ps.setString(1,password);
            ResultSet rs = ps.executeQuery();
            
             
            if (!rs.next()) {
                out.println("<img src=\"" +request.getContextPath() + "/images/invalid.jpg\" />");
            }
            else{
            out.println("<img src=\"" + request.getContextPath() + "/images/valid.jpg\" />");
            }
            out.println();



        } catch (Exception ex) {

            out.println("Error ->" + ex.getMessage());

        } finally {
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

