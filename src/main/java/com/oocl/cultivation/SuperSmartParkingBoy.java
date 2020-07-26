package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy {

    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public CarTicket park(Car car) {
        return null;
    }
}
