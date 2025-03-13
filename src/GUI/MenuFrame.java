package GUI;

import Logical_Class.AdminClass;
import Logical_Class.CustomerClass;
import Logical_Class.MealClass;
import Shapes.ArrowButton;
import Shapes.PanelBackground;

import javax.swing.*;
import java.awt.*;


public class MenuFrame {

    JFrame frame = new JFrame();

    JPanel MenuItemPanel = new JPanel();

    JPanel TypeFoodItemPanel = new JPanel();

    JPanel AppetizerPanel = new JPanel();
    JPanel MainMealPanel = new JPanel();
    JPanel DessertPanel = new JPanel();

//    JPanel ContainerPanel = new JPanel();

    JScrollPane AppetizerScrollPanel = new JScrollPane(AppetizerPanel);
    JScrollPane MainMealScrollPanel = new JScrollPane(MainMealPanel);
    JScrollPane DessertScrollPanel = new JScrollPane(DessertPanel);

    JButton AppetizerButton = new JButton();
    JLabel AppetizerText = new JLabel();

    JButton MainCoursesButton = new JButton();
    JLabel MainCoursesText1 = new JLabel();
    JLabel MainCoursesText2 = new JLabel();

    JLabel TypeFoodHandel = new JLabel();
    JLabel MenuHandel = new JLabel();

    JButton DessertButton = new JButton();
    JLabel DessertText = new JLabel();

    ArrowButton NextButton = new ArrowButton(ArrowButton.RIGHT); // =>
    JButton GoBack = new JButton();

