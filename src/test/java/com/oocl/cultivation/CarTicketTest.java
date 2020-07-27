package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTicketTest {

    @Test
    void should_return_false_when_carTicket_equals_given_two_diff_ticket() {
        //given
        CarTicket carTicket1 = new CarTicket();
        CarTicket carTicket2 = new CarTicket();

        //when
        Boolean isSameCarTicket = carTicket1.equals(carTicket2);

        //then
        assertFalse(isSameCarTicket);
    }
}
