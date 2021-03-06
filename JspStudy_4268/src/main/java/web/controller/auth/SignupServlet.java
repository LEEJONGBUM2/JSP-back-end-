package web.controller.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnectionMgr;
import repository.AuthDao;
import repository.AuthDaoImpl;
import web.service.AuthService;
import web.service.AuthServiceImpl;

/**
 * Servlet implementation class SIgnupServlet
 */
@WebServlet("/auth/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthService authService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
//		DBConnectionMgr pool = DBConnectionMgr.getInstance();
//		AuthDao authDao = new AuthDaoImpl(pool);
		ServletContext servletContext = config.getServletContext();
		
		authService = new AuthServiceImpl((AuthDao)servletContext.getAttribute("authDao"));
	}
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/auth/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(email);
		System.out.println(name);
		System.out.println(username);
		System.out.println(password);
		
		boolean result = authService.signup(email, name, username, password);
		
		if(result == true) {
			response.sendRedirect("/JspStudy_4268/auth/signin");
		}else {
			StringBuilder builder = new StringBuilder();
			builder.append("<body>");
			builder.append("<script>");
			
			builder.append("alert(\"???????????? ??????\");");
			builder.append("history.back();");
			
			builder.append("</script>");
			builder.append("</body>");
			
			out.println(builder.toString());
		}
		
	}
}
