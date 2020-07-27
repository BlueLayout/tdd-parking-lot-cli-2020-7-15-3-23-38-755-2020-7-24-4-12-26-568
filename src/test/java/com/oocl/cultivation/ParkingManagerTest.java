package com.oocl.cultivation;

import com.oocl.cultivation.Exception.InvalidTicketException;
import com.oocl.cultivation.Exception.NoParkingSpaceException;
import com.oocl.cultivation.Exception.NoParkingTicketException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingManagerTest {

    @Test
    void should_return_parkingBoyList_when_parkingManager_append_parkingBoy_given_parkingBoy() {
        //given
        ParkingLot parkingLot = new ParkingLot("1", 10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        //when
        ParkingManager parkingManager = new ParkingManager(parkingLot);
        parkingManager.appendParkingBoy(new ParkingBoy(parkingLots));

        //then
        assertEquals(1, parkingManager.getParkingStaff().size());
    }

    @Test
    void should_return_ticket_when_parkingManager_executePark_given_car_and_parkingBoy() throws NoParkingSpaceException {
        //given
        ParkingLot parkingLot = new ParkingLot("1", 10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        //when
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingManager parkingManager = new ParkingManager(parkingLot);
        CarTicket carTicket = parkingManager.parkStrategy(new Car(), parkingBoy);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_when_parkingManager_executeFetch_given_ticket_and_parkingBoy() throws NoParkingTicketException, InvalidTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot("1", 10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        //when
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingManager parkingManager = new ParkingManager(parkingLot);
        CarTicket carTicket = parkingManager.park(new Car());
        Car car = parkingManager.fetchStrategy(carTicket, parkingBoy);

        //then
        assertNotNull(car);
    }
}
