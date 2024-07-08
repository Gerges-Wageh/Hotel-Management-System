package ProceduralProgamming;



// Represents a section/portion of code (in C language) consists of some related methods
public class MenuManagement {
    Hotel hotel;
    MenuManagement(Hotel hotel){
        this.hotel = hotel;
    }


    // Adding new meal
    void addMeal(String name, String description, double price){
        Meal newMeal = new Meal();
        newMeal.name = name;
        newMeal.description = description;
        newMeal.price = price;

        hotel.menu.meals.add(newMeal);
    }

    // Removing existing meal
    void removeMeal(String name){
        for(Meal meal : hotel.menu.meals){
            if(meal.name.equals(name)){
                hotel.menu.meals.remove(meal);
            }
        }
    }

    Meal getMeal(String name){
        Meal targetMeal = null;
        for(Meal meal : hotel.menu.meals){
            if(meal.name.equals(name)){
                targetMeal = meal;
            }
        }
        return targetMeal;
    }

    void getAllMeals(){

        System.out.println("Meal Name" + "           " + "Meal description" + "      " + "Price");

        for (Meal meal : hotel.menu.meals){
            System.out.printf("%-20s %-20s %-20s",meal.name, meal.description, meal.price);
            System.out.println();
        }
    }
}
