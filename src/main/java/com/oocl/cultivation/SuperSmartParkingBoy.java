package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NoParkingSpaceException;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy implements ParkingAble {

    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    @Override
    public CarTicket park(Car car) throws NoParkingSpaceException {
        CarTicket carTicket;
        ParkingLot parkingLot = parkingLots.stream().min(Comparator.comparingDouble(ParkingLot::getUseRateLot)).orElse(null);
        if (parkingLot != null) {
            carTicket = parkingLot.carIn(car);
            return carTicket;
        }
        throw new NoParkingSpaceException("Not enough position.");
    }

}
