package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarksheetModel {

	ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.resourcebundle.app");

	String url = rb.getString("url");
	String driver = rb.getString("driver");
	String username = rb.getString("username");
	String password = rb.getString("password");

	public void add(MarksheetBean bean) throws Exception {

		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, password);

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

		PreparedStatement pstmt = conn
				.prepareStatement("UPDATE marksheet SET rollno=?, name=?, phy=?, chm=?, math=? WHERE id=?");

		pstmt.setInt(1, bean.getRollNo());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhy());
		pstmt.setInt(4, bean.getChm());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(i + " row affected(record updated)");

	}

	public void delete(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "1234567890");

		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		conn.close();
		pstmt.close();

		System.out.println(i + " row affected(record deleted)");
	}

	public MarksheetBean findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "1234567890");

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChm(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			
		}

		return bean;

	}

	public List<MarksheetBean> search(MarksheetBean bean) throws Exception {

		Class.forName(driver);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "1234567890");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");

		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and Name like '" + bean.getName() + "%'");
			}
			/*if (bean.getLastname() != null && bean.getLastname().length() > 0) {
				sql.append(" and lastName like '" + bean.getLastname() + "%'");
			}*/
		}

		System.out.println("sql ===> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		// PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");

		ResultSet rs = pstmt.executeQuery();

		List<MarksheetBean> list = new ArrayList<MarksheetBean>();

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChm(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
		}

		return list;

	}

}
