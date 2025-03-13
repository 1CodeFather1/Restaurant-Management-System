package GUI;

import Logical_Class.DialogMSG;
import Logical_Class.AdminClass;
import Shapes.PanelBackground;
import Shapes.RoundLabel;
import Shapes.RoundedTextField;
import Shapes.RoundedPasswordField;
import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class AdminCreateNewAccount {

    JFrame frame = new JFrame();
    JPanel TransparentBackground = new JPanel();
    JLabel WelcomeText = new JLabel();
    RoundLabel ImageLabel = new RoundLabel();
    JLabel Token = new JLabel();
    JLabel UsernameText = new JLabel();
    JLabel PasswordText = new JLabel();
    JLabel ConfirmPasswordText = new JLabel();
    RoundedTextField TokenField = new RoundedTextField("", 20);
    RoundedTextField UsernameField = new RoundedTextField("", 20);
    RoundedPasswordField PasswordField = new RoundedPasswordField(20, 20);
    RoundedPasswordField ConfirmPasswordField = new RoundedPasswordField(20, 20);
    JRadioButton ShowPasswordButton = new JRadioButton();
    JButton SubmitButton = new JButton();
    JButton CreateNewAccount = new JButton();
    JButton GoBack = new JButton();
    ImageIcon ImageIconOpen = new ImageIcon("src\\Images\\Images For Buttons\\AdminImageIcon.png");
    ImageIcon ImageIconClosed = new ImageIcon("src\\Images\\Images For Buttons\\AdminImageIcon.png");

    public AdminCreateNewAccount() {

        frame.setTitle("Bite Byte Restaurant");
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* -------Modifies Panels------- */
        TransparentBackground.setBackground(new Color(0, 0, 0, 150));
        TransparentBackground.setLayout(null);
        TransparentBackground.setBounds(600, 10, 580, 745);
        PanelBackground MainBackground = new PanelBackground("src\\Images\\Backgrounds\\Login Admin Frame Background.jpg");
        MainBackground.setBackground(new Color(0x2c384a));
        MainBackground.setLayout(null);

        /*-------Labels Modifies-------*/
        WelcomeText.setText("Sign Up");
        WelcomeText.setFont(new Font("Arial", Font.BOLD, 24));
        WelcomeText.setForeground(new Color(0x956d49));
        WelcomeText.setHorizontalAlignment(SwingConstants.CENTER);
        WelcomeText.setVerticalAlignment(SwingConstants.BOTTOM);
        WelcomeText.setBounds(150, 320, 300, 30);

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
        ImageLabel.setBounds(775, 60, 250, 250);
        ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        /*------- Label Text Modifies-------*/
        Token.setText("Activation key:");
        Token.setFont(new Font("Arial", Font.ITALIC, 18));
        Token.setForeground(Color.WHITE);
        Token.setBounds(60, 350, 220, 65);

        UsernameText.setText("Username: ");
        UsernameText.setFont(new Font("Arial", Font.ITALIC, 18));
        UsernameText.setForeground(Color.WHITE);
        UsernameText.setBounds(90, 398, 220, 65);

        PasswordText.setText("Password: ");
        PasswordText.setFont(new Font("Arial", Font.ITALIC, 18));
        PasswordText.setBounds(90, 450, 220, 65);
        PasswordText.setForeground(Color.WHITE);

        ConfirmPasswordText.setText("Confirm Password:");
        ConfirmPasswordText.setFont(new Font("Arial", Font.ITALIC, 18));
        ConfirmPasswordText.setForeground(Color.WHITE);
        ConfirmPasswordText.setBounds(30, 500, 220, 65);

        /*-------Token Field Modifies-------*/
        TokenField.setBounds(800, 378, 225, 30);
        TokenField.setBackground(new Color(0xcabcad));
        TokenField.setFont(new Font("Arial", Font.BOLD, 16));
        TokenField.setBorder(null);


        /*-------Username Field Modifies-------*/
        UsernameField.setBounds(800, 425, 225, 30);
        UsernameField.setBackground(new Color(0xcabcad));
        UsernameField.setFont(new Font("Arial", Font.BOLD, 16));
        UsernameField.setBorder(null);

        /*-------Password Field Modifies-------*/
        PasswordField.setBounds(800, 478, 225, 30);
        PasswordField.setBackground(new Color(0xc2b8b0));
        PasswordField.setFont(new Font("Arial", Font.BOLD, 16));
        PasswordField.setBorder(null);

        /*-------ConfirmPasswordField Field Modifies-------*/
        ConfirmPasswordField.setBounds(800, 528, 225, 30);
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
        ShowPasswordButton.setBounds(PasswordField.getX(), 565, 150, 25);

        /*-------Submit Button Modifies-------*/
        SubmitButton.setText("Register ");
        SubmitButton.setBackground(new Color(0xc2b8b0));
        SubmitButton.setFont(new Font("Arial", Font.BOLD, 14));
        SubmitButton.setFocusable(false);
        SubmitButton.setBounds(260, 590, 100, 30);

        /*-------Go Back Button Modifies-------*/
        GoBack.setText("X");
        GoBack.setForeground(Color.WHITE);
        GoBack.setBackground(Color.RED);
        GoBack.setFocusable(false);
        GoBack.setBounds(10, 10, 45, 30);
//        GoBack.setOpaque(false);

        /*-------Buttons Event Modifies-------*/
        SubmitButton.addActionListener(_ -> {
            if (CreateAccountCheck()) {
                return;
            }
            frame.dispose();
            SwingUtilities.invokeLater(AdminLoginFrame::new);
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
            SwingUtilities.invokeLater(AdminLoginFrame::new);
        });

        /*-------Adding Components-------*/
        frame.add(PasswordField);
        frame.add(ConfirmPasswordField);
        TransparentBackground.add(Token);
        frame.add(TokenField);
        TransparentBackground.add(SubmitButton);
        frame.add(ShowPasswordButton);
        TransparentBackground.add(PasswordText);
        TransparentBackground.add(ConfirmPasswordText);
        TransparentBackground.add(WelcomeText);
        TransparentBackground.add(GoBack);
        frame.add(UsernameField);
        TransparentBackground.add(UsernameText);
        frame.add(CreateNewAccount);
        frame.add(ImageLabel);
        frame.add(TransparentBackground);
        frame.add(MainBackground);
        frame.setVisible(true);

    }

    private boolean CreateAccountCheck() {
        String name = UsernameField.getText();
        char[] password = PasswordField.getPassword();
        char[] ConfirmPassword = ConfirmPasswordField.getPassword();
        if (TokenField.getText().isEmpty()) {
            DialogMSG.EmptyFieldError("Key Activation");
            return true;
        }
        if (!TokenField.getText().equals(AdminClass.ActivationKey)) {
            Logical_Class.DialogMSG.ErrorKeyActivation();
            return true;
        }
        if (name.trim().isEmpty()) {
            Logical_Class.DialogMSG.EmptyFieldError("UserName");
            return true;
        }
        if (password.length == 0 && ConfirmPassword.length == 0) {
            Logical_Class.DialogMSG.EmptyFieldError("Password");
            return true;
        }
        if (!Arrays.equals(password, ConfirmPassword)) {
            Logical_Class.DialogMSG.Mismatch();
            return true;
        }
        AdminClass.createAccount(name, String.valueOf(password), "Admins.txt");
        return false;
    }
}
