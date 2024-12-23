package com.uap.eclassroom;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.uap.eclassroom.Data.Classwork;
import com.uap.eclassroom.Data.DataManage;
import static com.uap.eclassroom.Data.DataManage.classwork;
import static com.uap.eclassroom.Data.DataManage.mahasiswa;
import static com.uap.eclassroom.Data.DataManage.presence;
import com.uap.eclassroom.Data.Mahasiswa;
import com.uap.eclassroom.Data.Presence;
import com.uap.eclassroom.componentPanel.DrawerBuilderStudent;
import com.uap.eclassroom.componentPanel.DrawerBuilderTeacher;
import com.uap.eclassroom.dosen.ClassworkListTeacher;
import com.uap.eclassroom.mahasiswa.ClassworkListStudent;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import raven.toast.Notifications;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        
        panel.putClientProperty(FlatClientProperties.STYLE,
                "[light]background: #CCCCCC; " +
                "[dark]background: #333333;" +
                "arc:20;");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        simpleTransition1 = new raven.swing.slider.SimpleTransition();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inputPassword = new javax.swing.JPasswordField();
        inputNIM = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        buttonChangeTheme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setPreferredSize(new java.awt.Dimension(330, 400));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Welcome to e-Classroom!");

        jLabel2.setText("Please sign in with your account");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("NIM");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Password");

        inputPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputPassword.setToolTipText("Input your password here");

        inputNIM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputNIM.setToolTipText("Input your username here");

        loginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginButton.setText("Login");
        loginButton.setFocusable(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputPassword)
                    .addComponent(inputNIM)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        buttonChangeTheme.setText("Dark");
        buttonChangeTheme.setFocusable(false);
        buttonChangeTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeThemeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonChangeTheme)
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(buttonChangeTheme)
                .addGap(18, 18, 18)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static void addPresence() {
        presence.add(new Presence("1", "23 December 2024", false));
        presence.add(new Presence("2", "30 December 2024", false));
        presence.add(new Presence("3", "6 January 2025", false));
        presence.add(new Presence("4", "13 January 2025", false));
        presence.add(new Presence("5", "20 January 2025", false));
        presence.add(new Presence("6", "27 January 2025", false));
        presence.add(new Presence("7", "3 February 2025", false));
        presence.add(new Presence("8", "10 February 2025", false));
        presence.add(new Presence("9", "17 February 2025", false));
        presence.add(new Presence("10", "24 February 2025", false));
    }
    
    private static void addMahasiswa() {
        ArrayList<String> presences = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            presences.add("Absen");
        }
        ArrayList<File> attacheds = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            attacheds.add(null);
        }
        ArrayList<File> permissionLetters = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            permissionLetters.add(null);
        }
        ArrayList<Double> grades = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            grades.add(0.0);
        }
        mahasiswa.add(new Mahasiswa("Muhammad Shaumi Rayyanullah", "202310370311399", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Evan Alfredio", "202310370311400", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Rhima Muthiya Qanita", "202310370311401", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Suryo Wisodono Prayogo", "202310370311402", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Chaidir Karnanda Batu Bara", "202310370311403", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Zaidan Kholis", "202310370311404", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Muhammad Bagus Al Hikma Azhar", "202310370311405", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Akhmad Zamri Ardani", "202310370311406", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Adifa Ar-Rayan", "202310370311407", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Muhammad Wahyudiono Putra", "202310370311408", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Reyvaldi Febryan Widya Utomo", "202310370311409", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Bintang Mars Satria Tuhu", "202310370311410", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Arya Affif Ramadhani", "202310370311411", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Dyata Lintar Akbar", "202310370311412", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Dhi'fan Faza Sukamto", "202310370311413", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Muhammad Anggara", "202310370311414", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Alfito Afdhan Nugraha", "202310370311415", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Muhammad Zaky Praditama", "202310370311416", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Siti Zahwa Nabila Putri", "202310370311417", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Panuel Giban", "202310370311418", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Ahmad Andik Septian Qomarudin", "202310370311419", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Muhammad Wilky", "202310370311420", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Leandra Chelsea Geovani Karyono", "202310370311421", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Muhammad Dzaky Hari Fitra", "202310370311422", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Zidane Amir", "202310370311423", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Mohammad Faiz Ulil Albab", "202310370311424", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Rima Marsya Putri Sabrina", "202310370311425", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Raditya Zeliq Amanta", "202310370311426", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Tengku Rabbani Fitrah Jayakaton", "202310370311427", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Adnan Al Faruq", "202310370311428", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Nabila Nabatan Hasana", "202310370311429", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Achmad Rizqy Nur", "202310370311430", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Sabian Franstiawan Wahyu Bagaskara", "202310370311431", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Muhammad Ibnu Juniar", "202310370311432", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Nawaf Sulaiman Al Hunaiti", "202310370311433", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("M. Dava Arya Nada Putra", "202310370311434", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Anisa Nabila Zahwa", "202310370311435", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Alvian Farhat", "202310370311436", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Wiji Fiko Teren", "202310370311437", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Nazwa Sulistiyawati", "202310370311438", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Unzila Putri Asran", "202310370311439", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Devis Triansyah", "202310370311440", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Muchammad Rifqi Dzaki Arrafi", "202310370311441", presences, attacheds, permissionLetters, grades));
        mahasiswa.add(new Mahasiswa("Chita Anudya Sulung Anugrah", "202310370311442", presences, attacheds, permissionLetters, grades));
    }
    
    private static void addClasswork() {
        classwork.add(new Classwork(
            "Pengenalan Pemrograman Java",
            "Selamat datang di tugas pertama tentang Pemrograman Java!\n" +
            "Kerjakan tugas berikut:\n" +
            "1. Buat program Java untuk mencetak 'Halo, Dunia!'.\n" +
            "2. Kirimkan file .java melalui portal tugas.\n" +
            "\n" +
            "Catatan Penting:\n" +
            "- Pastikan kode Anda berjalan tanpa error.\n" +
            "- Ikuti konvensi penamaan yang telah dibahas di kelas.",
            "14 August 2024, 10:10"));

        classwork.add(new Classwork(
            "Struktur Data: Array dan Linked List",
            "Tugas ini berfokus pada struktur data dasar:\n" +
            "\n" +
            "Tugas:\n" +
            "1. Buat array yang menyimpan 10 bilangan bulat dan cetak hasil jumlahnya.\n" +
            "2. Implementasikan linked list sederhana di Java dengan metode untuk:\n" +
            "   - Menambah node.\n" +
            "   - Menghapus node.\n" +
            "   - Menampilkan daftar node.\n" +
            "\n" +
            "Kirimkan kode Anda beserta komentar yang menjelaskan setiap metode.",
            "24 December 2024, 14:00"));

        classwork.add(new Classwork(
            "Dasar-Dasar Basis Data: Query SQL",
            "Tugas ini berkaitan dengan dasar-dasar SQL. Kerjakan tugas berikut:\n" +
            "\n" +
            "1. Tuliskan query SQL untuk membuat tabel 'Mahasiswa' dengan kolom:\n" +
            "   - ID (Primary Key, INT)\n" +
            "   - Nama (VARCHAR)\n" +
            "   - Umur (INT)\n" +
            "   - Kelas (VARCHAR)\n" +
            "   - IPK (FLOAT)\n" +
            "\n" +
            "2. Masukkan minimal 5 data ke dalam tabel tersebut.\n" +
            "3. Tulis query untuk menampilkan mahasiswa dengan IPK > 3.5.\n" +
            "\n" +
            "Kirimkan file SQL atau screenshot hasil eksekusi query.",
            "20 August 2024, 09:30"));

    }
    
    private void buttonChangeThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeThemeActionPerformed
        if(buttonChangeTheme.getText().equals("Light")) {
            FlatMacDarkLaf.setup();
            buttonChangeTheme.setText("Dark");
        }else {
            FlatMacLightLaf.setup();
            buttonChangeTheme.setText("Light");
        }
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_buttonChangeThemeActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String nim = inputNIM.getText().toString();
        String password = inputPassword.getText().toString();
        Notifications.getInstance().setJFrame(this);
        if(nim.isEmpty() && password.isEmpty()) {
            setError("Your NIM and Password field is empty!");
        }else {
            if(nim.isEmpty()) {
                setError("Your NIM field is empty!");
            }else if(password.isEmpty()) {
                setError("Your Password field is empty!");
            }else {
                if(nim.equals("dosen")) {
                    if(password.equals("dosen")) {
                        Point currentLocation = this.getLocation();
                        ClassworkListTeacher frame2 = new ClassworkListTeacher();
                        frame2.setLocation(currentLocation);
                        frame2.setVisible(true);
                        DrawerBuilderTeacher.position = frame2;
                        dispose();
                    }else {
                        setError("Incorrect password!");
                    }
                }else if(nim.length() < 15) {
                    setError("Incorrect NIM format!");
                }else if(nim.matches("\\d+")) {
                    boolean userFound = false;
                    for(int i = 0; i < mahasiswa.size(); i++) {
                        if(mahasiswa.get(i).getNIM().equals(nim)) {
                            userFound = true;
                            String lastThree = nim.substring(nim.length() - 3);
                            String passwordVerif = "password" + lastThree;
                            if(password.equals(passwordVerif)) {
                                DataManage.studentLogin = nim;
                                setSuccess("Successfully login as " + mahasiswa.get(i).getName());
                                Point currentLocation = this.getLocation();
                                ClassworkListStudent frame2 = new ClassworkListStudent();
                                frame2.setLocation(currentLocation);
                                frame2.setVisible(true);
                                DrawerBuilderStudent.position = frame2;
                                dispose();
                            }else {
                                setError("Incorrect Password!");
                            }
                        }
                    }
                    if(!userFound) {
                        setError("NIM not found.");
                    }
                }else {
                    setError("NIM must contains number!");
                }
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void setError(String message) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, message);
    }
    
    private void setSuccess(String message) {
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, message);
    }
    
    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
  
        addClasswork();
        addMahasiswa();
        addPresence();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChangeTheme;
    private javax.swing.JTextField inputNIM;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel panel;
    private raven.swing.slider.SimpleTransition simpleTransition1;
    // End of variables declaration//GEN-END:variables
}
