package week5Assigments.ObjectContainer1.UtilityClases;

public class Address {
    private String country;
    private String season;

    public Address() {
    }

    public Address(String country, String season) {
        this.country = country;
        this.season = season;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
