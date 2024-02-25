package week5Assigments.ObjectContainer1.Person;

import week5Assigments.ObjectContainer1.UtilityClasses.Hobby;

import java.util.List;

public class Employee extends Person {
    private final String status = "employee";

    public Employee() {
    }

    public Employee(String name, int age) {
        super(name, age);
    }

    public Employee(String name, int age, List<Hobby> hobbies) {
        super(name, age, hobbies);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}
