package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParkingLotTest {

    @Test
    void should_return_car_when_parkingLot_fetch_given_current_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        CarTicket carTicket = parkingBoy.park(car);
        Car carFetched = parkingLot.carOut(carTicket);

        //then
        assertNotNull(carFetched);
    }

    @Test
    void should_return_no_car_when_parkingLot_fetch_given_wrong_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        CarTicket carTicket = parkingBoy.park(car);
        CarTicket wrongTicket = new CarTicket();
        Car carFetched = parkingLot.carOut(wrongTicket);

        //then
        assertNull(carFetched);
    }
}
