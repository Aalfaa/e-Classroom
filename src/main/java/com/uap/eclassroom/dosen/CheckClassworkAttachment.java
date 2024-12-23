package com.uap.eclassroom.dosen;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import static com.uap.eclassroom.Data.DataManage.classwork;
import static com.uap.eclassroom.Data.DataManage.mahasiswa;
import com.uap.eclassroom.componentPanel.DrawerBuilderTeacher;
import com.uap.eclassroom.componentPanel.GradingTeacher;
import com.uap.eclassroom.componentPanel.ItemStudentAttachment;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import jnafilechooser.api.JnaFileChooser;
import net.miginfocom.swing.MigLayout;
import raven.toast.Notifications;

public class CheckClassworkAttachment extends javax.swing.JFrame {

    private int localIndex = 0;
    private int secIndex = 0;
    
    public CheckClassworkAttachment(int index) {
        initComponents();
        
        localIndex = index;
        titleText.setText(classwork.get(index).getTitle());
        instructionsText.setText(classwork.get(index).getDescription());
        deadlineText.setText("Deadline: " + classwork.get(index).getDeadline());
        int countAttached = 0;
        
        panelPengumpulan.setLayout(new MigLayout("wrap 1", "[grow, fill]", "[]10[]"));
        for(int i = 0; i < mahasiswa.size(); i++) {
            if(mahasiswa.get(i).getAttached().get(index) != null) {
                secIndex = i;
                countAttached++;
                ItemStudentAttachment form = new ItemStudentAttachment();
                
                form.getLabelNIM().setText(mahasiswa.get(i).getNIM());
                form.getButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        GradingTeacher gradingPanel = new GradingTeacher();
                        gradingPanel.getDownloadButton().addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                downloadPDF(secIndex);
                            }
                        });
                        gradingPanel.getGradeInput().setText(String.valueOf(mahasiswa.get(secIndex).getGrade().get(localIndex)));
                        int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        gradingPanel, 
                                        "Attachment Information", 
                                        JOptionPane.OK_CANCEL_OPTION, 
                                        JOptionPane.PLAIN_MESSAGE
                                    );
                        if (option == JOptionPane.OK_OPTION) {
                            String inputNilai = gradingPanel.getGradeInput().getText().toString();
                            if(inputNilai.isEmpty()) {
                                setError("Grade input is empty!");
                            }else if(inputNilai.matches("^[-+]?[0-9]*\\\\.?[0-9]+$")) {
                                setError("Grade input must be numeric!");
                            }else if(Double.parseDouble(inputNilai) < 0 || Double.parseDouble(inputNilai) > 100) {
                                setError("Grade Min. 0 and Max. 100!");
                            }else {
                                ArrayList<Double> temp = mahasiswa.get(secIndex).getGrade();
                                ArrayList<Double> temp2 = new ArrayList<>();
                                for(int k = 0; k < temp.size(); k++) {
                                    if(localIndex != k) {
                                        temp2.add(temp.get(k));
                                    }else {
                                        temp2.add(Double.parseDouble(inputNilai));
                                    }
                                }
                                mahasiswa.get(secIndex).setGrade(temp2);
                            }
                        }
                    }
                });
                
                panelPengumpulan.add(form);
            }
        }
        studentAttachmentCount.setText(String.valueOf(countAttached) + "/" + String.valueOf(mahasiswa.size()));
        
        if(FlatLaf.isLafDark()) {
            backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton_dark_icon.png")));
        }else {
            backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton_light_icon.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        titleText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        instructionsText = new javax.swing.JTextArea();
        studentAttachmentCount = new javax.swing.JLabel();
        panelPengumpulan = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        deadlineText = new javax.swing.JLabel();

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

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Title");

        titleText.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        titleText.setText("Ini adalah judulnya");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Instructions");

        instructionsText.setEditable(false);
        instructionsText.setColumns(20);
        instructionsText.setRows(5);
        instructionsText.setFocusable(false);
        instructionsText.setMargin(new java.awt.Insets(10, 10, 10, 10));
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                    .addComponent(titleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        studentAttachmentCount.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        studentAttachmentCount.setText("0/34");

        javax.swing.GroupLayout panelPengumpulanLayout = new javax.swing.GroupLayout(panelPengumpulan);
        panelPengumpulan.setLayout(panelPengumpulanLayout);
        panelPengumpulanLayout.setHorizontalGroup(
            panelPengumpulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        panelPengumpulanLayout.setVerticalGroup(
            panelPengumpulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Student Attachment");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentAttachmentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelPengumpulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 341, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentAttachmentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelPengumpulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        deadlineText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deadlineText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        deadlineText.setText("Deadline: 15 August 2024, 10:10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deadlineText, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deadlineText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
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

    private void setError(String message) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, message);
    }
    
    public void downloadPDF(int index) {
        File fileData = mahasiswa.get(index).getAttached().get(localIndex); 
        
        JnaFileChooser fileChooser = new JnaFileChooser();
        fileChooser.setMode(JnaFileChooser.Mode.Files); 
        fileChooser.setTitle("Simpan PDF");
        fileChooser.addFilter("PDF Files", "*.pdf"); 

        String downloadsPath = System.getProperty("user.home") + "/Downloads";
        fileChooser.setCurrentDirectory(downloadsPath);

        if (fileChooser.showSaveDialog(null)) {
            File destinationFile = fileChooser.getSelectedFile();

            if (!destinationFile.getName().toLowerCase().endsWith(".pdf")) {
                destinationFile = new File(destinationFile.getAbsolutePath() + ".pdf");
            }

            saveFile(fileData, destinationFile);
        } else {
            System.out.println("Proses penyimpanan dibatalkan.");
        }
    }

    private void saveFile(File sourceFile, File destinationFile) {
        System.out.println("Sedang menyimpan file...");
        try (FileInputStream in = new FileInputStream(sourceFile);
             FileOutputStream out = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.flush();
            System.out.println("File berhasil disimpan di: " + destinationFile.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Point currentLocation = this.getLocation();
        ClassworkListTeacher frame2 = new ClassworkListTeacher();
        frame2.setLocation(currentLocation);
        frame2.setVisible(true);
        dispose();
        DrawerBuilderTeacher.position = frame2;
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

    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel deadlineText;
    private javax.swing.JTextArea instructionsText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelPengumpulan;
    private javax.swing.JLabel studentAttachmentCount;
    private javax.swing.JLabel titleText;
    // End of variables declaration//GEN-END:variables
}
