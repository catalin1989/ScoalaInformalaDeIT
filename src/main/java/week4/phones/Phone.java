package week4.phones;

import week4.phoneSoftware.Contact;
import week4.phoneSoftware.Message;
import week4.phoneSoftware.ServiceProvider;

import java.util.ArrayList;

public abstract class Phone implements PhoneBehaviour {
    protected String color;
    protected String material;
    protected int batteryLife;
    protected ArrayList<Contact> contacts;
    protected final String IMEI;

    protected Message sentMessage;

    protected Message receivedMessage;

    protected ServiceProvider serviceProvider;

    public Phone(){
        contacts=new ArrayList<>();
        batteryLife=100;
        this.IMEI=String.valueOf(Math.random()*1000);
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public String getIMEI() {
        return IMEI;
    }


    @Override
    public void sendTextMessage(String phoneNumber, String text) {
        sentMessage=new Message(phoneNumber,text);
    }

    @Override
    public void receiveTextMessage() {
        System.out.println("You got a new message!");
        this.receivedMessage = serviceProvider.getMessage();
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public Message getSentMessage() {
        return sentMessage;
    }

    public Message getReceivedMessage() {
        return receivedMessage;
    }


}
