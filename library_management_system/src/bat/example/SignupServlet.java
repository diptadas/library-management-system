package bat.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int studentId = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		boolean ret = DBOperation.studentReg(studentId, name, "CSE", password, email);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (ret) out.println("<html><div class='alert alert-success'><strong>Registration Completed!</strong></div></html>");
		else
			out.println("<html><div class='alert alert-danger'><strong>Registration Failed! Please try again.</strong></div></html>");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
