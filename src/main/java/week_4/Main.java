package week_4;

import week_4.phones.serviceProvider.ServiceProvider;
import week_4.phones.Phone;
import week_4.phones.iPhone.Iphone15;
import week_4.phones.samsung.SamsungGalaxy;
import week_4.phones.samsung.SamsungS8;

public class Main {
    public static void main(String[] args) {
        ServiceProvider orange = new ServiceProvider();//This is the service provider. I called it orange, like the company.
        Phone myIPhone = new Iphone15();
        myIPhone.setServiceProvider(orange);
        myIPhone.setColor("red");
        myIPhone.setMaterial("platic");
        System.out.println(myIPhone.getColor());
        System.out.println(myIPhone.getMaterial());
        System.out.println(myIPhone.getBatteryLife());//the phone has a full battery
        System.out.println(myIPhone.getIMEI());
        myIPhone.addContact("444-888", "Jose", "Mourinho");
        myIPhone.addContact("444-111", "John", "Oliver");
        myIPhone.setMyPhoneNumber("444-222");//this sets the phone's phone number. This phone belong to Didie Drogba.
        System.out.println();

        Phone samsungGalaxy = new SamsungGalaxy();//this phone belongs to John Oliver
        samsungGalaxy.setMyPhoneNumber("444-111");
        samsungGalaxy.setServiceProvider(orange);
        samsungGalaxy.addContact("444-222", "Didie", "Drogba");

        Phone mySamsung = new SamsungS8();
        //Phone myNewSamsung=new Samsung(); this does not compile
        mySamsung.setServiceProvider(orange);
        mySamsung.setColor("blue");
        mySamsung.setMaterial("ebony");
        System.out.println(mySamsung.getIMEI());
        mySamsung.addContact("444-999", "Rahim", "Sterling");
        mySamsung.addContact("444-222", "Didie", "Drogba");
        mySamsung.setMyPhoneNumber("444-888");//This phone belongs to Jose Mourinho.
        mySamsung.getFirstContact();
        mySamsung.getLastContact();
        System.out.println();

        myIPhone.sendTextMessage("444-888", "Hello Jose. Am I in the starting 11 players for tomorrow?");//sending a message to a contact
        orange.transferMessaged(myIPhone);//the service provider transfers the message
        mySamsung.receiveTextMessage();//the second phone receives the message and prints to the console that we have a message
        myIPhone.sendTextMessage("444-888", "One more thing coach, at what hour do we start training today?");
        orange.transferMessaged(myIPhone);
        mySamsung.receiveTextMessage();
        System.out.println(myIPhone.getFirstMessage("444-888"));//gets the first message sent to this contact
        System.out.println(myIPhone.getSecondMessage("444-888"));//gets the second message sent to this contact
        System.out.println();


        mySamsung.sendTextMessage("444-222", "Yes, you are in the 11 players that will start the mach tomorrow");//replying to the message
        orange.transferMessaged(mySamsung);//transferring the message
        myIPhone.receiveTextMessage();//receiving the message
        mySamsung.seeMessagesForContact("Didie");//this shows the conversation between the two phones, just like in real life on Whatsapp, or other messaging system
        mySamsung.seeExistingContact();//this shows the existing contacts

        myIPhone.makeACall("444-111");
        orange.transferCall(myIPhone);
        samsungGalaxy.receiveACall();//receives the call and prints to the console that we received a call
        myIPhone.seeAllCallHistory();//prints the call history

        System.out.println(myIPhone.getBatteryLife());//-2 hours for 2 mesages and -2 hours for one call
        System.out.println();
        samsungGalaxy.seeAllCallHistory();//the phone that is called shows the number that has called it and the hour minute and second


    }
}
