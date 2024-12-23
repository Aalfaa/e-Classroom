package com.uap.eclassroom.dosen;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static com.uap.eclassroom.Data.DataManage.classwork;
import static com.uap.eclassroom.Data.DataManage.mahasiswa;
import com.uap.eclassroom.Data.ExcelRecap;
import com.uap.eclassroom.componentPanel.DrawerBuilderTeacher;
import com.uap.eclassroom.componentPanel.ItemClassworkTeacher;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

public class ClassworkListTeacher extends javax.swing.JFrame {
    
    public ClassworkListTeacher() {
        initComponents();
        
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
        
        setIconNavigation();
        
        panelClassworkList.setLayout(new MigLayout("wrap 1", "[grow, fill]", "[]10[]"));
        
        for (int i = 0; i < classwork.size(); i++) { 
            ItemClassworkTeacher form = new ItemClassworkTeacher();
            
            form.getJudul().setText(classwork.get(i).getTitle());
            form.getDeadline().setText(classwork.get(i).getDeadline());
            form.setIndex(i);
            
            form.putClientProperty(FlatClientProperties.STYLE,
                "[light]background: #CCCCCC; " +
                "[dark]background: #333333;" +
                "arc:20;");
            
            JButton deleteButton = form.getDelete();
            
            deleteButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int pilihan = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this classwork??", "Confirmation", JOptionPane.CANCEL_OPTION);
                    if(pilihan == JOptionPane.OK_OPTION) {
                        int index = form.getIndex();
                        classwork.remove(index);
                        for(int j = 0; j < mahasiswa.size(); j++) {
                            mahasiswa.get(j).getAttached().remove(index);
                        }
                        panelClassworkList.remove(form);
                        panelClassworkList.revalidate();
                        
                        for (int j = index; j < classwork.size(); j++) {
                            ((ItemClassworkTeacher) panelClassworkList.getComponent(j)).setIndex(j);
                        }
                    }
                }
            });
           
            int index = i;
            form.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JFrame frameNow = (JFrame) SwingUtilities.getWindowAncestor(e.getComponent());
                    Point currentLocation = frameNow.getLocation();
                    CheckClassworkAttachment frame2 = new CheckClassworkAttachment(index);
                    frame2.setLocation(currentLocation);
                    frame2.setVisible(true);
                    dispose();
                }
                public void mouseEntered(MouseEvent e) {
                    if (UIManager.getLookAndFeel() instanceof FlatMacDarkLaf) {
                        form.setBackground(Color.decode("#474747"));
                    }else { 
                        form.setBackground(Color.decode("#B6B6B6"));
                    }
                }
                public void mouseExited(MouseEvent e) {
                    if (UIManager.getLookAndFeel() instanceof FlatMacDarkLaf) {
                        form.setBackground(Color.decode("#333333"));
                    }else {
                        form.setBackground(Color.decode("#CCCCCC"));
                    }
                }
            });
            
            panelClassworkList.add(form);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        navigationButton = new javax.swing.JButton();
        buttonChangeTheme = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        panelClassworkList = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Classwork");

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
        buttonChangeTheme.setFocusable(false);
        buttonChangeTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeThemeActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        createButton.setBackground(new java.awt.Color(51, 153, 255));
        createButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        createButton.setForeground(new java.awt.Color(255, 255, 255));
        createButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_dark.png"))); // NOI18N
        createButton.setText("  Create");
        createButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        createButton.setIconTextGap(15);
        createButton.setMargin(new java.awt.Insets(2, 15, 3, 14));
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelClassworkListLayout = new javax.swing.GroupLayout(panelClassworkList);
        panelClassworkList.setLayout(panelClassworkListLayout);
        panelClassworkListLayout.setHorizontalGroup(
            panelClassworkListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        panelClassworkListLayout.setVerticalGroup(
            panelClassworkListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelClassworkList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelClassworkList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Recap");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(navigationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(buttonChangeTheme)
                .addGap(19, 19, 19))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonChangeTheme)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(navigationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
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

    private void navigationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navigationButtonActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_navigationButtonActionPerformed

    private void navigationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navigationButtonMouseEntered
        navigationButton.setIcon(new ImageIcon(getClass().getResource("/images/three_menu_hover.png")));
    }//GEN-LAST:event_navigationButtonMouseEntered

    private void navigationButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navigationButtonMouseExited
        setIconNavigation();
    }//GEN-LAST:event_navigationButtonMouseExited

    private void buttonChangeThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeThemeActionPerformed
        if(buttonChangeTheme.getText().equals("Light")) {
            buttonChangeTheme.setText("Dark");
            FlatMacDarkLaf.setup();
            DrawerBuilderTeacher.mode = "Dark";
        }else {
            buttonChangeTheme.setText("Light");
            FlatMacLightLaf.setup();
            DrawerBuilderTeacher.mode = "Light";
        }
        SwingUtilities.updateComponentTreeUI(this);
        setIconNavigation();
        DrawerBuilderTeacher drawerBuilder =  new DrawerBuilderTeacher();
        Drawer.getInstance().setDrawerBuilder(drawerBuilder);
        DrawerBuilderTeacher.position = this;
    }//GEN-LAST:event_buttonChangeThemeActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        Point currentLocation = this.getLocation();
        MakeClasswork frame2 = new MakeClasswork();
        frame2.setLocation(currentLocation);
        frame2.setVisible(true);
        dispose();
    }//GEN-LAST:event_createButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ExcelRecap.exportGradesToExcel("grading_data.xlsx");
    }//GEN-LAST:event_jButton1ActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassworkListTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChangeTheme;
    private javax.swing.JButton createButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton navigationButton;
    private javax.swing.JPanel panelClassworkList;
    // End of variables declaration//GEN-END:variables
}
