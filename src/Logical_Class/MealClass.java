package Logical_Class;

public class MealClass {

    private final String nameMeal;
    private int currQuantityMeal;   // This For The user
    private int totalQuantityMeal; // This For The Admin
    private final float priceMeal;
    private String imageMeal;
    private String descriptionMeal;


    /*--------Constructor--------*/

    public MealClass(String nameMeal, float priceMeal, int currQuantityMeal) { //To read From File To System
        this.nameMeal = nameMeal;
        this.priceMeal = priceMeal;
        this.currQuantityMeal = currQuantityMeal;
    }


    public MealClass(String nameMeal, int totalQuantityMeal, float priceMeal, String imageMeal, String descriptionMeal) {
        /*For Add A new Meal*/
        this.nameMeal = nameMeal;
        this.totalQuantityMeal = totalQuantityMeal;
        this.priceMeal = priceMeal;
        this.imageMeal = imageMeal;
        this.descriptionMeal = descriptionMeal;
    }

    /*--------Getter--------*/
    public String getNameMeal() {
        return nameMeal;
    }

    public int getCurrQuantityMeal() {
        return currQuantityMeal;
    }

    public float getPriceMeal() {
        return priceMeal;
    }

    public String getImageMeal() {
        return imageMeal;
    }

    public String getDescriptionMeal() {
        return descriptionMeal;
    }

    public int getTotalQuantityMeal() {
        return totalQuantityMeal;
    }

}
