package ProceduralProgamming;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

// Represents a section/portion of code (in C language) consists of some related methods

public class RoomManagement {
    // Here I don't intent to instantiate a Hotel object as we assume we are out of OOP and know nothing about it.
    // The only reason to have a Hotel reference variable here is to mimic the idea of global variables in other languages
    // Since java in an OOP language and doesn't support the idea of global vars the way it is in C language for example
    // We have to maintain global state cross the app by having a reference to the only Hotel object instantiated in the main method.

    Hotel hotel;

    // Here we catch the global Hotel Object
    RoomManagement(Hotel hotel){
        this.hotel = hotel;
    }

    // Adding new room to the system
    void addRoom(int roomNum, int numberOfBeds, double price){
        Room newRoom = new Room();
        newRoom.number = roomNum;
        newRoom.price = price;
        newRoom.numberOfBeds = numberOfBeds;
        hotel.rooms.add(newRoom);
    }

    // Removing existing room
    void removeRoom(int roomNumber){
        for (Room room : hotel.rooms){
            if(room.number == roomNumber){
                hotel.rooms.remove(room);
            }
        }
    }

    // Getting the available rooms
    void getAvailableRooms(){
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : hotel.rooms){
            if(!room.isReserved){
                availableRooms.add(room);
            }
        }
        System.out.println("Room Number" + "     " + "Number of Beds" + "            " + "Price");
        for (Room room : availableRooms){
            System.out.printf("%-20s %-20s %-20s", room.number, room.numberOfBeds, room.price);
            System.out.println();
        }
    }

    // Reserving a room
    void reserveRoom(int roomNumber, int reservationDays, String customerName,String customerID){
        Room targetRoom = null;
        for (Room room : hotel.rooms){
            if (room.number == roomNumber){
               targetRoom = room;
            }
        }

        targetRoom.isReserved = true;
        targetRoom.startDate = LocalDate.now();
        targetRoom.endDate = LocalDate.now().plusDays(reservationDays);
        targetRoom.customerName = customerName;
        targetRoom.customerID = customerID;

    }

    // Freeing a room
    void freeRoom(int roomNumber){
        Room targetRoom = null;
        for(Room room : hotel.rooms){
            if(room.number == roomNumber){
                targetRoom = room;
            }
        }
        targetRoom.isReserved = false;
        targetRoom.customerID = null;
        targetRoom.customerName = null;
        targetRoom.startDate = null;
        targetRoom.endDate = null;
    }

}
