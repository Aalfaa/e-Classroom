package com.uap.eclassroom.dosen;

import com.uap.eclassroom.Data.ExcelRecap;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.uap.eclassroom.componentPanel.DrawerBuilderTeacher;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

public class PresenceList extends javax.swing.JFrame {

    public PresenceList() {
        initComponents();
        
        tabel.getTableHeader().putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
        tabel.putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            
        TableColumn column = tabel.getColumnModel().getColumn(0); 
        column.setCellRenderer(centerRenderer);
        column = tabel.getColumnModel().getColumn(1); 
        column.setCellRenderer(centerRenderer);
        
        if(FlatLaf.isLafDark()) {
            navigationButton.setIcon(new ImageIcon(getClass().getResource("/images/three_menu_dark.png")));
            buttonChangeTheme.setText("Dark");
            DrawerBuilderTeacher.mode = "Dark";
        }else {
            navigationButton.setIcon(new ImageIcon(getClass().getResource("/images/three_menu_light.png")));
            buttonChangeTheme.setText("Light");
            DrawerBuilderTeacher.mode = "Light";
        }
        GlassPanePopup.install(this);
        DrawerBuilderTeacher drawerBuilder =  new DrawerBuilderTeacher();
        Drawer.getInstance().setDrawerBuilder(drawerBuilder);
        
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tabel.rowAtPoint(e.getPoint());
                JFrame frameNow = (JFrame) SwingUtilities.getWindowAncestor(e.getComponent());
                Point currentLocation = frameNow.getLocation();
                PresenceEdit frame2 = new PresenceEdit(String.valueOf(row+1));
                frame2.setLocation(currentLocation);
                frame2.setVisible(true);
                dispose();
               
            }
        });
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
        jButton1 = new javax.swing.JButton();

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

        buttonChangeTheme.setText("Dark");
        buttonChangeTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeThemeActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "23 December 2024"},
                {"2", "30 December 2024"},
                {"3", "6 January 2025"},
                {"4", "13 January 2025"},
                {"5", "20 January 2025"},
                {"6", "27 January 2025"},
                {"7", "3 February 2025"},
                {"8", "10 February 2025"},
                {"9", "17 February 2025"},
                {"10", "24 February 2025"}
            },
            new String [] {
                "Meeting", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel.setFocusable(false);
        tabel.setRowHeight(40);
        tabel.setShowHorizontalLines(true);
        jScrollPane3.setViewportView(tabel);

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

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Recap");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonChangeTheme)
                .addGap(19, 19, 19))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        if(buttonChangeTheme.getText().equals("Light")) {
            buttonChangeTheme.setText("Dark");
            FlatMacDarkLaf.setup();
        }else {
            buttonChangeTheme.setText("Light");
            FlatMacLightLaf.setup();
        }
        SwingUtilities.updateComponentTreeUI(this);
        setIconNavigation();
        Drawer.getInstance().closeDrawer();
        DrawerBuilderTeacher drawerBuilder =  new DrawerBuilderTeacher();
        Drawer.getInstance().setDrawerBuilder(drawerBuilder);
        DrawerBuilderTeacher.position = this;
    }//GEN-LAST:event_buttonChangeThemeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ExcelRecap.exportPresenceToExcel("presence_data.xlsx");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void setIconNavigation() {
        if (UIManager.getLookAndFeel() instanceof FlatMacDarkLaf) {
            navigationButton.setIcon(new ImageIcon(getClass().getResource("/images/three_menu_dark.png")));
            buttonChangeTheme.setText("Dark");
            DrawerBuilderTeacher.mode = "Dark";
        }else {
            navigationButton.setIcon(new ImageIcon(getClass().getResource("/images/three_menu_light.png")));
            buttonChangeTheme.setText("Light");
            DrawerBuilderTeacher.mode = "Light";
        }
    }
    
    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PresenceList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChangeTheme;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton navigationButton;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
