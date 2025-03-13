package GUI;

import Logical_Class.AdminClass;
import Logical_Class.DialogMSG;
import Logical_Class.OrderClass;
import Shapes.PanelBackground;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ArchiveRestaurantFrame {
    JFrame frame = new JFrame();
    // The Components For Choose Operation (Left Panel)//
    JLabel TitleChooseOperation = new JLabel();
    JButton GoBack = new JButton();
    JPanel ButtonsPanel = new JPanel();
    JPanel ItemsControlsPanel = new JPanel();
    JButton ShowOrderButton = new JButton();
    JButton EditMenuButton = new JButton();
    JButton ShowFundsButton = new JButton();
    // -------------------END------------------- //

    // The Components For Show Details (Right Panel)//
    JLabel TitleShowOperation = new JLabel();
    JPanel OriginShowOperationPanel = new JPanel();
    JPanel ContainerPanel = new JPanel();
    JPanel OrdersPanel = new JPanel();
    JPanel FundsPanel = new JPanel();
    JScrollPane ScrollPanel = new JScrollPane(ContainerPanel);
    CardLayout cardLayout = new CardLayout();
    // -----------More Details----------- //
    JPanel MoreDetails = new JPanel();
    JLabel CashCustomer = new JLabel();
    JLabel getCashCustomer = new JLabel();
    JLabel OrderMeal = new JLabel();
    JLabel getOrderMeal = new JLabel();

    // -------------------END------------------- //
    JPanel BackgroundPanel;
    Font fontLabel = new Font("Arial", Font.BOLD, 20);
    Font fontData = new Font("Arial", Font.PLAIN, 18);

    public ArchiveRestaurantFrame(AdminClass Admin) {
        /*-----------Frame-----------*/
        frame.setTitle("Bite Byte Restaurant");
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*-----------Titles-----------*/
        JPanel TitleButtonOperation = new JPanel();
        TitleButtonOperation.setMaximumSize(new Dimension(595, 40));
        TitleButtonOperation.setLayout(new BoxLayout(TitleButtonOperation, BoxLayout.X_AXIS));
        TitleButtonOperation.setOpaque(false);

        TitleButtonOperation.add(GoBack);
        TitleButtonOperation.add(Box.createHorizontalStrut(40));
        TitleButtonOperation.add(TitleChooseOperation);

        TitleChooseOperation.setText("Please Choose Operation");
        TitleChooseOperation.setHorizontalAlignment(JLabel.CENTER);
        TitleChooseOperation.setAlignmentX(Component.CENTER_ALIGNMENT);
        TitleChooseOperation.setFont(new Font("Arial", Font.BOLD, 33));
        TitleChooseOperation.setForeground(new Color(0xc47208));
        //--------------//
        TitleShowOperation.setText("-Bite Byte Archive-");
        TitleShowOperation.setHorizontalAlignment(JLabel.CENTER);
        TitleShowOperation.setAlignmentX(Component.CENTER_ALIGNMENT);
        TitleShowOperation.setBorder(BorderFactory.createEmptyBorder(12, 0, 10, 0));
        TitleShowOperation.setFont(new Font("Arial", Font.BOLD, 33));
        TitleShowOperation.setForeground(new Color(0xc47208));

        /*-----------More Details Modify-----------*/
        TitledBorder titledBorder = BorderFactory.createTitledBorder("More Details");
        titledBorder.setTitleColor(Color.WHITE);
        MoreDetails.setOpaque(false);
        MoreDetails.setLayout(new BoxLayout(MoreDetails, BoxLayout.X_AXIS));
        MoreDetails.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(titledBorder),
                BorderFactory.createEmptyBorder(4, 5, 6, 5)));
        MoreDetails.setMaximumSize(new Dimension(545, 10));
        //--------------//
        CashCustomer.setFont(fontLabel);
        CashCustomer.setForeground(new Color(0xdaa662));
        //--------------//
        getCashCustomer.setFont(fontData);
        getCashCustomer.setForeground(Color.WHITE);
        //--------------//
        OrderMeal.setFont(fontLabel);
        OrderMeal.setForeground(new Color(0xdaa662));
        //--------------//
        getOrderMeal.setFont(fontData);
        getOrderMeal.setForeground(Color.WHITE);
        //--------------//
        MoreDetails.add(CashCustomer);   // Cash is total price // Customer is top Customer
        MoreDetails.add(Box.createHorizontalStrut(5));
        MoreDetails.add(getCashCustomer);
        MoreDetails.add(Box.createHorizontalStrut(110));
        MoreDetails.add(OrderMeal);
        MoreDetails.add(Box.createHorizontalStrut(5));
        MoreDetails.add(getOrderMeal);

        /*-----------Buttons Modifies-----------*/
        ShowOrderButton.setText("Show Orders");
        ShowOrderButton.setFont(new Font("Arial", Font.BOLD, 34));
        ShowOrderButton.setForeground(Color.WHITE);
        ShowOrderButton.setBackground(new Color(0x3d3f42));
        ShowOrderButton.setFocusable(false);
        ShowOrderButton.addActionListener(_ -> {
            CashCustomer.setText("Top Customer:");
            getCashCustomer.setText(Admin.getTopCustomer(AdminClass.Orders));
            OrderMeal.setText("Top Meal:");
            getOrderMeal.setText(Admin.getTopMeal(AdminClass.Orders).trim());
            cardLayout.show(ContainerPanel, "Orders Panel");
            OriginShowOperationPanel.setVisible(true);
            frame.repaint();
        });
        //--------------//
        EditMenuButton.setText("Edit Menu");
        EditMenuButton.setFont(new Font("Arial", Font.BOLD, 34));
        EditMenuButton.setForeground(Color.WHITE);
        EditMenuButton.setBackground(new Color(0x3d3f42));
        EditMenuButton.setFocusable(false);
        EditMenuButton.addActionListener(_ -> {
            if (DialogMSG.ConfirmWindowSwitch("Edit The Menu")) {
                frame.dispose();
                SwingUtilities.invokeLater(() ->
                        new EditMenuFrame(Admin));
            }
        });
        //--------------//
        ShowFundsButton.setText("Show Funds");
        ShowFundsButton.setFont(new Font("Arial", Font.BOLD, 34));
        ShowFundsButton.setForeground(Color.WHITE);
        ShowFundsButton.setBackground(new Color(0x3d3f42));
        ShowFundsButton.setFocusable(false);
        ShowFundsButton.addActionListener(_ -> {
            CashCustomer.setText("Total Cash:");
            getCashCustomer.setText(String.format("%.2f $",AdminClass.getTotalCash()));
            OrderMeal.setText("Total Orders:");
            getOrderMeal.setText(AdminClass.Orders.size() + " Orders");
            cardLayout.show(ContainerPanel, "Funds Panel");
            OriginShowOperationPanel.setVisible(true);
            frame.repaint();
        });
        GoBack.setText("X");
        GoBack.setForeground(Color.WHITE);
        GoBack.setPreferredSize(new Dimension(45, 35));
        GoBack.setBackground(Color.RED);
        GoBack.setFocusable(false);
        GoBack.addActionListener(_ -> {
            if(DialogMSG.ConfirmWindowSwitch("Login Window")) {
                SwingUtilities.invokeLater(AdminLoginFrame::new);
                frame.dispose();
            }
        });

        /*-----------The Right Panels-----------*/
        //This Just For The Buttons
        ButtonsPanel.setLayout(new GridLayout(0, 1, 50, 50));
        ButtonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ButtonsPanel.setPreferredSize(new Dimension(350, 300));
        ButtonsPanel.setMaximumSize((new Dimension(350, 300)));
        ButtonsPanel.add(ShowOrderButton);
        ButtonsPanel.add(EditMenuButton);
        ButtonsPanel.setOpaque(false);
        ButtonsPanel.add(ShowFundsButton);
        //--------------//
        ItemsControlsPanel.setBackground(new Color(0, 0, 0, 150));
        ItemsControlsPanel.setLayout(new BoxLayout(ItemsControlsPanel, BoxLayout.Y_AXIS));
        ItemsControlsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ItemsControlsPanel.setBounds(10, 15, 560, 740);

        /*-----------The Left Panels-----------*/
        OriginShowOperationPanel.setBackground(new Color(0, 0, 0, 150));
        OriginShowOperationPanel.setLayout(new BoxLayout(OriginShowOperationPanel, BoxLayout.Y_AXIS));
        OriginShowOperationPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        OriginShowOperationPanel.setBounds(580, 15, 595, 740);
        OriginShowOperationPanel.setVisible(true);
        //--------------//
        OrdersPanel.setLayout(new GridLayout(0, 1, 10, 10));
        OrdersPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        OrdersPanel.setOpaque(false);
        //--------------//
        FundsPanel.setLayout(new GridLayout(0, 1, 10, 10));
        FundsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        FundsPanel.setOpaque(false);
        //--------------//
        ContainerPanel.setLayout(cardLayout);
        ContainerPanel.add(FundsPanel, "Funds Panel");
        ContainerPanel.add(OrdersPanel, "Orders Panel");
        ContainerPanel.setBackground(new Color(0x3d3f42));
        //--------------//
        ScrollPanel.setMaximumSize(new Dimension(545, 570));
        ScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        /*-----------The Main Background Panel-----------*/
        BackgroundPanel = new PanelBackground("src\\Images\\Backgrounds\\ArchiveRestaurantFrame.jpg");
        BackgroundPanel.setLayout(null);

        /*-----------Add Components-----------*/
        AdminClass.readOrdersFromFile();
        for (OrderClass X : AdminClass.Orders) {
            OrdersPanel.add(new ShowOrders(frame, X, "Type"));
        }
        for (OrderClass X : AdminClass.Orders)
            FundsPanel.add(new ShowOrders(frame, X, "Cost"));

        ItemsControlsPanel.add(Box.createVerticalStrut(12));
        ItemsControlsPanel.add(TitleButtonOperation);
        ItemsControlsPanel.add(Box.createVerticalStrut(150));
        ItemsControlsPanel.add(ButtonsPanel);
        //--------------//
        OriginShowOperationPanel.add(TitleShowOperation);
        OriginShowOperationPanel.add(Box.createVerticalStrut(70));
        OriginShowOperationPanel.add(ScrollPanel);
        OriginShowOperationPanel.add(Box.createVerticalStrut(10));
        OriginShowOperationPanel.add(MoreDetails);
        //--------------//
        BackgroundPanel.add(OriginShowOperationPanel);
        BackgroundPanel.add(ItemsControlsPanel);
        //--------------//
        frame.add(BackgroundPanel);
        frame.setVisible(true);

    }
}
