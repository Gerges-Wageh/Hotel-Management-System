package ProceduralProgamming;



// Represents a section/portion of code (in C language) consists of some related methods

public class OrderManagement {
    Hotel hotel;

    OrderManagement(Hotel hotel){
        this.hotel = hotel;
    }

    // Adding order
    void addOrder(Order order){
        hotel.orders.add(order);
    }

    // Getting the room order
    void getRoomOrder(int roomNumber){
        Order targetOrder = null;
        for (Order order : hotel.orders){
            if(order.roomNumber == roomNumber){
                targetOrder = order;
            }
        }
        System.out.println("Meal Name" + "     " + "Description" + "     " + "Price");
        for (Meal meal : targetOrder.meals){
            System.out.printf("%-10s %-10s %-10s", meal.name, meal.description, meal.price);
        }
    }

}
