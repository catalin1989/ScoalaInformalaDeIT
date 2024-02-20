package week4.phones;

import week4.phoneSoftware.Call;
import week4.phoneSoftware.Contact;
import week4.phoneSoftware.Message;
//This is the interface that stipulates the phone behaviour
public interface PhoneBehaviour {

    public void addContact(int position, String phoneNumber, String firstName, String lastName);

    public void seeExistingContact();

    public void sendTextMessage(String phoneNumber, String text);

    public void receiveTextMessage();
    public Message getFirstMessage(String string);
    public Message getSecondMessage(String string);

    public void seeMessagesForContact(String contact);

    public Call makeACall(String string);

    public void receiveACall();
    public void seeAllCallHistory();
}
