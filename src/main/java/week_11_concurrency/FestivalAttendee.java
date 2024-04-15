package week_11_concurrency;

import static java.lang.Thread.sleep;

//This class represents the festival attendee
//It has delayMultiplier field. I don't want all the threads to validate the ticket simultaneous
public class FestivalAttendee extends Thread {
    private Ticket ticket;

    private FestivalGate gate;

    private long delayMultiplier;

    public FestivalAttendee(Ticket ticket, FestivalGate gate, long delayMultiplier) {
        if (ticket == null) {
            throw new IllegalArgumentException("You can't enter without a null ticket.");
        }
        if (gate == null) {
            throw new IllegalArgumentException("You have to validate the ticket at a gate!You haven't selected a gate.");
        }
        this.ticket = ticket;
        this.gate = gate;
        this.delayMultiplier = delayMultiplier;
    }

    //when creating a number of threads in a loop, I have set the sleep parameter to 25 milliseconds*delayMultiplier
//which can be the number of the loop. This means that I will have a thread that will validate they're ticked once every 25
// milliseconds.
    @Override
    public void run() {
        try {
            sleep(delayMultiplier * 25);
            gate.validate(this);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public Ticket getTicket() {
        return ticket;
    }
}
