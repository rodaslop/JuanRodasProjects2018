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
public class Title {
    
    private String isbn;
    private String title;
    private int editionNumber;
    private String copyright;
    
    public Title(){};

    public Title(String isbn, String title, int edition, String copyright) {
        this.isbn = isbn;
        this.title = title;
        this.editionNumber = edition;
        this.copyright = copyright;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the editionNumber
     */
    public int getEditionNumber() {
        return editionNumber;
    }

    /**
     * @param editionNumber the editionNumber to set
     */
    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    /**
     * @return the copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * @param copyright the copyright to set
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
    
    
}
