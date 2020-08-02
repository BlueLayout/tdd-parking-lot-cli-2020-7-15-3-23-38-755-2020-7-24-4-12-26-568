package com.oocl.cultivation;

import com.oocl.cultivation.Constant.ExceptionMessage;
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
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.checkSurplusCapacity() != 0) {
                carTicket = parkingLot.carIn(car);
                return carTicket;
            }
        }
        throw new NoParkingSpaceException(ExceptionMessage.NO_ENOUGH_POSITION.getMessage());
    }

    @Override
    public Car fetch(CarTicket carTicket) throws NoParkingTicketException, InvalidTicketException {
        if (carTicket == null) {
            throw new NoParkingTicketException(ExceptionMessage.NO_PARKING_TICKET.getMessage());
        }
        for (ParkingLot parkingLot : parkingLots
        ) {
            Car car = parkingLot.carOut(carTicket);
            if (car != null) {
                return car;
            }
        }
        throw new InvalidTicketException(ExceptionMessage.UNRECOGNIZED_PARKING_TICKET.getMessage());
    }

}
