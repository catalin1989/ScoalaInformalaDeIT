package week4.phones;

import week4.phoneSoftware.Contact;
import week4.phoneSoftware.Message;
import week4.phoneSoftware.MessageAgenda;
import week4.phoneSoftware.ServiceProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Phone implements PhoneBehaviour {
    protected String color;
    protected String material;
    protected int batteryLife;
    protected ArrayList<Contact> contacts;
    protected Map<Contact, MessageAgenda> receivedMessagesAgenda;
    protected Map<Contact, MessageAgenda> sentMessages;
    protected final String IMEI;

    protected Message sentMessage;

    protected Message receivedMessage;

    protected ServiceProvider serviceProvider;

    public Phone() {
        contacts = new ArrayList<>();
        receivedMessagesAgenda=new HashMap<>();
        sentMessages=new HashMap<>();
        batteryLife = 100;
        this.IMEI = String.valueOf(Math.random() * 1000);
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public String getIMEI() {
        return IMEI;
    }


    @Override
    public void sendTextMessage(String phoneNumber, String text) {
        sentMessage = new Message(phoneNumber, text);
        for(Contact contact1:contacts){
            if(sentMessage.getPhoneNumber().equals(contact1.getPhoneNumber())){
                MessageAgenda agenda=receivedMessagesAgenda.get(contact1);
                agenda.addMessaged(sentMessage);
                receivedMessagesAgenda.replace(contact1,agenda);
            }
        }

    }

    @Override
    public void receiveTextMessage() {
        System.out.println("You got a new message!");
        this.receivedMessage = serviceProvider.getMessage();
        for(Contact contact1:contacts){
            if (receivedMessage.getPhoneNumber().equals(contact1.getPhoneNumber())){
                MessageAgenda agenda=receivedMessagesAgenda.get(contact1);
                agenda.addMessaged(receivedMessage);
                receivedMessagesAgenda.replace(contact1,agenda);

            }
        }
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public Message getSentMessage() {
        return sentMessage;
    }

    public Message getReceivedMessage() {
        return receivedMessage;
    }

    @Override
    public void addContact(int position, String phoneNumber, String firstName, String lastName) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contacts.add(position, contact);
        receivedMessagesAgenda.put(contact,new MessageAgenda());

    }

    public void addContact(String phoneNumber, String firstName, String lastName) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contacts.add(contact);
        receivedMessagesAgenda.put(contact,new MessageAgenda());
    }

    public Contact getFirstContact() {
        return contacts.get(0);
    }

    public Contact getLastContact() {
        return contacts.get(contacts.size() - 1);
    }

    public Contact getContact(String string) {
        Contact contact = null;
        for (Contact contact1 : contacts) {
            if (string.equals(contact1.getFirstName())) {
                contact = contact1;
                break;
            } else if (string.equals(contact1.getPhoneNumber())) {
                contact=contact1;
                break;
            }
            else if(string.equals(contact1.getLastName())){
                contact=contact1;
                break;
            }
        }
        return contact;
    }

    public void deleteContact(String string) {
        Contact contact = null;
        for (Contact contact1 : contacts) {
            if (string.equals(contact1.getFirstName())) {
                contact = contact1;
                break;
            } else if (string.equals(contact1.getPhoneNumber())) {
                contact=contact1;
                break;
            }
            else if(string.equals(contact1.getLastName())){
                contact=contact1;
                break;
            }
        }
        contacts.remove(contact);
        receivedMessagesAgenda.remove(contact);

    }

    @Override
    public void seeExistingContact() {
    for(Contact contact1:contacts){
        System.out.println(contact1);
    }
    }

    @Override
    public void seeMessagesForContact(String contact) {
        for(Contact contact1:contacts){
            if(contact.equals(contact1.getFirstName())){
                ArrayList<Message> list=receivedMessagesAgenda.get(contact1).getMessageAgenda();
                for(Message message:list){
                    System.out.println(message);
                }
            }
        }
    }


}
