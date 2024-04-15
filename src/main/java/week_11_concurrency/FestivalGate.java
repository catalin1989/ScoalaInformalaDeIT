package week_11_concurrency;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//This class acts as the gate
//It has a private BlockingQueue which is instantiated in the constructor as a LinkedBlockingQueue
//The LinkedBlockingQueue is trade safe, as it has an internal lock which allows only one thread
//to perform an operation on the queue;
public class FestivalGate {
    private BlockingQueue<Ticket> festivalQueue;

    public FestivalGate() {
        festivalQueue = new LinkedBlockingQueue<>();

    }

    public void validate(FestivalAttendee festivalAttendee) {
        try {
            festivalQueue.put(festivalAttendee.getTicket());
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

    public BlockingQueue<Ticket> getFestivalQueue() {
        return festivalQueue;
    }

}
