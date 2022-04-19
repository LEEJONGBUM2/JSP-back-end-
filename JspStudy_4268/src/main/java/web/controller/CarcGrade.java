package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GradeServlet
 */
@WebServlet("/calc-grade")
public class CarcGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	/*
	 * public void init(ServletConfig config) throws ServletException {
	 * System.out.println("서블릿 실행"); }
	 */

	/**
	 * @see Servlet#destroy()
	 */
	/*
	 * public void destroy() { System.out.println("서블릿 종료"); }
	 */

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String[] subjects = request.getParameterValues("subject");
		String[] grade = request.getParameterValues("grade");
		String[] time = request.getParameterValues("time");
		
		double score = 0;
		int totalTime = 0;
		double gradeAvg = 0;
		
		for(int i = 0; i < subjects.length; i++){
			totalTime += Integer.parseInt(time[i]);
			
			if(grade[i].equals("A+")){
				score += (4.5 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("A")){
				score += (4.0 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("B+")){
				score += (3.5 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("B")){
				score += (3.0 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("C+")){
				score += (2.5 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("C")){
				score += (2.0 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("D+")){
				score += (1.5 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("D")){
				score += (1.0 * Integer.parseInt(time[i]));
			}else{
				score += 0;
			}
		}
		
		gradeAvg = score / totalTime;
		
		request.setAttribute("grade", gradeAvg);
		
		StringBuilder builder = new StringBuilder(); //이런식으로 만들면 스크립트에 바로 넣을수가 있고 실행 시킬수가 있다
		builder.append("<body>");
		builder.append("<script>");
		builder.append("alert(\"총 평점:"+ gradeAvg +"\");");
		builder.append("history.back();"); //history back은 뒤로가기와 같은 기능이다.
		builder.append("</script>");
		builder.append("</body>");
		
		System.out.println(builder.toString());
		out.write(builder.toString()); //out.write가 데이터를 전송하는 것이다.
		/* out.print(builder.toString()); */
			
		//		String grade = request.getParameter("grade");
//		PrintWriter out = response.getWriter();
		//response.setHeader("Content-Type", "text/plain;charset=UTF-8");
		//request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/plain;charset=utf-8");
//		response.setCharacterEncoding("UTF-8");
//		
//		String grade = request.getParameter("grade");
//		
//		PrintWriter out = response.getWriter();
//		out.println("학생의 성적: " + grade);
//		System.out.println(grade);
		//System.out.println("서블릿 내용");
	}

}
