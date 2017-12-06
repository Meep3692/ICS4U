/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hockeyteams;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author John
 */
public class StringListEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    
    JButton button;
    List<String> list;
    JFrame frame;
    
    public StringListEditor(){
        button = new JButton();//Create button
        button.setBackground(Color.WHITE);
        button.setActionCommand("edit");
        button.addActionListener(this);
        button.setBorderPainted(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ("edit".equals(e.getActionCommand()))
        {
            //Create dialog and get new array
            list = new StringListEditorDialog(frame, list).showDialog();
            fireEditingStopped();//Editing done
        }
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        list = (List<String>) value;//Get value
        return button;//Show edit button
    }

    @Override
    public Object getCellEditorValue() {
        return list;//Array set by dialog
    }
}
