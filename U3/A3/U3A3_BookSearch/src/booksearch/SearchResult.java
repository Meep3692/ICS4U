/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksearch;

/**
 *
 * @author Darian
 */
public class SearchResult {
    public final String title;
    public final long timeMillis;

    public SearchResult(String title, long timeMillis) {
        this.title = title;
        this.timeMillis = timeMillis;
    }
}
