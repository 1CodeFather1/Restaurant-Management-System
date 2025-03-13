package GUI;

import Logical_Class.OrderClass;
import Shapes.PanelBackground;
import Shapes.RoundedTextField;
import javax.swing.*;
import java.awt.*;


public class MoreDetailsAboutOrder {
    Dialog frame;
    JPanel ColorBackground;
    JPanel ItemBackground;
    PanelBackground LogoBackground;

    JLabel Title = new JLabel();
    JLabel Number = new JLabel();
    JLabel variableLabel = new JLabel();
    JLabel typeLabel = new JLabel();
    JLabel priceLabel = new JLabel();
    JLabel mealsLabel = new JLabel();
    RoundedTextField nameField;
    RoundedTextField typeField;
    RoundedTextField priceField;
    RoundedTextField payField;
    JTextArea mealsField;
    JButton CloseButton = new JButton();

    Font fontLabels = new Font("Arial", Font.BOLD, 24);
    Font fontFields = new Font("Arial", Font.PLAIN, 18);

    public MoreDetailsAboutOrder(JFrame mainframe, OrderClass order) {
        nameField = new RoundedTextField(order.getOwnerOrder(), 20);
        typeField = new RoundedTextField(order.getTypeOrder(), 20);
        priceField = new RoundedTextField(order.getTotalPriceOrder() + "$  " + order.getPayMethod(), 20);
        payField = new RoundedTextField(order.getTypeOrder(), 20);
        mealsField = new JTextArea(order.getAllMeals() + "\n{Note!: " + order.getNotes() + '}');
        mealsField.setLineWrap(true); // when You Arrive end of line he moves down
        mealsField.setWrapStyleWord(true);

        /*-------frame Modifies-------*/
        frame = new Dialog(mainframe);
        frame.setSize(600, 410);
        frame.setTitle("Order Details");
        frame.setResizable(false);
        frame.setLocationRelativeTo(mainframe);

        /*-------TitleChooseOperation Modifies-------*/
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        Title.setText("- Order Details -");
        Title.setForeground(Color.WHITE);
        Title.setFont(new Font("Serif", Font.BOLD, 35));
        Title.setAlignmentX(Component.CENTER_ALIGNMENT);
        //--------------//
        Number.setText('-' + String.valueOf(order.getNumberOrder()) + '-');
        Number.setForeground(Color.WHITE);
        Number.setFont(new Font("Serif", Font.BOLD, 18));
        Number.setAlignmentX(Component.CENTER_ALIGNMENT);
        //--------------//
        titlePanel.add(Title);
        titlePanel.add(Number);

        /*-------Labels Modifies-------*/
        variableLabel.setText("Owner's Name: ");
        variableLabel.setPreferredSize(new Dimension(250, 25));
        variableLabel.setForeground(Color.WHITE);
        variableLabel.setFont(fontLabels);

        typeLabel.setText("Order's Type:");
        typeLabel.setPreferredSize(new Dimension(250, 25));
        typeLabel.setForeground(Color.WHITE);
        typeLabel.setFont(fontLabels);

        priceLabel.setText("Order's Cost:");
        priceLabel.setPreferredSize(new Dimension(250, 25));
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setFont(fontLabels);

        mealsLabel.setText("Order's Meals:");
        mealsLabel.setPreferredSize(new Dimension(250, 25));
        mealsLabel.setForeground(Color.WHITE);
        mealsLabel.setFont(fontLabels);

        /*-------Field Modifies-------*/
        nameField.setPreferredSize(new Dimension(300, 40));
        nameField.setBackground(new Color(250, 250, 250, 100));
        nameField.setOpaque(false);
        nameField.setFont(fontFields);
        nameField.setEditable(false);

        typeField.setPreferredSize(new Dimension(300, 40));
        typeField.setBackground(new Color(250, 250, 250, 100));
        typeField.setOpaque(false);
        typeField.setFont(fontFields);
        typeField.setEditable(false);

        priceField.setPreferredSize(new Dimension(300, 40));
        priceField.setBackground(new Color(250, 250, 250, 100));
        priceField.setOpaque(false);
        priceField.setFont(fontFields);
        priceField.setEditable(false);

        mealsField.setPreferredSize(new Dimension(300, 160));
        mealsField.setBackground(new Color(250, 250, 250, 150));
        mealsField.setOpaque(false);
        mealsField.setFont(fontFields);
        mealsField.setEditable(false);

        /*-------Button Modifies-------*/
        JPanel ClosePanel = new JPanel();
        ClosePanel.setOpaque(false);
        ClosePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        CloseButton.setPreferredSize(new Dimension(100, 30));
        CloseButton.setText("Close");
        CloseButton.setFont(fontLabels);
        CloseButton.setForeground(new Color(0x8d6e63));
        CloseButton.setFocusable(false);
        ClosePanel.add(CloseButton);
        CloseButton.addActionListener(_ -> frame.dispose());


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
        ItemBackground.add(variableLabel);
        ItemBackground.add(nameField);
        //--------------//
        ItemBackground.add(typeLabel);
        ItemBackground.add(typeField);
        //--------------//
        ItemBackground.add(priceLabel);
        ItemBackground.add(priceField);
        //--------------//
        ItemBackground.add(mealsLabel);
        ItemBackground.add(mealsField);
        //--------------//
        LogoBackground.add(titlePanel, BorderLayout.NORTH);
        LogoBackground.add(ItemBackground, BorderLayout.CENTER);
        LogoBackground.add(ClosePanel, BorderLayout.SOUTH);
        //--------------//
        ColorBackground.add(LogoBackground);
        frame.add(ColorBackground);
        frame.setVisible(true);

    }
}
