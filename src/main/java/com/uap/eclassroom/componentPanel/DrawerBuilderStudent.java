package com.uap.eclassroom.componentPanel;

import static com.uap.eclassroom.Data.DataManage.mahasiswa;
import static com.uap.eclassroom.Data.DataManage.studentLogin;
import com.uap.eclassroom.Main;
import com.uap.eclassroom.mahasiswa.ClassworkListStudent;
import com.uap.eclassroom.mahasiswa.SelfPresence;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.drawer.component.menu.data.Item;
import raven.drawer.component.menu.data.MenuItem;
import raven.swing.AvatarIcon;

public class DrawerBuilderStudent extends SimpleDrawerBuilder {
    
    public static String mode;
    public static JFrame position;
    
    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        String name = "";
        String nim = "";
        for(int i = 0; i < mahasiswa.size(); i++) {
            if(mahasiswa.get(i).getNIM().equals(studentLogin)) {
                name = mahasiswa.get(i).getName();
                nim = mahasiswa.get(i).getNIM();
            }
        }
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon(getClass().getResource("/images/avatar_mahasiswa.png"), 100, 100, 999))
                .setTitle(name)
                .setDescription(nim);
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        if(mode.equals("Dark")) {
            MenuItem items[] = new MenuItem[]{
                new Item.Label("CLASSWORK"),
                new Item("Classwork list", "list_icon_dark.svg"),
                new Item.Label("PRESENCE"),
                new Item("Presence", "presence_icon_dark.svg"),
                new Item.Label("OTHER"),
                new Item("Logout", "logout_icon_dark.svg")};
            return new SimpleMenuOption().setMenus(items)
                    .setBaseIconPath("images")
                    .setIconScale(0.05f)
                    .addMenuEvent(new MenuEvent() {
                        @Override
                        public void selected(MenuAction action, int[] index) {
                            if(index[0] == 0) {
                                if(!(position instanceof ClassworkListStudent)) {
                                    Point currentLocation = position.getLocation();
                                    ClassworkListStudent frame2 = new ClassworkListStudent();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
                                    position = frame2;
                                }
                            }else if(index[0] == 1) {
                                if(!(position instanceof SelfPresence)) {
                                    Point currentLocation = position.getLocation();
                                    SelfPresence frame2 = new SelfPresence();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
                                    position = frame2;
                                }
                            }else if(index[0] == 2) {
                                int pilihan = JOptionPane.showConfirmDialog(position, "Are you sure you want to logout from Lecturer account?", "Logout Confirmation", JOptionPane.CANCEL_OPTION);
                                if (pilihan == JOptionPane.OK_OPTION) {
                                    Point currentLocation = position.getLocation();
                                    Main frame2 = new Main();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
                                    position = frame2;
                                }
                            }
                        }
                    });
        }else {
            MenuItem items[] = new MenuItem[]{
                new Item.Label("CLASSWORK"),
                new Item("Classwork list", "list_icon_light.svg"),
                new Item.Label("PRESENCE"),
                new Item("Presence", "presence_icon_light.svg"),
                new Item.Label("OTHER"),
                new Item("Logout", "logout_icon_light.svg")};

            return new SimpleMenuOption()
                    .setMenus(items)
                    .setBaseIconPath("images")
                    .setIconScale(0.05f)
                    .addMenuEvent(new MenuEvent() {
                        @Override
                        public void selected(MenuAction action, int[] index) {
                            if(index[0] == 0) {
                                if(!(position instanceof ClassworkListStudent)) {
                                    Point currentLocation = position.getLocation();
                                    ClassworkListStudent frame2 = new ClassworkListStudent();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
                                    position = frame2;
                                }
                            }else if(index[0] == 1) {
                                if(!(position instanceof SelfPresence)) {
                                    Point currentLocation = position.getLocation();
                                    SelfPresence frame2 = new SelfPresence();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
                                    position = frame2;
                                }
                            }else if(index[0] == 2) {
                                int pilihan = JOptionPane.showConfirmDialog(position, "Are you sure you want to logout from Lecturer account?", "Logout Confirmation", JOptionPane.CANCEL_OPTION);
                                if (pilihan == JOptionPane.OK_OPTION) {
                                    Point currentLocation = position.getLocation();
                                    Main frame2 = new Main();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
                                    position = frame2;
                                }
                            }
                        }
                    });
            
            
        }
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        
        return new SimpleFooterData()
                .setTitle("eClassroom")
                .setDescription("by Alvian Farhat and Rima Marsya P. S.");
    }

    @Override
    public int getDrawerWidth() {
        return 275;
    }
    
}
