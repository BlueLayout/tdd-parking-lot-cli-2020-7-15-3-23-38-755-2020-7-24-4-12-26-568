package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager implements ParkingStaff{

    private ParkingLot parkingLot;

    private List<ParkingStaff> parkingStaffs;

    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        parkingStaffs = new ArrayList<>();
    }

    public List<ParkingStaff> getParkingStaff() {
        return parkingStaffs;
    }

    public void appendParkingBoy(ParkingStaff parkingStaff) {
        parkingStaffs.add(parkingStaff);
    }

    @Override
    public CarTicket park(Car car) {
        return parkingLot.carIn(car);
    }

    @Override
    public Car fetch(CarTicket carTicket) {
        return parkingLot.carOut(carTicket);
    }

    public CarTicket executePark(Car car,ParkingStaff parkingStaff){
        return parkingStaff.park(car);
    }

}
