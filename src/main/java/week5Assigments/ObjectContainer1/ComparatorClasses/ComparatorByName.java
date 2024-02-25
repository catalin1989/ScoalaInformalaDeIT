package week5Assigments.ObjectContainer1.ComparatorClasses;

import week5Assigments.ObjectContainer1.Person.Person;

import java.util.Comparator;

//I created a CompareByName that implement the Comparator interface
public class ComparatorByName implements Comparator<Person> {

    //Thies method compares the names of the persons. But If 2 names are equal it checks the age
    //to see if the objects are the same or the age is different. In real life we have persons
    //with the same name but we know they are not the same person.
    @Override
    public int compare(Person o1, Person o2) {
        int result = o1.getName().compareTo(o2.getName());
        if (result != 0) {
            return result;
        }
        return o1.getAge() - o2.getAge();
    }
}
