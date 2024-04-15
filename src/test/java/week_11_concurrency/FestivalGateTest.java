package week_11_concurrency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FestivalGateTest {

    private FestivalGate gate;

    @BeforeEach
    void setUp() {
        gate = new FestivalGate();
    }

    @Test
    void fiveFestivalAttendeesValidate_expectedResultSuccess_resultSuccessfully() {
        FestivalAttendee attendee1 = new FestivalAttendee(Ticket.setTicketType(1), gate, 1);
        FestivalAttendee attendee2 = new FestivalAttendee(Ticket.setTicketType(2), gate, 1);
        FestivalAttendee attendee3 = new FestivalAttendee(Ticket.setTicketType(3), gate, 1);
        FestivalAttendee attendee4 = new FestivalAttendee(Ticket.setTicketType(4), gate, 1);
        FestivalAttendee attendee5 = new FestivalAttendee(Ticket.setTicketType(5), gate, 1);
        attendee1.start();
        attendee2.start();
        attendee3.start();
        attendee4.start();
        attendee5.start();

        try {
            //need this sleep on the main thread, so the attendees have time to validate the ticket.
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        assertEquals(5, gate.getFestivalQueue().size());
    }


}