package week_11_concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

//This thread is responsible for the calculating of the statistics
public class FestivalStatisticsThread extends Thread {
    private FestivalGate gate;
    private volatile boolean running = true;
    private int totalPersonsEntered = 0;
    private final List<TicketsByTypeAndNumber> listOfTickets = new ArrayList<>();

    //here we initialize the list of Tickets, with a ticket with each type and a starting value of 0
    {
        TicketsByTypeAndNumber vipTickets = new TicketsByTypeAndNumber(0, "vip ticket");
        TicketsByTypeAndNumber fullTickets = new TicketsByTypeAndNumber(0, "full ticket");
        TicketsByTypeAndNumber freePassTickets = new TicketsByTypeAndNumber(0, "free pass tickets");
        TicketsByTypeAndNumber oneDayVipTickets = new TicketsByTypeAndNumber(0, "one day vip ticket");
        TicketsByTypeAndNumber oneDayTicket = new TicketsByTypeAndNumber(0, "one day ticket");
        listOfTickets.add(vipTickets);
        listOfTickets.add(fullTickets);
        listOfTickets.add(freePassTickets);
        listOfTickets.add(oneDayVipTickets);
        listOfTickets.add(oneDayTicket);

    }

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    //I created a static inner class to tie the ticket type with they're number
    //I preferred this version over a Map<Ticket, Integer>, because the class can implement
    //the comparable interface and I can sort the objects and print them in order as
    // the requirements of the assignment.
    static class TicketsByTypeAndNumber implements Comparable<TicketsByTypeAndNumber> {
        private int number;
        private String ticketType;

        public TicketsByTypeAndNumber(int number, String ticketType) {
            this.number = number;
            this.ticketType = ticketType;
        }


        public int getNumber() {
            return number;
        }

        public String getTicketType() {
            return ticketType;
        }

        public void updateNumber(int number) {
            this.number += number;
        }

        @Override
        public int compareTo(TicketsByTypeAndNumber o) {
            if (o.number != this.number) {
                return o.number - this.number;
            }
            return this.ticketType.compareTo(o.ticketType);
        }
    }

    public void stopProcessing() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            processQueue();
            System.out.println("-----------------------------------------------");
            System.out.println(totalPersonsEntered + " have entered the festival");
            listOfTickets.stream().sorted().forEach(ticketsByTypeAndNumber -> {
                System.out.println(ticketsByTypeAndNumber.number + " people have " + ticketsByTypeAndNumber.ticketType);
            });
            //this thread is sleeping, giving time for the FestivalAttendee to validate they're tickets
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            //if there are no FestivalAttendee that have validated they're ticked, we receive a message
            // and call the stopProcessing method,which sets the value of running to false, which breaks the loop.
            if (gate.getFestivalQueue().isEmpty()) {
                System.out.println("All of the participants have been processed");
                stopProcessing();
            }
        }
    }
    //this method gets a copy of the data from the gate queue and takes all the data until the
    //queue is empty. After if processes all the data, it updates the number of the tickets
    //in the list.

    protected void processQueue() {
        int vipTickets = 0;
        int fullTickets = 0;
        int freePassTickets = 0;
        int oneDayVipTickets = 0;
        int oneDayPassTickets = 0;
        //here I access the queue and take all of the elements from the queue and process them
        BlockingQueue<Ticket> queue = gate.getFestivalQueue();
        if (queue.isEmpty()) {
            return;
        }
        while (!queue.isEmpty()) {
            try {
                Ticket ticket = queue.take();
                //each /.take() increments the totalPersonsEntered
                totalPersonsEntered++;
                switch (ticket.getNumber()) {
                    case 1:
                        vipTickets++;
                        break;
                    case 2:
                        fullTickets++;
                        break;
                    case 3:
                        freePassTickets++;
                        break;
                    case 4:
                        oneDayVipTickets++;
                        break;
                    case 5:
                        oneDayPassTickets++;
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }
        //We know at which index is each ticket type, this is why we hard code the first parameter.

        updateListOfTickets(0, vipTickets);
        updateListOfTickets(1, fullTickets);
        updateListOfTickets(2, freePassTickets);
        updateListOfTickets(3, oneDayVipTickets);
        updateListOfTickets(4, oneDayPassTickets);

    }

    //This method is used to update the list of tickets.
    protected void updateListOfTickets(int index, int number) {
        listOfTickets.get(index).updateNumber(number);
    }

    public int getTotalPersonsEntered() {
        return totalPersonsEntered;
    }
}

