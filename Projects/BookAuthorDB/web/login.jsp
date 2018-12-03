<%-- 
    Document   : index
    Created on : 20-Dec-2017, 5:56:16 PM
    Author     : Juan Rodas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="/JuanRodas-Assignment4/css/styles.css">
    </head>
    <body>
        <header>
            <div class="header-nav">
                <a href="https://localhost:8443/JuanRodas-Assignment4/index.jsp">
                    <button class="button">Home</button></a>
            </div>
        </header>
        <div class="login-form">
            <h1>Sign In</h1>
            <form method="post" action="j_security_check">
                <input type="text" name="j_username" placeholder="username"><br>
                <input type="password" name= "j_password" placeholder="password"><br>
                <input class="button" type="submit" value="Login">
            </form>
        </div>
        <footer>
            <div>
                <h2 id="footer">Contact</h2>
                <div class="footer-container">
                    <span>JavaEE7 @ Sheridan College</span>
                    <span>By: Juan Rodas</span>
                    <span>rodaslop@sheridancollege.ca</span>
                </div>
            </div>          
        </footer>
    </body>
</html>
