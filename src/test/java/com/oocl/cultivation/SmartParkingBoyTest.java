package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartParkingBoyTest {

    @Test
    void should_return_car_in_more_space_parking_when_smartParkingBoy_park_given_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot moreParkingLot = new ParkingLot(10);
        moreParkingLot.carIn(new Car());
        moreParkingLot.carIn(new Car());
        moreParkingLot.carIn(new Car());
        ParkingLot lessParkingLot = new ParkingLot(10);
        lessParkingLot.carIn(new Car());
        parkingLots.add(moreParkingLot);
        parkingLots.add(lessParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket carTicket = smartParkingBoy.park(car);

        //then
        assertTrue(smartParkingBoy.getParkingLots().get(1).getParkingRooms().containsKey(carTicket));
    }
}
