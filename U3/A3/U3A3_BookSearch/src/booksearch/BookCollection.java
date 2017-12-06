/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darian
 */
public class BookCollection {
    private Book[] books;
    
    public BookCollection(Book[] books){
        this.books = books;
    }
    
    /**
     * Load a book collection from a file
     * @param path The path to the file
     * @return The book collection as defined by the file
     */
    public static BookCollection loadFile(String path){
        List<Book> bookList = new ArrayList<>();//Arraylist to store books in temporarily
        BufferedReader br = null;//Buffered reader to read file
        try {
            br = new BufferedReader(new FileReader(path));//Open file into buffered reader
            String line;//Store line
            while((line = br.readLine()) != null){//Iterate through the lines
                bookList.add(//Add new book
                        new Book(br.readLine()//Read title from next line
                                , Integer.parseInt(line)//Parse this line for the reference number
                        ));//This will make it skip every second line which we want
            }
            return new BookCollection((Book[])bookList.toArray());//Convert list to array and return new bok collection
        } catch (IOException ex) {
            Logger.getLogger(BookCollection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(BookCollection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public SearchResult search(SearchMethod method, int refNumber){
        String title;//String to store title
        long timeMillis;//Long integer to store the time it takes
        long startTimeMillis = System.currentTimeMillis();//Get the time before searching
        title = method.search(books, refNumber);//Search
        timeMillis = System.currentTimeMillis() - startTimeMillis;//Get the time elapsed
        return new SearchResult(title, timeMillis);//Create results and return it
    }
}
