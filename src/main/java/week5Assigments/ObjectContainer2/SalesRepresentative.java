package week5Assigments.ObjectContainer2;

//This is the SalesRepresentative class that implements the Comparable interface
//it compares the revenues of each sales person
public class SalesRepresentative implements Comparable<SalesRepresentative> {
    private String name;
    private int numberOfSales;
    private int quota;
    private int revenue;

    public SalesRepresentative(String name, int numberOfSales, int quota) {
        this.name = name;
        this.numberOfSales = numberOfSales;
        this.quota = quota;
        revenue = numberOfSales * quota;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public int getQuota() {
        return quota;
    }

    public int getRevenue() {
        return revenue;
    }

    @Override
    public int compareTo(SalesRepresentative o) {
        return this.revenue - o.revenue;
    }

    @Override
    public String toString() {
        return "SalesRepresentative{" +
                "name='" + name + '\'' +
                ", revenue=" + revenue +
                '}';
    }
}
