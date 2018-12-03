/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books.model;

/**
 *
 * @author Juan Rodas
 */
public class Author {
    
    private int authorID;
    private String firstName;
    private String lastName;
    
    public Author(){};

    public Author(int authorID, String firstName, String lastName) {
        this.authorID = authorID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the authorID
     */
    public int getAuthorID() {
        return authorID;
    }

    /**
     * @param authorID the authorID to set
     */
    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
