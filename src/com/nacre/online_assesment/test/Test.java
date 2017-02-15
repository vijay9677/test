/**
 * 
 */
package com.nacre.online_assesment.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.ImageUtil;

/**
 * @author Vijay Kumar Reddy K
 *
 */
 class Test {

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args represents Command line arguments
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		// TODO Auto-generated method stub
		
		System.out.println("in test class");
		Connection con=DbUtil.getConnection();
		try{
			
			File file=new File("C:\\Users\\lenovo\\Desktop\\ram.jpg");
			
			InputStream is=new FileInputStream(file);
			String image=ImageUtil.encodeImage(is);
			
			PreparedStatement ps=con.prepareStatement("update tbl_user set image=? where user_id=?");
			ps.setString(1, image);
			ps.setInt(2, 102);
			 int i=ps.executeUpdate();
			 System.out.println("value of i is"+i);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
