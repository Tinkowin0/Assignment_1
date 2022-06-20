package com.jdc.assignment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jdc.assignment.domain.Registration;
import com.jdc.assignment.modle.OpenClassModel;
import com.jdc.assignment.modle.RegistrationModel;

@WebServlet(urlPatterns = { "/registration", "/reg-edit" })
public class RegistrationServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var classId = req.getParameter("cId");
		var openModel = getBean("openClassModel", OpenClassModel.class);
		var openC = openModel.findByOPId(Integer.parseInt(classId));

		var couresId = req.getParameter("courseIDD").toString();
		var couresName = req.getParameter("courseName").toString();

		req.setAttribute("openC", openC);
		req.setAttribute("cc", couresId);
		req.setAttribute("cn", couresName);

		var page = switch (req.getServletPath()) {
		case "/registration" -> {
			var model = getBean("regModel", RegistrationModel.class);
			req.setAttribute("registration", model.findByClass(Integer.parseInt(classId)));
			yield "registration";
		}
		default -> "reg-edit";
		};
		getServletContext().getRequestDispatcher("/%s.jsp".formatted(page)).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var student = req.getParameter("student");
		var phone = req.getParameter("phone");
		var email = req.getParameter("email");
		var cour = req.getParameter("cou");

		var cn = req.getParameter("courseName");
		var ci = req.getParameter("courseIDD");

		var openModel = getBean("openClassModel", OpenClassModel.class);
		var openC = openModel.findByOPId(Integer.parseInt(cour));

		var reg = new Registration();
		reg.setOpenClass(openC);
		reg.setStudent(student);
		reg.setPhone(phone);
		reg.setEmail(email);

		getBean("regModel", RegistrationModel.class).input(reg);
		resp.sendRedirect("/registration?cId=" + cour + "&courseName=" + cn + "&courseIDD=" + ci);
	}
}
