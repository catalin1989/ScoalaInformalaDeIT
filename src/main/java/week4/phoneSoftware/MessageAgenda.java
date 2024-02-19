package week4.phoneSoftware;

import java.util.ArrayList;

public class MessageAgenda {
    private ArrayList<Message> messageAgenda=new ArrayList<>();

    public void addMessaged(Message message){
        messageAgenda.add(message);
    }

    public ArrayList<Message> getMessageAgenda() {
        return messageAgenda;
    }
}
