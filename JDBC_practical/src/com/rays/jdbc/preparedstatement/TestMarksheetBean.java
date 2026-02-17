package com.rays.jdbc.preparedstatement;

public class TestMarksheetBean {

	public static void main(String[] args) throws Exception {

		testdelete();

		testupdate();

		testadd();
	}

	private static void testadd() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(11);
		bean.setRollNo(111);
		bean.setName("Ronak");
		bean.setPhy(67);
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

		bean.setId(2);

		MarksheetModel model = new MarksheetModel();
		model.delete(bean);

	}

}
