package com.oocl.cultivation;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest {
    //delete
    @Test
    void write_your_first_test() {

    }

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
    void should_return_car_when_parking_boy_fetch_car_given_carTicket() {
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
        for (Car car:cars
             ) {
            parkingBoy.park(car);
        }

        //then
        assertEquals(parkingBoy.getParkingLots().get(0).getParkingRooms().size(),3);
    }

}
