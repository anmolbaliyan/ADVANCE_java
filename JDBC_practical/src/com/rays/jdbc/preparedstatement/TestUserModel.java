package com.rays.jdbc.preparedstatement;

import java.util.Date;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		testAdd();

		testupdate();

		testdelete();

	}

	private static void testdelete() throws Exception {
		UserBean bean = new UserBean();

		bean.setId(14);

		UserModel model = new UserModel();

		model.delete(bean);

	}

	private static void testupdate() throws Exception {
		UserBean bean = new UserBean();

		
		bean.setFirstname("karan");
		bean.setLastname("Mehu");
		bean.setLogin("karan12");
		bean.setPassword("km@123");
		bean.setDob(new Date());
		bean.setId(11);

		UserModel model = new UserModel();

		model.update(bean);
		//update code
		

	}

	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();

		bean.setId(3);
		bean.setFirstname("AAdesh");
		bean.setLastname("Ahuja");
		bean.setLogin("adesh12");
		bean.setPassword("adi@123");
		bean.setDob(new Date());

		UserModel model = new UserModel();

		int id = model.add(bean);

		System.out.println("record interted ad id: " + id);

	}

}
