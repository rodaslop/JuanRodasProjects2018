<%-- 
    Document   : books.jsp
    Created on : 21-Dec-2017, 10:09:25 AM
    Author     : Juan Rodas
--%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books</title>
        <link rel="stylesheet" href="/JuanRodas-Assignment4/css/styles.css">
    </head>
    <body>
        <sql:setDataSource var = "booksDB" driver = "com.mysql.jdbc.Driver"
                           url = "jdbc:mysql://localhost:3306/books"
                           user = "root"  password = "rodaslop"/>
        <sql:query dataSource = "${booksDB}" var = "result">
            SELECT * FROM titles;
        </sql:query>
        <header>
            <div class="header-nav">
                <a class="button" href="<c:url value="/index.jsp"/>">Home</a>
            </div>
        </header>
            
        <main>
            <div class="header-title">
                <h1 style="color: #0066cc">Books</h1>
                <span style="color: red">${message}</span>
                <a class="add-button" href="<c:url value="/BooksServlet?action=edit-book"/>">
                    <img src="<c:url value="/images/add_icon.png"/>" alt="add button" height="50px" width="50px"/>
                </a>
            </div>
            <div class="table-container">
                <table class="books-table">
                    <thead>
                        <tr>                          
                            <th>ISBN</th>
                            <th>Title ID</th>
                            <th>Edition #</th>
                            <th>Copyright</th>
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach var="book" items="${result.rows}" varStatus="counter">
                        <tr>
                            <td>${book.isbn}</td>
                            <td style="text-align: left">${book.title}</td>
                            <td>${book.editionNumber}</td>
                            <td>${book.copyright}</td>
                            <td><a href="<c:url value="/BooksServlet?action=edit-book&isbn=${book.isbn}"/>">Edit</a></td>
                            <td><a href="<c:url value="/BooksServlet?action=delete-book&isbn=${book.isbn}"/>">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
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
