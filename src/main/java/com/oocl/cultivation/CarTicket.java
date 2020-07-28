package com.oocl.cultivation;

import java.util.Objects;
import java.util.Random;

public class CarTicket {

    private static final int NUM_COUNT = 10;
    private static final int RANDOM_NUMBER_BOUND = 10;
    private String ticketBarcode;

    public CarTicket() {
        this.ticketBarcode = getRandomNum();
    }

    private String getRandomNum() {
        StringBuilder randomNum = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < NUM_COUNT; i++) {
            randomNum.append(random.nextInt(RANDOM_NUMBER_BOUND));
        }
        return randomNum.toString();
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
