package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GradeInput
 */
@WebServlet("/grade-Input")
public class GradeInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("test", "test입니다.");
		request.getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
		//req, res는 매개변수에 받는 것을 그대로 전달 한다. 
		//forward(request)가 모델이된다.
	}

}
