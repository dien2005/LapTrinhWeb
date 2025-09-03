<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

    <!-- FontAwesome -->
    <link rel="stylesheet" 
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow-lg rounded-3">
                <div class="card-body p-4">
                    <h2 class="text-center mb-4">Quên mật khẩu</h2>

                    <!-- Hiển thị thông báo -->
                    <c:if test="${alert != null}">
                        <div class="alert alert-danger text-center">${alert}</div>
                    </c:if>

                    <!-- Form quên mật khẩu -->
                    <form action="${pageContext.request.contextPath}/views/forgot_password" method="post">
                        <!-- Email -->
						<div class="mb-3">
						    <label class="form-label">Email</label>
						    <div class="input-group">
						        <span class="input-group-text">
						            <i class="fa fa-envelope"></i>
						        </span>
						        <input type="email" name="email" 
						               class="form-control" placeholder="Nhập email đã đăng ký" required>
						    </div>
						</div>

                        <!-- Submit -->
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">
                                <i class="fa fa-paper-plane"></i> Gửi yêu cầu
                            </button>
                        </div>					
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
