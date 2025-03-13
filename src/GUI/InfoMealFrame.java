package GUI;

import Logical_Class.DialogMSG;
import Logical_Class.CustomerClass;
import Logical_Class.MealClass;
import Shapes.PanelBackground;
import Shapes.RoundedTextField;

import javax.swing.*;
import java.awt.*;

/*This Class To View Meal's Details When User Click on meal's Photo*/
public class InfoMealFrame {
    Dialog frame;
    int CurrQuantity = 1;
    JPanel ColorBackground;
    JPanel ItemBackground;
    PanelBackground LogoBackground;

    JLabel Title = new JLabel();
    JLabel nameLabel = new JLabel();
    JLabel priceLabel = new JLabel();
    JLabel quantityLabel = new JLabel();
    JLabel detailsLabel = new JLabel();
    RoundedTextField nameField;
    RoundedTextField priceField;
    RoundedTextField quantityField;
    JTextArea detailsField;
    JButton SaveButton = new JButton();

    Font fontLabels = new Font("Arial", Font.BOLD, 24);
    Font fontFields = new Font("Arial", Font.PLAIN, 18);


    /*This Class For Show Meals Detail On The Menu Frame*/
    public InfoMealFrame(JFrame parentFrame, MenuFrame.MealsOnMenuFrame meal, CustomerClass Customer, String check) {
        frame = new Dialog(parentFrame, "Flavor Details", true);
        nameField = new RoundedTextField(meal.name, 20);
        priceField = new RoundedTextField(meal.price + " $", 20);
        quantityField = new RoundedTextField("", 20);
        detailsField = new JTextArea(meal.description);

        /*-------frame Modifies-------*/
        frame.setSize(600, 400);
        frame.setTitle("Flavor Details");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        /*-------TitleChooseOperation Modifies-------*/
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        Title.setPreferredSize(new Dimension(300, 40));
        Title.setText("- Flavor Details -");
        Title.setHorizontalAlignment(JLabel.CENTER);
        Title.setAlignmentX(Component.CENTER_ALIGNMENT);
        Title.setForeground(Color.WHITE);
        Title.setFont(new Font("Serif", Font.BOLD, 35));
        titlePanel.add(Title);


        /*-------Labels Modifies-------*/
        nameLabel.setText("Meal's Name: ");
        nameLabel.setPreferredSize(new Dimension(250, 25));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(fontLabels);

        priceLabel.setText("Meal's Price: ");
        priceLabel.setPreferredSize(new Dimension(250, 25));
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setFont(fontLabels);

        quantityLabel.setText("Meal's Quantity: ");
        quantityLabel.setPreferredSize(new Dimension(250, 25));
        quantityLabel.setForeground(Color.WHITE);
        quantityLabel.setFont(fontLabels);

        detailsLabel.setText("Meal's Description: ");
        detailsLabel.setPreferredSize(new Dimension(250, 25));
        detailsLabel.setForeground(Color.WHITE);
        detailsLabel.setFont(fontLabels);

        /*-------Field Modifies-------*/
        nameField.setPreferredSize(new Dimension(300, 40));
        nameField.setBackground(new Color(250, 250, 250, 100));
        nameField.setOpaque(false);
        nameField.setFont(fontFields);
        nameField.setEditable(false);

        priceField.setPreferredSize(new Dimension(300, 40));
        priceField.setBackground(new Color(250, 250, 250, 100));
        priceField.setOpaque(false);
        priceField.setFont(fontFields);
        priceField.setEditable(false);

        quantityField.setPreferredSize(new Dimension(300, 40));
        quantityField.setBackground(new Color(250, 250, 250, 100));
        quantityField.setOpaque(false);
        quantityField.setFont(fontFields);
        if (check.equals("Details")) {
            quantityField.setText("Choose Meal? Click On CheckBox");
            quantityField.setEnabled(false);
            SaveButton.setText("Close");
        } else {
            SaveButton.setText("Save");
            quantityField.setText("Enter the Quantity...");
            quantityField.addFocusListener(new java.awt.event.FocusListener() {
                @Override
                public void focusGained(java.awt.event.FocusEvent e) {
                    if (quantityField.getText().equals("Enter the Quantity...")) {
                        quantityField.setText("");
                    }
                }

                @Override
                public void focusLost(java.awt.event.FocusEvent e) {
                    if (quantityField.getText().isEmpty()) {
                        quantityField.setText("Enter the Quantity...");
                    }
                }
            });
        }
        detailsField.setPreferredSize(new Dimension(300, 115));
        detailsField.setBackground(new Color(250, 250, 250, 150));
        detailsField.setOpaque(false);
        detailsField.setFont(fontFields);
        detailsField.setEditable(false);
        detailsField.setWrapStyleWord(true);
        detailsField.setLineWrap(true);
        /*-------Button Modifies-------*/
        JPanel SavePanel = new JPanel();
        SavePanel.setOpaque(false);
        SavePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        SaveButton.setPreferredSize(new Dimension(100, 33));
        SaveButton.setFont(fontLabels);
        SaveButton.setForeground(new Color(0x8d6e63));
        SaveButton.setFocusable(false);
        SavePanel.add(SaveButton);
        SaveButton.addActionListener(_ -> {
            if (!check.equals("Details")) {
                if (!quantityField.getText().matches("\\d+")) {  //contains char
                    DialogMSG.EnterValidData("Quantity");
                } else if (meal.totalQuantity > Integer.parseInt(quantityField.getText())) {
                    CurrQuantity = Integer.parseInt(quantityField.getText());
                    Customer.orderCustomer.Meals.add(new MealClass(meal.name, meal.price, CurrQuantity));
                    frame.dispose();
                } else {
                    DialogMSG.NotEnoughQuantity();
                }
            } else {
                frame.dispose();
            }
        });
        /*-------Panels Modifies-------*/
        ItemBackground = new JPanel();
        ItemBackground.setOpaque(false);
        ItemBackground.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));

        LogoBackground = new PanelBackground("src\\Images\\Backgrounds\\Restaurant Logo.png");
        LogoBackground.setLayout(new BorderLayout(5, 5));
        LogoBackground.setOpaque(false);
        ColorBackground = new JPanel();
        ColorBackground.setBackground(new Color(0x343434));
        ColorBackground.setLayout(new GridLayout());

        /*-------Add Components-------*/
        ItemBackground.add(nameLabel);
        ItemBackground.add(nameField);
        //--------------//
        ItemBackground.add(priceLabel);
        ItemBackground.add(priceField);
        //--------------//
        ItemBackground.add(quantityLabel);
        ItemBackground.add(quantityField);
        //--------------//
        ItemBackground.add(detailsLabel);
        ItemBackground.add(detailsField);
        //--------------//
        LogoBackground.add(titlePanel, BorderLayout.NORTH);
        LogoBackground.add(ItemBackground, BorderLayout.CENTER);
        LogoBackground.add(SavePanel, BorderLayout.SOUTH);
        //--------------//
        ColorBackground.add(LogoBackground);
        frame.add(ColorBackground);
        frame.setVisible(true);
    }
}