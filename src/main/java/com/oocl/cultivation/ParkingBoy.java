package com.oocl.cultivation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy {

    private List<ParkingLot> parkingLots;


    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public CarTicket park(Car car) {
        CarTicket carTicket;
        for (ParkingLot parkingLot:parkingLots
             ) {
            if (parkingLot.checkSurplusCapacity()!=0){
               carTicket =  parkingLot.carIn(car);
               return carTicket;
            }
        }
        return null;
    }

    public Car fetch(CarTicket carTicket) {
        for (ParkingLot parkingLot:parkingLots
             ) {
            Car car = parkingLot.carOut(carTicket);
            if (car!=null){
                return car;
            }
        }
        return null;
    }

    public String queryMessage(CarTicket carTicket) {
        if (carTicket==null){
            return "Please provide your parking ticket.";
        }
        for (ParkingLot parkingLot:parkingLots
             ) {
            boolean isContainsTicket = parkingLot.getParkingRooms().containsKey(carTicket);
            if (isContainsTicket){
                return null;
            }
        }
        return "Unrecognized parking ticket.";
    }

    public String queryParkMessage(Car car){
        int capacity = 0;
        for (ParkingLot parkingLot:parkingLots
             ) {
            capacity += parkingLot.getParkingRooms().size();
        }
        if (capacity == 20){
            return "Not enough position.";
        }
        return null;
    }
}
