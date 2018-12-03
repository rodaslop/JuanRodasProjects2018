<%-- 
    Document   : update_author
    Created on : 22-Dec-2017, 12:44:03 PM
    Author     : Juan Rodas
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Author Update</title>
        <link rel="stylesheet" href="/JuanRodas-Assignment4/css/styles.css">
    </head>
    <body>
        <header>
            <div class="header-nav">
                <a class="button" href="<c:url value="/index.jsp"/>">Home</a>
            </div>
        </header>
        <div class="form-div">
            <form method="post" action="AuthorsServlet">
                <input type="hidden" name="action" value="update-author">
                <input type="hidden" name="authorID" value="${author.authorID}">
                <table>
                    <tr>
                        <td><h1 class="bolder">Author</h1></td>
                    </tr>
                    <tr>
                        <td><label>First Name</label></td>
                        <td><input type="text" name="firstName" value="${author.firstName}" autofocus /></td>
                    </tr>
                    <tr>
                        <td><label>Last Name</label></td>
                        <td><input type="text" name= "lastName" value="${author.lastName}"></td>
                    </tr>
                    <tr>
                        <td><a class="button" href="<c:url value="/users/authors/authors.jsp"/>">Cancel</a></td>
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
