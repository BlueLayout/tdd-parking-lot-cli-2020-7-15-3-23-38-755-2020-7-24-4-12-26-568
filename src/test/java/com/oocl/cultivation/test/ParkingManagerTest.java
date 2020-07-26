package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingManagerTest {

    @Test
    void should_return_parkingBoyList_when_parkingManager_append_parkingBoy_given_parkingBoy() {
        //given
        ParkingLot parkingLot = new ParkingLot("1",10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        //when
        ParkingManager parkingManager = new ParkingManager(parkingLot);
        parkingManager.appendParkingBoy(new ParkingBoy(parkingLots));

        //then
        assertEquals(1,parkingManager.getParkingBoys().size());
    }
}
