/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hockeyteams;

import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author John
 */
public class ListRenderer extends DefaultTableCellRenderer {
    
    public ListRenderer() {
        super();
    }
    
    @Override
    public void setValue(Object value){
        List array = (List) value;//Cast to List
        if(array.size() == 0){//If the size is zero, it gets weird
            setText("");//Just set to empty string
            return;
        }
        String text = "";//Empty string to hold text representation
        for(Object object : array){//For each object in the list
            text += object.toString() + ", ";//Use object's toString method to add to string with comma
        }
        text = text.substring(0, text.length() - 2);//Remove comma and space at the end
        setText(text);//Set cell text
    }
}
