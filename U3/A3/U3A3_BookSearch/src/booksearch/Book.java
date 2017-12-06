/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksearch;

import java.util.Objects;

/**
 * A book
 * @author Darian
 */
public class Book {
    private String title;
    private int refNumber;

    /**
     * Create a new book
     * @param title Title
     * @param refNumber Library reference number
     */
    public Book(String title, int refNumber) {
        this.title = title;
        this.refNumber = refNumber;
    }

    /**
     * Get title
     * @return Title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title
     * @param title New title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get library reference number
     * @return Library reference number
     */
    public int getRefNumber() {
        return refNumber;
    }

    /**
     * Set library reference number
     * @param refNumber New library reference number
     */
    public void setRefNumber(int refNumber) {
        this.refNumber = refNumber;
    }

    /**
     * Generate hashcode for this object
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + this.refNumber;
        return hash;
    }

    /**
     * Check if this object is equal to another
     * @param obj The other object to check
     * @return True if they are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.refNumber != other.refNumber) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }
    
    
}
