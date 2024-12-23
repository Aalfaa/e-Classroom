package com.uap.eclassroom.Events;

import com.uap.eclassroom.Data.DataManage;
import com.uap.eclassroom.componentPanel.ItemPermissionLetterTeacher;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TablePLTeacher extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
    
        ItemPermissionLetterTeacher buttonGet = new ItemPermissionLetterTeacher();
        
        return buttonGet;
    }
    
}
