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
            <h1 class="bolder">Are you sure you want to delete?</h1>
            <table>
                <tr>
                    <td><label>First Name</label></td>
                    <td>${author.firstName}</td>
                </tr>
                <tr>
                    <td><label>Last Name</label></td>
                    <td>${author.lastName}</td>
                </tr>
                <tr>
                    <td><a class="button" href="<c:url value="/users/authors/authors.jsp"/>">No</a></td>
                    <td>
                        <form method="post" action="AuthorsServlet">
                            <input type="hidden" name="action" value="post-delete-author">
                            <input type="hidden" name="authorID" value="${author.authorID}">
                            <input class="button" type="submit" value="Yes">
                        </form>
                    </td>
                </tr>
            </table>
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
