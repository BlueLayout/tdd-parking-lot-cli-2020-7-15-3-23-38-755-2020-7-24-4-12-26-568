package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NoParkingSpaceException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_car_when_parkingLot_fetch_given_current_ticket() throws NoParkingSpaceException {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        //when
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        CarTicket carTicket = parkingBoy.park(car);
        Car carFetched = parkingLot.carOut(carTicket);

        //then
        assertNotNull(carFetched);
    }

    @Test
    void should_return_no_car_when_parkingLot_fetch_given_wrong_ticket() throws NoParkingSpaceException {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        //when
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car);
        CarTicket wrongTicket = new CarTicket();
        Car carFetched = parkingLot.carOut(wrongTicket);

        //then
        assertNull(carFetched);
    }

    @Test
    void should_return_no_car_when_parkingLot_fetch_given_repeat_ticket() throws NoParkingSpaceException {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        //when
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        CarTicket carTicket = parkingBoy.park(car);
        parkingLot.carOut(carTicket);
        Car carRepeat = parkingLot.carOut(carTicket);

        //then
        assertNull(carRepeat);
    }

    @Test
    void should_return_ticket_when_parkingBoy_park_given_car_11() throws NoParkingSpaceException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));

        //when
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i <= 9; i++) {
            parkingBoy.park(new Car());
        }
        CarTicket carTicket = parkingBoy.park(new Car());

        //then
        assertNotNull(carTicket);
    }
}
