package GUI;

import Logical_Class.AdminClass;
import Logical_Class.CustomerClass;
import Shapes.*;
import javax.swing.*;
import java.awt.*;


public class OrderTypeFrame {
    JFrame frame = new JFrame();

    /*-----------Delivery-----------*/
    JLabel NameLabel = new JLabel();
    JLabel AddressLabel = new JLabel();
    JLabel PhoneLabel = new JLabel();
    JLabel TableLabel = new JLabel();
    JLabel TipsLabel = new JLabel();
    JLabel NoteLabel = new JLabel();

    RoundedTextField NameField = new RoundedTextField("", 20);
    RoundedTextField AddressField = new RoundedTextField("", 20);
    RoundedTextField PhoneField = new RoundedTextField("", 20);
    RoundedTextField TipsField = new RoundedTextField("", 20);
    RoundedTextField TableField = new RoundedTextField("", 20);
    JTextArea NoteArea = new JTextArea();


    // ------------//
    JLabel TitleType = new JLabel();
    JLabel TitleData = new JLabel();
    PanelBackground MainBackground;

    JPanel TypeOrderPanel = new JPanel();
    JPanel TypeOrderPanelFalse = new JPanel();  // This Panel To Solving Shadow Problem
    JPanel DataOrderPanel = new JPanel();

    JButton GoBack = new JButton();
    JButton Cash = new JButton();
    JButton Card = new JButton();
    RoundButton DeliveryButton = new RoundButton();
    RoundButton InternalButton = new RoundButton();

