package week5Assigments.ObjectContainer2;

public class Main {
    public static void main(String[] args) {

        SalesRepresentative bob = new SalesRepresentative("Bob", 10, 200);
        SalesRepresentative john = new SalesRepresentative("John", 8, 200);
        SalesRepresentative olivia = new SalesRepresentative("Olivia", 12, 180);
        SalesRepresentative dani = new SalesRepresentative("Dani", 8, 150);
        SalesRepresentative sara = new SalesRepresentative("Sara", 15, 210);

        SalesRepresentative[] salesRepresentatives = {bob, john, olivia, dani, sara};
        System.out.println("Printing the unsorted array");
        printArray(salesRepresentatives);

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sortSalesRepresentativesByRevenue(salesRepresentatives);
        System.out.println();
        System.out.println("Printing the sorted array");
        printArray(salesRepresentatives);
    }

    public static void printArray(SalesRepresentative[] salesRepresentatives) {
        for (SalesRepresentative salesRepresentative : salesRepresentatives) {
            System.out.println(salesRepresentative);
        }
    }
}
