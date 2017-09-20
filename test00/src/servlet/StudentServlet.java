package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import entity.Employee;

public class StudentServlet extends HttpServlet {

	StudentDao stuDao = new StudentDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String type = request.getParameter("type");
		if (type == null) {

			showAll(request, response);
		} else if (type.equals("showAdd")) {

			showAdd(request, response);

		} else if (type.equals("add")) {

			add(request, response);

		} else if (type.equals("delete")) {

			delete(request, response);

		} else if (type.equals("showModify")) {

			showModify(request, response);

		} else if (type.equals("modify")) {

			modify(request, response);

		}

	}

	private void modify(HttpServletRequest request, HttpServletResponse response) {
		Employee stu = new Employee();
		int id = Integer.parseInt(request.getParameter("id"));

		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		stu.setId(id);

		stu.setName(name);
		stu.setGender(sex);
		stu.setAge(age);
		boolean flag = stuDao.update(stu);

		if (flag) {
			try {
				response.sendRedirect("student");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void showModify(HttpServletRequest request,
			HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));

		Employee stu = stuDao.searchById(id);
		request.setAttribute("stu", stu);
		try {
			request.getRequestDispatcher("modify.jsp").forward(request,
					response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));
		boolean flag = stuDao.delete(id);
		if (flag) {
			try {
				response.sendRedirect("student");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void add(HttpServletRequest request, HttpServletResponse response) {

		Employee stu = new Employee();
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));

		stu.setName(name);
		stu.setGender(sex);
		stu.setAge(age);
		boolean flag = stuDao.add(stu);

		if (flag) {
			try {
				response.sendRedirect("student");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void showAdd(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getRequestDispatcher("add.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showAll(HttpServletRequest request, HttpServletResponse response) {

		List<Employee> list = stuDao.searchAll();
		//request.setAttribute("stus", list);
		request.setAttribute("emps", list);

		try {
			request.getRequestDispatcher("employee1.jsp").forward(request,
					response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
