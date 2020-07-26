package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {

    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
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
        ParkingLot parkingLot = parkingLots.stream().max(Comparator.comparingInt(ParkingLot::checkSurplusCapacity)).orElse(null);
        if (parkingLot!=null){
            carTicket = parkingLot.carIn(car);
            return carTicket;
        }
        return null;
    }
}