    CardLayout cardLayout = new CardLayout();
    JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);

    CustomerClass Customer;

    public MenuFrame(CustomerClass oldCustomer) {
        /*To prepare The meals*/
        AdminClass.readMeals("Appetizers.txt");
        AdminClass.readMeals("Main Meals.txt");
        AdminClass.readMeals("Desserts.txt");
        for (MealClass x : AdminClass.AppetizerMeals) {
            AppetizerPanel.add(new MealsOnMenuFrame(x));
        }
        for (MealClass x : AdminClass.MainMealMeals) {
            MainMealPanel.add(new MealsOnMenuFrame(x));
        }
        for (MealClass x : AdminClass.DessertMeals) {

            DessertPanel.add(new MealsOnMenuFrame(x));
        }
        Customer = new CustomerClass();
        Customer.setUsername(oldCustomer.getUsername());
        /*---------------------Frame---------------------*/
        frame.setTitle("Bite Byte Restaurant");
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*---------------------Titles Modifies---------------------*/
        MenuHandel.setHorizontalAlignment(SwingConstants.CENTER);
        MenuHandel.setText("M E N U");
        MenuHandel.setFont(new Font("", Font.BOLD, 50));
        MenuHandel.setForeground(new Color(0xdaa662));
        MenuHandel.setBounds(130, 15, 300, 50);
        //--------------//
        TypeFoodHandel.setHorizontalAlignment(SwingConstants.CENTER);
        TypeFoodHandel.setFont(new Font("", Font.BOLD + Font.ITALIC, 50));
        TypeFoodHandel.setForeground(new Color(0xdaa662));
        TypeFoodHandel.setBounds(150, 10, 300, 50);
        /*--------Progress Bar Modifies--------*/
        bar.setString("Please Wait a Little...Your Order is Preparing");
        bar.setFont(new Font("Serif", Font.BOLD, 20));
        bar.setIndeterminate(true);
        bar.setStringPainted(true);
        bar.setBounds(400, 325, 425, 100);
        bar.setVisible(false);
        /*--------Next DetailsButton Modifies------------*/
        NextButton.setBackground(Color.GREEN);
        NextButton.setOpaque(false);
        NextButton.setFocusable(false);
        NextButton.setBounds(500, 15, 70, 65);
        NextButton.addActionListener(_ -> new Thread(() -> {
            try {
                frame.setEnabled(false);
                bar.setVisible(true);
                frame.repaint();
                Thread.sleep(2500);
                frame.dispose();
                SwingUtilities.invokeLater(() -> new OrderTypeFrame(Customer));
            } catch (InterruptedException _) {
            }
        }).start());
        // ------------//
        GoBack.setText("X");
        GoBack.setForeground(Color.WHITE);
        GoBack.setBackground(Color.RED);
        GoBack.setFocusable(false);
        GoBack.setBounds(20, 25, 45, 30);
        GoBack.addActionListener(_ -> {
            frame.dispose();
            SwingUtilities.invokeLater(MainFrame::new);
        });
        /*---------------------Appetizer Modifies---------------------*/
        AppetizerText.setText("Appetizer");
        AppetizerText.setForeground(Color.WHITE);
        AppetizerText.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 40));
        AppetizerText.setVerticalAlignment(JLabel.CENTER);
        AppetizerText.setBounds(20, 240, 200, 50);
        //------------//
        ImageIcon iconAppetizer = new ImageIcon("src\\Images\\Images For Buttons\\Appetizer.jpeg");
        Image imgAppetizer = iconAppetizer.getImage();
        Image scaledImgAppetizer = imgAppetizer.getScaledInstance(300, 120, Image.SCALE_SMOOTH);
        iconAppetizer = new ImageIcon(scaledImgAppetizer);
        AppetizerButton.setIcon(iconAppetizer);
        AppetizerButton.setBounds(250, 200, 300, 125);
        AppetizerButton.setBorder(BorderFactory.createLineBorder(new Color(0xdaa662), 2, true));
        AppetizerButton.addActionListener(_ -> {
            TypeFoodHandel.setText("- Appetizer -");
            MenuItemPanel.remove(MainMealScrollPanel);
            MenuItemPanel.remove(DessertScrollPanel);
            MenuItemPanel.add(AppetizerScrollPanel);
            MenuItemPanel.setVisible(true);
            frame.repaint();
        });
        /*---------------------Main Meal Modifies---------------------*/
        MainCoursesText1.setText("Main");
        MainCoursesText1.setForeground(Color.WHITE);
        MainCoursesText1.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 40));
        MainCoursesText1.setVerticalAlignment(JLabel.CENTER);
        MainCoursesText1.setBounds(20, 410, 200, 50);
        //------------//
        MainCoursesText2.setText("Meal");
        MainCoursesText2.setForeground(Color.WHITE);
        MainCoursesText2.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 40));
        MainCoursesText2.setVerticalAlignment(JLabel.CENTER);
        MainCoursesText2.setBounds(435, 410, 200, 50);
        //------------//
        ImageIcon iconMainMeal = new ImageIcon("src\\Images\\Images For Buttons\\Main Meal.jpeg");
        Image imgMainMeal = iconMainMeal.getImage();
        Image scaledImgMainMeal = imgMainMeal.getScaledInstance(300, 120, Image.SCALE_SMOOTH + Image.SCALE_AREA_AVERAGING);
        iconMainMeal = new ImageIcon(scaledImgMainMeal);
        MainCoursesButton.setIcon(iconMainMeal);
        MainCoursesButton.setBounds(125, 375, 300, 125);
        MainCoursesButton.setBorder(BorderFactory.createLineBorder(new Color(0xdaa662), 2, true));
        MainCoursesButton.addActionListener(_ -> {
            TypeFoodHandel.setText("- Entree -");
            MenuItemPanel.remove(AppetizerScrollPanel);
            MenuItemPanel.remove(DessertScrollPanel);
            MenuItemPanel.add(MainMealScrollPanel);
            MenuItemPanel.setVisible(true);
            frame.repaint();
        });
        /*---------------------Dessert Modifies---------------------*/
        DessertText.setText("Dessert");
        DessertText.setForeground(Color.WHITE);
        DessertText.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 40));
        DessertText.setVerticalAlignment(JLabel.CENTER);
        DessertText.setBounds(345, 590, 200, 50);
        //------------//
        ImageIcon iconDessert = new ImageIcon("src\\Images\\Images For Buttons\\Dessert.jpeg");
        Image imgDessert = iconDessert.getImage();
        Image scaledImgDessert = imgDessert.getScaledInstance(300, 121, Image.SCALE_SMOOTH);
        iconDessert = new ImageIcon(scaledImgDessert);
        DessertButton.setIcon(iconDessert);
        DessertButton.setBounds(20, 550, 300, 125);
        DessertButton.setBorder(BorderFactory.createLineBorder(new Color(0xdaa662), 2, true));
        DessertButton.addActionListener(_ -> {
            TypeFoodHandel.setText("- Dessert -");
            MenuItemPanel.remove(AppetizerScrollPanel);
            MenuItemPanel.remove(MainMealScrollPanel);
            MenuItemPanel.add(DessertScrollPanel);
            MenuItemPanel.setVisible(true);
            frame.repaint();
        });
        /*---------------------Panel Modifies---------------------*/
        //--------------//
        TypeFoodItemPanel.setBackground(new Color(0, 0, 0, 150));
        TypeFoodItemPanel.setBounds(10, 15, 570, 740);
        TypeFoodItemPanel.setLayout(null);
        /*-------------Menu Panels--------------*/
        //--------------//
        MenuItemPanel.setBounds(590, 15, 585, 740);
        MenuItemPanel.setLayout(null);
        MenuItemPanel.setBackground(new Color(0, 0, 0, 140));
        MenuItemPanel.setOpaque(true);
        MenuItemPanel.setVisible(false);
        /*------------- Scrolled Panels--------------*/
        AppetizerPanel.setLayout(new GridLayout(0, 2, 10, 10));
        AppetizerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        AppetizerPanel.setBackground(new Color(0, 0, 0, 150));
        AppetizerPanel.setOpaque(true);
        //--------------//
        MainMealPanel.setLayout(new GridLayout(0, 2, 10, 10));
        MainMealPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        MainMealPanel.setBackground(new Color(0, 0, 0, 150));
        MainMealPanel.setOpaque(true);
        //--------------//
        DessertPanel.setLayout(new GridLayout(0, 2, 10, 10));
        DessertPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        DessertPanel.setBackground(new Color(0, 0, 0, 150));
        DessertPanel.setOpaque(true);
        //--------------//
        AppetizerScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        AppetizerScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        AppetizerScrollPanel.setBounds(15, 150, 560, 570);
        AppetizerScrollPanel.setBackground(new Color(0, 0, 0, 0));
        AppetizerScrollPanel.getViewport().setOpaque(false);
        JScrollBar AppetizerVerticalBar = AppetizerScrollPanel.getVerticalScrollBar();
        AppetizerVerticalBar.addAdjustmentListener(e -> {  /*To Solve Shadow Problem When Scrolled*/
            if (!e.getValueIsAdjusting()) {
                frame.revalidate();
                frame.repaint();
            }
        });
        //--------------//
        MainMealScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        MainMealScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        MainMealScrollPanel.setBounds(15, 150, 560, 570);
        MainMealScrollPanel.setBackground(new Color(0, 0, 0, 0));
        MainMealScrollPanel.getViewport().setOpaque(false);
        JScrollBar MainMealVerticalBar = MainMealScrollPanel.getVerticalScrollBar();
        MainMealVerticalBar.addAdjustmentListener(e -> {  /*To Solve Shadow Problem When Scrolled*/
            if (!e.getValueIsAdjusting()) {
                frame.revalidate();
                frame.repaint();
            }
        });
        //--------------//
        DessertScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        DessertScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        DessertScrollPanel.setBounds(15, 150, 560, 570);
        DessertScrollPanel.setBackground(new Color(0, 0, 0, 0));
        DessertScrollPanel.getViewport().setOpaque(false);
        JScrollBar DessertVerticalBar = DessertScrollPanel.getVerticalScrollBar();
        DessertVerticalBar.addAdjustmentListener(e -> {  /*To Solve Shadow Problem When Scrolled*/
            if (!e.getValueIsAdjusting()) {
                frame.revalidate();
                frame.repaint();
            }
        });
        //--------------//
        /*-------------Background Panels--------------*/
        PanelBackground MainBackground = new PanelBackground("src\\Images\\Backgrounds\\Menu Background.jpg");
        MainBackground.setLayout(null);

        /*---------------------Adding Components---------------------*/
        TypeFoodItemPanel.add(MenuHandel);
        TypeFoodItemPanel.add(AppetizerText);
        TypeFoodItemPanel.add(MainCoursesText1);
        TypeFoodItemPanel.add(MainCoursesText2);
        TypeFoodItemPanel.add(DessertText);
        TypeFoodItemPanel.add(AppetizerButton);
        TypeFoodItemPanel.add(MainCoursesButton);
        TypeFoodItemPanel.add(DessertButton);
        //------------//
        MenuItemPanel.add(TypeFoodHandel);
        //------------//
        MainBackground.add(NextButton);
        MainBackground.add(GoBack);
        MainBackground.add(bar);
        MainBackground.add(MenuItemPanel);
        MainBackground.add(TypeFoodItemPanel);
        //------------//
        frame.add(MainBackground);
        frame.setVisible(true);
    }

    /* ****************************************************** */
    public class MealsOnMenuFrame extends JPanel {
        String name;
        float price;
        String image;
        String description;
        int totalQuantity;
        JCheckBox CButton = new JCheckBox();
        JButton DetailsButton = new JButton();
        JLabel NameLabel = new JLabel();
        JLabel PriceLabel = new JLabel();
        JPanel InfoPanel = new JPanel();

        public MealsOnMenuFrame(MealClass mealClass) {
            this.name = mealClass.getNameMeal();
            this.price = mealClass.getPriceMeal();
            this.image = mealClass.getImageMeal();
            this.description = mealClass.getDescriptionMeal();
            this.totalQuantity = mealClass.getTotalQuantityMeal();
            this.setLayout(new BorderLayout());

            /*-------------Details Button--------------*/
            ImageIcon imageIcon = new ImageIcon(mealClass.getImageMeal());
            Image imgButton = imageIcon.getImage();
            Image scaledImgDetails = imgButton.getScaledInstance(275, 200, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImgDetails);
            DetailsButton.setIcon(imageIcon);
            DetailsButton.setPreferredSize(new Dimension(205, 175));
            DetailsButton.setFocusPainted(true);
            DetailsButton.setContentAreaFilled(false);
            DetailsButton.addActionListener(_ -> SwingUtilities.invokeLater(() -> new InfoMealFrame(frame, MealsOnMenuFrame.this, Customer, "Details")));
            /*-------------Check Box Button--------------*/
            CButton.addActionListener(_ -> {
                if (CButton.isSelected()) {
                    SwingUtilities.invokeLater(() -> new InfoMealFrame(frame, MealsOnMenuFrame.this, Customer, "CheckBox"));
                } else {
                    if (!Customer.orderCustomer.Meals.isEmpty()) {
                        Customer.orderCustomer.Meals.removeIf(x -> x.getNameMeal().equals(name));
                    }
                }
            });
            /*-------------Name & Price--------------*/
            NameLabel.setForeground(Color.WHITE);
            NameLabel.setFont(new Font("Arial", Font.BOLD, 14));
            NameLabel.setText(name);
            PriceLabel.setForeground(Color.WHITE);
            PriceLabel.setText(String.valueOf(price) + '$');
            PriceLabel.setFont(new Font("Arial", Font.BOLD, 14));

            /*-----Their Panel------*/
            InfoPanel.setLayout(new BorderLayout());
            InfoPanel.setPreferredSize(new Dimension(100, 33));
            InfoPanel.setBackground(new Color(0xdaa662));
            InfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 5));

            /*-------------Add Component--------------*/
            InfoPanel.add(CButton, BorderLayout.WEST);
            InfoPanel.add(PriceLabel, BorderLayout.EAST);
            InfoPanel.add(NameLabel, BorderLayout.CENTER);
            this.add(InfoPanel, BorderLayout.SOUTH);
            this.add(DetailsButton, BorderLayout.NORTH);
        }
    }
}
