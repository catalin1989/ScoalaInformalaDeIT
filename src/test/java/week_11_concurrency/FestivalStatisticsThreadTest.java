package week_11_concurrency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FestivalStatisticsThreadTest {

    private FestivalGate gate;
    private FestivalStatisticsThread statisticsThread;

    @BeforeEach
    void setUp() {
        gate = new FestivalGate();
        statisticsThread = new FestivalStatisticsThread(gate);
    }

    @Test
    void fivePersonsEntered_fivePersonsAreValidated_resultSuccessful() {
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
        statisticsThread.start();
        try {
            //need this sleep on the main thread, so the attendees and statistics thread have time to validate the ticket.
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        //this checks if all of the persons have been counted
        assertEquals(5, statisticsThread.getTotalPersonsEntered());
        //this checks if all of the ticket from the queue have been processed
        assertEquals(0, gate.getFestivalQueue().size());
    }


}