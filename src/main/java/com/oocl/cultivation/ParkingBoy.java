package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public CarTicket park(Car car) {
        return parkingLot.carIn(car);
    }

    public Car fetch(CarTicket carTicket) {
        return parkingLot.carOut(carTicket);
    }

    public String queryMessage(CarTicket carTicket) {
        boolean  isContainsTicket = parkingLot.getParkingRooms().containsKey(carTicket);
        if (!isContainsTicket){
            return "Unrecognized parking ticket.";
        }
        return null;
    }
}
