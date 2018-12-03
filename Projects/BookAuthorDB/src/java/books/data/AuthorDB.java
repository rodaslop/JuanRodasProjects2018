/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books.data;

import books.model.Author;
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
public class AuthorDB {

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

    public static Author selectAuthor(int authorID) {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        String query = "SELECT * FROM authors\n"
                + "WHERE authors.authorID = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, authorID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getNString(2);
                String lastName = rs.getNString(3);
                Author author = new Author(id, firstName, lastName);
                return author;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DBUtil.closeConnection(conn);
            DBUtil.closePreparedStatement(ps);
        }
        return null;
    }

    public static ArrayList<Author> selectAuthors() {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        String query = "SELECT * FROM authors";
        try {
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return AuthorDB.getArrayList(rs);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DBUtil.closeConnection(conn);
            DBUtil.closePreparedStatement(ps);
        }
        return null;
    }

    private static ArrayList<Author> getArrayList(ResultSet rs) {
        ArrayList<Author> al = new ArrayList<>();
        try {
            while (rs.next()) {
                int authorID = rs.getInt(1);
                String firstName = rs.getNString(2);
                String lastName = rs.getNString(3);
                Author author = new Author(authorID, firstName, lastName);
                al.add(author);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return al;
    }

    public static int insertAuthor(String firstName, String lastName) {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        String query = "INSERT INTO authors "
                + "(firstName, lastName)"
                + "VALUES (?, ?);";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
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

    public static int updateAuthor(Author author) {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        String query = "UPDATE authors SET\n "
                + "firstName = ?,\n"
                + "lastName = ? \n"
                + "WHERE authorID = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, author.getFirstName());
            ps.setString(2, author.getLastName());
            ps.setInt(3, author.getAuthorID());
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

    public static int deleteAuthor(int authorID) {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        String query = "DELETE FROM authors\n"
                + "WHERE authors.authorID = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, authorID);
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

    public static boolean exists(int authorID) {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        String query = "SELECT * FROM authors\n"
                + "WHERE authors.authorID = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, authorID);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DBUtil.closeConnection(conn);
            DBUtil.closePreparedStatement(ps);
        }
        return false;
    }

}
