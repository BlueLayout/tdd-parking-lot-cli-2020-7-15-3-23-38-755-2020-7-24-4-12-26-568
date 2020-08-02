package com.oocl.cultivation;


import com.oocl.cultivation.Constant.ExceptionMessage;
import com.oocl.cultivation.Exception.InvalidTicketException;
import com.oocl.cultivation.Exception.NoParkingSpaceException;
import com.oocl.cultivation.Exception.NoParkingTicketException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingLot implements ParkingAble {

    private static final int DEFAULT_USE_RATE = 1;
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
        BigDecimal dividend = BigDecimal.valueOf(parkingRooms.size());
        BigDecimal divisor = BigDecimal.valueOf(capacity);
        if (dividend.compareTo(BigDecimal.ZERO) != 0 && divisor.compareTo(BigDecimal.ZERO) != 0) {
            return dividend.divide(divisor, 10, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return DEFAULT_USE_RATE;
    }

    @Override
    public CarTicket park(Car car) throws NoParkingSpaceException {
        if (capacity > parkingRooms.size()) {
            CarTicket carTicket = new CarTicket();
            parkingRooms.put(carTicket, car);
            return carTicket;
        }
        throw new NoParkingSpaceException(ExceptionMessage.NO_ENOUGH_POSITION.getMessage());
    }

    @Override
    public Car fetch(CarTicket carTicket) throws NoParkingTicketException, InvalidTicketException {
        if (Objects.isNull(carTicket)) {
            throw new NoParkingTicketException(ExceptionMessage.NO_PARKING_TICKET.getMessage());
        }
        Car car = parkingRooms.remove(carTicket);
        if (Objects.isNull(car)) {
            throw new InvalidTicketException(ExceptionMessage.UNRECOGNIZED_PARKING_TICKET.getMessage());
        }
        return car;
    }
}
