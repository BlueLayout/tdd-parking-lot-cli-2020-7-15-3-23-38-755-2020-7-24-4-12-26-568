package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private CarTicket carTicket;

    private Map<CarTicket, Car> parkingRooms;

    public ParkingLot() {
        this.parkingRooms = new HashMap<>();
    }

    public CarTicket carIn(Car car){
        CarTicket carTicket = new CarTicket();
        parkingRooms.put(carTicket, car);
        return carTicket;
    }

    public Car carOut(CarTicket carTicket){
        return parkingRooms.remove(carTicket);
    }

    public Map<CarTicket, Car> getParkingRooms() {
        return parkingRooms;
    }

    public void setParkingRooms(Map<CarTicket, Car> parkingRooms) {
        this.parkingRooms = parkingRooms;
    }
}
