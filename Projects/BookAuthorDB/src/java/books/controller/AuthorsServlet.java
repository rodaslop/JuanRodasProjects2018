/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books.controller;

import books.data.AuthorDB;
import books.model.Author;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Rodas
 */
public class AuthorsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "view-index"; //default action
        }

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("edit-author")) {
            url = editAuthor(request, response);
        } else if (action.equals("delete-author")) {
            url = confirmDelete(request, response);
        }

        RequestDispatcher view = request.getRequestDispatcher(url);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "view-index"; //default action
        }

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("update-author")) {
            url = updateAuthor(request, response);
        } else if (action.equals("post-delete-author")) {
            url = postDeleteAuthor(request, response);
        }

        RequestDispatcher view = request.getRequestDispatcher(url);
        view.forward(request, response);
    }

    private String updateAuthor(HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        String authorID = request.getParameter("authorID");
        System.out.println("authorID: " + authorID);
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        if (authorID.isEmpty()) {
            AuthorDB.insertAuthor(firstName, lastName);
            message = "Author " + firstName + " " + lastName + ", has been created.";
        } else {
            Author author = new Author(Integer.parseInt(authorID), firstName, lastName);
            AuthorDB.updateAuthor(author);
            message = "AuthorID# " + authorID + ", has been updated.";
        }
        request.setAttribute("message", message);
        return "/users/authors/authors.jsp";
    }

    private String editAuthor(HttpServletRequest request, HttpServletResponse response) {
        String authorID = request.getParameter("authorID");
        System.out.println("authorID:" + authorID);
        //create exists method
        if (authorID != null) {
            //select existing author
            Author author = AuthorDB.selectAuthor(Integer.parseInt(authorID));
            request.setAttribute("author", author);
        }
        
        return "/users/authors/update_author.jsp";
    }

    private String confirmDelete(HttpServletRequest request, HttpServletResponse response) {
        String authorID = request.getParameter("authorID");
        Author author = AuthorDB.selectAuthor(Integer.parseInt(authorID));
        request.setAttribute("author", author);
        return "/users/authors/confirm_delete_author.jsp";
    }

    private String postDeleteAuthor(HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        String authorID = request.getParameter("authorID");
        int deleted = AuthorDB.deleteAuthor(Integer.parseInt(authorID));
        if (deleted == 1) {
            message = "AuthorID# " + authorID + ", has been deleted.";
        } else {
            message = "Error: unable to delete AuthorID# " + authorID;
        }
        request.setAttribute("message", message);
        return "/users/authors/authors.jsp";
    }
}
