package GUI;

import Logical_Class.DialogMSG;
import Logical_Class.AdminClass;
import Logical_Class.MealClass;
import Shapes.PanelBackground;
import Shapes.RoundedTextField;

import javax.swing.*;
import java.awt.*;


// The Small frame that show when use popup
public class AddEdit_Meal {
    JDialog frame;
    String oldMealName;
    JPanel ColorBackground;
    JPanel ItemBackground;
    PanelBackground LogoBackground;

    JLabel Title = new JLabel();
    JLabel nameLabel = new JLabel();
    JLabel priceLabel = new JLabel();
    JLabel quantityLabel = new JLabel();
    JLabel pathLabel = new JLabel();
    JLabel detailsLabel = new JLabel();
    RoundedTextField nameField;
    RoundedTextField priceField;
    RoundedTextField quantityField;
    RoundedTextField pathField;
    JTextArea detailsField;
    JButton SaveButton = new JButton();
    JButton CloseButton = new JButton();

    Font fontLabels = new Font("Arial", Font.BOLD, 24);
    Font fontFields = new Font("Arial", Font.PLAIN, 18);
    private boolean isClosed = false;

    /*Add A new Meal*/
    public AddEdit_Meal(JFrame mainframe, String typeMeal) {
        nameField = new RoundedTextField("", 20);
        priceField = new RoundedTextField("", 20);
        quantityField = new RoundedTextField("", 20);
        pathField = new RoundedTextField("", 20);
        detailsField = new JTextArea("");
        detailsField.setLineWrap(true); // when You Arrive end of line he moved down
        detailsField.setWrapStyleWord(true);

        /*-------frame Modifies-------*/
        frame = new JDialog(mainframe, "Flavor Modify", true);
        frame.setSize(600, 410);
        frame.setTitle("Flavor Modify");
        frame.setResizable(false);
        frame.setLocationRelativeTo(mainframe);

        /*-------TitleChooseOperation Modifies-------*/
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        Title.setPreferredSize(new Dimension(300, 40));
        Title.setText("- Flavor Modify -");
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

        pathLabel.setText("Meal's Image: ");
        pathLabel.setPreferredSize(new Dimension(250, 25));
        pathLabel.setForeground(Color.WHITE);
        pathLabel.setFont(fontLabels);

        detailsLabel.setText("Meal's Description: ");
        detailsLabel.setPreferredSize(new Dimension(250, 25));
        detailsLabel.setForeground(Color.WHITE);
        detailsLabel.setFont(fontLabels);

        /*-------Field Modifies-------*/
        nameField.setPreferredSize(new Dimension(300, 40));
        nameField.setBackground(new Color(250, 250, 250, 100));
        nameField.setOpaque(false);
        nameField.setFont(fontFields);

        priceField.setPreferredSize(new Dimension(300, 40));
        priceField.setBackground(new Color(250, 250, 250, 100));
        priceField.setOpaque(false);
        priceField.setFont(fontFields);

        quantityField.setPreferredSize(new Dimension(300, 40));
        quantityField.setBackground(new Color(250, 250, 250, 100));
        quantityField.setOpaque(false);
        quantityField.setFont(fontFields);

        pathField.setPreferredSize(new Dimension(300, 40));
        pathField.setBackground(new Color(250, 250, 250, 100));
        pathField.setOpaque(false);
        pathField.setFont(fontFields);

        detailsField.setPreferredSize(new Dimension(300, 80));
        detailsField.setBackground(new Color(250, 250, 250, 150));
        detailsField.setOpaque(false);
        detailsField.setFont(fontFields);
        detailsField.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (detailsField.getText().equals("Keep it in Three Line")) {
                    detailsField.setText("");
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (detailsField.getText().isEmpty()) {
                    detailsField.setText("Keep it in Three Line");
                }
            }
        });

        /*-------Button Modifies-------*/
        JPanel SavePanel = new JPanel();
        SavePanel.setOpaque(false);
        SavePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        // *************************//
        CloseButton.setPreferredSize(new Dimension(100, 30));
        CloseButton.setText("Close");
        CloseButton.setFont(fontLabels);
        CloseButton.setForeground(new Color(0x8d6e63));
        CloseButton.setFocusable(false);
        CloseButton.addActionListener(_ -> {
            isClosed = true;
            frame.dispose();
        });
        // *************************//
        SaveButton.setPreferredSize(new Dimension(100, 30));
        SaveButton.setText("Save");
        SaveButton.setFont(fontLabels);
        SaveButton.setForeground(new Color(0x8d6e63));
        SaveButton.setFocusable(false);
        SavePanel.add(SaveButton);
        SavePanel.add(CloseButton);
        SaveButton.addActionListener(_ -> {
            if (validateFields()) {
                return ;
            } else if (Logical_Class.DialogMSG.ConfirmActionForMeal("Add", nameField.getText())) {
                AdminClass.addMealToFile(nameField.getText(), typeMeal,
                        Integer.parseInt(quantityField.getText().trim()),
                        Float.parseFloat(priceField.getText().trim()),
                        pathField.getText(),
                        detailsField.getText(), (typeMeal + ".txt"));
                frame.dispose();
            }
        });

        /*-------Panels Modifies-------*/
        ItemBackground = new JPanel();
        ItemBackground.setOpaque(false);
        ItemBackground.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 7));

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
        ItemBackground.add(pathLabel);
        ItemBackground.add(pathField);
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


    /*Edit Meal*/
    public AddEdit_Meal(JFrame mainframe, MealClass meal, String tabTitle) {
        nameField = new RoundedTextField(meal.getNameMeal(), 20);
        priceField = new RoundedTextField(String.valueOf(meal.getPriceMeal()) + '$', 20);
        quantityField = new RoundedTextField(meal.getTotalQuantityMeal() + " Pieces", 20);
        pathField = new RoundedTextField(meal.getImageMeal(), 20);
        detailsField = new JTextArea(meal.getDescriptionMeal());
        detailsField.setLineWrap(true);
        oldMealName = nameField.getText();

        /*-------frame Modifies-------*/
        frame = new JDialog(mainframe, "Flavor Modify", true);
        frame.setSize(600, 400);
        frame.setTitle("Flavor Modify");
        frame.setResizable(false);
        frame.setLocationRelativeTo(mainframe);

        /*-------TitleChooseOperation Modifies-------*/
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        Title.setPreferredSize(new Dimension(300, 40));
        Title.setText("- Flavor Modify -");
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

        pathLabel.setText("Meal's Image: ");
        pathLabel.setPreferredSize(new Dimension(250, 25));
        pathLabel.setForeground(Color.WHITE);
        pathLabel.setFont(fontLabels);

        detailsLabel.setText("Meal's Description: ");
        detailsLabel.setPreferredSize(new Dimension(250, 25));
        detailsLabel.setForeground(Color.WHITE);
        detailsLabel.setFont(fontLabels);

        /*-------Field Modifies-------*/
        nameField.setPreferredSize(new Dimension(300, 40));
        nameField.setBackground(new Color(250, 250, 250, 100));
        nameField.setOpaque(false);
        nameField.setFont(fontFields);

        priceField.setPreferredSize(new Dimension(300, 40));
        priceField.setBackground(new Color(250, 250, 250, 100));
        priceField.setOpaque(false);
        priceField.setFont(fontFields);


        quantityField.setPreferredSize(new Dimension(300, 40));
        quantityField.setBackground(new Color(250, 250, 250, 100));
        quantityField.setOpaque(false);
        quantityField.setFont(fontFields);


        pathField.setPreferredSize(new Dimension(300, 40));
        pathField.setBackground(new Color(250, 250, 250, 100));
        pathField.setOpaque(false);
        pathField.setFont(fontFields);


        detailsField.setPreferredSize(new Dimension(300, 90));
        detailsField.setBackground(new Color(250, 250, 250, 150));
        detailsField.setOpaque(false);
        detailsField.setFont(fontFields);


        /*-------Button Modifies-------*/
        JPanel SavePanel = new JPanel();
        SavePanel.setOpaque(false);
        SavePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //--------------//
        CloseButton.setPreferredSize(new Dimension(100, 30));
        CloseButton.setText("Close");
        CloseButton.setFont(fontLabels);
        CloseButton.setForeground(new Color(0x8d6e63));
        CloseButton.setFocusable(false);
        CloseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        CloseButton.addActionListener(_ -> {
            isClosed = true;
            frame.dispose();
        });
        //--------------//
        SaveButton.setPreferredSize(new Dimension(100, 30));
        SaveButton.setText("Save");
        SaveButton.setFont(fontLabels);
        SaveButton.setForeground(new Color(0x8d6e63));
        SaveButton.setFocusable(false);
        SavePanel.add(SaveButton);
        SavePanel.add(CloseButton);
        SaveButton.addActionListener(_ -> {
            if (validateFields()) {
                return;
            } else {
                AdminClass.editMealInFile(oldMealName, nameField.getText(), tabTitle,
                        Integer.parseInt(quantityField.getText().trim()),
                        Float.parseFloat(priceField.getText().trim()),
                        pathField.getText(),
                        detailsField.getText(), tabTitle+".txt");
            }
            frame.dispose();
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
        ItemBackground.add(pathLabel);
        ItemBackground.add(pathField);
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

    private boolean validateFields() {
        // We use Trim() method to Ignore spaces
        if (nameField.getText().isEmpty()) {
            DialogMSG.EmptyFieldError("Meal Name");
            return true;
        }
        if (priceField.getText().trim().isEmpty()) {
            DialogMSG.EmptyFieldError("Meal Price");
            return true;
        }
        if (!priceField.getText().trim().matches("\\d+(\\.\\d+)?")) {
            Logical_Class.DialogMSG.EnterValidData("Meal Price");
            return true;
        }
//        if (!priceField.getText().matches("\\d+")) { // this allow admin to enter only integer
//            Logical_Class.DialogMSG.EnterValidData("Meal Price");
//            return true;
//        }
        if (quantityField.getText().trim().isEmpty()) {
            Logical_Class.DialogMSG.EmptyFieldError("Meal Quantity");
            return true;
        }
        if (!quantityField.getText().trim().matches("\\d+")) {
            DialogMSG.EnterValidData("Meal Quantity");
            return true;
        }
        if (detailsField.getText().trim().isEmpty()) {
            DialogMSG.EmptyFieldError("Meal Details");
            return true;
        }
        return false;
    }

    public boolean isClosed() {
        return !isClosed;
    }

}