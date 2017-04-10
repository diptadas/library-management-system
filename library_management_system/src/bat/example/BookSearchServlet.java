package bat.example;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookSearchServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String bookName = request.getParameter("bookName");

		List<BookInfo> results = DBOperation.searchBook(bookName);

		request.setAttribute("bookResult", results);

		String type = CookieRes.getCookieValue(request, "type");

		RequestDispatcher dispatcher;

		if (type.equals("student")) dispatcher = request.getRequestDispatcher("/student_index.jsp");
		else
			dispatcher = request.getRequestDispatcher("/librarian_index.jsp");

		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
