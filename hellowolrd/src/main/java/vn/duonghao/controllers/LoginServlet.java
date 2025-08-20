package vn.duonghao.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
//		String username1 = request.getParameter("username");
//		String password1 = request.getParameter("password");
//		if (username1.equals("trungnh") && password1.equals("123")) {
//			out.print("Chào mừng bạn, " + username1);
//			HttpSession session = request.getSession();
//			session.setAttribute("name", username1);
//		} else {
//			out.print("Tài khoản hoặc mật khẩu không chính xác");
//			request.getRequestDispatcher("login.html").include(request, response);
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password");
		if (username1.equals("trungnh") && password1.equals("123")) {
			out.print("Chao mung ban, " + username1);
			HttpSession session = request.getSession();
			session.setAttribute("name", username1);
		} else {
			out.print("Tai khoan khong chinh xac");
			request.getRequestDispatcher("login.html").include(request, response);
		}

	}
//		response.setContentType("text/html");
//		String user = request.getParameter("username");
//		String pass = request.getParameter("password");
//		if (user.equals("trung") && pass.equals("123")) {
//			Cookie cookie = new Cookie("username", user);
//			cookie.setMaxAge(30);
//			response.addCookie(cookie);
//			response.sendRedirect("/hellowolrd/xin-chao");
//		} else {
//			response.sendRedirect("/hellowolrd/login");
//		}
//	}

}
