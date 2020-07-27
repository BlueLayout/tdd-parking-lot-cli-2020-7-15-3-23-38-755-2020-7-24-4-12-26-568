package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NoParkingSpaceException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartParkingBoyTest {

    @Test
    void should_return_car_in_more_space_parking_when_smartParkingBoy_park_given_car() throws NoParkingSpaceException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot moreSpaceParkingLot = new ParkingLot(10);
        moreSpaceParkingLot.carIn(new Car());
        moreSpaceParkingLot.carIn(new Car());
        moreSpaceParkingLot.carIn(new Car());

        ParkingLot lessSpaceParkingLot = new ParkingLot(10);
        lessSpaceParkingLot.carIn(new Car());
        parkingLots.add(moreSpaceParkingLot);
        parkingLots.add(lessSpaceParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket carTicket = smartParkingBoy.park(car);

        //then
        assertTrue(smartParkingBoy.getParkingLots().get(1).getParkingRooms().containsKey(carTicket));
    }
}
