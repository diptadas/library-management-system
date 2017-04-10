package bat.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class StudentStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentStatusServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int studentId = Integer.parseInt(request.getParameter("student_id"));

		List<Object[]> results = DBOperation.studentStatus(studentId);
		List<Map<String, String>> options = new ArrayList<Map<String, String>>();

		for (Object[] res : results)
		{
			Map<String, String> m = new LinkedHashMap<>();
			m.put("book_id", res[0].toString());
			m.put("name", res[1].toString());
			m.put("date_issue", res[2].toString());
			options.add(m);
		}

		response.setContentType("application/json");
		String json = new Gson().toJson(options);

		System.out.println(json);

		response.getWriter().write(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
