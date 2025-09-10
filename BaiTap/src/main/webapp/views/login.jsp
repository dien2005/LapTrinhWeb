<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <!-- Bootstrap CSS -->
    <link href="<c:url value='/css/bootstrap.min.css' />" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet" />
    <style>
        body {
            height: 100vh;
            background: linear-gradient(135deg, #6f42c1, #6610f2);
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .login-card {
            background: #ffffff;
            padding: 40px 30px;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.1);
            width: 100%;
            max-width: 400px;
        }
        .login-card h3 {
            margin-bottom: 25px;
            color: #6610f2;
            font-weight: 600;
        }
        .form-control:focus {
            border-color: #6610f2;
            box-shadow: 0 0 5px rgba(102,16,242,0.5);
        }
        .btn-primary {
            background-color: #6610f2;
            border: none;
        }
        .btn-primary:hover {
            background-color: #6f42c1;
        }
        .input-group-text {
            background-color: #6610f2;
            color: #fff;
            border: none;
        }
        .alert {
            font-size: 0.9rem;
        }
        .register-link a {
            color: #6610f2;
            text-decoration: none;
        }
        .register-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="login-card">
        <h3 class="text-center">Đăng nhập</h3>
        <form action="<c:url value='/login' />" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Tên đăng nhập</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Nhập tên đăng nhập" required>
                </div>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Mật khẩu</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-lock"></i></span>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Nhập mật khẩu" required>
                </div>
            </div>
            <c:if test="${not empty errorMsg}">
                <div class="alert alert-danger" role="alert">
                    ${errorMsg}
                </div>
            </c:if>
            <div class="d-grid mb-3">
                <button type="submit" class="btn btn-primary btn-lg">Đăng nhập</button>
            </div>
            <p class="text-center register-link">
                Chưa có tài khoản? <a href="<c:url value='/register' />">Đăng ký</a>
            </p>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="<c:url value='/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>
