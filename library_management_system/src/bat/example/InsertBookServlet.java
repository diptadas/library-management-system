package bat.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertBookServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name = request.getParameter("name");
		int edition = Integer.parseInt(request.getParameter("edition"));
		String category = request.getParameter("category");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		boolean ret = DBOperation.insertBook(name, edition, category, author, publisher, quantity);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (ret) out.println("<html><div class='alert alert-success alert-dismissable fade in'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Book Inserted.</strong></div></html>");
		else
			out.println("<html><div class='alert alert-danger alert-dismissable fade in'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>'><strong>Failed! Please try again.</strong></div></html>");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/librarian_index.jsp");
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
