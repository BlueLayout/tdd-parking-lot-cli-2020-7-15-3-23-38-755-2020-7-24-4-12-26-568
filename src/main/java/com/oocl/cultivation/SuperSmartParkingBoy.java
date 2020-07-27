package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy implements ParkingAble {

    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    @Override
    public CarTicket park(Car car) {
        CarTicket carTicket;
        ParkingLot parkingLot = parkingLots.stream().min(Comparator.comparingDouble(ParkingLot::getUseRateLot)).orElse(null);
        if (parkingLot != null) {
            carTicket = parkingLot.carIn(car);
            return carTicket;
        }
        return null;
    }

    @Override
    public Car fetch(CarTicket carTicket) {
        for (ParkingLot parkingLot : parkingLots
        ) {
            Car car = parkingLot.carOut(carTicket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }
}
