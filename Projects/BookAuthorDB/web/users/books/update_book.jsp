<%-- 
    Document   : update_author
    Created on : 22-Dec-2017, 12:44:03 PM
    Author     : Juan Rodas
--%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Update</title>
        <link rel="stylesheet" href="/JuanRodas-Assignment4/css/styles.css">
    </head>
    <body>
        <header>
            <div class="header-nav">
                <a class="button" href="<c:url value="/index.jsp"/>">Home</a>
            </div>
        </header>
        <div class="form-div">
            <form method="post" action="BooksServlet">
                <input type="hidden" name="action" value="update-book">  
                <table>
                    <tr>
                        <td><h1 class="bolder">Book</h1></td>
                    </tr>
                    <tr>
                        <td><label>ISBN</label></td>
                        <td><input type="text" name="isbn" value="${book.isbn}" ${readonly} required></td>
                    </tr>
                    <tr>
                        <td><label>Title</label></td>
                        <td><input type="text" name="title" value="${book.title}" required></td>
                    </tr>
                    <tr>
                        <td><label>Edition #</label></td>
                        <td><input type="text" name= "editionNumber" value="${book.editionNumber}" required></td>
                    </tr>
                    <tr>
                        <td><label>Copyright</label></td>
                        <td><input type="text" name= "copyright" value="${book.copyright}" required></td>
                    </tr>
                    <tr>
                        <td><a class="button" href="<c:url value="/users/books/books.jsp"/>">Cancel</a></td>
                        <td><input class="button" type="submit" value="Submit"></td>
                    </tr>
                </table>            
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
