package com.oocl.cultivation;

import com.oocl.cultivation.Exception.InvalidTicketException;
import com.oocl.cultivation.Exception.NoParkingSpaceException;
import com.oocl.cultivation.Exception.NoParkingTicketException;

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

    public CarTicket parkStrategy(Car car, ParkingAble parkingAble) throws NoParkingSpaceException {
        return parkingAble.park(car);
    }

    public Car fetchStrategy(CarTicket carTicket, ParkingAble parkingAble) throws NoParkingTicketException, InvalidTicketException {
        return parkingAble.fetch(carTicket);
    }
}
