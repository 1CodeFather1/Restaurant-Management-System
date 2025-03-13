package Logical_Class;

import GUI.MenuFrame;

import javax.swing.*;

public class DialogMSG extends JOptionPane {

    public static void ErrorPassUser() {
        String[] answer1 = {"Try Again", "Cancel"};
        JOptionPane.showOptionDialog(null, "<html><p style='font-size:14px;'>Sorry, the username or password is incorrect.</p></html>", "Error Password", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, answer1, 0);
    }

    public static void Mismatch() {
        String[] answer2 = {"Try Again", "Cancel"};
        JOptionPane.showOptionDialog(null, "<html><p style='font-size:14px;'>Sorry, the passwords do not match.</p></html>", "Password Mismatch", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, answer2, 0);
    }
    public static boolean ConfirmWindowSwitch(String nextWindowName) {
        int choice = JOptionPane.showConfirmDialog(
                null,
                "<html><p style='font-size:14px;'>Are you sure you want to close this window and go to <b>" + nextWindowName + "</b>?</p></html>",
                "Confirm Window Switch",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        return choice == JOptionPane.YES_OPTION;
    }


    public static void ErrorKeyActivation() {
        String[] answer3 = {"Try Again", "Cancel"};
        JOptionPane.showOptionDialog(null, "<html><p style='font-size:14px;'>Sorry, the activation key is incorrect.</p></html>", "Activation Key Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, answer3, 0);
    }


    public static void LoginMessage() {
        JOptionPane.showMessageDialog(null, "<html><p style='font-size:14px;'>Login Successful!</p></html>", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void CreateAccountMessage() {
        JOptionPane.showMessageDialog(null, "<html><p style='font-size:14px;'><b>Account created successfully!</b><br>Welcome to our service.</p></html>", "Account Created", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void AccountExists() {
        JOptionPane.showMessageDialog(null, "<html><p style='font-size:14px;'>An account with this information already exists!</p></html>", "Account Exists", JOptionPane.WARNING_MESSAGE);
    }

    public static void NotEnoughQuantity() {
        JOptionPane.showMessageDialog(null, "<html><p style='font-size:14px;'>Sorry, we do not have this quantity available right now.</p></html>", "Insufficient Stock", JOptionPane.ERROR_MESSAGE);
    }

    public static void EnterValidData(String field) {
        JOptionPane.showMessageDialog(null, "<html><p style='font-size:14px;'>Please enter valid data for the <b>" + field + "</b> field.</p></html>", "Invalid Input", JOptionPane.ERROR_MESSAGE);
    }

    public static void EmptyFieldError(String fieldName) {
        JOptionPane.showMessageDialog(null, "<html><p style='font-size:14px;'>The <b>" + fieldName + "</b> field cannot be empty!</p></html>", "Empty Field", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean ConfirmPayment(double amount) {
        int choice = JOptionPane.showConfirmDialog(null, "<html><p style='font-size:14px;'>Are you sure you want to proceed with the payment of <b>$" + String.format("%.2f", amount) + "</b>?</p></html>", "Confirm Payment", JOptionPane.YES_NO_OPTION);
        return choice != JOptionPane.YES_OPTION;
    }

    public static boolean ConfirmDeletion(String itemName) {
        int choice = JOptionPane.showConfirmDialog(null, "<html><p style='font-size:14px;'>Are you sure you want to delete <b>" + itemName + "</b>?</p></html>", "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        return choice == JOptionPane.YES_OPTION;
    }
    public static boolean ConfirmActionForMeal(String actionType, String mealName) {
        int choice = JOptionPane.showConfirmDialog(
                null,
                "<html><p style='font-size:14px;'>Are you sure you want to <b>" + actionType + "</b> the meal <b>" + mealName + "</b>?</p></html>",
                "Confirm " + actionType,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        return choice == JOptionPane.YES_OPTION;
    }


    public static void DeletionSuccess(String itemName) {
        JOptionPane.showMessageDialog(null, "<html><p style='font-size:14px;'><b>" + itemName + "</b> has been successfully deleted.</p></html>", "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void OrderAgain(JFrame frame, CustomerClass customerClass) {
        Object[] options = {"Order Again", "Exit"};
        int choice = JOptionPane.showOptionDialog(frame,
                "<html><p style='font-size:14px;'>Enjoy your meal! Choose an action:</p></html>",
                "End of Program",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if (choice == JOptionPane.YES_OPTION) {
            SwingUtilities.invokeLater(() -> new MenuFrame(customerClass));
        } else if (choice == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
        frame.dispose();
    }
}
