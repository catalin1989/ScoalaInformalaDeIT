package week4.phoneSoftware;

public class Message {
    private String phoneNumber;
    private String text;

    public Message(String phoneNumber, String text) {
        this.phoneNumber = phoneNumber;
        this.text = text;
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
                "phoneNumber='" + phoneNumber + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
