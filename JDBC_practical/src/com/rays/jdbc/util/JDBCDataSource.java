package com.rays.jdbc.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public final class JDBCDataSource {
	
	private static ComboPooledDataSource cpds = null;
	
	private JDBCDataSource() {
		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/advance_java");
			cpds.setUser("root");
			cpds.setPassword("1234567890");
			cpds.setMaxPoolSize(150);
			cpds.setMinPoolSize(10);
			cpds.setAcquireIncrement(10);
			cpds.setInitialPoolSize(10);
		} catch (PropertyVetoException e) {
			
			e.printStackTrace();
		}
	}
	
	private static JDBCDataSource jdbc = null;
	
	private static JDBCDataSource getInstance() {
		
		if (jdbc == null) {
			jdbc = new JDBCDataSource();
		}

		return jdbc;
		
	}
	
	public static Connection getConnection() {
		try {
			return getInstance().cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
