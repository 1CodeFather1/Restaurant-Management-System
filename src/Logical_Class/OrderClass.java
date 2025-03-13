package Logical_Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OrderClass {
    int numberOrder;
    private String ownerOrder;
    public ArrayList<MealClass> Meals;
    private double priceOrder;
    private double tipOrder;
    private String typeOrder;
    private String payMethod;
    private String Notes;

    /*--------Constructor--------*/

    public OrderClass() {
        Meals = new ArrayList<>();
        setNumberOrder(getLastOrderNumberFromFile("Orders.txt") + 1);
    }

    /*--------Getter & Setter--------*/
    public int getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    
    public String getOwnerOrder() {
        return ownerOrder;
    }

    public void setOwnerOrder(String ownerOrder) {
        this.ownerOrder = ownerOrder;
    }

    
    public float getTotalPriceOrder() {
        if (priceOrder == 0) {
            for (MealClass x : Meals) {
                priceOrder += (x.getPriceMeal() * x.getCurrQuantityMeal());
            }
            return (float) priceOrder;
        }
        return (float) priceOrder;
    }
    
    public void setTotalPriceOrder(float priceOrder) {
        this.priceOrder = priceOrder;
    }

    public double getTipOrder() {
        return tipOrder;
    }

    public void setTipOrder(double tipOrder) {
        this.tipOrder = tipOrder;
    }

    public String getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(String typeOrder) {
        this.typeOrder = typeOrder;
    }


    /*To display the Meals on MoreDetailsAboutOrder*/
    public String getAllMeals() {
        StringBuilder AllMeals = new StringBuilder();
        for (MealClass X : this.Meals) {
            AllMeals.append(X.getNameMeal()).append(" ×").append(X.getCurrQuantityMeal()).append(" + ");
        }
        if (!AllMeals.isEmpty()) {
            AllMeals.setLength(AllMeals.length() - 2);
        }
        return AllMeals.toString();
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    /*To Get The of Last Orders Number*/
    public static int getLastOrderNumberFromFile(String filePath) {
        int lastOrderNumber = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentOrderNumber = 0;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Order #")) {
                    String[] parts = line.split("#");
                    if (parts.length > 1) {
                        currentOrderNumber = Integer.parseInt(parts[1].trim());
                    }
                }
            }
            lastOrderNumber = currentOrderNumber;

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return lastOrderNumber;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
}

