package GUI;

import Logical_Class.OrderClass;

import javax.swing.*;
import java.awt.*;


/*
 * This Panel To Show The Order Details in ArchiveRestaurantFrame
 * Like Number, Name, Details, Small Button
 */
public class ShowOrders extends JPanel {
    JLabel setNumber = new JLabel();
    JLabel getNumber = new JLabel();

    JLabel setOwner = new JLabel();
    JLabel getOwner = new JLabel();

    JLabel setInfo = new JLabel();
    JLabel getInfo = new JLabel();

    JButton OrderDetails = new JButton();

    Font fontLabel = new Font("Arial", Font.BOLD, 20);
    Font fontData = new Font("Arial", Font.PLAIN, 18);

    public ShowOrders(JFrame frame, OrderClass order, String Operation) {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setBackground(new Color(0, 0, 0, 140));
        this.setPreferredSize(new Dimension(100, 100));

        /*-------Number-------*/
        setNumber.setFont(fontLabel);
        setNumber.setForeground(new Color(0xdaa662));
        getNumber.setText("- " + order.getNumberOrder() + " -");
        getNumber.setFont(fontData);
        getNumber.setHorizontalAlignment(JLabel.CENTER);
        getNumber.setForeground(Color.WHITE);

        /*-------Owner-------*/
        JPanel OwnerOrderPanel = new JPanel();
        OwnerOrderPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        OwnerOrderPanel.setOpaque(false);

        setOwner.setText("Customer:");
        setOwner.setFont(fontLabel);
        setOwner.setForeground(new Color(0xdaa662));

        getOwner.setText(order.getOwnerOrder());
        getOwner.setFont(fontData);
        getOwner.setForeground(Color.WHITE);

        OwnerOrderPanel.add(setOwner);
        OwnerOrderPanel.add(getOwner);

        /*-------Status-------*/
        JPanel DetailsOrderPanel = new JPanel();
        DetailsOrderPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        DetailsOrderPanel.setOpaque(false);
        if (Operation.equalsIgnoreCase("Type")) {
            setInfo.setText("Type Order:");
            getInfo.setText(order.getTypeOrder());
        } else {
            setInfo.setText("Total Cost:");
            getInfo.setText(String.format("%.2f $", order.getTotalPriceOrder()));
        }

        setInfo.setFont(fontLabel);
        setInfo.setForeground(new Color(0xdaa662));

        getInfo.setFont(fontData);
        getInfo.setForeground(Color.WHITE);

        DetailsOrderPanel.setMaximumSize(new Dimension(500, 50));
        DetailsOrderPanel.add(setInfo);
        DetailsOrderPanel.add(getInfo);


        /*-------Details-------*/
        OrderDetails.setText("...");
        OrderDetails.setForeground(new Color(0xdaa662));
        OrderDetails.setFocusable(false);
        OrderDetails.setFont(new Font("Arial", Font.BOLD, 20));
        OrderDetails.setPreferredSize(new Dimension(30, 25));
        OrderDetails.setBackground(new Color(0x3d3f42));
        OrderDetails.addActionListener(_ -> SwingUtilities.invokeLater(() ->
                new MoreDetailsAboutOrder(frame, order)));
        DetailsOrderPanel.add(OrderDetails);
        this.add(getNumber);
        this.add(Box.createHorizontalGlue());
        this.add(OwnerOrderPanel);
        this.add(Box.createHorizontalGlue());
        this.add(DetailsOrderPanel);
    }
}
