package GUI;

import Shapes.CustomLinePanel;
import Shapes.PanelBackground;
import Shapes.RoundButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    //-------Obj-------//
    JFrame frame = new JFrame();
    RoundButton UserBtnLogin = new RoundButton();
    RoundButton AdminBtnLogin = new RoundButton();
    JLabel UserLabel = new JLabel("Customer", SwingConstants.CENTER);
    JLabel AdminLabel = new JLabel("Chef", SwingConstants.CENTER);
    JLabel labelRestaurantName = new JLabel();
    JLabel UserLabelQuote = new JLabel();
    JLabel AdminLabelQuote = new JLabel();
    JLabel imageLabel = new JLabel();
    PanelBackground ImagePanelBackground;
    JPanel ItemsPanel = new JPanel();
    CustomLinePanel linePanel1 = new CustomLinePanel();
    CustomLinePanel linePanel2 = new CustomLinePanel();

    public MainFrame() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frame);
            frame.revalidate();
            frame.repaint();
        } catch (Exception _) {
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        /*-------Frame-------*/
        frame.setTitle("Bite Byte Restaurant");
        ImageIcon frameLogo = new ImageIcon("src\\Images\\Backgrounds\\Origin Restaurant Logo.png");
        Image frameImage = frameLogo.getImage();
        frame.setIconImage(frameImage);
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /*-------User Modifies Components*/
        //-------User DetailsButton Login-------//
        ImageIcon iconUser = new ImageIcon("src\\Images\\Images For Buttons\\UserLogo.png");
        Image imgUser = iconUser.getImage();
        Image scaledImgUser = imgUser.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        iconUser = new ImageIcon(scaledImgUser);
        UserBtnLogin.setIcon(iconUser);
        UserBtnLogin.setBounds(360, 20, 200, 200);
        UserBtnLogin.setOpaque(false);
        UserBtnLogin.addActionListener(this);

        //-------User Label Login-------//
        UserLabel.setBounds(350, 210, 200, 40);
        UserLabel.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 30));
        UserLabel.setForeground(new Color(0x222222));

        //-------User Text Login-------//
        UserLabelQuote.setText("<html><body style='width: 400px; line-height: 5;'>"  //&nbsp;&nbsp;&nbsp; == tab
                + "Our Happiness Lies in<br>"
                + "Your Satisfaction<br>"
                + "Savor Each Bite<br>"
                + "Day or Night<br>"
                + "Fuel Your Day With Us!"
                + "</body></html>");
        UserLabelQuote.setFont(new Font("Playwrite Australia Victoria Guides", Font.ITALIC, 30));
        UserLabelQuote.setForeground(new Color(0x463628));
        UserLabelQuote.setBounds(20, 10, 660, 240);

        /*-------Admin Modifies Components*/
        //-------Admin DetailsButton Login-------//
        ImageIcon iconAdmin = new ImageIcon("src\\Images\\Images For Buttons\\AdminImageIcon.png");
        Image imgAdmin = iconAdmin.getImage();
        Image scaledImgAdmin = imgAdmin.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        iconAdmin = new ImageIcon(scaledImgAdmin);
        AdminBtnLogin.setIcon(iconAdmin);
        AdminBtnLogin.setBounds(20, 470, 200, 200);
        AdminBtnLogin.addActionListener(this);
        //-------Admin Label Login-------//
        AdminLabel.setBounds(5, 660, 200, 40);
        AdminLabel.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 30));
        AdminLabel.setForeground(new Color(0x222222));

        //-------Admin Text Login-------//
        AdminLabelQuote.setText("<html><body style='width: 400px; line-height: 15;'>"  //&nbsp;&nbsp;&nbsp; == tab
                + "The Chefs And Servers<br>"
                + "You are The Heroes<br>"
                + "Behind The Scenes.<br>"
                + "You are The Reason <br>"
                + "That Our Guests Keep<br>"
                + "Coming Back"
                + "</body></html>");
        AdminLabelQuote.setFont(new Font("Playwrite Australia Victoria Guides", Font.ITALIC, 30));
        AdminLabelQuote.setForeground(new Color(0x463628));
        AdminLabelQuote.setBounds(240, 450, 600, 230);


        /*-------Line Panel-------*/
        linePanel1.setBounds(0, 340, 600, 10);
        linePanel2.setBounds(0, 365, 600, 10);


        /*-------Backgrounds Panel-------*/
        ImagePanelBackground = new PanelBackground("src\\Images\\Backgrounds\\MainImageFrame.jpg");
        ImagePanelBackground.setLayout(null);
        ItemsPanel.setBackground(new Color(240, 240, 240, 100));
        ItemsPanel.setBounds(10, 10, 600, 745);
        ItemsPanel.setLayout(null);
        ItemsPanel.setOpaque(true);


        /*-------Adding Components-------*/
        frame.add(UserBtnLogin);
        ItemsPanel.add(UserLabel);
        ItemsPanel.add(UserLabelQuote);
        //--------------//
        frame.add(AdminBtnLogin);
        ItemsPanel.add(AdminLabel);
        ItemsPanel.add(AdminLabelQuote);
        //--------------//
        ItemsPanel.add(labelRestaurantName);
        ItemsPanel.add(imageLabel);
        //--------------//
        ItemsPanel.add(linePanel1);
        ItemsPanel.add(linePanel2);
        //--------------//
        frame.add(ItemsPanel);
        frame.add(ImagePanelBackground);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == UserBtnLogin) {
            SwingUtilities.invokeLater(UserLoginFrame::new);
            frame.dispose();
        } else if (e.getSource() == AdminBtnLogin) {
            SwingUtilities.invokeLater(AdminLoginFrame::new);
            frame.dispose();
        }
    }
}
