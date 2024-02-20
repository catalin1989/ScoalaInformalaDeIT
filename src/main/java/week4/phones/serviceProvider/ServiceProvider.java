package week4.phones.serviceProvider;

import week4.phoneSoftware.Call;
import week4.phoneSoftware.Message;
import week4.phones.Phone;
//I wanted to create this class to simulate the way phone work. They don't send messages directly to
//other phones, they use a third party. This can be a standard company like Vodafone, Orange, etc. Or
//can be the internet and a messaging app.
public class ServiceProvider {

    private Message message;
    private Call call;
    //This method receives the message from the phone that is the parameter, creates a new message object with the
    //number of the phone that has sent the message
    public void transferMessaged(Phone iPhone ){
        Message message1= iPhone.getSentMessage();
        message=new Message(iPhone.getMyPhoneNumber(), message1.getText());
    }

    //This method sends the created message to the receiving phone. The receiving phone
    //will see the senders phone number, just like in real life
    public Message getMessage() {
        return message;
    }

    //This method receives the call from the phone that is the parameter, creates a new call object with the
    //number of the phone that has sent the call
    public void transferCall(Phone iphone){

     call=new Call(iphone.getMyPhoneNumber());
    }
    //This sends the created call
    public Call getCall() {
        return call;
    }
}
