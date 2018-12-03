/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books.data;

import books.model.Title;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Rodas
 */
public class TitleDB {

    private static Connection getConnection() {
        Connection con = null;
        try {
            String dbURL = "jdbc:mysql://localhost:3306/books";
            String user = "root";
            String pw = "rodaslop";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user, pw);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
    public static Title selectTitle(String isbn) {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        String query = "SELECT * FROM titles\n"
                + "WHERE titles.isbn = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, isbn);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String isbnCol = rs.getNString(1);
                String title = rs.getNString(2);
                int edition = rs.getInt(3);
                String copyright = rs.getNString(4);
                Title book = new Title (isbnCol, title, edition, copyright);    
                return book;
            }  
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DBUtil.closeConnection(conn);
            DBUtil.closePreparedStatement(ps);
        }
        return null;
    }

    public static ArrayList<Title> selectTitles() {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        String query = "SELECT * FROM titles";
        try {
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return TitleDB.getArrayList(rs);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DBUtil.closeConnection(conn);
            DBUtil.closePreparedStatement(ps);
        }
        return null;
    }

    private static ArrayList<Title> getArrayList(ResultSet rs) {
        ArrayList<Title> al = new ArrayList<>();
        try {
            while (rs.next()) {
                String isbn = rs.getNString(1);
                String title = rs.getNString(2);
                int edition = rs.getInt(3);
                String copyright = rs.getNString(4);
                Title book = new Title(isbn, title, edition, copyright);
                al.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return al;
    }

    public static int insertTitle(String isbn, String title, int edition, String copyright) {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        String query = "INSERT INTO titles "
                + "(isbn, title, editionNumber, copyright)"
                + "VALUES (?, ?, ?, ?);";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, isbn);
            ps.setString(2, title);
            ps.setInt(3, edition);
            ps.setString(4, copyright);
            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closeConnection(conn);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static int updateTitle(Title book) {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        String query = "UPDATE titles SET \n"
                + "title = ?, \n"
                + "editionNumber = ?, \n"
                + "copyright = ? \n"
                + "WHERE isbn = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getEditionNumber());
            ps.setString(3, book.getCopyright());
            ps.setString(4, book.getIsbn());
            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closeConnection(conn);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static int deleteTitle(String isbn) {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        String query = "DELETE FROM titles\n"
                + "WHERE titles.isbn = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, isbn);
            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closeConnection(conn);
            DBUtil.closePreparedStatement(ps);
        }
    }
    
    public static boolean exists(String isbn){
        Connection conn = getConnection();
        PreparedStatement ps = null;
        String query = "SELECT * FROM titles\n"
                + "WHERE titles.isbn = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, isbn);
            ResultSet rs = ps.executeQuery();
            boolean exists = rs.first();
            return exists;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DBUtil.closeConnection(conn);
            DBUtil.closePreparedStatement(ps);
        }
        return false;
    }

}
