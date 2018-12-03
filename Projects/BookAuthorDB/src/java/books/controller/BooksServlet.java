/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books.controller;

import books.data.TitleDB;
import books.model.Title;
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
public class BooksServlet extends HttpServlet {

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
        if (action.equals("edit-book")) {
            url = editBook(request, response);
        } else if (action.equals("delete-book")) {
            url = deleteBook(request, response);
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
        if (action.equals("update-book")) {
            url = updateBook(request, response);
        } else if(action.equals("post-delete-book")) {
            url = postDeleteBook(request, response);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(url);
        view.forward(request, response);
    }

    private String updateBook(HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String editionNumber = request.getParameter("editionNumber");
        String copyright = request.getParameter("copyright");
        Title book = new Title (isbn, title, Integer.parseInt(editionNumber), copyright);
        //check if title exists
        boolean exists = TitleDB.exists(isbn);
        if(exists == true) {
            TitleDB.updateTitle(book);
            message = "ISBN# " + isbn + ", has been updated.";
        } else {
            TitleDB.insertTitle(isbn, title, Integer.parseInt(editionNumber), copyright);
            message = "ISBN# " + isbn + ", has been inserted.";
        }
        request.setAttribute("message", message);
        return "/users/books/books.jsp";
    }

    private String editBook(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        if (isbn != null) {
            request.setAttribute("readonly", "readonly");
            Title book = TitleDB.selectTitle(isbn);
            request.setAttribute("book", book);
        }      
        return "/users/books/update_book.jsp";
    }

    private String deleteBook(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        Title book = TitleDB.selectTitle(isbn);
        request.setAttribute("book", book);
        return "/users/books/confirm_delete_book.jsp";
    }

    private String postDeleteBook(HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        String isbn = request.getParameter("isbn");
        int deleted = TitleDB.deleteTitle(isbn);
        if (deleted == 1) {
            message = "ISBN# " + isbn + ", has been deleted.";
        } else {
            message = "Error: unable to delete ISBN# " + isbn;
        }
        request.setAttribute("message", message);
        return "/users/books/books.jsp";
    }
}
