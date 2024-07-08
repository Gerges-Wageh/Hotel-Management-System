package ProceduralProgamming;

public class CheckoutManagement {
    Hotel hotel;

    CheckoutManagement(Hotel hotel){
        this.hotel = hotel;
    }

    // Calculating the total cost of the room reservation and the total meals
    void checkoutRoom(int roomNumber) {

        Room targetRoom = null;
        for(Room room : hotel.rooms) {

            if(room.number == roomNumber) {
                targetRoom = room;
            }
        }

        double totalPrice = targetRoom.startDate.until(targetRoom.endDate).getDays() * targetRoom.price;

        Order roomOrder = null;
        for(Order order : hotel.orders) {

            if(order.roomNumber == roomNumber) {

                roomOrder = order;
            }
        }

        double orderPrice = 0;
        for(Meal meal : roomOrder.meals) {

            orderPrice += meal.price;
        }

        totalPrice += orderPrice;

        System.out.println("Thank you Mr/ " + targetRoom.customerName + " your total price is " + totalPrice + " EGP");
    }
}


