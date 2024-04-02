package week_4.phoneSoftware;

import java.util.ArrayList;
import java.util.List;

//I need this class for the Map<Contact, MessageAgenda>, this helps me to get all messages for a specific contact
//The key is the contact and the value is the MessageAgenda, which is an ArrayList
public class MessageAgenda {
    private final List<Message> messageAgenda = new ArrayList<>();

    public void addMessaged(Message message) {
        messageAgenda.add(message);
    }

    public List<Message> getMessageAgenda() {
        return messageAgenda;
    }
}
