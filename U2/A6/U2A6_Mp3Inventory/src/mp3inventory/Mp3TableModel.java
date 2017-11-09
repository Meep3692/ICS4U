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

    private List<Mp3> data;//List of mp3s
    private int sorting;//Current sorting method
    
    public Mp3TableModel(){
        data = new ArrayList<>();//Initialise list
        sorting = 1;//Default to 1
    }
    
    /**
     * Add song to songs list
     * @param mp3 Mp3 to add to list
     */
    public void addSong(Mp3 mp3){
        data.add(mp3);
        sortBy(sorting);//Keep everything in order
    }
    
    /**
     * Sort by a specific column
     * @param column Index of column, negative for inverse sorting
     */
    public void sortBy(int column){
        data.sort(new Mp3Comparator(column));//Sort by comparator with column
        sorting = column;//Set current sorting method
    }
    
    public int getSortingMethod(){
        return sorting;
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
                int length = data.get(rowIndex).getLength();
                if(length < 0) return "Unknown"; else return length;//Return unknown if it's -1
            case 4://Year
                int year = data.get(rowIndex).getYear();
                if(year < 0) return "Unknown"; else return year;//Same as length
        }
        return null;//This shouldn't be able to happen
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //Switch on column index and set values acordingly
        switch(columnIndex){
            case 0://Title
                data.get(rowIndex).setTitle((String)aValue);
                return;
            case 1://Artist
                data.get(rowIndex).setArtist((String)aValue);
                return;
            case 2://Album
                data.get(rowIndex).setAlbum((String)aValue);
                return;
            case 3://Length
                data.get(rowIndex).setLength((int)aValue);
                return;
            case 4://Year
                data.get(rowIndex).setYear((int)aValue);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;//Make cells editable
    }
    
    
    
}
