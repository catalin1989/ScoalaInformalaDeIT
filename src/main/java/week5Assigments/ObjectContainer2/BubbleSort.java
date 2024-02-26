package week5Assigments.ObjectContainer2;

//This class has one method that is implementing the bubble sorting algorithm
public class BubbleSort {

    public void sortSalesRepresentativesByRevenue(SalesRepresentative[] salesRepresentatives) {
        boolean swapped;
        for (int i = 0; i < salesRepresentatives.length; i++) {
            swapped = false;
            for (int j = 0; j < salesRepresentatives.length - 1 - i; j++) {
                if (salesRepresentatives[j].compareTo(salesRepresentatives[j + 1]) < 0) {

                    SalesRepresentative temp = salesRepresentatives[j + 1];
                    salesRepresentatives[j + 1] = salesRepresentatives[j];
                    salesRepresentatives[j] = temp;
                    swapped = true;
                }

            }
            if (!swapped) {
                break;
            }
        }
    }
}
