package com.oocl.cultivation;

import com.oocl.cultivation.Exception.InvalidTicketException;
import com.oocl.cultivation.Exception.NoParkingTicketException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {

    @Test
    void should_return_ticket_when_parking_boy_park_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        //when
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        CarTicket carTicket = parkingBoy.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_when_parking_boy_fetch_car_given_carTicket() throws NoParkingTicketException, InvalidTicketException {
        //given
        CarTicket carTicket = new CarTicket();
        ParkingLot parkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        //when
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        CarTicket carTicket1 = parkingBoy.park(new Car());
        Car car = parkingBoy.fetch(carTicket1);
        //then
        assertNotNull(car);
    }

    @Test
    void should_return_more_ticket_when_parking_boy_park_given_more_car() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car[] cars = {car1, car2, car3};
        ParkingLot parkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        //when
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (Car car : cars
        ) {
            parkingBoy.park(car);
        }

        //then
        assertEquals(parkingBoy.getParkingLots().get(0).getParkingRooms().size(), 3);
    }


    @Test
    void should_throws_NoParkingTicketException_when_parkingBoy_fetch_given_null_ticket() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot(10);

        //when
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Throwable exception = assertThrows(NoParkingTicketException.class, () -> {
            parkingBoy.fetch(null);
        });

        //then
        assertEquals("Please provide your parking ticket.", exception.getMessage());
    }

    @Test
    void should_throws_InvalidTicketException_when_parkingBoy_fetch_given_repeat_ticket() throws NoParkingTicketException, InvalidTicketException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot(10);
        parkingLots.add(parkingLot);
        
        //when
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        CarTicket carTicket = parkingBoy.park(new Car());
        parkingBoy.fetch(carTicket);
        Throwable exception = assertThrows(InvalidTicketException.class, () -> {
            parkingBoy.fetch(carTicket);
        });

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
}
