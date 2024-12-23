package com.uap.eclassroom.componentPanel;

import javax.swing.JLabel;

public class ItemClassworkStudent extends javax.swing.JPanel {

    public ItemClassworkStudent() {
        initComponents();
    }
    
    public JLabel getJudul() {
        return judul;
    }
    
    public JLabel getDeadline() {
        return deadline;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        judul = new javax.swing.JLabel();
        deadline = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/task_icon.png"))); // NOI18N

        judul.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        judul.setText("Materi 4 - Dimana Kita Berada Disitu Kita Menjaga");

        deadline.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        deadline.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        deadline.setText("Deadline: 15 August 2024, 10:10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 327, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(judul)
                            .addComponent(deadline)))
                    .addComponent(jLabel2))
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel deadline;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel judul;
    // End of variables declaration//GEN-END:variables
}
