package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingBoy() {
        this.parkingLot = new ParkingLot();
    }

    public CarTicket park(Car car) {
        return parkingLot.carIn(car);
    }
}
