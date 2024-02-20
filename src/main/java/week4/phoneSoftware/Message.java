package week4.phoneSoftware;
//I created a class Message to be able to send message objects between the phones
//I can retrieve with ease information from a message object
public class Message {
    private String phoneNumber;
    private String text;

    private final int maxMessageCharacters=500;
    //The message has a limit of 500 characters, as required in the task.
    //If the message has more than 500 characters, only the first 500 will be send

    public Message(String phoneNumber, String text) {
        this.phoneNumber = phoneNumber;
        if (text.length() > 500) {
            this.text = text.substring(0, 499);
        } else {
            this.text = text;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                '}';
    }
}
