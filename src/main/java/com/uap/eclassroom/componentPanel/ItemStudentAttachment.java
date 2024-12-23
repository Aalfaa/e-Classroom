package com.uap.eclassroom.componentPanel;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ItemStudentAttachment extends javax.swing.JPanel {

    public ItemStudentAttachment() {
        initComponents();
    }
    
    public JLabel getLabelNIM() {
        return nim;
    }
    
    public JButton getButton() {
        return getButton;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nim = new javax.swing.JLabel();
        getButton = new javax.swing.JButton();

        nim.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        nim.setText("202310370311436");

        getButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getButton.setText("Get");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(getButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(nim)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(getButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton getButton;
    private javax.swing.JLabel nim;
    // End of variables declaration//GEN-END:variables
}
