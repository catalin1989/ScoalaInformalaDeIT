package week_11_concurrency;

import java.util.Random;

//This class is responsible for creating and starting the FestivalAttendee threads;
//It takes a Random object, the Gate object and a Long number as an input;
//It has private FestivalAttendee attendee field that it will instantiate for how many times we set the numberOfParticipant parameter
public class MyFestivalAttendeeStarter {
    private long numberOfParticipants;
    private FestivalAttendee attendee;
    private FestivalGate gate;
    private Random random;

    public MyFestivalAttendeeStarter(Random random, FestivalGate gate, long numberOfParticipants) {
        if (numberOfParticipants < 0) {
            throw new IllegalArgumentException("Can't have a negative number as participants");
        }
        this.random = random;
        this.gate = gate;
        this.numberOfParticipants = numberOfParticipants;
    }

    public void start() {
        for (long i = 0; i < numberOfParticipants; i++) {
            Ticket ticket = Ticket.setTicketType(random.nextInt(1, 6));
            attendee = new FestivalAttendee(ticket, gate, i);
            attendee.start();
        }
    }

}
