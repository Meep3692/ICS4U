/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3inventory;

import java.util.Comparator;

/**
 *
 * @author Darian
 */
public class Mp3Comparator<T extends Mp3> implements Comparator<T> {

    //Constatns for sorting. Starts at 1 instead of 0 bc there is no -0 for inverse sorting
    /**
     * Sort by name
     */
    public static final int SORT_NAME = 1;
    /**
     * Sort by artist
     */
    public static final int SORT_ARTIST = 2;
    /**
     * Sort by album
     */
    public static final int SORT_ALBUM = 3;
    /**
     * Sort by length
     */
    public static final int SORT_LENGTH = 4;
    /**
     * Sort by year
     */
    public static final int SORT_YEAR = 5;
    
    //Column to compare
    private int compare;
    
    public Mp3Comparator(int compare){
        this.compare = compare;
    }
    
    @Override
    public int compare(T o1, T o2) {
        int output;
        //Switch on the column to compare and compare the respective value
        switch(Math.abs(compare)){
            case 1://Title
                output = o1.getTitle().compareTo(o2.getTitle());
                break;
            case 2://Artist
                output = o1.getArtist().compareTo(o2.getArtist());
                break;
            case 3://Album
                output = o1.getAlbum().compareTo(o2.getAlbum());
                break;
            case 4://Length
                output = Integer.compare(o1.getLength(), o2.getLength());
                break;
            case 5://Year
                output = Integer.compare(o1.getYear(), o2.getYear());
                break;
            default:
                output = 0;//This shouldn't happen
        }
        //Invert output if compare is negative for inverse sorting
        if(compare > 0)
            return output;
        else
            return -output;
    }
    
}