    public OrderTypeFrame(CustomerClass Customer) {
        /*-----------Frame-----------*/
        frame.setTitle("Bite Byte Restaurant");
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*-----------TitleChooseOperation Type Modifies-----------*/
        TitleType.setText("Please Choose Order Type");
        TitleType.setBounds(90, 10, 450, 50);
        TitleType.setFont(new Font("Arial", Font.BOLD, 33));
        TitleType.setForeground(new Color(0xf1b97a));

        /*-----------TitleChooseOperation Restaurant name Modifies-----------*/
        TitleData.setText("- Bite Byte Restaurant -");
        TitleData.setBounds(120, 12, 450, 50);
        TitleData.setFont(new Font("Arial", Font.BOLD, 33));
        TitleData.setForeground(new Color(0xf1b97a));

        /*-----------Labels Modifies-----------*/
        //-------Delivery Labels-------//
        NameLabel.setText("Name:");
        NameLabel.setBounds(50, 190, 450, 30);
        NameLabel.setFont(new Font("Arial", Font.BOLD, 33));
        NameLabel.setForeground(Color.WHITE);
        NameLabel.setLabelFor(NameField);
        // ------------//
        NameField.setBounds(230, 190, 300, 40);
        NameField.setBackground(new Color(0xcabcad));
        NameField.setFont(new Font("Arial", Font.BOLD, 16));
        NameField.setBorder(null);
        // ------------//
        AddressLabel.setText("Address:");
        AddressLabel.setFont(new Font("Arial", Font.BOLD, 33));
        AddressLabel.setForeground(Color.WHITE);
        AddressLabel.setLabelFor(AddressField);
        // ------------//
        AddressField.setBackground(new Color(0xcabcad));
        AddressField.setFont(new Font("Arial", Font.BOLD, 16));
        AddressField.setBorder(null);
        // ------------//
        PhoneLabel.setText("Phone:");
        PhoneLabel.setFont(new Font("Arial", Font.BOLD, 33));
        PhoneLabel.setForeground(Color.WHITE);
        PhoneLabel.setLabelFor(PhoneField);
        // ------------//
        PhoneField.setBackground(new Color(0xcabcad));
        PhoneField.setFont(new Font("Arial", Font.BOLD, 16));
        PhoneField.setBorder(null);
        // ------------//
        TableLabel.setText("Table:");
        TableLabel.setFont(new Font("Arial", Font.BOLD, 33));
        TableLabel.setForeground(Color.WHITE);
        TableLabel.setLabelFor(TableField);
        // ------------//
        TableField.setBackground(new Color(0xcabcad));
        TableField.setFont(new Font("Arial", Font.BOLD, 16));
        TableField.setBorder(null);
        // ------------//
        TipsLabel.setText("Tip:");
        TipsLabel.setFont(new Font("Arial", Font.BOLD, 33));
        TipsLabel.setForeground(Color.WHITE);
        TipsLabel.setLabelFor(TipsField);
        // ------------//
        TipsField.setBackground(new Color(0xcabcad));
        TipsField.setFont(new Font("Arial", Font.BOLD, 16));
        TipsField.setBorder(null);
        // ------------//
        NoteLabel.setText("Note:");
        NoteLabel.setFont(new Font("Arial", Font.BOLD, 33));
        NoteLabel.setForeground(Color.WHITE);
        NoteLabel.setLabelFor(NoteArea);
        // ------------//
        NoteArea.setBackground(new Color(0xcabcad));
        NoteArea.setFont(new Font("Arial", Font.BOLD, 16));
        NoteArea.setLineWrap(true);

        /*-----------Buttons Modifies-----------*/
        InternalButton.setFocusable(false);
        InternalButton.setBounds(170, 150, 225, 225);
        ImageIcon iconInternal = new ImageIcon("src\\Images\\Images For Buttons\\InternalLogo.png");
        Image imgUser = iconInternal.getImage();
        Image scaledImgInternal = imgUser.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        iconInternal = new ImageIcon(scaledImgInternal);
        InternalButton.setIcon(iconInternal);
        InternalButton.setBackground(new Color(0x363431));
        InternalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InternalButton.setBackground(new Color(0x030200));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                InternalButton.setBackground(new Color(0x363431));
            }
        });
        InternalButton.addActionListener(_ -> {
            TableLabel.setBounds(50, 250, 450, 30);
            TableField.setBounds(230, 250, 300, 40);
            TipsLabel.setBounds(50, 310, 450, 30);
            TipsField.setBounds(230, 310, 300, 40);
            NoteLabel.setBounds(50, 370, 450, 30);
            NoteArea.setBounds(230, 370, 300, 80);

            DataOrderPanel.remove(AddressLabel);
            DataOrderPanel.remove(AddressField);
            DataOrderPanel.remove(PhoneLabel);
            DataOrderPanel.remove(PhoneField);

            DataOrderPanel.add(TableLabel);
            DataOrderPanel.add(TableField);
            frame.repaint();
            DataOrderPanel.setVisible(true);
            Customer.orderCustomer.setTypeOrder("Internal");
        });
        // ------------//
        DeliveryButton.setFocusable(false);
        DeliveryButton.setBounds(170, 450, 225, 225);
        ImageIcon iconDelivery = new ImageIcon("src\\Images\\Images For Buttons\\Delivery.png");
        Image imgDelivery = iconDelivery.getImage();
        Image scaledImgDelivery = imgDelivery.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
        iconDelivery = new ImageIcon(scaledImgDelivery);
        DeliveryButton.setIcon(iconDelivery);
        DeliveryButton.setBackground(new Color(0x363431));
        DeliveryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeliveryButton.setBackground(new Color(0x030200));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeliveryButton.setBackground(new Color(0x363431));
            }
        });
        DeliveryButton.addActionListener(_ -> {
            AddressLabel.setBounds(50, 250, 450, 30);
            PhoneLabel.setBounds(50, 310, 450, 30);
            TipsLabel.setBounds(50, 370, 450, 30);
            NoteLabel.setBounds(50, 430, 450, 30);
            AddressField.setBounds(230, 250, 300, 40);
            PhoneField.setBounds(230, 310, 300, 40);
            TipsField.setBounds(230, 370, 300, 40);
            NoteArea.setBounds(230, 430, 300, 80);
            DataOrderPanel.remove(TableLabel);
            DataOrderPanel.remove(TableField);
            DataOrderPanel.add(AddressLabel);
            DataOrderPanel.add(AddressField);
            DataOrderPanel.add(PhoneLabel);
            DataOrderPanel.add(PhoneField);
            frame.repaint();
            DataOrderPanel.setVisible(true);
            Customer.orderCustomer.setTypeOrder("Delivery");
        });
        // ------------//
        GoBack.setText("X");
        GoBack.setForeground(Color.WHITE);
        GoBack.setBackground(Color.RED);
        GoBack.setFocusable(false);
        GoBack.setBounds(15, 20, 45, 30);
        GoBack.addActionListener(_ -> {
            frame.dispose();
            SwingUtilities.invokeLater(() ->
                    new MenuFrame(Customer));
        });
        // ------------//
        Card.setText("Card");
        Card.setFont(new Font("Arial", Font.BOLD, 20));
        Card.setForeground(Color.WHITE);
        Card.setBackground(new Color(0x3d3f42));
        Card.setFocusable(false);
        Card.setBounds(80, 580, 150, 60);
        Card.setBorder(null);
        Card.addActionListener(_ -> {
            String orderType = Customer.orderCustomer.getTypeOrder();
            boolean isInternal = orderType.equals("Internal");
            if (validateFields(isInternal)) {
                return;
            }
            String tipsText = TipsField.getText().trim();
            if (!tipsText.isEmpty() && !tipsText.matches("\\d+")) {
                Logical_Class.DialogMSG.EnterValidData("Tips");
                return;
            }

            Customer.orderCustomer.setTipOrder(tipsText.isEmpty() ? 0 : Float.parseFloat(tipsText));

            if (Logical_Class.DialogMSG.ConfirmPayment(Customer.orderCustomer.getTotalPriceOrder() + Customer.orderCustomer.getTipOrder())) {
                return;
            }
            String additionalInfo = isInternal ? ("Table Num: "+TableField.getText()) : PhoneField.getText() + ' ' + AddressField.getText();
            AdminClass.writeOrderToFile(
                    Customer.orderCustomer.getNumberOrder(),
                    NameField.getText(),
                    orderType,
                    additionalInfo,
                    Customer.orderCustomer.Meals,
                    Customer.orderCustomer.getTotalPriceOrder(),
                    "By Cash",
                    NoteArea.getText()
            );
            /* We Put this Statement her Because Maybe The user Login With a name
             * and Write The Order Owner With Different Name
             * So We Will Write The Main name in the file (for Best Customer)
             * and Write The New Name in the Bill ↓↓↓ */
            Customer.orderCustomer.setOwnerOrder(NameField.getText());

            SwingUtilities.invokeLater(() -> {
                try {
                    frame.dispose();
                    new BillFrame(Customer.orderCustomer);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            });
        });
        // ------------//
        Cash.setText("Cash");
        Cash.setFont(new Font("Arial", Font.BOLD, 20));
        Cash.setForeground(Color.WHITE);
        Cash.setBackground(new Color(0x3d3f42));
        Cash.setFocusable(false);
        Cash.setBounds(350, 580, 150, 60);
        Cash.setBorder(null);
        Cash.addActionListener(_ -> {
            String orderType = Customer.orderCustomer.getTypeOrder();
            boolean isInternal = orderType.equals("Internal");
            if (validateFields(isInternal)) {
                return;
            }
            String tipsText = TipsField.getText().trim();
            if (!tipsText.isEmpty() && !tipsText.matches("\\d+")) {
                Logical_Class.DialogMSG.EnterValidData("Tips");
                return;
            }
            Customer.orderCustomer.setTipOrder(tipsText.isEmpty() ? 0 : Float.parseFloat(tipsText));

            if (Logical_Class.DialogMSG.ConfirmPayment(Customer.orderCustomer.getTotalPriceOrder() + Customer.orderCustomer.getTipOrder())) {
                return;
            }
            String additionalInfo = isInternal ? ("Table Num: "+TableField.getText()) : PhoneField.getText() + ' ' + AddressField.getText();
            AdminClass.writeOrderToFile(
                    Customer.orderCustomer.getNumberOrder(),
                    NameField.getText(),
                    orderType,
                    additionalInfo,
                    Customer.orderCustomer.Meals,
                    Customer.orderCustomer.getTotalPriceOrder(),
                    "By Cash",
                    NoteArea.getText()
            );
            /* We Put this Statement her Because Maybe The user Login With a name
             * and Write The Order Owner With Different Name
             * So We Will Write The Main name in the file (for Best Customer)
             * and Write The New Name in the Bill ↓↓↓ */
            Customer.orderCustomer.setOwnerOrder(NameField.getText());

            SwingUtilities.invokeLater(() -> {
                try {
                    frame.dispose();
                    new BillFrame(Customer.orderCustomer);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            });
        });

        /*------------Panel Modifies-----------*/
        TypeOrderPanel.setLayout(null);
        TypeOrderPanel.setOpaque(false);
        TypeOrderPanel.setBounds(590, 15, 585, 740);
        // ------------//
        TypeOrderPanelFalse.setBackground(new Color(0, 0, 0, 150));
        TypeOrderPanelFalse.setLayout(null);
        TypeOrderPanelFalse.setBounds(590, 15, 585, 740);
        // ------------//
        /*-------Background Panels-------*/
        DataOrderPanel.setBackground(new Color(0, 0, 0, 150));
        DataOrderPanel.setLayout(null);
        DataOrderPanel.setBounds(10, 15, 570, 740);
        DataOrderPanel.setVisible(false);

        /*-------Main Background-------*/
        MainBackground = new PanelBackground("src\\Images\\Backgrounds\\ArchiveRestaurantFrame.jpg");
        MainBackground.setLayout(null);

        /*-----------Adding Components-----------*/
        TypeOrderPanel.add(TitleType);
        DataOrderPanel.add(TitleData);
        // ------------//
        TypeOrderPanel.add(InternalButton);
        TypeOrderPanel.add(DeliveryButton);
        TypeOrderPanel.add(GoBack);
        // ------------//
        DataOrderPanel.add(NameLabel);
        DataOrderPanel.add(TipsLabel);
        DataOrderPanel.add(NoteLabel);
        // ------------//
        DataOrderPanel.add(NameField);
        DataOrderPanel.add(TipsField);
        DataOrderPanel.add(NoteArea);
        // ------------//
        DataOrderPanel.add(Cash);
        DataOrderPanel.add(Card);
        // ------------//
        MainBackground.add(DataOrderPanel);
        MainBackground.add(TypeOrderPanel);
        MainBackground.add(TypeOrderPanelFalse);
        // ------------//
        frame.add(MainBackground);
        frame.setVisible(true);
    }

    private boolean validateFields(boolean isInternal) {
        // We use Trim() method to Ignore spaces
        if (NameField.getText().trim().isEmpty()) {
            Logical_Class.DialogMSG.EmptyFieldError("Name");
            return true;
        }
        if (isInternal) {
            if (TableField.getText().trim().isEmpty()) {
                Logical_Class.DialogMSG.EmptyFieldError("Table");
                return true;
            }
            if (!TableField.getText().trim().matches("\\d+")) {
                Logical_Class.DialogMSG.EnterValidData("Table Number");
                return true;
            }
        } else {
            if (AddressField.getText().trim().isEmpty()) {
                Logical_Class.DialogMSG.EmptyFieldError("Address");
                return true;
            }
            if (PhoneField.getText().trim().isEmpty()) {
                Logical_Class.DialogMSG.EmptyFieldError("Phone Number");
                return true;
            }
            if (!PhoneField.getText().trim().matches("\\d+")) {
                Logical_Class.DialogMSG.EnterValidData("Phone Number");
                return true;
            }
        }
        return false;
    }
}
