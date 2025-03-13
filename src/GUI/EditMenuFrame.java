package GUI;

import Logical_Class.DialogMSG;
import Logical_Class.AdminClass;
import Logical_Class.MealClass;
import Shapes.PanelBackground;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditMenuFrame {

    JFrame frame = new JFrame();

    JPanel InformationPanel = new JPanel();

    JPanel AppetizerPanel = new JPanel();
    JScrollPane AppetizerScroll = new JScrollPane(AppetizerPanel);
    JPanel MainMealPanel = new JPanel();
    JScrollPane MainMealScroll = new JScrollPane(MainMealPanel);
    JPanel DessertPanel = new JPanel();
    JScrollPane DessertScroll = new JScrollPane(DessertPanel);

    JPanel MealDetailsPanel = new JPanel();

    PanelBackground MainBackground;

    JLabel Details = new JLabel();
    JPopupMenu popupMenu;
    JTabbedPane tabbedPane = new JTabbedPane();

    /***************************************/
    JLabel MealNameLabel = new JLabel();
    JLabel getName = new JLabel();

    JLabel MealPriceLabel = new JLabel();
    JLabel getPrice = new JLabel();

    JLabel MealQuantityLabel = new JLabel();
    JLabel getQuantity = new JLabel();
    JLabel MealDetailsLabel = new JLabel();
    JTextArea getDetails = new JTextArea();

    Font minefont = new Font("Arial", Font.BOLD, 24);
    Font secfont = new Font("Arial", Font.BOLD + Font.ITALIC, 20);

    public EditMenuFrame(AdminClass Admin) {

        //********************************************************//
        AdminClass.readMeals("Appetizers.txt");
        AdminClass.readMeals("Main Meals.txt");
        AdminClass.readMeals("Desserts.txt");
        for (MealClass x : AdminClass.AppetizerMeals) {
            addCookingButton(AppetizerPanel, x);
        }
        for (MealClass x : AdminClass.MainMealMeals) {
            addCookingButton(MainMealPanel, x);
        }
        for (MealClass x : AdminClass.DessertMeals) {
            addCookingButton(DessertPanel, x);
        }
        //********************************************************//        frame.setTitle("Bite Byte Restaurant");
        frame.setSize(1200, 800);
        frame.setTitle("Edit Menu");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*-------Popup Menu Modifiers-------*/
        popupMenu = new JPopupMenu();
        JMenuItem EditMeal = new JMenuItem("Edit");
        JMenuItem AddMeal = new JMenuItem("Add");
        JMenuItem DeleteMeal = new JMenuItem("Delete");
        popupMenu.add(EditMeal);
        popupMenu.addSeparator();
        popupMenu.add(AddMeal);
        popupMenu.addSeparator();
        popupMenu.add(DeleteMeal);
        //--------------//
        tabbedPane.addChangeListener(_ -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            String tabTitle = tabbedPane.getTitleAt(selectedIndex);
            String path, array;
            if (tabTitle.equals("Appetizers")) {
                path = "Appetizers.txt";
                array = "Appetizers";
            } else if (tabTitle.equals("Main Meals")) {
                path = "Main Meals.txt";
                array = "Main Meals";
            } else {
                path = "Desserts.txt";
                array = "Desserts";
            }

            AddMeal.addActionListener(_ -> {
                Component invoker = popupMenu.getInvoker();
                Container parent = invoker.getParent();
                AddEdit_Meal AddFrame = new AddEdit_Meal(frame, array);
                if (AddFrame.isClosed()) { // if the user click on (close button) we will not do anything
                    refreshMealPanel(array, path, parent);
                }
            });
            EditMeal.addActionListener(_ -> {
                Component invoker = popupMenu.getInvoker();
                Container parent = invoker.getParent();
                if (invoker instanceof ButtonForMeals_EditFrame) {

                    AddEdit_Meal EditFrame = new AddEdit_Meal(frame, ((ButtonForMeals_EditFrame) invoker).currMeal, array);
                    if (EditFrame.isClosed()) {// if the user click on close button we will not do anything
                        refreshMealPanel(array, path, parent);
                    }
                }
            });
            DeleteMeal.addActionListener(_ -> {
                Component invoker = popupMenu.getInvoker();
                Container parent = invoker.getParent();
                if (invoker instanceof ButtonForMeals_EditFrame) {
                    String MealName = String.valueOf(((ButtonForMeals_EditFrame) invoker).currMeal.getNameMeal());
                    if (DialogMSG.ConfirmDeletion(MealName)) {
                        AdminClass.removeMealFromFile(MealName, path);
                        DialogMSG.DeletionSuccess(MealName);
                        refreshMealPanel(array, path, parent);
                    }
                }
            });
        });

        /*-------Information Modifiers-------*/
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Details.setText("<html><body style='width: 300px; line-height: 10;'>" + "Admin: " + Admin.getUsername() + "<br>" + formatter.format(today)    // Because You print Label Not String :)
                + "</body></html>");
        Details.setFont(new Font("Arial", Font.BOLD, 20));
        Details.setForeground(Color.WHITE);

        ImageIcon imageIcon = new ImageIcon("src\\Images\\Backgrounds\\OriRestaurant Logo.png");
        Image image = imageIcon.getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel RestaurantLogo = new JLabel(scaledIcon);

        /*-------Backgrounds Panel-------*/
        InformationPanel.setLayout(new BorderLayout(10, 10));
        InformationPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        InformationPanel.setOpaque(true);
        InformationPanel.setBackground(new Color(0, 0, 0, 150));
        InformationPanel.setBounds(10, 15, 330, 738);
        //--------------//
        AppetizerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        AppetizerScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        AppetizerPanel.setLayout(new GridLayout(0, 3, 10, 10));
        AppetizerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        AppetizerPanel.setOpaque(true);
        AppetizerPanel.setBackground(new Color(0, 0, 0, 150));
        //--------------//
        MainMealPanel.setLayout(new GridLayout(0, 3, 10, 10));
        MainMealPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        MainMealPanel.setOpaque(true);
        MainMealPanel.setBackground(new Color(0, 0, 0, 150));

        MainMealScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        MainMealScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //--------------//
        DessertPanel.setLayout(new GridLayout(0, 3, 10, 10));
        DessertPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        DessertPanel.setOpaque(true);
        DessertPanel.setBackground(new Color(0, 0, 0, 150));

        DessertScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        DessertScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //--------------//
        tabbedPane.setBounds(350, 0, 825, 750);
        tabbedPane.setOpaque(false);
        //--------------//
        MainBackground = new PanelBackground("src\\Images\\Backgrounds\\Edit Menu Background.jpg");
        MainBackground.setLayout(null);
        /*-------MealDetailsPanel-------*/
        MealDetailsPanel.setOpaque(false);
        MealDetailsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 15));
        MealDetailsPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createBevelBorder(BevelBorder.RAISED),
                new EmptyBorder(4, 4, 4, 4)
        ));
        MealNameLabel.setText("Meal's Name:");
        MealNameLabel.setFont(minefont);
        MealNameLabel.setForeground(new Color(0x8d6e63));
        MealNameLabel.setPreferredSize(new Dimension(250, 20));

        getName.setFont(secfont);
        getName.setPreferredSize(new Dimension(250, 30));
        getName.setForeground(Color.white);

        MealPriceLabel.setText("Meal's Price:");
        MealPriceLabel.setFont(minefont);
        MealPriceLabel.setForeground(new Color(0x8d6e63));
        MealPriceLabel.setPreferredSize(new Dimension(250, 20));


        getPrice.setFont(secfont);
        getPrice.setForeground(Color.white);
        getPrice.setPreferredSize(new Dimension(250, 30));

        MealQuantityLabel.setText("Meal's Quantity:");
        MealQuantityLabel.setFont(minefont);
        MealQuantityLabel.setForeground(new Color(0x8d6e63));
        MealQuantityLabel.setPreferredSize(new Dimension(250, 20));

        getQuantity.setFont(secfont);
        getQuantity.setForeground(Color.white);
        getQuantity.setPreferredSize(new Dimension(250, 30));

        MealDetailsLabel.setText("Meal's Details:");
        MealDetailsLabel.setFont(minefont);
        MealDetailsLabel.setForeground(new Color(0x8d6e63));
        MealDetailsLabel.setPreferredSize(new Dimension(250, 20));

        getDetails.setFont(secfont);
        getDetails.setLineWrap(true);
        getDetails.setWrapStyleWord(true);
        getDetails.setOpaque(true);
        getDetails.setBackground(new Color(0, 0, 0, 100));
        getDetails.setEditable(false);
        getDetails.setForeground(Color.white);
        getDetails.setPreferredSize(new Dimension(285, 150));
        getDetails.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.repaint();
            }
        });
        getDetails.addCaretListener(_ -> frame.repaint());

        MealDetailsPanel.add(MealNameLabel);
        MealDetailsPanel.add(getName);
        MealDetailsPanel.add(MealPriceLabel);
        MealDetailsPanel.add(getPrice);
        MealDetailsPanel.add(MealQuantityLabel);
        MealDetailsPanel.add(getQuantity);
        MealDetailsPanel.add(MealDetailsLabel);
        MealDetailsPanel.add(getDetails);
        MealDetailsPanel.setVisible(true);


        /*-------Adding Components-------*/
        InformationPanel.add(RestaurantLogo, BorderLayout.NORTH);
        InformationPanel.add(MealDetailsPanel, BorderLayout.CENTER);
        InformationPanel.add(Details, BorderLayout.SOUTH);
        //--------------//
        tabbedPane.addTab("Appetizers", AppetizerScroll);
        tabbedPane.addTab("Main Meals", MainMealScroll);
        tabbedPane.addTab("Desserts", DessertScroll);
        //--------------//
        MainBackground.add(InformationPanel);
        MainBackground.add(tabbedPane);
        //--------------//
        frame.add(MainBackground);
        frame.setVisible(true);
    }

    /* *****This Panel is every meal inside the tapped panels******* */
    public class ButtonForMeals_EditFrame extends JPanel {
        JButton DetailsButton = new JButton();
        JLabel NameLabel = new JLabel();
        JLabel PriceLabel = new JLabel();
        JPanel InfoPanel = new JPanel();
        MealClass currMeal;

        public ButtonForMeals_EditFrame(MealClass meal) {
            currMeal = meal;
            this.setLayout(new BorderLayout());
            this.setPreferredSize(new Dimension(250, 160));
            this.setMaximumSize(new Dimension(250, 160));

            /*---------Details Button----------*/
            ImageIcon imageIcon = new ImageIcon(currMeal.getImageMeal());
            Image imgButton = imageIcon.getImage();
            Image scaledImgDetails = imgButton.getScaledInstance(250, 130, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImgDetails);
            DetailsButton.setIcon(imageIcon);
            DetailsButton.setContentAreaFilled(false);   // for solving image on info panel
            DetailsButton.setPreferredSize(new Dimension(100, 100));
            DetailsButton.setMaximumSize(new Dimension(100, 100));
            DetailsButton.addActionListener(_ -> {
                getName.setText(currMeal.getNameMeal());
                getPrice.setText(String.valueOf(currMeal.getPriceMeal()) + '$');
                getDetails.setText(currMeal.getDescriptionMeal());
                getQuantity.setText(currMeal.getTotalQuantityMeal() + " Pieces");
                frame.repaint();
            });

            /*---------Name & Price----------*/
            InfoPanel.setLayout(new BorderLayout());
            InfoPanel.setPreferredSize(new Dimension(100, 31));
            InfoPanel.setBackground(new Color(0xdaa662));
            InfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

            NameLabel.setForeground(Color.WHITE);
            NameLabel.setFont(new Font("Arial", Font.BOLD, 15));
            NameLabel.setText(currMeal.getNameMeal());

            PriceLabel.setForeground(Color.WHITE);
            PriceLabel.setText(String.valueOf(currMeal.getPriceMeal()) + '$');
            PriceLabel.setFont(new Font("Arial", Font.BOLD, 15));

            /*-------------Add Component--------------*/
            InfoPanel.add(PriceLabel, BorderLayout.EAST);
            InfoPanel.add(NameLabel, BorderLayout.CENTER);
            this.add(InfoPanel, BorderLayout.SOUTH);
            this.add(DetailsButton, BorderLayout.CENTER);
        }
    }

    // to Read From The Array And Passing data in ButtonForMeals_EditFrame To Show It
    public void addCookingButton(JPanel panel, MealClass mealClass) {
        ButtonForMeals_EditFrame newMeal = new ButtonForMeals_EditFrame(mealClass);
        newMeal.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopupMenu(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopupMenu(e);
            }

            private void showPopupMenu(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(newMeal, e.getX(), e.getY());
                    popupMenu.setInvoker(newMeal);
                }
            }
        });
        panel.add(newMeal);
        panel.revalidate();
        panel.repaint();
    }

    // to Refresh the Meals onn the panel after any operation(Add, Edit, delete)
    private void refreshMealPanel(String array, String path, Container parent) {
        if (array.equals("Appetizers")) {
            AdminClass.AppetizerMeals.clear();
            parent.removeAll();
            AdminClass.readMeals(path);
            for (MealClass x : AdminClass.AppetizerMeals) {
                addCookingButton(AppetizerPanel, x);
            }
        } else if (array.equals("Main Meals")) {
            AdminClass.MainMealMeals.clear();
            parent.removeAll();
            AdminClass.readMeals(path);
            for (MealClass x : AdminClass.MainMealMeals) {
                addCookingButton(MainMealPanel, x);
            }
        } else {
            AdminClass.DessertMeals.clear();
            parent.removeAll();
            AdminClass.readMeals(path);
            for (MealClass x : AdminClass.DessertMeals) {
                addCookingButton(DessertPanel, x);
            }
        }
        parent.revalidate();
        parent.repaint();
        frame.revalidate();
//        frame.repaint();
    }

}
