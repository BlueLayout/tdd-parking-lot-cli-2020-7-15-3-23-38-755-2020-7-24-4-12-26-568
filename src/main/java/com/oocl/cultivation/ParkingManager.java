package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {

    private ParkingLot parkingLot;

    private List<ParkingBoy> parkingBoys;

    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        parkingBoys = new ArrayList<>();
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public void appendParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }
}
