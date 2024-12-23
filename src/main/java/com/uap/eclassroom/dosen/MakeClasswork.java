package com.uap.eclassroom.dosen;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.uap.eclassroom.Data.Classwork;
import static com.uap.eclassroom.Data.DataManage.classwork;
import static com.uap.eclassroom.Data.DataManage.mahasiswa;
import com.uap.eclassroom.componentPanel.DrawerBuilderTeacher;
import java.awt.Font;
import java.awt.Point;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import raven.datetime.component.date.DateSelectionAble;
import raven.toast.Notifications;

public class MakeClasswork extends javax.swing.JFrame {

    public MakeClasswork() {
        initComponents();
        timePickerComponent.setEditor(timePicker);
        timePickerComponent.set24HourView(true);
        
        timePickerComponent.setSelectedTime(LocalTime.parse("23:59"));
        
        datePickerComponent.setEditor(datePicker);
        datePickerComponent.setDateSelectionAble(new DateSelectionAble() {
            @Override
            public boolean isDateSelectedAble(LocalDate date) {
                return !date.isBefore(LocalDate.now());
            }
        });
        
        datePickerComponent.setSelectedDate(LocalDate.now());
        
        if(FlatLaf.isLafDark()) {
            backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton_dark_icon.png")));
        }else {
            backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton_light_icon.png")));
        }
        
        inputTitle.putClientProperty("JTextField.placeholderText", "Input the title");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePickerComponent = new raven.datetime.component.time.TimePicker();
        datePickerComponent = new raven.datetime.component.date.DatePicker();
        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputInstructions = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        datePicker = new javax.swing.JFormattedTextField();
        timePicker = new javax.swing.JFormattedTextField();

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Title");

        inputTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputTitle.setToolTipText("Input the title here");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Instructions");

        inputInstructions.setColumns(20);
        inputInstructions.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputInstructions.setRows(5);
        jScrollPane1.setViewportView(inputInstructions);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Deadline");

        submitButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        submitButton.setText("Submit");
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        datePicker.setToolTipText("");
        datePicker.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        timePicker.setToolTipText("");
        timePicker.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 190, Short.MAX_VALUE)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(timePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputTitle)
                            .addComponent(jScrollPane1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
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

    private void setError(String message) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, message);
    }
    
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        String title = inputTitle.getText().toString();
        String instructions = inputInstructions.getText().toString();
        String time = timePickerComponent.getSelectedTimeAsString();
        String date = datePickerComponent.getSelectedDateAsString();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        LocalDate parseDate = LocalDate.parse(date, inputFormatter);
        String formattedDate = parseDate.format(outputFormatter);

        String deadline = formattedDate + ", " + time;
        if(title.isEmpty()) {
            setError("Title field is empty!");
        }else if(instructions.isEmpty()) {
            setError("Instructions field is empty!");
        }else {
            classwork.add(new Classwork(title, instructions, deadline));
            for(int i = 0; i < mahasiswa.size(); i++) {
                mahasiswa.get(i).getAttached().add(null);
                mahasiswa.get(i).getGrade().add(0.0);
            }
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Successfully added new Classwork!");
            Point currentLocation = this.getLocation();
            ClassworkListTeacher frame2 = new ClassworkListTeacher();
            frame2.setLocation(currentLocation);
            frame2.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakeClasswork().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JFormattedTextField datePicker;
    private raven.datetime.component.date.DatePicker datePickerComponent;
    private javax.swing.JTextArea inputInstructions;
    private javax.swing.JTextField inputTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitButton;
    private javax.swing.JFormattedTextField timePicker;
    private raven.datetime.component.time.TimePicker timePickerComponent;
    // End of variables declaration//GEN-END:variables
}
