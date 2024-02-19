package week4.phones;

import week4.phoneSoftware.Contact;

public interface PhoneBehaviour {

    public void addContact(int position, String phoneNumber, String firstName, String lastName);

    public void seeExistingContact();

    public void sendTextMessage(String phoneNumber, String text);

    public void receiveTextMessage();

    public void seeMessagesForContact(String contact);

    public void makeACall();
    public void seeAllCallHistory();
}
