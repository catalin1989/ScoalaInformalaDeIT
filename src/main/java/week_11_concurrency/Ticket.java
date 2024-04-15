package week_11_concurrency;

//This are the ticket types. They require in the constructor a name and a number
//This will help me later
public enum Ticket {
    VIP("VIP pass", 1),
    Full_Ticket("full ticket", 2),
    Free_Pass("free pass", 3),
    One_Day_VIP_Pass("one day VIP pass", 4),
    One_Day_Pass("one day pass", 5);


    private final String type;
    private final int number;

    Ticket(String type, int number) {
        this.type = type;
        this.number = number;
    }

    //I created this method so I can randomly assign a ticket to a festival attendee
    public static Ticket setTicketType(int number) {
        return switch (number) {
            case 1 -> Ticket.VIP;
            case 2 -> Ticket.Full_Ticket;
            case 3 -> Ticket.Free_Pass;
            case 4 -> Ticket.One_Day_VIP_Pass;
            case 5 -> Ticket.One_Day_Pass;
            default ->
                    throw new IllegalArgumentException("There are only 5 ticket types. You have entered an invalid number. " +
                            "Please enter a number between 1 and 5!");
        };
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }
}
