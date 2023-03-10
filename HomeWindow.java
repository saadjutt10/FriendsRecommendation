
//  package GUI;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class HomeWindow extends JFrame {
    HomeWindow(User user) {
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Home");
        // setBackground("yellow");
        // setBackground("green");
        // setLayout(new GridLayout());
        setLayout(new GridLayout(2, 1));
        setBackground((Color.decode("#" + Main.DarkColor)));
        // GridBagConstraints constraints = new GridBagConstraints();

        // Create the image
        // JLabel imageLabel = new JLabel();
        // imageLabel.setIcon(new ImageIcon(user.getImageDir()));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(1, 4, 30, 60));
        infoPanel.setBackground((Color.decode("#" + Main.DarkColor)));
        // UserPanel

        JLabel Userimg = new JLabel();

        // Create an ImageIcon from a file
        ImageIcon imgIcon = new ImageIcon(user.getImageDir());
        Image img = imgIcon.getImage();

        // Create a new ImageIcon with a different size
        Image newImg = img.getScaledInstance(170, 170, java.awt.Image.SCALE_SMOOTH);
        Userimg.setIcon(new ImageIcon(newImg));

        JPanel info = new JPanel();
        info.setBackground((Color.decode("#" + Main.DarkColor)));
        info.setLayout(new GridLayout(5, 1));
        JLabel uName = new JLabel("Name :" + user.getName() + " " + user.getLastName());
        uName.setForeground(Color.white);
        JLabel uAge = new JLabel("Age :" + user.getAge());
        uAge.setForeground(Color.white);
        JLabel uAdd = new JLabel(user.getAdd().getCity() + " Street :" + user.getAdd().getStreetNo()
                + " House No :" + user.getAdd().getHouseNo());
        uAdd.setForeground(Color.white);
        info.add(new JLabel(""));
        info.add(uName);
        info.add(uAge);
        info.add(uAdd);
        info.add(new JLabel(""));

        // Panel to add function panel in center
        JPanel fCentre = new JPanel();
        fCentre.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        fCentre.setBackground((Color.decode("#" + Main.notDarkColor)));

        // Function Panel
        JPanel functionJPanel = new JPanel();
        functionJPanel.setLayout(new GridLayout(1, 3, 50, 50));
        functionJPanel.setBackground(Color.decode("#" + Main.notDarkColor));

        // Panel 1
        JPanel frndsPanel = new JPanel();
        
        frndsPanel.setBackground(Color.decode("#" + Main.notDarkColor));
        frndsPanel.setLayout(new BorderLayout());
        frndsPanel.setBackground(Color.yellow);
        JLabel frndsimg = new JLabel();
        ImageIcon frndicon = new ImageIcon("friendship.png");
        Image fimg = frndicon.getImage();
        Image frndNewimg = fimg.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
        frndsimg.setIcon(new ImageIcon(frndNewimg));

        JButton frndsBtn = new JButton("Friends");
        frndsBtn.setPreferredSize(new Dimension(frndNewimg.getWidth(null) - 10, 20));
        frndsPanel.add(frndsimg, BorderLayout.CENTER);
        frndsPanel.add(frndsBtn, BorderLayout.SOUTH);
        // Panel 2
        JPanel recoPanel = new JPanel();
        recoPanel.setLayout(new BorderLayout());
        JLabel recimg = new JLabel();
        ImageIcon recIcon = new ImageIcon("rating.png");
        Image recoimg = recIcon.getImage();
        Image recNewimg = recoimg.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
        recimg.setIcon(new ImageIcon(recNewimg));

        JButton recBtn = new JButton("Recommendations");
        recBtn.setPreferredSize(new Dimension(frndNewimg.getWidth(null) - 10, 20));
        recoPanel.add(recimg, BorderLayout.CENTER);
        recoPanel.add(recBtn, BorderLayout.SOUTH);
        // Panel 3
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());
        JLabel searchimg = new JLabel();
        ImageIcon sicon = new ImageIcon("searchimg.png");
        Image simg = sicon.getImage();
        Image sNewimg = simg.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
        searchimg.setIcon(new ImageIcon(sNewimg));

        JButton searchBtn = new JButton("Search");
        searchBtn.setPreferredSize(new Dimension(frndNewimg.getWidth(null) - 10, 20));
        searchPanel.add(searchimg, BorderLayout.CENTER);
        searchPanel.add(searchBtn, BorderLayout.SOUTH);

        // Adding to Function Panel
        functionJPanel.add(recoPanel);
        functionJPanel.add(frndsPanel);
        functionJPanel.add(searchPanel);
        // Adding to (Info)User Panel
        infoPanel.add(Userimg);
        infoPanel.add(info);
        infoPanel.add(new JLabel(""));
        // Corner Panel
        JPanel cornerPanel = new JPanel();
        
        cornerPanel.setBackground(Color.decode("#" + Main.DarkColor));
        cornerPanel.setLayout(new GridLayout(4, 1, 50, 30));
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setPreferredSize(new Dimension(100, 30));
        JPanel logoutBtnPanel = new JPanel();
        
        logoutBtnPanel.setBackground(Color.decode("#" + Main.DarkColor));
        logoutBtnPanel.add(logoutBtn);
        logoutBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton settingBtn = new JButton("Setting");
        
        settingBtn.setPreferredSize(new Dimension(100, 30));
        JPanel settingBtnPanel = new JPanel();
        
        settingBtnPanel.setBackground(Color.decode("#" + Main.DarkColor));
        settingBtnPanel.add(settingBtn);
        settingBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        cornerPanel.add(new JLabel(""));
        cornerPanel.add(logoutBtnPanel);
        cornerPanel.add(settingBtnPanel);
        cornerPanel.add(new JLabel(""));

        infoPanel.add(cornerPanel);
        // Adding spaces and functional panel to fcentre
        JLabel space = new JLabel("sasas");
        space.setBackground(Color.red);
        // space.setPreferredSize(new Dimension(30,10));
        // fCentre.add(space);
        fCentre.add(functionJPanel);

        // Adding to Main Frame
        add(infoPanel);
        add(fCentre);
        // *******************Adding Action Listners */
        MyActionListener alA = new MyActionListener(user);
        logoutBtn.addActionListener(alA);
        settingBtn.addActionListener(alA);
        searchBtn.addActionListener(alA);
        recBtn.addActionListener(alA);
        frndsBtn.addActionListener(alA);

    }

    class MyActionListener implements ActionListener {
        User user;

        MyActionListener(User u) {
            user = u;
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "Logout") {
                dispose();
                new Login();
            } else if (e.getActionCommand() == "Search") {
                try {
                    dispose();
                    new SearchWindow(user, "");
                } catch (ClassNotFoundException | IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else if (e.getActionCommand() == "Recommendations") {

                try {
                    dispose();
                    new RecoWindow(user);
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else if (e.getActionCommand() == "Setting") {
                dispose();
                new SettingsWindow(user);
            } else if (e.getActionCommand() == "Friends") {
                try {
                    dispose();
                    new FriendsFrame(user);
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        new HomeWindow(Main_With_IO.getAllNodes("Data.txt").get(0));
    }
}
