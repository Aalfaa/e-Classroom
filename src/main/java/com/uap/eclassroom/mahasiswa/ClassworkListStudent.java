package com.uap.eclassroom.mahasiswa;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.uap.eclassroom.componentPanel.DrawerBuilderStudent;
import com.uap.eclassroom.componentPanel.ItemClassworkStudent;
import static com.uap.eclassroom.Data.DataManage.classwork;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

public class ClassworkListStudent extends javax.swing.JFrame {
    
    public ClassworkListStudent() {
        initComponents();
        
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
       
        panelClassworkList.setLayout(new MigLayout("wrap 1", "[grow, fill]", "[]10[]"));
        
        System.out.println(classwork.size());
        for (int i = 0; i < classwork.size(); i++) { 
            ItemClassworkStudent form = new ItemClassworkStudent();

            form.getJudul().setText(classwork.get(i).getTitle());
            form.getDeadline().setText(classwork.get(i).getDeadline());
            
            form.putClientProperty(FlatClientProperties.STYLE,
                "[light]background: #CCCCCC; " +
                "[dark]background: #333333;" +
                "arc:20;");
           
            int index = i;
            form.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JFrame frameNow = (JFrame) SwingUtilities.getWindowAncestor(e.getComponent());
                    Point currentLocation = frameNow.getLocation();
                    ClassworkAssign frame2 = new ClassworkAssign(index);
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
        panelClassworkList = new javax.swing.JPanel();

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

        buttonChangeTheme.setText("Light");
        buttonChangeTheme.setFocusable(false);
        buttonChangeTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeThemeActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout panelClassworkListLayout = new javax.swing.GroupLayout(panelClassworkList);
        panelClassworkList.setLayout(panelClassworkListLayout);
        panelClassworkListLayout.setHorizontalGroup(
            panelClassworkListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        panelClassworkListLayout.setVerticalGroup(
            panelClassworkListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(panelClassworkList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(panelClassworkList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

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
                        .addComponent(buttonChangeTheme))
                    .addComponent(navigationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1))
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
                new ClassworkListStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChangeTheme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton navigationButton;
    private javax.swing.JPanel panelClassworkList;
    // End of variables declaration//GEN-END:variables
}
