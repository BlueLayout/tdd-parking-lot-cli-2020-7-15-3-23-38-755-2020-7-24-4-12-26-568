package com.oocl.cultivation;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private String id;

    private int capacity;

    private Map<CarTicket, Car> parkingRooms;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingRooms = new HashMap<>();
    }

    public ParkingLot(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.parkingRooms = new HashMap<>();
    }

    public CarTicket carIn(Car car) {
        if (capacity > parkingRooms.size()) {
            CarTicket carTicket = new CarTicket();
            parkingRooms.put(carTicket, car);
            return carTicket;
        }
        return null;
    }

    public Car carOut(CarTicket carTicket) {
        return parkingRooms.remove(carTicket);
    }

    public Map<CarTicket, Car> getParkingRooms() {
        return parkingRooms;
    }

    int checkSurplusCapacity() {
        return capacity - parkingRooms.size();
    }

    double getUseRateLot() {
        BigDecimal p = BigDecimal.valueOf(parkingRooms.size());
        BigDecimal c = BigDecimal.valueOf(capacity);
        if (p.compareTo(BigDecimal.ZERO) != 0 && c.compareTo(BigDecimal.ZERO) != 0) {
            return p.divide(c, 10, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return 0;
    }
}
