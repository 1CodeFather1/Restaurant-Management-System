package Logical_Class;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AdminClass extends PersonClass {
    public static final String ActivationKey = "20ITE25";
    public static ArrayList<MealClass> AppetizerMeals = new ArrayList<>();
    public static ArrayList<MealClass> MainMealMeals = new ArrayList<>();
    public static ArrayList<MealClass> DessertMeals = new ArrayList<>();
    public static ArrayList<OrderClass> Orders = new ArrayList<>();

    public AdminClass(String Username) {
        super(Username);
    }

    /* To Return Total Sells*/
    public static float getTotalCash() {
        float totalCash = 0;
        for (OrderClass X : AdminClass.Orders) {
            totalCash += X.getTotalPriceOrder();
        }
        return totalCash;
    }

    /* To Return The Most Customer Who Ordered*/
    public String getTopCustomer(List<OrderClass> orders) {
        if (orders.isEmpty()) {
            return "No customers found";
        }

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (OrderClass order : orders) {
            String name = order.getOwnerOrder();
            frequencyMap.put(name, frequencyMap.getOrDefault(name, 0) + 1);
        }

        String mostFrequent = null;
        int maxFrequency = 0;

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequent = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        return mostFrequent;
    }

    /* To Return The Most Meal that Ordered*/
    public String getTopMeal(List<OrderClass> orders) {
        if (orders.isEmpty()) {
            return "No meals found";
        }

        Map<String, Integer> mealFrequency = new HashMap<>();

        for (OrderClass order : orders) {
            for (MealClass meal : order.Meals) {
                String mealName = meal.getNameMeal();
                mealFrequency.put(mealName, mealFrequency.getOrDefault(mealName, 0) + meal.getCurrQuantityMeal());
            }
        }

        String mostFrequentMeal = null;
        int maxFrequency = 0;

        for (Map.Entry<String, Integer> entry : mealFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentMeal = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        if (mostFrequentMeal != null) {
            String[] words = mostFrequentMeal.split(" ");
            return words[0];
        } else {
            return "All Same";
        }
    }


    /* To Move The Meals From The File Into The ArrayList*/
    public static void readMeals(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] mealData = line.split("<>");
                if (mealData.length == 6) {
                    String name = mealData[0].trim();
                    String type = mealData[1].trim();
                    int quantity = Integer.parseInt(mealData[2].trim());
                    float price = Float.parseFloat(mealData[3].trim());
                    String imagePath = mealData[4].trim();
                    String description = mealData[5].trim();
                    if (filePath.equals("Appetizers.txt")) {
                        AppetizerMeals.add(new MealClass(name, quantity, price, imagePath, description));
                    } else if (filePath.equals("Main Meals.txt")) {
                        MainMealMeals.add(new MealClass(name, quantity, price, imagePath, description));
                    } else {
                        DessertMeals.add(new MealClass(name, quantity, price, imagePath, description));
                    }

                }
            }
        } catch (IOException _) {
        }
    }

    /*To Edit a Meal From The Menu*/
    public static void editMealInFile(String oldName, String newName, String newType, int newTotalQuantity,
                                      float newPrice, String newImage, String newDescription, String filePath) {

        ArrayList<String> meals = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] mealData = line.split("<>");
                if (mealData[0].trim().equals(oldName)) {
                    // Update the meal details
                    line = newName + "<>" + newType + "<>" + newTotalQuantity + "<>" + newPrice + "<>" + newImage + "<>"
                            + newDescription;
                }
                meals.add(line);
            }
        } catch (IOException _) {
        }
        // Write the updated meals back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String meal : meals) {
                writer.write(meal);
                writer.newLine();
            }
        } catch (IOException _) {
        }
        // Update the corresponding ArrayList
        switch (filePath) {
            case "Appetizers.txt" -> {
                // Remove the old meal from AppetizerMeals
                AppetizerMeals.removeIf(meal -> meal.getNameMeal().equals(oldName));
                // Add the updated meal to AppetizerMeals
                AppetizerMeals.add(new MealClass(newName, newTotalQuantity, newPrice, newImage, newDescription));
            }
            case "Main Meal.txt" -> {
                // Remove the old meal from MainMealMeals
                MainMealMeals.removeIf(meal -> meal.getNameMeal().equals(oldName));
                // Add the updated meal to MainMealMeals
                MainMealMeals.add(new MealClass(newName, newTotalQuantity, newPrice, newImage, newDescription));
            }
            case "Desserts.txt" -> {
                // Remove the old meal from DessertMeals
                DessertMeals.removeIf(meal -> meal.getNameMeal().equals(oldName));
                // Add the updated meal to DessertMeals
                DessertMeals.add(new MealClass(newName, newTotalQuantity, newPrice, newImage, newDescription));
            }
        }
    }

    /*To Remove a Meal From The Menu*/
    public static void removeMealFromFile(String nameToRemove, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        ArrayList<String> meals = new ArrayList<>();
        boolean found = false; // To check if the meal exists

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] mealData = line.split("<>");
                if (mealData.length > 0 && mealData[0].trim().equalsIgnoreCase(nameToRemove)) {
                    found = true; // The meal to be deleted was found.
                    continue; // Skip this line without adding it to the list
                }
                meals.add(line); // Keep other meals
            }
        } catch (IOException _) {
        }
        if (!found) {
            return;
        }
        // Rewrite data to file without deleted meal
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String meal : meals) {
                writer.write(meal);
                writer.newLine();
            }
        } catch (IOException _) {
        }
    }

    /*To Add a new Meal Into The File*/
    public static void addMealToFile(String nameMeal, String typeMeal, int totalQuantityMeal, float priceMeal,
                                     String imageMeal, String descriptionMeal, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(
                    nameMeal + "<>" + typeMeal + "<>" + totalQuantityMeal + "<>" + priceMeal + "<>" + imageMeal + "<>"
                            + descriptionMeal);
            writer.newLine();
        } catch (IOException _) {
        }
    }

    /*To Write The Order From GUI To The File*/
    public static void writeOrderToFile(int orderNum, String owner, String type, String phone, List<MealClass> meals,
                                        float priceOrder, String payMethod, String note) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Orders.txt", true))) {
            writer.write("Order #" + orderNum);
            writer.newLine();
            writer.write("Owner: " + owner);
            writer.newLine();
            writer.write("Type: " + type);
            writer.newLine();
            writer.write("Details: " + phone);
            writer.newLine();

            writer.write("Meals: ");
            for (int i = 0; i < meals.size(); i++) {
                MealClass meal = meals.get(i);
                writer.write(meal.getNameMeal() + ", " + meal.getCurrQuantityMeal() + " pieces, " + meal.getPriceMeal() + "$");
                if (i < meals.size() - 1) {
                    writer.write(" + ");
                }
            }
            writer.newLine();
            writer.write("Total Price: " + priceOrder + "$");
            writer.newLine();
            writer.write("Payment Method: " + payMethod);
            writer.newLine();
            writer.write("Note: " + note);
            writer.newLine();
            writer.write("---------------------------------------");
            writer.newLine();
        } catch (IOException _) {
        }
    }


    /*To Read The Order From File To The GUI*/
    public static void readOrdersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Orders.txt"))) {
            String line;
            OrderClass currentOrder = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Order #")) {
                    if (currentOrder != null) {
                        AdminClass.Orders.add(currentOrder);
                    }
                    currentOrder = new OrderClass();
                    currentOrder.setNumberOrder(Integer.parseInt(line.split("#")[1].trim()));
                } else if (line.startsWith("Owner:")) {
                    assert currentOrder != null;
                    currentOrder.setOwnerOrder(line.replace("Owner:", "").trim());
                } else if (line.startsWith("Type:")) {
                    assert currentOrder != null;
                    currentOrder.setTypeOrder(line.replace("Type:", "").trim());
                } else if (line.startsWith("Total Price:")) {
                    assert currentOrder != null;
                    currentOrder.setTotalPriceOrder(Float.parseFloat(line.replace("Total Price:", "").replace("$", "").trim()));
                } else if (line.startsWith("Meals:")) {
                    String mealsData = line.replace("Meals:", "").trim();
                    String[] mealsArray = mealsData.split("\\s*\\+\\s*");
                    ArrayList<MealClass> mealList = new ArrayList<>();
                    for (String meal : mealsArray) {
                        String[] mealParts = meal.split(", ");
                        if (mealParts.length == 3) {
                            String mealName = mealParts[0].trim();
                            int quantity = Integer.parseInt(mealParts[1].replace(" pieces", "").trim());
                            float price = Float.parseFloat(mealParts[2].replace("$", "").trim());
                            mealList.add(new MealClass(mealName, price, quantity));
                        }
                    }
                    assert currentOrder != null;
                    currentOrder.Meals = mealList;

                } else if (line.startsWith("Payment Method:")) {
                    assert currentOrder != null;
                    currentOrder.setPayMethod(line.replace("Payment Method:", "").trim());
                } else if (line.startsWith("Note:")) {
                    assert currentOrder != null;
                    currentOrder.setNotes(line.replace("Note:", "").trim());
                }
            }
            if (currentOrder != null) {
                AdminClass.Orders.add(currentOrder);
            }

        } catch (IOException _) {
        }
    }
}
