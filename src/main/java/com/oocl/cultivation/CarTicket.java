package com.oocl.cultivation;

import java.util.Random;

public class CarTicket {

    private String ticketBarcode;

    public CarTicket() {
        this.ticketBarcode = getRandomNum();
    }

    public String getTicketBarcode() {
        return ticketBarcode;
    }

    private String getRandomNum(){
        String val = "";
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }
}
