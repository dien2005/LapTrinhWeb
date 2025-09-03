package vn.duonghao.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.duonghao.services.UserService;
import vn.duonghao.services.Impl.UserServiceImpl;

import java.io.IOException;
import java.util.UUID;

/**
 * Servlet implementation class ForgotPasswordController
 */
@WebServlet(urlPatterns = "/views/forgot_password")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordController() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String email = request.getParameter("email");
		UserService service = new UserServiceImpl();

		if (!service.checkExistEmail(email)) {
			request.setAttribute("alert", "Email không tồn tại!");
			request.getRequestDispatcher("/views/forgot_password.jsp").forward(request, response);
			return;
		}

		// Tạo mật khẩu ngẫu nhiên
		String newPassword = UUID.randomUUID().toString().substring(0, 8);

		// Update vào DB
		boolean isUpdated = service.updatePasswordByEmail(email, newPassword);

		if (isUpdated) {
			// TODO: Gửi email mật khẩu mới (tạm thời hiển thị ra cho dễ test)
			request.setAttribute("alert", "Mật khẩu mới của bạn là: " + newPassword);
		} else {
			request.setAttribute("alert", "Có lỗi khi cập nhật mật khẩu!");
		}

		request.getRequestDispatcher("/views/forgot_password.jsp").forward(request, response);
	}
}
