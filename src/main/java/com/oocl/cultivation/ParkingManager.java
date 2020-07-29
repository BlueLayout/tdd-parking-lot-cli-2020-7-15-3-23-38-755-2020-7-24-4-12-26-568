package com.oocl.cultivation;

import com.oocl.cultivation.Exception.InvalidTicketException;
import com.oocl.cultivation.Exception.NoParkingSpaceException;
import com.oocl.cultivation.Exception.NoParkingTicketException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingManager {

    private List<ParkingAble> parkingAbles = new ArrayList<>();

    public ParkingManager(ParkingAble... parkingAbles) {
        this.getParkingStaff().addAll(Arrays.asList(parkingAbles));
    }

    //todo rename getParkingStaff
    public List<ParkingAble> getParkingStaff() {
        return parkingAbles;
    }

    public void appendParkingBoy(ParkingAble parkingAble) {
        parkingAbles.add(parkingAble);
    }

    public CarTicket parkStrategy(Car car, ParkingAble parkingAble) throws NoParkingSpaceException {
        return parkingAble.park(car);
    }

    public Car fetchStrategy(CarTicket carTicket, ParkingAble parkingAble) throws NoParkingTicketException, InvalidTicketException {
        return parkingAble.fetch(carTicket);
    }

}
