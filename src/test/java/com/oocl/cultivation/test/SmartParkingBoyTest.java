package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartParkingBoyTest {

    @Test
    void should_return_car_in_more_space_parking_when_smartParkingBoy_park_given_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot moreParkingLot = new ParkingLot();
        moreParkingLot.carIn(new Car());
        ParkingLot lessParkingLot = new ParkingLot();
        lessParkingLot.carIn(new Car());
        lessParkingLot.carIn(new Car());
        lessParkingLot.carIn(new Car());
        parkingLots.add(moreParkingLot);
        parkingLots.add(lessParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket carTicket = smartParkingBoy.park(car);

        //then
        assertTrue(smartParkingBoy.getParkingLots().get(0).getParkingRooms().containsKey(carTicket));
    }
}
