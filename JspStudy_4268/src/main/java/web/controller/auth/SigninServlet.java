package web.controller.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import repository.AuthDao;

import web.service.AuthService;
import web.service.AuthServiceImpl;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/auth/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthService authService;
	/*
	 * private String username; private String password;
	 * 
	 * @Override public void init() throws ServletException { username = "jongbum";
	 * password = "1234"; }
	 */
	
	@Override
	public void init(ServletConfig config) throws ServletException {
//		DBConnectionMgr pool = DBConnectionMgr.getInstance();
//		AuthDao authDao = new AuthDaoImpl(pool);
		ServletContext servletContext = config.getServletContext();
		
		authService = new AuthServiceImpl((AuthDao)servletContext.getAttribute("authDao"));
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 서블릿 get요청");
		request.getRequestDispatcher("/WEB-INF/views/auth/signin.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 서블릿 post요청");
		response.setContentType("text/html;charset=utf8");
//		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Map<String, ?> msg = authService.signin(username, password);
		
		if(msg.containsKey("200")) {
			System.out.println("test");
			HttpSession session = request.getSession();
			session.setAttribute("principal", authService.getUser(username));
			//session.setAttribute("username", "jongbum");
			//session.setAttribute("name", "이종범");
			//session.setAttribute("email", "jongbum@gmail.com");
			response.sendRedirect("/JspStudy_4268/profile/mypage");
			//request.getRequestDispatcher("/WEB-INF/views/profile/mypage.jsp").forward(request, response);
			
		}else {
			StringBuilder builder = new StringBuilder();
			builder.append("<body>");
			builder.append("<script>");
			
			builder.append("alert(\"" + (msg.containsKey("400")? msg.get("400") : msg.get("500")) + "\");");
			builder.append("history.back();");
			
			builder.append("</script>");
			builder.append("</body>");
			
			out.println(builder.toString());
		}
		
		
		System.out.println("포스트 요청옴?");
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		
		/*
		 * if(username.equals(this.username)) { if(password.equals(this.password)) {
		 * System.out.println("로그인 성공"); } }
		 */
	}
}
