package GUI;

import Logical_Class.CustomerClass;
import Logical_Class.MealClass;
import Logical_Class.OrderClass;
import Shapes.PanelBackground;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BillFrame {
    JFrame frame = new JFrame();
    JLabel TitleLabel = new JLabel();
    JLabel ThankLabel = new JLabel();
    //--------------//
    JPanel MainBackground = new JPanel();
    JPanel ItemsPanel = new JPanel();
    PanelBackground ImageBackground;
    JScrollPane ScrollPanel;
    //--------------//

    //-------Bill Details Panel-------//
    JPanel TopPanel = new JPanel();
    JLabel setNumber = new JLabel();
    JLabel setName = new JLabel();
    JLabel getName = new JLabel();
    JLabel setType = new JLabel();
    JLabel getType = new JLabel();
    JLabel setDate = new JLabel();
    //---------------End---------------//

    //-------Pay Details Panel-------//
    JPanel BottomPanel = new JPanel();
    JLabel setPrice = new JLabel();
    JLabel getPrice = new JLabel();
    JLabel setTip = new JLabel();
    JLabel getTip = new JLabel();
    JLabel setTax = new JLabel();
    JLabel getTax = new JLabel();
    JLabel setTotalCost = new JLabel();
    JLabel getTotalCost = new JLabel();
    //---------------End---------------//

    Font fontSet = new Font("Serif", Font.BOLD, 20);
    Font fontGet = new Font("", Font.BOLD, 18);

    public BillFrame(OrderClass order) throws InterruptedException {
        /*-------Frame-------*/
        frame.setTitle("Restaurant Bill");
        frame.setSize(600, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*-------Title-------*/
        TitleLabel.setText("Bite Byte Restaurant");
        TitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        TitleLabel.setForeground(new Color(0xdaa662));
        TitleLabel.setFont(new Font("Serif", Font.BOLD, 40));
        /*-------Thank-------*/
        ThankLabel.setText("-Thank you-");
        ThankLabel.setForeground(Color.WHITE);
        ThankLabel.setFont(new Font("Serif", Font.BOLD, 20));
        ThankLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ThankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ThankLabel.setVerticalAlignment(SwingConstants.CENTER);
        ThankLabel.setPreferredSize(new Dimension(0, 28));
        ThankLabel.setVisible(false);
        /*-------Information-------*/
        setNumber.setText('-' + String.valueOf(order.getNumberOrder()) + '-');
        setNumber.setForeground(new Color(0xdaa662));
        setNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
        setNumber.setFont(fontSet);
        setNumber.setVisible(false);
        //--------------//
        setName.setText("Customer: ");
        setName.setForeground(new Color(0xdaa662));
        setName.setFont(fontSet);
        setName.setBounds(10, 5, 200, 25);
        //--------------//
        getName.setText(order.getOwnerOrder());
        getName.setForeground(Color.WHITE);
        getName.setFont(fontGet);
        getName.setBounds(105, 5, 500, 25);
        getName.setVisible(false);
        //--------------//
        setType.setText("Type: ");
        setType.setForeground(new Color(0xdaa662));
        setType.setFont(fontSet);
        setType.setBounds(10, 30, 200, 25);
        //--------------//
        getType.setForeground(Color.WHITE);
        getType.setText(order.getTypeOrder());
        getType.setFont(fontGet);
        getType.setBounds(65, 30, 300, 25);
        getType.setVisible(false);
        //--------------//
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        setDate.setText(formatter.format(today));
        setDate.setForeground(new Color(0xdaa662));
        setDate.setFont(fontSet);
        setDate.setBounds(445, 30, 100, 25);
        setDate.setVisible(false);
        //--------------//
        TopPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        TopPanel.setMaximumSize(new Dimension(550, 60));
        TopPanel.setLayout(null);
        TopPanel.add(setName);
        TopPanel.add(getName);
        TopPanel.add(setType);
        TopPanel.add(getType);
        TopPanel.add(setDate);
        TopPanel.setOpaque(false);

        /*-------Pay Details-------*/
        BottomPanel.setLayout(new GridLayout(0, 2, 6, 6));
        BottomPanel.setOpaque(false);
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Thanks for visiting, have a nice day!");
        titledBorder.setTitleColor(Color.WHITE);
        BottomPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(titledBorder)
                , BorderFactory.createEmptyBorder(2, 10, 2, 10)));
        BottomPanel.setPreferredSize(new Dimension(545, 125));
        BottomPanel.setMaximumSize(new Dimension(545, 125));
        //--------------//
        setPrice.setText("Order Price:");
        setPrice.setForeground(new Color(0xdaa662));
        setPrice.setHorizontalAlignment(JLabel.LEFT);
        setPrice.setFont(fontSet);
        //--------------//
        getPrice.setText(String.format(" %.2f $", order.getTotalPriceOrder()));
        getPrice.setForeground(Color.WHITE);
        getPrice.setFont(fontGet);
        getPrice.setHorizontalAlignment(JLabel.RIGHT);
        getPrice.setVisible(false);
        //--------------//
        setTip.setText("Order Tips:");
        setTip.setForeground(new Color(0xdaa662));
        setTip.setFont(fontSet);
        setTip.setHorizontalAlignment(JLabel.LEFT);
        //--------------//
        getTip.setText(String.format(" %.2f $", order.getTipOrder()));
        getTip.setForeground(Color.WHITE);
        getTip.setFont(fontGet);
        getTip.setHorizontalAlignment(JLabel.RIGHT);
        getTip.setVisible(false);
        //--------------//
        if (order.getTypeOrder().equalsIgnoreCase("Delivery")) {
            setTax.setText("Delivery Fees:");
            frame.repaint();
        } else {
            setTax.setText("Table Fees:");
            frame.repaint();
        }
        setTax.setForeground(new Color(0xdaa662));
        setTax.setHorizontalAlignment(JLabel.LEFT);
        setTax.setFont(fontSet);
        //--------------//
        double taxAmount = 5 + (Math.random() * (25 - 5));
        getTax.setText(String.format("%.2f $", taxAmount));
        getTax.setAlignmentX(Component.RIGHT_ALIGNMENT);
        getTax.setHorizontalAlignment(JLabel.RIGHT);
        getTax.setForeground(Color.WHITE);
        getTax.setFont(fontGet);
        getTax.setVisible(false);
        //--------------//
        setTotalCost.setText("Total Cost:");
        setTotalCost.setForeground(new Color(0xdaa662));
        setTotalCost.setFont(fontSet);
        setTotalCost.setHorizontalAlignment(JLabel.LEFT);
        //--------------//
        getTotalCost.setText(String.format("%.2f $",(order.getTotalPriceOrder() + order.getTipOrder() + taxAmount)));
        getTotalCost.setForeground(Color.WHITE);
        getTotalCost.setFont(fontGet);
        getTotalCost.setHorizontalAlignment(JLabel.RIGHT);
        getTotalCost.setVisible(false);
        //--------------//
        BottomPanel.add(setPrice);
        BottomPanel.add(getPrice);
        BottomPanel.add(setTip);
        BottomPanel.add(getTip);
        BottomPanel.add(setTax);
        BottomPanel.add(getTax);
        BottomPanel.add(setTotalCost);
        BottomPanel.add(getTotalCost);

        /*-------Panel Modifies-------*/
        MainBackground.setBackground(new Color(0, 0, 0, 140));
        MainBackground.setLayout(new BoxLayout(MainBackground, BoxLayout.Y_AXIS));
        MainBackground.setBackground(new Color(0, 0, 0, 140));
        //--------------//
        if (order.Meals.size() <= 10) {
            /* When We Use FlowLayout The Scroll Bar doesn't Show up
             * So We Have To Make Sure That The Number Of Meal Is 10 or Less
             * Also the First Meal 's Position it's incorrect .
             * if it's More Thant 10 We Use GridLayout But The Problem it's Start Adding from Center */
            ItemsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            ItemsPanel.setPreferredSize(new Dimension(550, order.Meals.size() * 40));
        } else {
            ItemsPanel.setLayout(new GridLayout(0, 1, 5, 5));
            ItemsPanel.setPreferredSize(new Dimension(550, order.Meals.size() * 40));
        }
        ItemsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 8, 10));
        ItemsPanel.setBackground(new Color(0, 0, 0, 140));

        ScrollPanel = new JScrollPane(ItemsPanel);
        ScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPanel.setBackground(new Color(0, 0, 0, 0));
        ScrollPanel.getViewport().setOpaque(false);
        ScrollPanel.setPreferredSize(new Dimension(550, 440));
        ScrollPanel.setMaximumSize(new Dimension(550, 440));
        JScrollBar verticalBar = ScrollPanel.getVerticalScrollBar();
        verticalBar.addAdjustmentListener(e -> {  /*To Solve Shadow Problem When Scrolled*/
            if (!e.getValueIsAdjusting()) {
                ItemsPanel.revalidate();
                ItemsPanel.repaint();
                frame.revalidate();
                frame.repaint();
            }
        });
        //--------------//
        ImageBackground = new PanelBackground("src\\Images\\Backgrounds\\Background-2-.jpg");
        ImageBackground.setLayout(new GridLayout());
        ImageBackground.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        new Thread(() -> {
            try {
                Thread.sleep(1500);
                SwingUtilities.invokeLater(() -> {
                    setNumber.setVisible(true);
                    frame.repaint();
                });
                Thread.sleep(1000);
                SwingUtilities.invokeLater(() -> {
                    getName.setVisible(true);
                    frame.repaint();
                });
                Thread.sleep(1500);
                SwingUtilities.invokeLater(() -> {
                    getType.setVisible(true);
                    frame.repaint();
                });
                Thread.sleep(1500);
                SwingUtilities.invokeLater(() -> {
                    setDate.setVisible(true);
                    frame.repaint();
                });
                Thread.sleep(500);
                for (int i = 0; i < order.Meals.size(); i++) {
                    Thread.sleep(1300);
                    int count = i;
                    SwingUtilities.invokeLater(() -> {
                        BillMealPanel mealPanel = new BillMealPanel(order.Meals.get(count));
                        ItemsPanel.add(mealPanel);
                        ItemsPanel.revalidate();
                        ItemsPanel.repaint();
                        frame.revalidate();
                        frame.repaint();
                    });
                    Thread.sleep(1000);
                }
                Thread.sleep(2000);

                SwingUtilities.invokeLater(() -> {
                    getPrice.setVisible(true);
                    frame.repaint();
                });
                Thread.sleep(2000);

                SwingUtilities.invokeLater(() -> {
                    getTip.setVisible(true);
                    frame.repaint();
                });

                Thread.sleep(2000);

                SwingUtilities.invokeLater(() -> {
                    getTax.setVisible(true);
                    frame.repaint();
                });

                Thread.sleep(2000);

                SwingUtilities.invokeLater(() -> {
                    getTotalCost.setVisible(true);
                    frame.repaint();
                });
                Thread.sleep(2500);

                SwingUtilities.invokeLater(() -> {
                    ThankLabel.setVisible(true);
                    frame.repaint();
                });
                Thread.sleep(2500);
                Logical_Class.DialogMSG.OrderAgain(frame,new CustomerClass(order.getOwnerOrder()));
                Thread.sleep(2500);
            } catch (InterruptedException _) {
            }
        }).start();
        //--------------//
        MainBackground.add(TitleLabel);
        MainBackground.add(setNumber);
        MainBackground.add(TopPanel);
        MainBackground.add(Box.createVerticalStrut(5));
        MainBackground.add(ScrollPanel);
        MainBackground.add(Box.createVerticalStrut(5));
        MainBackground.add(BottomPanel);
        MainBackground.add(ThankLabel);
        MainBackground.add(Box.createVerticalStrut(2));
        //--------------//
        ImageBackground.add(MainBackground);
        //--------------//
        frame.add(ImageBackground);
        frame.setVisible(true);
    }

    public class BillMealPanel extends JPanel {
        JLabel MealName = new JLabel();
        JLabel MealPrice = new JLabel();

        public BillMealPanel(MealClass Meal) {
            this.setBackground(new Color(0, 0, 0, 0));
            this.setLayout(new BorderLayout());
            this.setPreferredSize(new Dimension(530, 30));
            this.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 12));


            MealName.setFont(new Font("Serif", Font.BOLD, 24));
            MealName.setForeground(Color.LIGHT_GRAY);
            MealName.setHorizontalAlignment(JLabel.LEFT);

            MealPrice.setText("");
            MealPrice.setFont(new Font("Serif", Font.BOLD, 24));
            MealPrice.setForeground(Color.LIGHT_GRAY);
            MealPrice.setHorizontalAlignment(JLabel.RIGHT);

            SwingUtilities.invokeLater(() ->
                    this.MealName.setText("- " + Meal.getNameMeal() + "   × " + Meal.getCurrQuantityMeal()));
            this.add(MealName, BorderLayout.WEST);
            this.add(MealPrice, BorderLayout.EAST);

            Timer timer = new Timer(1200, _ -> {
                this.MealPrice.setText(String.format("%.2f", Meal.getPriceMeal() * Meal.getCurrQuantityMeal()) + '$');
                frame.repaint();
                frame.revalidate();
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
}