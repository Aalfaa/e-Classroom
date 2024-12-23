package com.uap.eclassroom.componentPanel;

import com.uap.eclassroom.Main;
import com.uap.eclassroom.dosen.ClassworkListTeacher;
import com.uap.eclassroom.dosen.MakeClasswork;
import com.uap.eclassroom.dosen.PresenceList;
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

public class DrawerBuilderTeacher extends SimpleDrawerBuilder {
    
    public static String mode;
    public static JFrame position;
    
    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon(getClass().getResource("/images/teacher_avatar.png"), 100, 100, 999))
                .setTitle("Lecturer")
                .setDescription("Hello!");
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        if(mode.equals("Dark")) {
            MenuItem items[] = new MenuItem[]{
                new Item.Label("CLASSWORK"),
                new Item("Classwork list", "list_icon_dark.svg"),
                new Item("Add Classwork", "add_icon_dark.svg"),
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
                                if(!(position instanceof ClassworkListTeacher)) {
                                    Point currentLocation = position.getLocation();
                                    ClassworkListTeacher frame2 = new ClassworkListTeacher();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
                                    position = frame2;
                                }
                            }else if(index[0] == 1) {
                                if(!(position instanceof MakeClasswork)) {
                                    Point currentLocation = position.getLocation();
                                    MakeClasswork frame2 = new MakeClasswork();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
                                    position = frame2;
                                }
                            }else if(index[0] == 2) {
                                if(!(position instanceof PresenceList)) {
                                    Point currentLocation = position.getLocation();
                                    PresenceList frame2 = new PresenceList();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
                                    position = frame2;
                                }
                            }else if(index[0] == 3) {
                                int pilihan = JOptionPane.showConfirmDialog(position, "Are you sure you want to logout from Lecturer account?", "Logout Confirmation", JOptionPane.CANCEL_OPTION);
                                if (pilihan == JOptionPane.OK_OPTION) {
                                    Point currentLocation = position.getLocation();
                                    Main frame2 = new Main();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
                                }
                            }
                        }
                    });
        }else {
            MenuItem items[] = new MenuItem[]{
                new Item.Label("CLASSWORK"),
                new Item("Classwork list", "list_icon_light.svg"),
                new Item("Add Classwork", "add_icon_light.svg"),
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
                                if(!(position instanceof ClassworkListTeacher)) {
                                    Point currentLocation = position.getLocation();
                                    ClassworkListTeacher frame2 = new ClassworkListTeacher();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
                                    position = frame2;
                                }
                            }else if(index[0] == 1) {
                                if(!(position instanceof MakeClasswork)) {
                                    Point currentLocation = position.getLocation();
                                    MakeClasswork frame2 = new MakeClasswork();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
                                    position = frame2;
                                }
                            }else if(index[0] == 2) {
                                if(!(position instanceof PresenceList)) {
                                    Point currentLocation = position.getLocation();
                                    PresenceList frame2 = new PresenceList();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
                                    position = frame2;
                                }
                            }else if(index[0] == 3) {
                                int pilihan = JOptionPane.showConfirmDialog(position, "Are you sure you want to logout from Lecturer account?", "Logout Confirmation", JOptionPane.CANCEL_OPTION);
                                if (pilihan == JOptionPane.OK_OPTION) {
                                    Point currentLocation = position.getLocation();
                                    Main frame2 = new Main();
                                    frame2.setLocation(currentLocation);
                                    frame2.setVisible(true);
                                    position.dispose();
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
