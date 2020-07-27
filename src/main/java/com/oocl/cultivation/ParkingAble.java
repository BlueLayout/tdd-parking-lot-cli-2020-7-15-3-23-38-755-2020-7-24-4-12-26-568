package com.oocl.cultivation;

import com.oocl.cultivation.Exception.InvalidTicketException;
import com.oocl.cultivation.Exception.NoParkingSpaceException;
import com.oocl.cultivation.Exception.NoParkingTicketException;

public interface ParkingAble {

    CarTicket park(Car car) throws NoParkingSpaceException;

    Car fetch(CarTicket carTicket) throws NoParkingTicketException, InvalidTicketException;
}
