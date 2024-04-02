package week_5_assigments.ObjectContainer1.Person;

import week_5_assigments.ObjectContainer1.UtilityClasses.Hobby;

import java.util.List;

public class Student extends Person {
    private final String status = "student";

    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    public Student(String name, int age, List<Hobby> hobbies) {
        super(name, age, hobbies);
    }

    @Override
    public String toString() {
        return "Student{" +
                "status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}
