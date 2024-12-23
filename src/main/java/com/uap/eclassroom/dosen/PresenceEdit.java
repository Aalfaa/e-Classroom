package com.uap.eclassroom.dosen;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static com.uap.eclassroom.Data.DataManage.mahasiswa;
import static com.uap.eclassroom.Data.DataManage.presence;
import com.uap.eclassroom.componentPanel.DrawerBuilderTeacher;
import java.awt.Font;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import jnafilechooser.api.JnaFileChooser;
import raven.toast.Notifications;

public class PresenceEdit extends javax.swing.JFrame {

    public PresenceEdit(String meeting) {
        initComponents();
        
        if(FlatLaf.isLafDark()) {
            backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton_dark_icon.png")));
            buttonChangeTheme.setText("Dark");
        }else {
            backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton_light_icon.png")));
            buttonChangeTheme.setText("Light");
        }
        
        labelMeeting.setText("Meeting: " + meeting);
        
        inputSearch.putClientProperty("JTextField.placeholderText", "Search");
        tabel.getTableHeader().putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
        tabel.putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
        
        generateTabel("");
        
        inputSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                generateTabel(inputSearch.getText().toString());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                generateTabel(inputSearch.getText().toString());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDateOptionLabel1 = new raven.datetime.component.date.PanelDateOptionLabel();
        utils1 = new raven.datetime.util.Utils();
        jPanel1 = new javax.swing.JPanel();
        labelMeeting = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        buttonChangeTheme = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        SelfAttendanceButton = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        inputSearch = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelMeeting.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelMeeting.setText("Meeting: 1");

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backButton_dark_icon.png"))); // NOI18N
        backButton.setContentAreaFilled(false);
        backButton.setFocusable(false);
        backButton.setPreferredSize(new java.awt.Dimension(35, 35));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        buttonChangeTheme.setText("Light");
        buttonChangeTheme.setFocusable(false);
        buttonChangeTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeThemeActionPerformed(evt);
            }
        });

        SelfAttendanceButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SelfAttendanceButton.setText("Self Attendance");
        SelfAttendanceButton.setIconTextGap(7);
        SelfAttendanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelfAttendanceButtonActionPerformed(evt);
            }
        });

        tabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "NIM", "P", "A", "E", "Permission Letter"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel.setFocusable(false);
        tabel.setRowHeight(40);
        tabel.setShowHorizontalLines(true);
        tabel.getTableHeader().setReorderingAllowed(false);
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel);
        if (tabel.getColumnModel().getColumnCount() > 0) {
            tabel.getColumnModel().getColumn(0).setResizable(false);
            tabel.getColumnModel().getColumn(0).setPreferredWidth(300);
            tabel.getColumnModel().getColumn(1).setResizable(false);
            tabel.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabel.getColumnModel().getColumn(2).setResizable(false);
            tabel.getColumnModel().getColumn(2).setPreferredWidth(10);
            tabel.getColumnModel().getColumn(3).setResizable(false);
            tabel.getColumnModel().getColumn(3).setPreferredWidth(10);
            tabel.getColumnModel().getColumn(4).setResizable(false);
            tabel.getColumnModel().getColumn(4).setPreferredWidth(10);
            tabel.getColumnModel().getColumn(5).setResizable(false);
        }

        inputSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(233, Short.MAX_VALUE)
                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(SelfAttendanceButton)
                .addGap(19, 19, 19))
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSearch)
                    .addComponent(SelfAttendanceButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
        );

        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        dateLabel.setText("|   24 December 2024");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(labelMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonChangeTheme)
                .addGap(19, 19, 19))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonChangeTheme)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateTabel(String search) {
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        model.setRowCount(0);
        String meeting = labelMeeting.getText().toString().replaceAll("Meeting: ", "");
        for (int i = 0; i < presence.size(); i++) {
            if(presence.get(i).getMeeting().equals(meeting)) {
                dateLabel.setText("|   " + presence.get(i).getDate());
                SelfAttendanceButton.setSelected(presence.get(i).isSelfPresence());
                
                for(int j = 0; j < mahasiswa.size(); j++) {
                    String name = mahasiswa.get(j).getName();
                    String nim = mahasiswa.get(j).getNIM();
                    if(name.toLowerCase().contains(search.toLowerCase()) || nim.toLowerCase().contains(search.toLowerCase())) {
                        String presences = mahasiswa.get(j).getPresence().get(Integer.parseInt(meeting)-1);
                        File plAttached = mahasiswa.get(j).getPermissionLetter().get(Integer.parseInt(meeting)-1);
                        String hasPL = "";
                        if(plAttached != null) {
                            hasPL = "yes";
                        }else {
                            hasPL = "no";
                        }
                        boolean hadir = presences.equals("Hadir");
                        boolean izin = presences.equals("Izin");
                        boolean absen = presences.equals("Absen");
                        model.addRow(new Object[]{name, nim, hadir, absen, izin, hasPL});
                    }
                }
            }
        }
        
        model.addTableModelListener(e -> {
            int row = e.getFirstRow(); 
            int col = e.getColumn(); 

            if (col == 2 || col == 3 || col == 4) { 
                if (model.getValueAt(row, col).equals(true)) {
                    for (int i = 2; i <= 4; i++) {
                        if (i != col) {
                            model.setValueAt(false, row, i);
                        }
                    }
                    String pres = "";
                    if(col == 2) {
                        pres = "Hadir";
                    }else if(col == 3) {
                        pres = "Absen";
                    }else if(col == 4) {
                        pres = "Izin";
                    }
                    String nim = String.valueOf(model.getValueAt(row, 1)); 
                    for (int j = 0; j < mahasiswa.size(); j++) {
                        if (mahasiswa.get(j).getNIM().equals(nim)) {
                            ArrayList<String> temp = mahasiswa.get(j).getPresence();
                            ArrayList<String> temp2 = new ArrayList<>();
                            for(int k = 0; k < temp.size(); k++) {
                                if((Integer.parseInt(meeting)-1) != k) {
                                    temp2.add(temp.get(k));
                                }else {
                                    temp2.add(pres);
                                }
                            }
                            mahasiswa.get(j).setPresence(temp2);
                        }
                    }
                }
            }else if(col == 5) {
                System.out.println("Tes");
                String nim = String.valueOf(model.getValueAt(row, 1)); 
                for (int j = 0; j < mahasiswa.size(); j++) {
                    if (mahasiswa.get(j).getNIM().equals(nim)) {
                           if(mahasiswa.get(j).getPermissionLetter().get(Integer.parseInt(meeting)-1) != null) {
                               downloadImage(j, Integer.parseInt(meeting)-1);
                           }
                    }
                }
            }
        });

    }
    
    public void downloadImage(int index, int indexTwo) {
        File fileData = mahasiswa.get(index).getPermissionLetter().get(indexTwo); 
        String nim = mahasiswa.get(index).getNIM();
        String destination = nim + "_Meeting " + String.valueOf(indexTwo+1) + "_Permission Letter";
        
        JnaFileChooser fileChooser = new JnaFileChooser();
        fileChooser.setMode(JnaFileChooser.Mode.Files);
        fileChooser.setTitle("Save Image");
        fileChooser.addFilter("Image Files", "*.png", "*.jpg"); 

        String downloadsPath = System.getProperty("user.home") + "/Downloads";
        fileChooser.setCurrentDirectory(downloadsPath);

        fileChooser.setDefaultFileName(destination);
        
        if (fileChooser.showSaveDialog(null)) {
            File destinationFile = fileChooser.getSelectedFile();

            if (!destinationFile.getName().toLowerCase().endsWith(".png") && 
                !destinationFile.getName().toLowerCase().endsWith(".jpg")) {
                destinationFile = new File(destinationFile.getAbsolutePath() + ".png"); // Default to .png
            }

            saveImage(fileData, destinationFile);
        } 
    }

    private void saveImage(File sourceFile, File destinationFile) {
        try {
            BufferedImage image = ImageIO.read(sourceFile); 
            String format = destinationFile.getName().toLowerCase().endsWith(".jpg") ? "jpg" : "png";
            ImageIO.write(image, format, destinationFile); 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton_hover_icon.png")));
    }//GEN-LAST:event_backButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        if(FlatLaf.isLafDark()) {
            backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton_dark_icon.png")));
        }else {
            backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton_light_icon.png")));
        }
    }//GEN-LAST:event_backButtonMouseExited

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Point currentLocation = this.getLocation();
        PresenceList frame2 = new PresenceList();
        frame2.setLocation(currentLocation);
        frame2.setVisible(true);
        dispose();
        DrawerBuilderTeacher.position = frame2;
    }//GEN-LAST:event_backButtonActionPerformed

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
    }//GEN-LAST:event_buttonChangeThemeActionPerformed

    private void SelfAttendanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelfAttendanceButtonActionPerformed
        int index = Integer.parseInt(labelMeeting.getText().replaceAll("Meeting: ", ""));
        if(presence.get(index-1).isSelfPresence()) {
            presence.get(index-1).setSelfPresence(false);
        }else {
            presence.get(index-1).setSelfPresence(true);
        }
    }//GEN-LAST:event_SelfAttendanceButtonActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int row = tabel.rowAtPoint(evt.getPoint());
        int column = tabel.columnAtPoint(evt.getPoint());
        
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        if(column == 5) {
            String nim = String.valueOf(model.getValueAt(row, 1)); 
            boolean notFound = false;
            for (int j = 0; j < mahasiswa.size(); j++) {
                if (mahasiswa.get(j).getNIM().equals(nim)) {
                    if(mahasiswa.get(j).getPermissionLetter().get(Integer.parseInt(labelMeeting.getText().replaceAll("Meeting: ", ""))-1) != null) {
                       downloadImage(j, Integer.parseInt(labelMeeting.getText().replaceAll("Meeting: ", ""))-1);
                    }else {
                        notFound = true;
                    }
                }
            }
            if(notFound) {
                setError("No Permission Letter Found!");
            }
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void setError(String message) {
         Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, message);
    }
    
    private void setIconNavigation() {
        if(FlatLaf.isLafDark()) {
            backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton_dark_icon.png")));
        }else {
            backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton_light_icon.png")));
        }
    }
    
    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton SelfAttendanceButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton buttonChangeTheme;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelMeeting;
    private raven.datetime.component.date.PanelDateOptionLabel panelDateOptionLabel1;
    private javax.swing.JTable tabel;
    private raven.datetime.util.Utils utils1;
    // End of variables declaration//GEN-END:variables
}
