package week4.phoneSoftware;

import java.text.SimpleDateFormat;
import java.util.Date;

//I created a class Call to be able to send call objects between the phones
//I can retrieve with ease information from a call object
public class Call {

    private final String phoneNumber;
    private final Date date;

    private final String dateAsString;

    //The call creates the date when it is created. It saves the day, minute and seconds.
    //If I create a delay in the ServiceProvider, the phone that has made the call and
    //the phone that has received the call will have different call times
    public Call(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("k m s");
        dateAsString = format.format(date);
    }


    public String getDateAsString() {
        return dateAsString;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Call{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", dateAsString='" + dateAsString + '\'' +
                '}';
    }
}
