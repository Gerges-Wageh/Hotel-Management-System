package ProceduralProgamming;

import java.util.List;
import java.util.Scanner;

public class AppRunner {
    public static void main(String[] args) {
        // Initializing the system and the services
        Hotel hotel = new Hotel();
        RoomManagement roomManagement = new RoomManagement(hotel);
        MenuManagement menuManagement = new MenuManagement(hotel);
        OrderManagement orderManagement = new OrderManagement(hotel);
        CheckoutManagement checkoutManagement = new CheckoutManagement(hotel);

        Scanner scanner = new Scanner(System.in);

        // Initializing the hotel rooms
        roomManagement.addRoom(1, 2, 250.0);
        roomManagement.addRoom(2, 1, 350.0);
        roomManagement.addRoom(3, 1, 300.0);
        roomManagement.addRoom(4, 2, 200.0);

        // Initializing the hotel meals
        menuManagement.addMeal("rizo", "rice with meat", 300.0);
        menuManagement.addMeal("pasto", "pasta with meat", 330.0);




        // Software in action
        System.out.println("Program Start Press Enter to Process");



        scanner.nextLine();
        System.out.println("========================================");
        System.out.println("Get Available Rooms");
        System.out.println("========================================");

        scanner.nextLine();
        roomManagement.getAvailableRooms();


        scanner.nextLine();
        System.out.println("========================================");
        System.out.println("Get All Meals");
        System.out.println("========================================");

        scanner.nextLine();
        menuManagement.getAllMeals();

        scanner.nextLine();
        System.out.println("========================================");
        System.out.println("Customer reserved Room 2 for 3 days");
        System.out.println("========================================");

        scanner.nextLine();
        roomManagement.reserveRoom(2, 3, "ahmed", "11223344");


        scanner.nextLine();
        System.out.println("========================================");
        System.out.println("Get Available Rooms After Reservation");
        System.out.println("========================================");


        scanner.nextLine();
        roomManagement.getAvailableRooms();

        scanner.nextLine();
        System.out.println("========================================");
        System.out.println("Customer makes order with Rizo meal for room number 2");
        System.out.println("========================================");

        scanner.nextLine();
        Order order = new Order();
        order.meals = List.of(menuManagement.getMeal("rizo"));
        order.customerName = "ahmed";
        order.roomNumber = 2;
        orderManagement.addOrder(order);


        scanner.nextLine();
        System.out.println("========================================");
        System.out.println("Checkout Room");
        System.out.println("========================================");

        scanner.nextLine();
        checkoutManagement.checkoutRoom(2);

        scanner.nextLine();
        System.out.println("========================================");
        System.out.println("System frees room number 2");
        System.out.println("========================================");

        scanner.nextLine();
        roomManagement.freeRoom(2);


        scanner.nextLine();
        System.out.println("========================================");
        System.out.println("Get Available Rooms After Checkout");
        System.out.println("========================================");

        scanner.nextLine();
        roomManagement.getAvailableRooms();


    }

}
