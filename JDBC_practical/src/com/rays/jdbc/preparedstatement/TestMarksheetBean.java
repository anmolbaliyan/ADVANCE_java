package com.rays.jdbc.preparedstatement;

import java.util.Iterator;
import java.util.List;

public class TestMarksheetBean {

	public static void main(String[] args) throws Exception {

		 testdelete();

		// testupdate();

		// testadd();

		//testFindByPk();
		
		//testsearch();
	}

	private static void testsearch() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		
		bean.setName("K");

		List<MarksheetBean> list = model.search(bean);

		Iterator<MarksheetBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getName());
			System.out.println(bean.getPhy());
			System.out.println(bean.getChm());
			System.out.println(bean.getMaths());
		}
		
	}

	private static void testFindByPk() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();

		bean = model.findByPk(3);

		if (bean != null) {
			System.out.println(bean.getRollNo());
			System.out.println(bean.getName());
		} else {
			System.out.println("user not found");
		}

	}

	private static void testadd() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(2);
		bean.setRollNo(102);
		bean.setName("Rakuten");
		bean.setPhy(69);
		bean.setChm(89);
		bean.setMaths(98);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);

	}

	private static void testupdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(3);
		bean.setRollNo(103);
		bean.setName("Anirudh");
		bean.setPhy(89);
		bean.setChm(67);
		bean.setMaths(56);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);

	}

	private static void testdelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(11);

		MarksheetModel model = new MarksheetModel();
		model.delete(bean);

	}

}
