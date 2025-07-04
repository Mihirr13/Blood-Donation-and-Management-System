<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Officer Login</title>
    <style>
        body { font-family: Arial; background: #f0f0f0; }
        .login-container {
            width: 400px; margin: 100px auto; padding: 30px;
            background: white; border-radius: 10px; box-shadow: 0 0 10px gray;
        }
        input { width: 100%; padding: 12px; margin: 10px 0; }
        input[type=submit] {
            background-color: #e53935; color: white; border: none; cursor: pointer;
        }
        input[type=submit]:hover { background-color: #c62828; }
        .error { color: red; text-align: center; }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Officer Login</h2>
    <form action="OfficerLoginServlet" method="post">
        <input type="text" name="email" placeholder="Email" required />
        <input type="password" name="password" placeholder="Password" required />
        <input type="submit" value="Login" />
    </form>
    <div class="error">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </div>
</div>
</body>
</html>
