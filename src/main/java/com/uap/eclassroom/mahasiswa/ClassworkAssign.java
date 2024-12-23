package com.uap.eclassroom.mahasiswa;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import static com.uap.eclassroom.Data.DataManage.classwork;
import static com.uap.eclassroom.Data.DataManage.mahasiswa;
import static com.uap.eclassroom.Data.DataManage.studentLogin;
import com.uap.eclassroom.componentPanel.DrawerBuilderStudent;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import jnafilechooser.api.JnaFileChooser;
import raven.toast.Notifications;

public class ClassworkAssign extends javax.swing.JFrame {

    private int localIndex = 0;
    
    public ClassworkAssign(int index) {
        initComponents();
        
        titleText.setText(classwork.get(index).getTitle());
        instructionsText.setText(classwork.get(index).getDescription());
        deadline.setText("Deadline: " + classwork.get(index).getDeadline());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy, HH:mm");

        LocalDateTime deadlineTime = LocalDateTime.parse(classwork.get(index).getDeadline(), formatter);
        LocalDateTime now = LocalDateTime.now();
        
        boolean already = false;
        for(int i = 0; i < mahasiswa.size(); i++) {
            if(mahasiswa.get(i).getNIM().equals(studentLogin)) {
                if(mahasiswa.get(i).getAttached().get(index) != null) {
                    infoAttachment.setText("Attachment Submitted.");
                    already = true;
                }
                if(mahasiswa.get(i).getGrade().get(index) > 0) {
                    DecimalFormat df = new DecimalFormat("#.##");
                    gradeText.setText(df.format(mahasiswa.get(i).getGrade().get(index)) + "/100");
                }
            }
        }
        
        if(now.isAfter(deadlineTime)) {
            if(!already) {
                infoAttachment.setText("Due to late.");
                uploadAttachmentButton.setEnabled(false);
            }
        }
        
        if(FlatLaf.isLafDark()) {
            backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton_dark_icon.png")));
        }else {
            backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton_light_icon.png")));
        }
        localIndex = index;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        titleText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        instructionsText = new javax.swing.JTextArea();
        infoAttachment = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        uploadAttachmentButton = new javax.swing.JButton();
        deadline = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        gradeText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backButton_dark_icon.png"))); // NOI18N
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Back ");

        jPanel2.setPreferredSize(new java.awt.Dimension(900, 488));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Title");

        titleText.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        titleText.setText("Ini adalah judulnya");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Instructions");

        instructionsText.setEditable(false);
        instructionsText.setColumns(20);
        instructionsText.setLineWrap(true);
        instructionsText.setRows(5);
        instructionsText.setFocusable(false);
        instructionsText.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(instructionsText);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(titleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleText)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        infoAttachment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        infoAttachment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoAttachment.setText("No Attachment Yet.");

        jLabel5.setText("Deadline:");

        uploadAttachmentButton.setBackground(new java.awt.Color(26, 115, 232));
        uploadAttachmentButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        uploadAttachmentButton.setForeground(new java.awt.Color(255, 255, 255));
        uploadAttachmentButton.setText("Upload Attachment");
        uploadAttachmentButton.setFocusable(false);
        uploadAttachmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadAttachmentButtonActionPerformed(evt);
            }
        });

        deadline.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deadline.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        deadline.setText("15 December 2024, 10:10");
        deadline.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deadline.setIconTextGap(0);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Grade:");

        gradeText.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        gradeText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradeText.setText("0/100");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(uploadAttachmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoAttachment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gradeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uploadAttachmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoAttachment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gradeText)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Point currentLocation = this.getLocation();
        ClassworkListStudent frame2 = new ClassworkListStudent();
        frame2.setLocation(currentLocation);
        frame2.setVisible(true);
        dispose();
        DrawerBuilderStudent.position = frame2;
    }//GEN-LAST:event_backButtonActionPerformed

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

    private void uploadAttachmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadAttachmentButtonActionPerformed
        JnaFileChooser fc = new JnaFileChooser();
        fc.addFilter("Documents", "pdf");
        fc.showOpenDialog(this);
        File file = fc.getSelectedFile();
        if(file != null) {
            for(int i = 0; i < mahasiswa.size(); i++) {
                if (mahasiswa.get(i).getNIM().equals(studentLogin)) {
                    ArrayList<File> temp = mahasiswa.get(i).getAttached();
                    ArrayList<File> temp2 = new ArrayList<>();
                    for(int j = 0; j < temp.size(); j++) {
                        if(localIndex != j) {
                            temp2.add(temp.get(j));
                        }else {
                            temp2.add(file);
                        }
                    }
                    mahasiswa.get(i).setAttached(temp2);
                    
                    infoAttachment.setText("Attachment Submitted.");
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Succesfully submmited the work attachment");
                }
                
            }
        }
    }//GEN-LAST:event_uploadAttachmentButtonActionPerformed

    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel deadline;
    private javax.swing.JLabel gradeText;
    private javax.swing.JLabel infoAttachment;
    private javax.swing.JTextArea instructionsText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel titleText;
    private javax.swing.JButton uploadAttachmentButton;
    // End of variables declaration//GEN-END:variables
}
