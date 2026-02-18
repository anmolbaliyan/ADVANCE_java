package com.rays.jdbc.preparedstatement;

import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		// testAdd();

		// testupdate();

		// testdelete();

		//testAuthencticate();

		// testFindByPk();

		 testSearch();

	}

	private static void testSearch() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		List<UserBean> list = model.search(bean);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstname());
			System.out.println(bean.getLastname());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}

	private static void testFindByPk() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByPk(3);

		if (bean != null) {
			System.out.println(bean.getFirstname());
			System.out.println(bean.getLastname());
		} else {
			System.out.println("user not found");
		}

	}

	private static void testAuthencticate() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.authenticate("rahul01", "rah123");

		if (bean != null) {
			System.out.println("user can login...");
			System.out.println(bean.getFirstname());
			System.out.println(bean.getLastname());
		} else {
			System.out.println("invalid login or password");
		}

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
		// update code

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
