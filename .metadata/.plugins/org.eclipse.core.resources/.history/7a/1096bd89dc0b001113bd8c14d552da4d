package com.rays.jdbc.preparedstatement;

import java.util.Date;

public class TestUserModel {
	
	public static void main(String[] args) throws Exception {
		
		UserBean bean = new UserBean();
		
		bean.setId(14);
		bean.setFirstname("luckey");
		bean.setLastname("ji");
		bean.setLogin("luckey12");
		bean.setPassword("luckey@123");
		bean.setDob(new Date());
		
		UserModel model = new UserModel();
		
		int id = model.add(bean);
		
		System.out.println("record interted ad id: " + id);
		
	}
	
	
	
	

}
