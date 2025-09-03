<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tạo tài khoản mới</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    
</head>
<body>

<div class="register-form">
    <form action="register" method="post">
        <h2>Tạo tài khoản mới</h2>

        <!-- Hiển thị thông báo lỗi -->
        <c:if test="${alert != null}">
            <div class="alert alert-danger text-center">${alert}</div>
        </c:if>

        <!-- Username -->
        <div class="form-group input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><i class="fa fa-user"></i></span>
            </div>
            <input name="username" class="form-control" placeholder="Tên đăng nhập" type="text" required>
        </div>

        <!-- Fullname -->
        <div class="form-group input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><i class="fa fa-id-card"></i></span>
            </div>
            <input name="fullname" class="form-control" placeholder="Họ tên" type="text" required>
        </div>

        <!-- Email -->
        <div class="form-group input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><i class="fa fa-envelope"></i></span>
            </div>
            <input name="email" class="form-control" placeholder="Nhập Email" type="email" required>
        </div>

        <!-- Phone -->
        <div class="form-group input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><i class="fa fa-phone"></i></span>
            </div>
            <input name="phone" class="form-control" placeholder="Số điện thoại" type="text" required>
        </div>

        <!-- Password -->
        <div class="form-group input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><i class="fa fa-lock"></i></span>
            </div>
            <input name="password" class="form-control" placeholder="Mật khẩu" type="password" required>
        </div>

        <!-- Confirm Password -->
        <div class="form-group input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><i class="fa fa-lock"></i></span>
            </div>
            <input name="confirmPassword" class="form-control" placeholder="Nhập lại mật khẩu" type="password" required>
        </div>

        <!-- Submit -->
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Tạo tài khoản</button>
        </div>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
