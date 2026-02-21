package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.rays.jdbc.exception.DuplicateRecordException;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserModel {
	
	ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.resourcebundle.app");

	String url = rb.getString("url");
	String driver = rb.getString("driver");
	String username = rb.getString("username");
	String password = rb.getString("password");

	public int add(UserBean bean) throws Exception {

		UserBean existsbean = findByLogin(bean.getLogin());
		if (existsbean != null) {
			throw new DuplicateRecordException("email id already exists");
		}

		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, password);

		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getFirstname());
		pstmt.setString(3, bean.getLastname());
		pstmt.setString(4, bean.getLogin());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

		int i = pstmt.executeUpdate();

		System.out.println(i + " row affected(record inserted)");

		return bean.getId();

	}

	public void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "1234567890");

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_user set firstname = ?, lastname = ?, login = ?, password = ?, dob = ? where id = ?");

		pstmt.setString(1, bean.getFirstname());
		pstmt.setString(2, bean.getLastname());
		pstmt.setString(3, bean.getLogin());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		conn.close();
		pstmt.close();
		System.out.println(i + " row affected(record update)");

	}

	public void delete(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "1234567890");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		conn.close();
		pstmt.close();

		System.out.println(i + " row affected(record deleted)");

	}

	public UserBean findByLogin(String login) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "1234567890");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ?");

		pstmt.setString(1, login);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
		}

		return bean;

	}

	public UserBean authenticate(String login, String password) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "1234567890");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ? and password = ?");

		pstmt.setString(1, login);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
		}

		return bean;

	}

	public UserBean findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "1234567890");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
		}

		return bean;

	}

	public List<UserBean> search(UserBean bean) throws Exception {

		//Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "1234567890");

		StringBuffer sql = new StringBuffer("select * from st_user where 1=1");

		if (bean != null) {
			if (bean.getFirstname() != null && bean.getFirstname().length() > 0) {
				sql.append(" and firstName like '" + bean.getFirstname() + "%'");
			}
			if (bean.getLastname() != null && bean.getLastname().length() > 0) {
				sql.append(" and lastName like '" + bean.getLastname() + "%'");
			}
		}

		System.out.println("sql ===> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		//PreparedStatement pstmt = conn.prepareStatement("select * from st_user");

		ResultSet rs = pstmt.executeQuery();

		List<UserBean> list = new ArrayList<UserBean>();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			list.add(bean);
		}

		return list;

	}

}
