package week_4.phoneSoftware;

import java.util.ArrayList;
import java.util.List;

//I need this class for the Map<Contact, CallAgenda>, this helps me to get all calls for a specific contact
//The key is the contact and the value is the CallAgenda, which is an ArrayList
public class CallAgenda {
    private final List<Call> callAgenda = new ArrayList<>();

    public void addCall(Call call) {
        callAgenda.add(call);
    }

    public List<Call> getCallAgenda() {
        return callAgenda;
    }
}
