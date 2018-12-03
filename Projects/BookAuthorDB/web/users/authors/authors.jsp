<%-- 
    Document   : authors
    Created on : 21-Dec-2017, 10:11:05 AM
    Author     : Juan Rodas
--%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authors</title>
        <link rel="stylesheet" href="/JuanRodas-Assignment4/css/styles.css">
    </head>
    <body>
        <sql:setDataSource var = "booksDB" driver = "com.mysql.jdbc.Driver"
                           url = "jdbc:mysql://localhost:3306/books"
                           user = "root"  password = "rodaslop"/>
        <sql:query dataSource = "${booksDB}" var = "result">
            SELECT * FROM authors;
        </sql:query>
        <header>
            <div class="header-nav">
                <a class="button" href="<c:url value="/index.jsp"/>">Home</a>
            </div>
        </header>        
        <main>
            <div class="header-title">
                <h1 style="color:  #0066cc">Authors</h1>
                <span style="color: red">${message}</span>
                <a class="add-button" href="<c:url value="/AuthorsServlet?action=edit-author"/>">
                    <img src="<c:url value="/images/add_icon.png"/>" alt="add button" height="50px" width="50px"/>
                </a>
            </div>
            <div class="table-container">
                <table class="authors-table">
                    <thead>
                        <tr>                  
                            <th>Author ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach var="author" items="${result.rows}" varStatus="counter">
                        <tr>                        
                            <td>${author.authorID}</td>
                            <td>${author.firstName}</td>
                            <td>${author.lastName}</td>
                            <td><a href="<c:url value="/AuthorsServlet?action=edit-author&authorID=${author.authorID}"/>">Edit</a></td>
                            <td><a href="<c:url value="/AuthorsServlet?action=delete-author&authorID=${author.authorID}"/>">Delete</a></td>
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
