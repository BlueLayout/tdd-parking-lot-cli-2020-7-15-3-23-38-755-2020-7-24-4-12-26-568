package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager implements ParkingAble {

    private ParkingLot parkingLot;

    private List<ParkingAble> parkingAbles;

    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        parkingAbles = new ArrayList<>();
    }

    public List<ParkingAble> getParkingStaff() {
        return parkingAbles;
    }

    public void appendParkingBoy(ParkingAble parkingAble) {
        parkingAbles.add(parkingAble);
    }

    @Override
    public CarTicket park(Car car) {
        return parkingLot.carIn(car);
    }

    @Override
    public Car fetch(CarTicket carTicket) {
        return parkingLot.carOut(carTicket);
    }

    public CarTicket executePark(Car car, ParkingAble parkingAble) {
        return parkingAble.park(car);
    }

    public Car executeFetch(CarTicket carTicket, ParkingAble parkingAble) {
        return parkingAble.fetch(carTicket);
    }
}
