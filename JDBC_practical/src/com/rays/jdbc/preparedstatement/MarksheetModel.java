package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MarksheetModel {

	public void add(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "1234567890");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setInt(2, bean.getRollNo());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhy());
		pstmt.setInt(5, bean.getChm());
		pstmt.setInt(6, bean.getMaths());

		int i = pstmt.executeUpdate();

		System.out.println(i + " row affected(record inserted)");

	}

	public void update(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "1234567890");
		
		PreparedStatement pstmt = conn.prepareStatement("UPDATE marksheet SET rollno=?, name=?, phy=?, chm=?, math=? WHERE id=?");
		
		pstmt.setInt(1, bean.getRollNo());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhy());
		pstmt.setInt(4, bean.getChm());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getId());
		
		int i = pstmt.executeUpdate();

		System.out.println(i + " row affected(record updated)");

	}
	
	public void delete(MarksheetBean bean)throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "1234567890");

		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");
		
		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		conn.close();
		pstmt.close();
		
		System.out.println(i + " row affected(record deleted)");
	}

}
