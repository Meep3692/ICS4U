/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hockeyteams;

import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author John
 */
public class IntArrayRenderer extends DefaultTableCellRenderer {

    public IntArrayRenderer() {
        super();
    }
    
    @Override
    public void setValue(Object value){
        int[] array = (int[]) value;//Cast to int array
        String text = "";//Empty string to hold text representation
        for(int number : array){//For each number in the array
            text += number + ", ";//Add the number to the string with a comma
        }
        text = text.substring(0, text.length() - 2);//Remove comma and space at the end
        setText(text);//Set cell text
    }
    
}
