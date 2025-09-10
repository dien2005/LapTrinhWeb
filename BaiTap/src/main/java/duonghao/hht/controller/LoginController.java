package duonghao.hht.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import duonghao.hht.models.UserModel;
import duonghao.hht.services.IUserService;
import duonghao.hht.services.Impl.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException
    {
    		userService = new UserServiceImpl();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        UserModel user = userService.login(username, password);

	        if (user != null) {
	            // Lưu user vào session
	            HttpSession session = request.getSession();
	            session.setAttribute("currentUser", user);

	            // Nếu là admin thì chuyển hướng admin.jsp, ngược lại home.jsp
	            if (user.isAdmin()) {
	                response.sendRedirect("/admin/admin.jsp");
	            } else {
	                response.sendRedirect("/home/home.jsp");
	            }
	        } else {
	            // Sai tài khoản hoặc mật khẩu
	            request.setAttribute("error", "Sai username hoặc password");
	            request.getRequestDispatcher("/web/login.jsp").forward(request, response);
	        }
	}

}
