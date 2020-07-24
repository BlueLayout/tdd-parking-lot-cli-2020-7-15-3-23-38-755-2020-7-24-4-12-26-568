package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingBoy() {
        this.parkingLot = new ParkingLot();
    }

    public CarTicket park(Car car) {
        return parkingLot.carIn(car);
    }

    public Car fetch(CarTicket carTicket) {
        return parkingLot.carOut(carTicket);
    }

    public Map<CarTicket,Car> park(Car... cars){
        Map<CarTicket,Car> parkingRoom = new HashMap<>();
        for (Car car:cars
             ) {
            CarTicket carTicket = parkingLot.carIn(car);
            parkingRoom.put(carTicket,car);
        }
        return parkingRoom;
    }

}
