/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksearch;

/**
 *  Interface for search methods used by BookCollection
 * @author Darian
 */
public interface SearchMethod {
    public String search(Book[] books, int refNumber);
}
