package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NoParkingSpaceException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuperSmartParkingBoyTest {

    @Test
    void should_return_car_in_larger_available_position_rate_when_superSmartParkingBoy_given_car() throws NoParkingSpaceException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot smallAvailablePositionRateLot = new ParkingLot(30);
        smallAvailablePositionRateLot.carIn(new Car());
        smallAvailablePositionRateLot.carIn(new Car());
        smallAvailablePositionRateLot.carIn(new Car());
        smallAvailablePositionRateLot.carIn(new Car());
        smallAvailablePositionRateLot.carIn(new Car());
        smallAvailablePositionRateLot.carIn(new Car());
        smallAvailablePositionRateLot.carIn(new Car());
        smallAvailablePositionRateLot.carIn(new Car());
        smallAvailablePositionRateLot.carIn(new Car());
        smallAvailablePositionRateLot.carIn(new Car());

        ParkingLot largerAvailablePositionRateLot = new ParkingLot(10);
        largerAvailablePositionRateLot.carIn(new Car());
        parkingLots.add(smallAvailablePositionRateLot);
        parkingLots.add(largerAvailablePositionRateLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket carTicket = superSmartParkingBoy.park(car);

        //then
        assertTrue(superSmartParkingBoy.getParkingLots().get(1).getParkingRooms().containsKey(carTicket));
    }
}
