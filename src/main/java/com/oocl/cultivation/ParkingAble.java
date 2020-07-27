package com.oocl.cultivation;

public interface ParkingAble {

    CarTicket park(Car car);

    Car fetch(CarTicket carTicket);
}
