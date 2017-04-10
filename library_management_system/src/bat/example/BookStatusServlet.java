package bat.example;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class BookStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookStatusServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int bookId = Integer.parseInt(request.getParameter("book_id"));

		List<IssueInfo> results = DBOperation.bookStatus(bookId);

		response.setContentType("application/json");
		String json = new Gson().toJson(results);

		System.out.println(json);

		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
