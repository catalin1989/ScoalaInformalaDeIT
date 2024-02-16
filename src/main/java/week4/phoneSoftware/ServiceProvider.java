package week4.phoneSoftware;

import week4.phones.Phone;

public class ServiceProvider {

    private Message message;
    public void transferMessaged(Phone iPhone ){
        message= iPhone.getSentMessage();
    }

    public Message getMessage() {
        return message;
    }
}
