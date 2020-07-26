package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_car_when_parkingLot_fetch_given_current_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket carTicket = parkingBoy.park(car);
        Car carFetched = parkingLot.carOut(carTicket);

        //then
        assertNotNull(carFetched);
    }

    @Test
    void should_return_no_car_when_parkingLot_fetch_given_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket wrongTicket = new CarTicket();
        Car carFetched = parkingLot.carOut(wrongTicket);

        //then
        assertNull(carFetched);
    }

    @Test
    void should_return_no_car_when_parkingLot_fetch_given_repeat_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket carTicket = parkingBoy.park(car);
        Car carFetched = parkingLot.carOut(carTicket);
        Car carRepeat = parkingLot.carOut(carTicket);

        //then
        assertNull(carRepeat);
    }

    @Test
    void should_return_no_ticket_when_parkingLot_park_given_11_car() {

        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        //when
        for (int i = 0; i <= 9; i++) {
            parkingBoy.park(new Car());
        }
        CarTicket carTicket = parkingBoy.park(new Car());

        //then
        assertNull(carTicket);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_parkingBoy_query_message_given_repeat_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket carTicket = parkingBoy.park(car);
        Car carFetch = parkingBoy.fetch(carTicket);
        String message = parkingBoy.queryMessage(carTicket);

        //then
        assertEquals("Unrecognized parking ticket.", message);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_parkingBoy_query_message_given_null_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket carTicket = parkingBoy.park(car);
        String message = parkingBoy.queryMessage(null);

        //then
        assertEquals("Please provide your parking ticket.", message);
    }

    @Test
    void should_return_not_enough_position_when_parkingBoy_queryParkMessage_given_parking_is_full() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i <= 19; i++) {
            parkingBoy.park(new Car());
        }

        //when
        Car car = new Car();
        String message = parkingBoy.queryParkMessage(car);

        //then
        assertEquals("Not enough position.", message);
    }

    @Test
    void should_return_ticket_when_parkingBoy_park_given_car_11() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());

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
