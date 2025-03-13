package GUI;

import Logical_Class.DialogMSG;
import Logical_Class.CustomerClass;
import Logical_Class.PersonClass;
import Shapes.PanelBackground;
import Shapes.RoundLabel;
import Shapes.RoundedTextField;
import Shapes.RoundedPasswordField;
import javax.swing.*;
import java.awt.*;


public class UserLoginFrame {
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
    ImageIcon ImageIconOpen = new ImageIcon("src\\Images\\Images For Buttons\\UserLogo.png");
    ImageIcon ImageIconClosed = new ImageIcon("src\\Images\\Images For Buttons\\UserLogo.png");
    JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);

    public UserLoginFrame() {
        frame.setTitle("Bite Byte Restaurant");
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*-------Modifies Panels-------*/
        TransparentBackground.setBackground(new Color(0, 0, 0, 150));
        TransparentBackground.setLayout(null);
        TransparentBackground.setBounds(600, 10, 580, 745);
        //--------------//
        PanelBackground MainBackground = new PanelBackground("src\\Images\\Backgrounds\\LoginImageFrame.jpg");
        MainBackground.setBackground(new Color(0x2c384a));
        MainBackground.setLayout(null);

        /*-------Labels Modifies-------*/
        WelcomeText.setText("Welcome Back Monsieur");
        WelcomeText.setFont(new Font("Arial", Font.BOLD, 24));
        WelcomeText.setForeground(new Color(0x956d49));
        WelcomeText.setHorizontalAlignment(SwingConstants.CENTER);
        WelcomeText.setVerticalAlignment(SwingConstants.BOTTOM);
        WelcomeText.setBounds(150, 355, 300, 30);

        /*-------Image Closed Modifies-------*/
        Image imageOpen = ImageIconOpen.getImage();
        Image scaledImageOpen = imageOpen.getScaledInstance(195, 195, Image.SCALE_SMOOTH);
        ImageIconOpen = new ImageIcon(scaledImageOpen);

        /*-------Image Closed Modifies-------*/
        Image imageClosed = ImageIconClosed.getImage();
        Image scaledImageClosed = imageClosed.getScaledInstance(195, 195, Image.SCALE_SMOOTH);
        ImageIconClosed = new ImageIcon(scaledImageClosed);

        /*--------------*/
        ImageLabel.setIcon(ImageIconOpen);
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

        /*-------Go Back Button Modifies-------*/
        GoBack.setText("X");
        GoBack.setForeground(Color.WHITE);
        GoBack.setBackground(Color.RED);
        GoBack.setFocusable(false);
        GoBack.setBounds(10, 10, 45, 30);

        /*-------Progress Bar Modifies-------*/
        bar.setFont(new Font("Arial", Font.BOLD , 25));
        bar.setString("Please Wait a Second");
        bar.setIndeterminate(true);
        bar.setStringPainted(true);
        bar.setBounds(110, 340, 400, 100);
        bar.setVisible(false);

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
            String password = String.valueOf(PasswordField.getPassword());
            if (PersonClass.validateAccount(username, password, "Customers.txt")) {
                Logical_Class.DialogMSG.LoginMessage();
                new Thread(() -> {
                    try {
                        frame.setEnabled(false);
                        bar.setVisible(true);
                        frame.repaint();
                        Thread.sleep(5500);
                        frame.dispose();
                        SwingUtilities.invokeLater(() -> new MenuFrame(new CustomerClass(username)));
                    } catch (InterruptedException _) {
                    }
                }).start();

            } else {
                DialogMSG.ErrorPassUser();
            }
        });
        GoBack.addActionListener(_ -> {
            frame.dispose();
            SwingUtilities.invokeLater(MainFrame::new);
        });
        /*-------Create Account DetailsButton Modifies-------*/
        CreateNewAccount.setText("Create a New Account ?");
        CreateNewAccount.setBounds(1022, 722, 155, 30);
        CreateNewAccount.setBackground(new Color(0x007BFF));
        CreateNewAccount.setBorderPainted(false);
        CreateNewAccount.setOpaque(false);
        CreateNewAccount.setForeground(Color.WHITE);
        CreateNewAccount.setFocusable(false);
        CreateNewAccount.addActionListener(_ -> {
            frame.dispose();
            SwingUtilities.invokeLater(UserCreateNewAccount::new);
        });

        /*-------Adding Components-------*/
        TransparentBackground.add(SubmitButton);
        TransparentBackground.add(PasswordText);
        TransparentBackground.add(UsernameText);
        TransparentBackground.add(WelcomeText);
        TransparentBackground.add(GoBack);
        MainBackground.add(bar);
        frame.add(PasswordField);
        frame.add(ShowPasswordButton);
        frame.add(UsernameField);
        frame.add(CreateNewAccount);
        frame.add(ImageLabel);
        frame.add(TransparentBackground);
        frame.add(MainBackground);
        frame.setVisible(true);

    }
}
