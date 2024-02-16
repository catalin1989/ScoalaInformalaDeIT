package week4;

import week4.phoneSoftware.ServiceProvider;
import week4.phones.Phone;
import week4.phones.iPhone.Iphone15;

public class Main {
    public static void main(String[] args) {
        ServiceProvider orange=new ServiceProvider();
    Phone myIPhone=new Iphone15();
    myIPhone.setServiceProvider(orange);
    Phone mySamsung=new Iphone15();
    mySamsung.setServiceProvider(orange);

    myIPhone.sendTextMessage("444-888","Testing messaging functions");
    orange.transferMessaged(myIPhone);
    mySamsung.receiveTextMessage();
        System.out.println(mySamsung.getReceivedMessage());



    }
}
