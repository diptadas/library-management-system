package bat.example;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IssueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IssueBookServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int studentId = Integer.parseInt(request.getParameter("student_id"));
		int bookId = Integer.parseInt(request.getParameter("book_id"));

		boolean ret = DBOperation.issueBook(studentId, bookId, new Date());

		if (ret) response.addHeader("success", "Book Issued");
		else
			response.addHeader("success", "Error");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
