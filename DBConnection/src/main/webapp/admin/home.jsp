<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Admin Home</title>
</head>
<body>
    <header>
        <h1>Welcome, Admin!</h1>
    </header>
    <main>
        <p>Xin chào bạn</p>
        <a href="<c:url value='/views/logout' />" class="logout">Đăng xuất</a>
    </main>
</body>
</html>
