package com.oocl.cultivation;

import com.oocl.cultivation.Constant.ExceptionMessage;
import com.oocl.cultivation.Exception.InvalidTicketException;
import com.oocl.cultivation.Exception.NoAvailableParkableException;
import com.oocl.cultivation.Exception.NoParkingSpaceException;
import com.oocl.cultivation.Exception.NoParkingTicketException;

import java.util.*;

public class ParkingManager {

    private List<ParkingAble> parkingAbles = new ArrayList<>();

    private Map<ParkingAble, Boolean> workStatus = new HashMap<>();

    public ParkingManager(ParkingAble... parkingAbles) {
        this.getParkingAbles().addAll(Arrays.asList(parkingAbles));
        getParkingAbles().forEach(x -> workStatus.put(x, true));
    }

    public List<ParkingAble> getParkingAbles() {
        return parkingAbles;
    }

    public void appendParkingBoy(ParkingAble parkingAble) {
        parkingAbles.add(parkingAble);
    }

    public CarTicket parkStrategy(Car car) throws NoParkingSpaceException, NoAvailableParkableException {
        ParkingAble parkingAble = parkingAbles.stream().filter(this::isAvailable).findFirst().orElse(null);
        if (Objects.nonNull(parkingAble)) {
            return parkingAble.park(car);
        }
        throw new NoAvailableParkableException(ExceptionMessage.NO_AVAILABLE_PARKABLE.getMessage());
    }

    public Car fetchStrategy(CarTicket carTicket) throws NoParkingTicketException, InvalidTicketException, NoAvailableParkableException {
        ParkingAble parkingAble = parkingAbles.stream().filter(this::isAvailable).findFirst().orElse(null);
        if (Objects.nonNull(parkingAble)) {
            return parkingAble.fetch(carTicket);
        }
        throw new NoAvailableParkableException(ExceptionMessage.NO_AVAILABLE_PARKABLE.getMessage());
    }

    private Boolean isAvailable(ParkingAble parkingAble) {
        return workStatus.get(parkingAble);
    }

}
