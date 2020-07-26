package com.oocl.cultivation;

public interface ParkingStaff {

    CarTicket park(Car car);

    Car fetch(CarTicket carTicket);
}
