package com.oocl.cultivation;

import com.oocl.cultivation.Exception.InvalidTicketException;
import com.oocl.cultivation.Exception.NoParkingTicketException;

public interface ParkingAble {

    CarTicket park(Car car);

    Car fetch(CarTicket carTicket) throws NoParkingTicketException, InvalidTicketException;
}
