<%-- 
    Document   : home
    Created on : 21-Dec-2017, 9:57:13 AM
    Author     : Juan Rodas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <header>
            <div class="header-nav">
                <a href="https://localhost:8443/JuanRodas-Assignment4/index.jsp">
                    <button class="button button-active">Home</button></a>
                <a href="#footer"><button class="button">Contact</button></a>
            </div>
            <div class="header-title">
                <h1 style="position: relative; top:20px">Book-Author Database</h1>
                <img class="overlap" src="images/book_image.jpg" alt="home-image">
            </div>
        </header>
        <main>
            <div class="main-images">
                <div>
                    <img src="images/author_image.jpg" alt="home-image"/><br>
                    <a href="https://localhost:8443/JuanRodas-Assignment4/users/authors/authors.jsp">View Authors</a>
                </div>
                <div>
                    <img src="images/books_image.jpg" alt="home-image"/><br>
                    <a href="https://localhost:8443/JuanRodas-Assignment4/users/books/books.jsp">View Books</a>
                </div>
            </div>
            <div class="welcome-section">
                <h2>Welcome to lorum ipsum</h2>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
                    Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
                    when an unknown printer took a galley of type and scrambled it to make a 
                    type specimen book. It has survived not only five centuries, but also the leap into 
                    electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s 
                    with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop 
                    publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
            </div>
        </main>
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
