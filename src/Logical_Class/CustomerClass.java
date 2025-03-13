package Logical_Class;

public class CustomerClass extends PersonClass {

    public OrderClass orderCustomer;

    /*--------Constructors--------*/

    // Create a Customer Object when login
    public CustomerClass(String username) {
        super(username);
        orderCustomer = new OrderClass();
    }

    // To Create a New Customer
    public CustomerClass(String username, String password) {
        super(username, password);
        orderCustomer = new OrderClass();
    }

    public CustomerClass() {
        super();
        orderCustomer = new OrderClass();
    }


//    /* To Convert Meal Object To String*/
//    public String getAllMeals() {
//        StringBuilder AllMeals = new StringBuilder();
//        for (MealClass X : this.orderCustomer.Meals) {
//            AllMeals.append(X.getNameMeal() + "->>"
//                    + X.getCurrQuantityMeal() + "->>"
//                    + X.getPriceMeal()).append("(())");
//        }
//        if (!AllMeals.isEmpty()) {
//            AllMeals.setLength(AllMeals.length() - 3);
//        }
//        return AllMeals.toString();
//    }

//    public static List<MealClass> MealsToArchive(String mealsString) {
//        List<MealClass> mealsList = new ArrayList<>();
//        String[] mealsArray = mealsString.split("(())");
//        for (String mealData : mealsArray) {
//            String[] fields = mealData.split("->>");
//            if (fields.length == 3) {
//                String name = fields[0];
//                int quantity = Integer.parseInt(fields[1]);
//                float price = Float.parseFloat(fields[2]);
//                MealClass meal = new MealClass(name, price,quantity);
//                mealsList.add(meal);
//            }
//        }
//        return mealsList;
//    }
}