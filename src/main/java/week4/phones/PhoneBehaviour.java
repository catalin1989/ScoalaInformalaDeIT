package week4.phones;

import week4.phoneSoftware.Contact;

public interface PhoneBehaviour {

    public void createNewContact();

    public void seeExistingContact();

    public void sendTextMessage(String phoneNumber, String text);

    public void receiveTextMessage();

    public void seeMessagesForContact();

    public void makeACall();
    public void seeAllCallHistory();
}
