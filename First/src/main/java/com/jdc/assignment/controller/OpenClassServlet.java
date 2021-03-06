package com.jdc.assignment.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jdc.assignment.domain.OpenClass;
import com.jdc.assignment.modle.CourseModel;
import com.jdc.assignment.modle.OpenClassModel;

@WebServlet(urlPatterns = { "/classes", "/class-edit" })
public class OpenClassServlet extends AbstractBeanFactoryServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var courseId = req.getParameter("courseId");
		var courseModel = getBean("courseModel", CourseModel.class);
		var course = courseModel.findById(Integer.parseInt(courseId));

		req.setAttribute("course", course);
		var page = switch (req.getServletPath()) {
		case "/classes" -> {
			var model = getBean("openClassModel", OpenClassModel.class);
			req.setAttribute("classes", model.findByCourse(Integer.parseInt(courseId)));
			yield "classes";
		}
		default -> "class-edit";
		};
		getServletContext().getRequestDispatcher("/%s.jsp".formatted(page)).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var teacher = req.getParameter("teacher");
		var date = req.getParameter("date");
		var cour = req.getParameter("cou");

		var courseModel = getBean("courseModel", CourseModel.class);
		var course = courseModel.findById(Integer.parseInt(cour));

		var openClass = new OpenClass();
		openClass.setCourse(course);
		openClass.setTeacher(teacher);
		var ld = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
		openClass.setStartDate(ld);

		getBean("openClassModel", OpenClassModel.class).creat(openClass);
		resp.sendRedirect("/classes?courseId=" + cour);
	}
}
