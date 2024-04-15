package week_11_concurrency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void badInputForTicketType_expectedException_resultIllegalArgumentException() {
        boolean flag = false;
        try {
            Ticket ticket = Ticket.setTicketType(6);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            flag = true;
        }
        assertTrue(flag);
    }
}