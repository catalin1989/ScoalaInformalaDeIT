package week_5_assigments.ObjectContainer1.ComparatorClasses;

import week_5_assigments.ObjectContainer1.Person.Person;

import java.util.Comparator;
//I created a CompareByAge that implement the Comparator interface

public class CompareByAge implements Comparator<Person> {

    //this method first compares the ages. I wanted to be able to be able to store in the
    //TreeSet persons with the same age and different names, this is why I added the if condition
    //and a second comparison
    @Override
    public int compare(Person o1, Person o2) {
        int result = Integer.compare(o1.getAge(), o2.getAge());
        if (result != 0) {
            return result;
        }
        return o1.getName().compareTo(o2.getName());
    }
}
