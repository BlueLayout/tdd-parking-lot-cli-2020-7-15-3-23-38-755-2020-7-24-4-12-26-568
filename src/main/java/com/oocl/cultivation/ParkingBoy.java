package com.oocl.cultivation;

import com.oocl.cultivation.Exception.InvalidTicketException;
import com.oocl.cultivation.Exception.NoParkingSpaceException;
import com.oocl.cultivation.Exception.NoParkingTicketException;

import java.util.List;

public class ParkingBoy implements ParkingAble {

    private List<ParkingLot> parkingLots;


    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    @Override
    public CarTicket park(Car car) throws NoParkingSpaceException {
        CarTicket carTicket;
        for (ParkingLot parkingLot : parkingLots
        ) {
            if (parkingLot.checkSurplusCapacity() != 0) {
                carTicket = parkingLot.carIn(car);
                return carTicket;
            }
        }
        throw new NoParkingSpaceException("Not enough position.");
    }

    @Override
    public Car fetch(CarTicket carTicket) throws NoParkingTicketException, InvalidTicketException {
        if (carTicket == null) {
            throw new NoParkingTicketException("Please provide your parking ticket.");
        }
        for (ParkingLot parkingLot : parkingLots
        ) {
            Car car = parkingLot.carOut(carTicket);
            if (car != null) {
                return car;
            }
        }
        throw new InvalidTicketException("Unrecognized parking ticket.");
    }

    public String queryMessage(CarTicket carTicket) {
        if (carTicket == null) {
            return "Please provide your parking ticket.";
        }
        for (ParkingLot parkingLot : parkingLots
        ) {
            boolean isContainsTicket = parkingLot.getParkingRooms().containsKey(carTicket);
            if (isContainsTicket) {
                return null;
            }
        }
        return "Unrecognized parking ticket.";
    }

    public String queryParkMessage(Car car) {
        int capacity = 0;
        for (ParkingLot parkingLot : parkingLots
        ) {
            capacity += parkingLot.getParkingRooms().size();
        }
        if (capacity == 20) {
            return "Not enough position.";
        }
        return null;
    }

}
