package week4.phones;

import week4.phoneSoftware.Call;
import week4.phoneSoftware.Contact;
import week4.phoneSoftware.Message;

//This is the interface that stipulates the phone behaviour
public interface PhoneBehaviour {

    void addContact(int position, String phoneNumber, String firstName, String lastName);

    void seeExistingContact();

    void sendTextMessage(String phoneNumber, String text);

    void receiveTextMessage();

    Message getFirstMessage(String string);

    Message getSecondMessage(String string);

    void seeMessagesForContact(String contact);

    Call makeACall(String string);

    void receiveACall();

    void seeAllCallHistory();
}
