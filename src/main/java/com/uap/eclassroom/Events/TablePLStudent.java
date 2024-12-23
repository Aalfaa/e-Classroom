package com.uap.eclassroom.Events;

import com.uap.eclassroom.componentPanel.ItemPermissionLetterStudent;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TablePLStudent extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
    
        ItemPermissionLetterStudent buttonUpload = new ItemPermissionLetterStudent();
       
        return buttonUpload;
    }
    
}
