package GUI;

import Logical_Class.PersonClass;
import Shapes.PanelBackground;
import Shapes.RoundLabel;
import Shapes.RoundedTextField;
import Shapes.RoundedPasswordField;
import java.awt.*;
import javax.swing.*;


public class UserCreateNewAccount {

    JFrame frame = new JFrame();
    JPanel TransparentBackground = new JPanel();
    JLabel WelcomeText = new JLabel();
    RoundLabel ImageLabel = new RoundLabel();
    JLabel UsernameText = new JLabel();
    JLabel PasswordText = new JLabel();
    JLabel ConfirmPasswordText = new JLabel();
    RoundedTextField UsernameField = new RoundedTextField("", 20);
    RoundedPasswordField PasswordField = new RoundedPasswordField(20, 20);
    RoundedPasswordField ConfirmPasswordField = new RoundedPasswordField(20, 20);
    JRadioButton ShowPasswordButton = new JRadioButton();
    JButton SubmitButton = new JButton();
    JButton CreateNewAccount = new JButton();
    JButton GoBack = new JButton();
    ImageIcon ImageIconOpen = new ImageIcon("src\\Images\\Images For Buttons\\UserLogo.png");
    ImageIcon ImageIconClosed = new ImageIcon("src\\Images\\Images For Buttons\\UserLogo.png");

    public UserCreateNewAccount() {

        frame.setTitle("Bite Byte Restaurant");
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* -------Modifies Panels------- */
        TransparentBackground.setBackground(new Color(0, 0, 0, 150));
        TransparentBackground.setLayout(null);
        TransparentBackground.setBounds(600, 10, 580, 745);
        PanelBackground MainBackground = new PanelBackground("src\\Images\\Backgrounds\\LoginImageFrame.jpg");
        MainBackground.setBackground(new Color(0x2c384a));
        MainBackground.setLayout(null);

        /*-------Labels Modifies-------*/
        WelcomeText.setText("Sign Up");
        WelcomeText.setFont(new Font("Arial", Font.BOLD, 24));
        WelcomeText.setForeground(new Color(0x956d49));
        WelcomeText.setHorizontalAlignment(SwingConstants.CENTER);
        WelcomeText.setVerticalAlignment(SwingConstants.BOTTOM);
        WelcomeText.setBounds(150, 355, 300, 30);

        /*-------Image Closed Modifies-------*/
        Image imageOpen = ImageIconOpen.getImage();
        Image scaledImageOpen = imageOpen.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIconOpen = new ImageIcon(scaledImageOpen);

        /*-------Image Closed Modifies-------*/
        Image imageClosed = ImageIconClosed.getImage();
        Image scaledImageClosed = imageClosed.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIconClosed = new ImageIcon(scaledImageClosed);

        /*--------------*/
        ImageLabel.setIcon(ImageIconOpen);
        ImageLabel.setBounds(775, 100, 250, 250);
        ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        /*------- Label Text Modifies-------*/
        UsernameText.setText("Username: ");
        UsernameText.setFont(new Font("Arial", Font.ITALIC, 18));
        UsernameText.setForeground(Color.WHITE);
        UsernameText.setBounds(90, 390, 220, 65);

        PasswordText.setText("Password: ");
        PasswordText.setFont(new Font("Arial", Font.ITALIC, 18));
        PasswordText.setBounds(90, 460, 220, 65);
        PasswordText.setForeground(Color.WHITE);

        ConfirmPasswordText.setText("Confirm Password:");
        ConfirmPasswordText.setFont(new Font("Arial", Font.ITALIC, 18));
        ConfirmPasswordText.setForeground(Color.WHITE);
        ConfirmPasswordText.setBounds(30, 510, 220, 65);

        /*-------Username Field Modifies-------*/
        UsernameField.setBounds(800, 418, 225, 30);
        UsernameField.setBackground(new Color(0xcabcad));
        UsernameField.setFont(new Font("Arial", Font.BOLD, 16));
        UsernameField.setBorder(null);

        /*-------Password Field Modifies-------*/
        PasswordField.setBounds(800, 488, 225, 30);
        PasswordField.setBackground(new Color(0xc2b8b0));
        PasswordField.setFont(new Font("Arial", Font.BOLD, 16));
        PasswordField.setBorder(null);

        /*-------ConfirmPasswordField Field Modifies-------*/
        ConfirmPasswordField.setBounds(800, 538, 225, 30);
        ConfirmPasswordField.setBackground(new Color(0xc2b8b0));
        ConfirmPasswordField.setFont(new Font("Arial", Font.BOLD, 16));
        ConfirmPasswordField.setBorder(null);

        /*-------Show Password Button Modifies-------*/
        ShowPasswordButton.setText("Show Password");
        ShowPasswordButton.setBackground(new Color(0, 0, 0, 100));
        ShowPasswordButton.setOpaque(false);
        ShowPasswordButton.setFocusable(false);
        ShowPasswordButton.setFont(new Font("Arial", Font.BOLD, 14));
        ShowPasswordButton.setForeground(Color.WHITE);
        ShowPasswordButton.setBounds(PasswordField.getX() + 10, 575, 150, 25);

        /*-------Submit Button Modifies-------*/
        SubmitButton.setText("Register ");
        SubmitButton.setBackground(new Color(0xc2b8b0));
        SubmitButton.setFont(new Font("Arial", Font.BOLD, 14));
        SubmitButton.setFocusable(false);
        SubmitButton.setBounds(260, 600, 100, 30);

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
            String ConfirmPass = new String(ConfirmPasswordField.getPassword());
            if (username.isEmpty()) {
                Logical_Class.DialogMSG.EmptyFieldError("Username");
            } else if (password.isEmpty() || ConfirmPass.isEmpty()) {
                Logical_Class.DialogMSG.EmptyFieldError("Password");
            } else if (!password.equals(ConfirmPass)) {
                Logical_Class.DialogMSG.Mismatch();
            } else {
                PersonClass.createAccount(username, password, "Customers.txt");
                frame.dispose();
                SwingUtilities.invokeLater(UserLoginFrame::new);
            }
        });
        ShowPasswordButton.addActionListener(_ -> {
            if (ShowPasswordButton.isSelected()) {
                PasswordField.setEchoChar((char) 0);
                ConfirmPasswordField.setEchoChar((char) 0);
            } else {
                PasswordField.setEchoChar('•');
                ConfirmPasswordField.setEchoChar(('•'));
            }
        });
        GoBack.addActionListener(_ -> {
            frame.dispose();
            SwingUtilities.invokeLater(UserLoginFrame::new);
        });

        /*-------Adding Components-------*/
        frame.add(PasswordField);
        frame.add(ConfirmPasswordField);
        TransparentBackground.add(SubmitButton);
        frame.add(ShowPasswordButton);
        TransparentBackground.add(PasswordText);
        TransparentBackground.add(ConfirmPasswordText);
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
