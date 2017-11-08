/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3inventory;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Table model for representing a list of mp3 files in a table
 * @author Darian
 */
public class Mp3TableModel extends AbstractTableModel {

    private List<Mp3> data;
    
    public Mp3TableModel(){
        data = new ArrayList<>();
    }
    
    /**
     * Add song to songs list
     * @param mp3 Mp3 to add to list
     */
    public void addSong(Mp3 mp3){
        data.add(mp3);
    }

    @Override
    public String getColumnName(int column) {
        switch(column){//Switch on the column to return the name
            case 0:
                return "Title";
            case 1:
                return "Artist";
            case 2:
                return "Album";
            case 3:
                return "Length";
            case 4:
                return "Year";
        }
        return "This shouldn't have happened";//Column is out of range
    }    
    
    @Override
    public int getRowCount() {
        //Rows equal to number of songs in list
        return data.size();
    }

    @Override
    public int getColumnCount() {
        //Always 5 colomns
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //Switches on the column to return the apropriate value
        //Uses row index for index in list
        switch(columnIndex){
            case 0://Title
                return data.get(rowIndex).getTitle();
            case 1://Artist
                return data.get(rowIndex).getArtist();
            case 2://Album
                return data.get(rowIndex).getAlbum();
            case 3://Length
                return data.get(rowIndex).getLength();
            case 4://Year
                return data.get(rowIndex).getYear();
        }
        return null;//This shouldn't be able to happen
    }
    
}
