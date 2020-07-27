package com.oocl.cultivation;

import java.util.Objects;
import java.util.Random;

public class CarTicket {

    private String ticketBarcode;

    public CarTicket(String ticketBarcode) {
        this.ticketBarcode = ticketBarcode;
    }

    public CarTicket() {
        this.ticketBarcode = getRandomNum();
    }

    public String getTicketBarcode() {
        return ticketBarcode;
    }

    private String getRandomNum() {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarTicket carTicket = (CarTicket) o;
        return Objects.equals(ticketBarcode, carTicket.ticketBarcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketBarcode);
    }
}
