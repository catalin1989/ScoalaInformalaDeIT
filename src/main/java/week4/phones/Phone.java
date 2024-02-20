package week4.phones;

import week4.phoneSoftware.*;
import week4.phones.serviceProvider.ServiceProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//This is the most important class
//Disclaimer, all the methods work only with the contact that are in the phone agenda
//If I try to use a method with an unknown number I will get a NullPointerException
//This can be fixed, but it isn't a homework requirement
public abstract class Phone implements PhoneBehaviour {
    protected String color;
    protected String material;
    protected int batteryLife;
    protected String myPhoneNumber;
    protected List<Contact> contacts;
    protected Map<Contact, MessageAgenda> messagesAgenda;
    protected Map<Contact, CallAgenda> callAgenda;

    protected List<Call> allCalls = new ArrayList<>();

    protected final String IMEI;

    protected Message sentMessage;

    protected Message receivedMessage;
    protected Call receivedCall;
    protected Call sentCall;

    protected ServiceProvider serviceProvider;

    //When I instantiate the phone, the constructor instantiates all the phone agendas and give a random number
    //as an IMEI
    public Phone() {
        contacts = new ArrayList<>();
        messagesAgenda = new HashMap<>();
        this.callAgenda = new HashMap<>();
        batteryLife = 100;
        this.IMEI = String.valueOf(Math.random() * 1000);
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public String getIMEI() {
        return IMEI;
    }

    //This method creates and send a message, drains the battery level and adds the message to the messageAgenda,
    //to the conversation with the specific contact
    @Override
    public void sendTextMessage(String phoneNumber, String text) {
        batteryLife--;
        sentMessage = new Message(phoneNumber, text);
        for (Contact contact1 : contacts) {
            if (sentMessage.getPhoneNumber().equals(contact1.getPhoneNumber())) {
                MessageAgenda agenda = messagesAgenda.get(contact1);
                agenda.addMessaged(sentMessage);
                messagesAgenda.replace(contact1, agenda);
            }
        }

    }

    //this method receives the messages, and adds it to the messageAgenda, to the conversation
    //with the specific contact
    @Override
    public void receiveTextMessage() {
        System.out.println("You got a new message!");
        this.receivedMessage = serviceProvider.getMessage();
        for (Contact contact1 : contacts) {
            if (receivedMessage.getPhoneNumber().equals(contact1.getPhoneNumber())) {
                MessageAgenda agenda = messagesAgenda.get(contact1);
                agenda.addMessaged(receivedMessage);
                messagesAgenda.replace(contact1, agenda);

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

    //This method adds a contact to a specific position in the contacts
    //It initializes the message agenda and call agenda for the added contact
    @Override
    public void addContact(int position, String phoneNumber, String firstName, String lastName) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contacts.add(position, contact);
        messagesAgenda.put(contact, new MessageAgenda());
        callAgenda.put(contact, new CallAgenda());

    }

    //This method adds a contact to contacts
    //It initializes the message agenda and call agenda for the added contact
    public void addContact(String phoneNumber, String firstName, String lastName) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contacts.add(contact);
        messagesAgenda.put(contact, new MessageAgenda());
        callAgenda.put(contact, new CallAgenda());
    }

    public void getFirstContact() {
        System.out.println(contacts.get(0));
    }

    public void getLastContact() {
        System.out.println(contacts.get(contacts.size() - 1));
    }

    //This method gives a specific contact from contacts. It works with the phone number, first name and last name parameter.
    public Contact getContact(String string) {
        Contact contact = null;
        for (Contact contact1 : contacts) {
            if (string.equals(contact1.getFirstName())) {
                contact = contact1;
                break;
            } else if (string.equals(contact1.getPhoneNumber())) {
                contact = contact1;
                break;
            } else if (string.equals(contact1.getLastName())) {
                contact = contact1;
                break;
            }
        }
        return contact;
    }

    //This method deletes a specific contact from contacts. It works with all the contact parameters
    public void deleteContact(String string) {
        Contact contact = null;
        for (Contact contact1 : contacts) {
            if (string.equals(contact1.getFirstName())) {
                contact = contact1;
                break;
            } else if (string.equals(contact1.getPhoneNumber())) {
                contact = contact1;
                break;
            } else if (string.equals(contact1.getLastName())) {
                contact = contact1;
                break;
            }
        }
        contacts.remove(contact);
        messagesAgenda.remove(contact);

    }

    @Override
    public void seeExistingContact() {
        for (Contact contact1 : contacts) {
            System.out.println(contact1);
        }
    }

    //This method prints the specific messages for a specific contact
    @Override
    public void seeMessagesForContact(String contact) {
        for (Contact contact1 : contacts) {
            if (contact.equals(contact1.getFirstName())) {
                List<Message> list = messagesAgenda.get(contact1).getMessageAgenda();
                for (Message message : list) {
                    System.out.println(message);
                }
            }
        }
    }

    @Override
    public Message getFirstMessage(String string) {
        Message message = null;
        for (Contact contact : contacts) {
            if (string.equals(contact.getPhoneNumber())) {
                message = messagesAgenda.get(contact).getMessageAgenda().get(0);
            }
        }
        return message;
    }

    @Override
    public Message getSecondMessage(String string) {
        Message message = null;
        for (Contact contact : contacts) {
            if (string.equals(contact.getPhoneNumber())) {
                message = messagesAgenda.get(contact).getMessageAgenda().get(1);
            }
        }
        return message;
    }

    //This method creates a Call object and returns it. It also adds the call to the callAgenda
    @Override
    public Call makeACall(String string) {
        batteryLife -= 2;
        Contact contact = null;
        for (Contact contact1 : contacts) {
            if (string.equals(contact1.getFirstName())) {
                contact = contact1;
                break;
            } else if (string.equals(contact1.getPhoneNumber())) {
                contact = contact1;
                break;
            } else if (string.equals(contact1.getLastName())) {
                contact = contact1;
                break;
            }
        }

        sentCall = new Call(contact.getPhoneNumber());
        CallAgenda calls = callAgenda.get(contact);
        calls.getCallAgenda().add(sentCall);
        callAgenda.replace(contact, calls);
        allCalls.add(sentCall);
        return sentCall;
    }

    //This method receives the call and adds it to the call agenda
    @Override
    public void receiveACall() {
        System.out.println("You got a Call!");
        receivedCall = serviceProvider.getCall();
        for (Contact contact1 : contacts) {
            if (contact1.getPhoneNumber().equals(receivedCall.getPhoneNumber())) {
                CallAgenda calls = callAgenda.get(contact1);
                calls.addCall(receivedCall);
                callAgenda.replace(contact1, calls);
            }
        }
        allCalls.add(receivedCall);
    }

    public Call getSentCall() {
        return sentCall;
    }

    @Override
    public void seeAllCallHistory() {
        for (Call call : allCalls) {
            System.out.println(call);
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    //I wanted to create a method to set the curents phone number, so, when I make a call or send a message
    //the phone that gets the call/message sees the number of the phone that has made the call/message
    public void setMyPhoneNumber(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
    }

    public String getMyPhoneNumber() {
        return myPhoneNumber;
    }
}
