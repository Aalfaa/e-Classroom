package com.uap.eclassroom.mahasiswa;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static com.uap.eclassroom.Data.DataManage.classwork;
import static com.uap.eclassroom.Data.DataManage.mahasiswa;
import static com.uap.eclassroom.Data.DataManage.presence;
import static com.uap.eclassroom.Data.DataManage.studentLogin;
import com.uap.eclassroom.Events.TablePLStudent;
import com.uap.eclassroom.componentPanel.DrawerBuilderStudent;
import java.awt.Font;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import jnafilechooser.api.JnaFileChooser;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;
import raven.toast.Notifications;

public class SelfPresence extends javax.swing.JFrame {

    public SelfPresence() {
        initComponents();
        
        String[] Date = {"23 December 2024", "30 December 2024", "6 January 2025", "13 January 2025", "20 January 2025", "27 January 2025",
        "27 January 2025", "3 February 2025", "10 February 2025", "17 February 2025", "24 February 2025"};
        String[] Header = {"Meeting", "Date", "Presence", "Upload Permission Letter"};
        
        
        if(FlatLaf.isLafDark()) {
            navigationButton.setIcon(new ImageIcon(getClass().getResource("/images/three_menu_dark.png")));
            buttonChangeTheme.setText("Dark");
            DrawerBuilderStudent.mode = "Dark";
        }else {
            navigationButton.setIcon(new ImageIcon(getClass().getResource("/images/three_menu_light.png")));
            buttonChangeTheme.setText("Light");
            DrawerBuilderStudent.mode = "Light";
        }
        GlassPanePopup.install(this);
        DrawerBuilderStudent drawerBuilder =  new DrawerBuilderStudent();
        Drawer.getInstance().setDrawerBuilder(drawerBuilder);
       
        setIconNavigation();
        
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        model.setRowCount(0);
        
        DefaultTableModel customModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 3) {
                    return true;
                }else if (column == 2) { 
                    boolean isChecked = (boolean) getValueAt(row, column); 
                    boolean selfPresence = presence.get(row).isSelfPresence(); 

                    return !isChecked && selfPresence;
                }else {
                    return false; 
                }
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return (columnIndex == 2) ? Boolean.class : super.getColumnClass(columnIndex);
            }
        };

        customModel.setColumnIdentifiers(new String[]{"Meeting", "Date", "Presence", "Upload Permission Letter"});

        
        for(int i = 0; i < 10; i++) {
            boolean hadir = false;
            for (int j = 0; j < mahasiswa.size(); j++) {
                if(mahasiswa.get(j).getNIM().equals(studentLogin)) {
                    if(mahasiswa.get(j).getPresence().get(i).equals("Hadir")) {
                        hadir = true;
                    }
                    customModel.addRow(new Object[]{String.valueOf(i+1), Date[i], hadir, null});
                }
            }
        }
        
        tabel.setModel(customModel);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            
        TableColumn column = tabel.getColumnModel().getColumn(0); 
        column.setCellRenderer(centerRenderer);
        column = tabel.getColumnModel().getColumn(1); 
        column.setCellRenderer(centerRenderer);
        
        tabel.getTableHeader().putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
        tabel.putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
        
        tabel.getColumnModel().getColumn(3).setCellRenderer(new TablePLStudent());
    }

    private String[] getColumnNames(DefaultTableModel model) {
            int columnCount = model.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                columnNames[i] = model.getColumnName(i);
            }
            return columnNames;
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        navigationButton = new javax.swing.JButton();
        buttonChangeTheme = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Presence");

        navigationButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\LOQ\\Downloads\\three_menu_dark.png")); // NOI18N
        navigationButton.setContentAreaFilled(false);
        navigationButton.setFocusable(false);
        navigationButton.setPreferredSize(new java.awt.Dimension(35, 35));
        navigationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                navigationButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                navigationButtonMouseExited(evt);
            }
        });
        navigationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navigationButtonActionPerformed(evt);
            }
        });

        buttonChangeTheme.setText("Light");
        buttonChangeTheme.setFocusable(false);
        buttonChangeTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeThemeActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "23 December 2024", null, null},
                {"2", "30 December 2024", null, null},
                {"3", "6 January 2024", null, null},
                {"4", "13 January 2024", null, null},
                {"5", "20 January 2024", null, null},
                {"6", "27 January 2024", null, null},
                {"7", "3 February 2024 ", null, null},
                {"8", "10 February", null, null},
                {"9", "17 February", null, null},
                {"10", "24 February 2024", null, null}
            },
            new String [] {
                "Meeting", "Date", "Presence", "Upload Permission Letter"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel.setColumnSelectionAllowed(true);
        tabel.setFocusable(false);
        tabel.setRowHeight(40);
        tabel.setShowHorizontalLines(true);
        tabel.getTableHeader().setReorderingAllowed(false);
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel);
        tabel.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabel.getColumnModel().getColumnCount() > 0) {
            tabel.getColumnModel().getColumn(0).setResizable(false);
            tabel.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabel.getColumnModel().getColumn(1).setResizable(false);
            tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabel.getColumnModel().getColumn(2).setResizable(false);
            tabel.getColumnModel().getColumn(2).setPreferredWidth(10);
            tabel.getColumnModel().getColumn(3).setResizable(false);
            tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(navigationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonChangeTheme)
                .addGap(19, 19, 19))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonChangeTheme))
                    .addComponent(navigationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void navigationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navigationButtonMouseEntered
        navigationButton.setIcon(new ImageIcon(getClass().getResource("/images/three_menu_hover.png")));
    }//GEN-LAST:event_navigationButtonMouseEntered

    private void navigationButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navigationButtonMouseExited
        setIconNavigation();
    }//GEN-LAST:event_navigationButtonMouseExited

    private void navigationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navigationButtonActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_navigationButtonActionPerformed

    private void buttonChangeThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeThemeActionPerformed
        if(buttonChangeTheme.getText().equals("Dark")) {
            buttonChangeTheme.setText("Light");
            FlatMacLightLaf.setup();
            DrawerBuilderStudent.mode = "Light";
        }else {
            buttonChangeTheme.setText("Dark");
            FlatMacDarkLaf.setup();
            DrawerBuilderStudent.mode = "Dark";
        }
        SwingUtilities.updateComponentTreeUI(this);
        setIconNavigation();
        DrawerBuilderStudent drawerBuilder =  new DrawerBuilderStudent();
        Drawer.getInstance().setDrawerBuilder(drawerBuilder);
        DrawerBuilderStudent.position = this;
    }//GEN-LAST:event_buttonChangeThemeActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int row = tabel.rowAtPoint(evt.getPoint());
        int column = tabel.columnAtPoint(evt.getPoint());
        
        if(column == 3) {
            JnaFileChooser fc = new JnaFileChooser();
            fc.addFilter("Image", "png", "jpg");
            fc.showOpenDialog(this);
            File file = fc.getSelectedFile();
            if(file != null) {
                for(int i = 0; i < mahasiswa.size(); i++) {
                    if (mahasiswa.get(i).getNIM().equals(studentLogin)) {
                        ArrayList<File> temp = mahasiswa.get(i).getPermissionLetter();
                        ArrayList<File> temp2 = new ArrayList<>();
                        for(int j = 0; j < temp.size(); j++) {
                            if(row != j) {
                                temp2.add(temp.get(j));
                            }else {
                                temp2.add(file);
                            }
                        }
                        mahasiswa.get(i).setPermissionLetter(temp2);

                        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Succesfully submmited the work attachment");
                    }

                }
            }
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void setIconNavigation() {
        if (UIManager.getLookAndFeel() instanceof FlatMacDarkLaf) {
            navigationButton.setIcon(new ImageIcon(getClass().getResource("/images/three_menu_dark.png")));
        }else {
            navigationButton.setIcon(new ImageIcon(getClass().getResource("/images/three_menu_light.png")));
        }
    }
    
    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelfPresence().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChangeTheme;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton navigationButton;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
