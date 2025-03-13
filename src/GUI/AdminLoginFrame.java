package GUI;

import Logical_Class.AdminClass;
import Shapes.PanelBackground;
import Shapes.RoundLabel;
import Shapes.RoundedTextField;
import Shapes.RoundedPasswordField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class AdminLoginFrame {
    JFrame frame = new JFrame();
    JPanel TransparentBackground = new JPanel();
    JLabel WelcomeText = new JLabel();
    RoundLabel ImageLabel = new RoundLabel();
    JLabel UsernameText = new JLabel();
    JLabel PasswordText = new JLabel();
    RoundedTextField UsernameField = new RoundedTextField("", 20);
    RoundedPasswordField PasswordField = new RoundedPasswordField(20, 20);
    JRadioButton ShowPasswordButton = new JRadioButton();
    JButton SubmitButton = new JButton();
    JButton CreateNewAccount = new JButton();
    JButton GoBack = new JButton();
    ImageIcon ImageIconOpen = new ImageIcon("src\\Images\\Images For Buttons\\AdminImageIcon.png");
    ImageIcon ImageIconClosed = new ImageIcon("src\\Images\\Images For Buttons\\AdminImageIcon.png");
    /*Try These Meme*/
//    ImageIcon ImageIconOpen = new ImageIcon("src\\Images\\Images For Buttons\\Open.png");
//    ImageIcon ImageIconClosed = new ImageIcon("src\\Images\\Images For Buttons\\Close.png");


    public AdminLoginFrame() {
        frame.setTitle("Bite Byte Restaurant");
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*-------Modifies Panels-------*/
        TransparentBackground.setBackground(new Color(0, 0, 0, 150));
        TransparentBackground.setLayout(null);
        TransparentBackground.setBounds(600, 10, 580, 745);
        PanelBackground MainBackground = new PanelBackground("src\\Images\\Backgrounds\\Login Admin Frame Background.jpg");
        MainBackground.setBackground(new Color(0x2c384a));
        MainBackground.setLayout(null);

        /*-------Labels Modifies-------*/
        WelcomeText.setText("Welcome Back Chef");
        WelcomeText.setFont(new Font("Arial", Font.BOLD, 24));
        WelcomeText.setForeground(new Color(0x956d49));
        WelcomeText.setForeground(new Color(0x8d6e63));
        WelcomeText.setHorizontalAlignment(SwingConstants.CENTER);
        WelcomeText.setVerticalAlignment(SwingConstants.BOTTOM);
        WelcomeText.setBounds(150, 355, 300, 30);

        /*-------Image Closed Modifies-------*/
        Image imageOpen = ImageIconOpen.getImage();
        Image scaledImageOpen = imageOpen.getScaledInstance(225, 225, Image.SCALE_SMOOTH);
        ImageIconOpen = new ImageIcon(scaledImageOpen);

        /*-------Image Closed Modifies-------*/
        Image imageClosed = ImageIconClosed.getImage();
        Image scaledImageClosed = imageClosed.getScaledInstance(225, 225, Image.SCALE_SMOOTH);
        ImageIconClosed = new ImageIcon(scaledImageClosed);
        /*--------------*/
        ImageLabel.setIcon(ImageIconClosed);
        ImageLabel.setBounds(775, 100, 250, 250);
        ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        /*------- Label Text Modifies-------*/
        UsernameText.setText("Username: ");
        UsernameText.setFont(new Font("Arial", Font.ITALIC, 18));
        UsernameText.setForeground(Color.WHITE);
        UsernameText.setBounds(90, 400, 220, 65);

        PasswordText.setText("Password: ");
        PasswordText.setFont(new Font("Arial", Font.ITALIC, 18));
        PasswordText.setBounds(90, 450, 220, 65);
        PasswordText.setForeground(Color.WHITE);

        /*-------Username Field Modifies-------*/
        UsernameField.setBounds(800, 428, 225, 30);
        UsernameField.setBackground(new Color(0xcabcad));
        UsernameField.setFont(new Font("Arial", Font.BOLD, 16));
        UsernameField.setBorder(null);

        /*-------Password Field Modifies-------*/
        PasswordField.setBounds(800, 478, 225, 30);
        PasswordField.setBackground(new Color(0xc2b8b0));
        PasswordField.setFont(new Font("Arial", Font.BOLD, 16));
        PasswordField.setBorder(null);

        /*-------Show Password DetailsButton Modifies-------*/
        ShowPasswordButton.setText("Show Password");
        ShowPasswordButton.setBackground(new Color(0, 0, 0, 100));
        ShowPasswordButton.setOpaque(false);
        ShowPasswordButton.setFocusable(false);
        ShowPasswordButton.setFont(new Font("Arial", Font.BOLD, 14));
        ShowPasswordButton.setForeground(Color.WHITE);
        ShowPasswordButton.setBounds(PasswordField.getX(), 515, 150, 25);

        /*-------Submit DetailsButton Modifies-------*/
        SubmitButton.setText("Login");
        SubmitButton.setBackground(new Color(0xc2b8b0));
        SubmitButton.setFont(new Font("Arial", Font.BOLD, 14));
        SubmitButton.setFocusable(false);
        SubmitButton.setBounds(250, 560, 100, 30);
        SubmitButton.setMnemonic(KeyEvent.VK_ENTER);
        /*-------Go Back Button Modifies-------*/
        GoBack.setText("X");
        GoBack.setForeground(Color.WHITE);
        GoBack.setBackground(Color.RED);
        GoBack.setFocusable(false);
        GoBack.setBounds(10, 10, 45, 30);
        /*-------Buttons Event Modifies-------*/
        ShowPasswordButton.addActionListener(_ -> {
            if (ShowPasswordButton.isSelected()) {
                PasswordField.setEchoChar((char) 0);
                ImageLabel.setIcon(ImageIconOpen);
            } else {
                PasswordField.setEchoChar('•');
                ImageLabel.setIcon(ImageIconClosed);
            }
        });
        SubmitButton.addActionListener(_ -> {
            String username = UsernameField.getText();
            String password = new String(PasswordField.getPassword());
            if (AdminClass.validateAccount(username, password, "Admins.txt")) {
                Logical_Class.DialogMSG.LoginMessage();
                frame.dispose();
                SwingUtilities.invokeLater(() -> new ArchiveRestaurantFrame(new AdminClass(username)));
            } else {
                Logical_Class.DialogMSG.ErrorPassUser();
            }
        });
        ShowPasswordButton.addActionListener(_ -> {
            if (ShowPasswordButton.isSelected()) {
                PasswordField.setEchoChar((char) 0);
            } else {
                PasswordField.setEchoChar('•');
            }
        });
        GoBack.addActionListener(_ -> {
            frame.dispose();
            SwingUtilities.invokeLater(MainFrame::new);
        });
        /*-------Create Account DetailsButton Modifies-------*/
        CreateNewAccount.setText("Create a New Account ?");
        CreateNewAccount.setBounds(1025, 725, 155, 30);
        CreateNewAccount.setBackground(new Color(0x007BFF));
        CreateNewAccount.setBorderPainted(false);
        CreateNewAccount.setOpaque(false);
        CreateNewAccount.setForeground(Color.WHITE);
        CreateNewAccount.setFocusable(false);
        CreateNewAccount.addActionListener(_ -> {
            frame.dispose();
            SwingUtilities.invokeLater(AdminCreateNewAccount::new);
        });

        /*-------Adding Components-------*/
        frame.add(PasswordField);
        TransparentBackground.add(SubmitButton);
        frame.add(ShowPasswordButton);
        TransparentBackground.add(PasswordText);
        TransparentBackground.add(WelcomeText);
        TransparentBackground.add(UsernameText);
        TransparentBackground.add(GoBack);
        frame.add(UsernameField);
        frame.add(CreateNewAccount);
        frame.add(ImageLabel);
        frame.add(TransparentBackground);
        frame.add(MainBackground);
        frame.setVisible(true);
    }
}
