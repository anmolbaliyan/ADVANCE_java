package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserModel {
	
	public int add(UserBean bean) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "1234567890");
		
		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?)");
		
		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getFirstname());
		pstmt.setString(3, bean.getLastname());
		pstmt.setString(4, bean.getLogin());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob() .getTime()));
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i + " row affected(record inserted)");
		
		return bean.getId();
		
		
	}

}
