package bat.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateLibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateLibrarianServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name = request.getParameter("lib_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		String type = CookieRes.getCookieValue(request, "type");

		boolean ret = false;

		if (type.equals("student"))
		{
			int studentId = Integer.parseInt(CookieRes.getCookieValue(request, "student_id"));
			ret = DBOperation.updateStudent(studentId, name, password, email);

		} else
		{
			int userId = Integer.parseInt(CookieRes.getCookieValue(request, "user_id"));
			ret = DBOperation.updateLibrarian(userId, name, password, email);
		}

		if (ret)
		{
			CookieRes.setCookie(response, "name", name);
			response.addHeader("success", "Profile Updated");
		} else
			response.addHeader("success", "Error");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
