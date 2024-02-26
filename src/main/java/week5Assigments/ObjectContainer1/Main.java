package week5Assigments.ObjectContainer1;

import week5Assigments.ObjectContainer1.ComparatorClasses.ComparatorByName;
import week5Assigments.ObjectContainer1.ComparatorClasses.CompareByAge;
import week5Assigments.ObjectContainer1.Person.*;
import week5Assigments.ObjectContainer1.UtilityClasses.Address;
import week5Assigments.ObjectContainer1.UtilityClasses.Hobby;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address("Romania", "every season");
        Address address2 = new Address("Italy", "winter");
        Address address3 = new Address("Hungary", "summer");
        Address address4 = new Address("France", "winter");

        List<Address> adressesForRunning = new ArrayList<>();
        List<Address> adressForSkying = new ArrayList<>();
        adressesForRunning.add(address1);
        adressesForRunning.add(address3);
        adressForSkying.add(address2);
        adressForSkying.add(address4);
        Hobby running = new Hobby("runnig", 4, adressesForRunning);
        Hobby skying = new Hobby("skying", 1, adressForSkying);
        List<Hobby> listOfHobbies1 = new ArrayList<>();
        listOfHobbies1.add(running);
        List<Hobby> listOfHobbies2 = new ArrayList<>();
        listOfHobbies2.add(running);
        listOfHobbies2.add(skying);
        Person pupil = new Pupil("Popescu Vasile", 15);
        Person pupil1 = new Pupil("John Doe", 15);
        Person student = new Student("Andreescu Mircea", 21);
        Person student1 = new Student("Andreescu Mircea", 23);
        Person employee = new Employee("Zamfirescu Andrei", 35);
        Person employee1 = new Employee("Zamfirescu Bogdan", 35);
        Person retired = new Retired("Voiculescu Dan", 72);
        Person retired1 = new Retired("Voiculescu Dan", 72);


        Set<Person> setByAge = new TreeSet<>(new CompareByAge());
        setByAge.add(pupil);
        setByAge.add(pupil1);//this will go in the TreeSet
        setByAge.add(student);
        setByAge.add(student1);
        setByAge.add(employee);
        setByAge.add(employee1);//this will go in the TreeSet
        setByAge.add(retired);
        setByAge.add(retired1);//this won't be inserted into the TreeSet, even if it is a different object, from the perspective of
        //the comparator, it is the same as retired
        System.out.println("Printing the TreeSet sorted by age");
        for (Person person : setByAge) {
            System.out.println(person.getName() + " " + person.getAge());
        }

        Set<Person> setByName = new TreeSet<>(new ComparatorByName());
        setByName.add(pupil);
        setByName.add(pupil1);
        setByName.add(student);
        setByName.add(student1);//this object will be added in the TreeSet, they have the same name but different age;
        setByName.add(employee);
        setByName.add(employee1);//this object won't be added in the ThreeSet, it is the same as employee, based on the CompareByName
        setByName.add(retired);
        setByName.add(retired1);
        System.out.println();
        System.out.println("Printing the TreeSet sorted by name");
        for (Person person : setByName) {
            System.out.println(person.getName() + " " + person.getAge());
        }

        Map<Person, List<Hobby>> personsAndHobbies = new HashMap<>();
        personsAndHobbies.put(pupil, listOfHobbies1);
        personsAndHobbies.put(employee, listOfHobbies2);

        printHobbiesForASpecificPerson(employee, personsAndHobbies);

        printAllPersonSAndHobbies(personsAndHobbies);

    }

    //This method prints all the persons and they're hobbies in the HashMap
    public static void printAllPersonSAndHobbies(Map<Person, List<Hobby>> personsAndHobbies) {
        for (Map.Entry<Person, List<Hobby>> entries : personsAndHobbies.entrySet()) {
            Person person = entries.getKey();
            List<Hobby> hobbies = entries.getValue();
            System.out.println();

            System.out.println("Printing hobbies for " + person.getName());
            System.out.println(person.getName() + " likes to practice " + hobbies + ".");
            for (Hobby hobby : hobbies) {

                System.out.println("He can practice " + hobby.getName() + " in: ");
                StringBuilder builder = new StringBuilder();
                for (Address address : hobby.getAddresses()) {
                    builder.append(address.getCountry() + ", ");
                }
                String result = builder.substring(0, builder.toString().length() - 2);
                System.out.println(result);
            }
        }
    }

    //This method print all the hobbies for a specific person and the countries where they can be practiced
    public static void printHobbiesForASpecificPerson(Person person, Map<Person, List<Hobby>> personsAndHobbies) {
        System.out.println();
        List<Hobby> listOfHobbies = personsAndHobbies.get(person);
        System.out.println("Printing hobbies for " + person.getName());
        System.out.println(person.getName() + " likes to practice " + listOfHobbies + ".");
        for (Hobby hobby : listOfHobbies) {

            System.out.println("He can practice " + hobby.getName() + " in: ");
            StringBuilder builder = new StringBuilder();
            for (Address address : hobby.getAddresses()) {
                builder.append(address.getCountry() + ", ");
            }
            String result = builder.substring(0, builder.toString().length() - 2);
            System.out.println(result);
        }
    }
}
